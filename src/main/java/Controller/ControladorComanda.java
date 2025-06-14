/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.Comanda;
import model.ItemComanda;
import model.Produto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Orquestra as operações relacionadas a uma Comanda.
 * É responsável por abrir, fechar, adicionar itens e calcular totais.
 */
public class ControladorComanda {

    // Este controlador vai precisar da ajuda dos outros para trabalhar.
    private final ControladorProduto ctrlProduto;
    private final ControladorItemComanda ctrlItemComanda;

    public ControladorComanda() {
        this.ctrlProduto = new ControladorProduto();
        this.ctrlItemComanda = new ControladorItemComanda();
    }
    
    /**
     * Cria uma nova comanda no banco de dados para um cliente.
     * @param idCliente O ID do cliente que está abrindo a comanda.
     * @return O objeto Comanda recém-criado, já com o ID gerado pelo banco.
     */
    public Comanda abrirComanda(int idCliente) {
        // A comanda começa com status ABERTA e valor total 0.
        String sql = "INSERT INTO Comanda(id_cliente, data_abertura, status, valor_total) VALUES (?, ?, 'ABERTA', 0.00) RETURNING id, data_abertura";
        
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int idComanda = rs.getInt("id");
                    Timestamp dataAbertura = rs.getTimestamp("data_abertura");

                    Comanda novaComanda = new Comanda();
                    novaComanda.setId(idComanda);
                    novaComanda.setIdCliente(idCliente);
                    novaComanda.setDataAbertura(dataAbertura);
                    novaComanda.setStatus("ABERTA");
                    novaComanda.setValorTotal(BigDecimal.ZERO);
                    return novaComanda;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao abrir nova comanda: " + e.getMessage(), e);
        }
        return null; // Retorna null se não conseguiu criar
    }

    /**
     * Adiciona um produto a uma comanda existente.
     * Esta é a operação mais importante do sistema.
     * @param idComanda O ID da comanda.
     * @param idProduto O ID do produto a ser adicionado.
     * @param quantidade A quantidade do produto.
     */
    public void adicionarItemNaComanda(int idComanda, int idProduto, int quantidade) {
        // 1. Buscar o produto para saber seu preço atual
        Produto produto = ctrlProduto.buscarPorId(idProduto);
        if (produto == null) {
            throw new RuntimeException("Produto com ID " + idProduto + " não encontrado.");
        }

        // 2. Criar o objeto ItemComanda
        ItemComanda novoItem = new ItemComanda();
        novoItem.setIdComanda(idComanda);
        novoItem.setIdProduto(idProduto);
        novoItem.setQuantidade(quantidade);
        novoItem.setPrecoUnitario(produto.getPreco());
        
        // 3. Calcular o subtotal deste item
        BigDecimal subtotal = produto.getPreco().multiply(new BigDecimal(quantidade));
        novoItem.setSubtotal(subtotal);

        // 4. Adicionar o item na tabela ItemComanda
        ctrlItemComanda.adicionarItem(novoItem);

        // 5. Atualizar o valor total da Comanda
        atualizarValorTotal(idComanda);
    }

    /**
     * Fecha uma comanda, atualizando seu status e data de fechamento.
     * @param idComanda O ID da comanda a ser fechada.
     */
    public void fecharComanda(int idComanda) {
        String sql = "UPDATE Comanda SET status = 'FECHADA', data_fechamento = ? WHERE id = ?";
        
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, idComanda);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar comanda: " + e.getMessage(), e);
        }
    }
    
    /**
     * Busca todas as comandas com um determinado status.
     * Útil para a tela do administrador ver a "fila de pedidos".
     * @param status O status a ser buscado (ex: "ABERTA").
     * @return Uma lista de comandas.
     */
    public List<Comanda> listarComandasPorStatus(String status) {
        String sql = "SELECT * FROM Comanda WHERE status = ? ORDER BY data_abertura ASC";
        List<Comanda> comandas = new ArrayList<>();
        
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, status);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    Comanda comanda = new Comanda();
                    comanda.setId(rs.getInt("id"));
                    comanda.setIdCliente(rs.getInt("id_cliente"));
                    comanda.setDataAbertura(rs.getTimestamp("data_abertura"));
                    comanda.setDataFechamento(rs.getTimestamp("data_fechamento"));
                    comanda.setValorTotal(rs.getBigDecimal("valor_total"));
                    comanda.setStatus(rs.getString("status"));
                    comandas.add(comanda);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar comandas por status: " + e.getMessage(), e);
        }
        return comandas;
    }

    /**
     * Método auxiliar privado para recalcular e atualizar o valor total de uma comanda.
     * Ele soma os subtotais de todos os itens daquela comanda.
     * @param idComanda O ID da comanda cujo total será recalculado.
     */
    private void atualizarValorTotal(int idComanda) {
        // Esta query soma todos os subtotais da tabela ItemComanda para um id_comanda específico
        // e atualiza o campo valor_total na tabela Comanda.
        // COALESCE garante que se não houver itens, o valor será 0 e não NULL.
        String sql = "UPDATE Comanda SET valor_total = (SELECT COALESCE(SUM(subtotal), 0) FROM ItemComanda WHERE id_comanda = ?) WHERE id = ?";
        
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idComanda); // Parâmetro para a subquery
            ps.setInt(2, idComanda); // Parâmetro para a cláusula WHERE do UPDATE
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar valor total da comanda: " + e.getMessage(), e);
        }
    }
    
    public void atualizarStatus(int idComanda, String novoStatus) {
        String sql = "UPDATE Comanda SET status = ? WHERE id = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, novoStatus);
            ps.setInt(2, idComanda);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar status da comanda: " + e.getMessage(), e);
        }
    }
}