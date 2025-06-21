package Controller;

import model.Comanda;
import model.ItemComanda;
import model.Produto;
import model.Cliente; // <-- IMPORT NECESSÁRIO
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ControladorComanda {

    private final ControladorProduto ctrlProduto;
    private final ControladorItemComanda ctrlItemComanda;
    private final ControladorCliente ctrlCliente; // <-- ADICIONADO

    public ControladorComanda() {
        this.ctrlProduto = new ControladorProduto();
        this.ctrlItemComanda = new ControladorItemComanda();
        this.ctrlCliente = new ControladorCliente(); // <-- ADICIONADO
    }

    // ========= MÉTODO NOVO E CORRIGIDO (O MAIS IMPORTANTE) =========
    public Comanda buscarOuAbrirComandaPorCpf(String cpf) {
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        String sqlSelect = "SELECT * FROM Comanda WHERE id_cliente = ? AND status = 'ABERTA'";
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sqlSelect)) {
            ps.setString(1, cpfLimpo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Comanda comandaExistente = new Comanda();
                    comandaExistente.setId(rs.getInt("id"));
                    comandaExistente.setIdCliente(rs.getString("id_cliente"));
                    comandaExistente.setStatus(rs.getString("status"));
                    comandaExistente.setValorTotal(rs.getBigDecimal("valor_total"));
                    return comandaExistente;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar comanda aberta: " + e.getMessage(), e);
        }

        // Se não encontrou comanda aberta, abre uma nova
        Cliente cliente = ctrlCliente.buscarPorCpf(cpfLimpo);
        if (cliente == null) {
            // Cliente não cadastrado, não podemos abrir comanda
            return null;
        }

        // Se o cliente existe, chama o método para criar uma nova comanda para ele
        return this.abrirComanda(cliente.getCpf());
    }
    
    // ========= MÉTODO ABRIRCOMANDA CORRIGIDO PARA ACEITAR CPF (STRING) =========
    public Comanda abrirComanda(String cpfCliente) {
        String sql = "INSERT INTO Comanda(id_cliente, data_abertura, status, valor_total) VALUES (?, ?, 'ABERTA', 0.00) RETURNING id";
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpfCliente);
            ps.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Comanda novaComanda = new Comanda();
                    novaComanda.setId(rs.getInt("id"));
                    novaComanda.setIdCliente(cpfCliente);
                    novaComanda.setStatus("ABERTA");
                    novaComanda.setValorTotal(BigDecimal.ZERO);
                    return novaComanda;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao abrir nova comanda: " + e.getMessage(), e);
        }
        return null;
    }

    // ========= SEUS OUTROS MÉTODOS (COM PEQUENOS AJUSTES) =========
    
    public void adicionarItemNaComanda(int idComanda, int idProduto, int quantidade) {
        Produto produto = ctrlProduto.buscarPorId(idProduto);
        if (produto == null) {
            throw new RuntimeException("Produto com ID " + idProduto + " não encontrado.");
        }
        ItemComanda novoItem = new ItemComanda();
        novoItem.setIdComanda(idComanda);
        novoItem.setIdProduto(idProduto);
        novoItem.setQuantidade(quantidade);
        novoItem.setPrecoUnitario(produto.getPreco());
        BigDecimal subtotal = produto.getPreco().multiply(new BigDecimal(quantidade));
        novoItem.setSubtotal(subtotal);
        ctrlItemComanda.adicionarItem(novoItem);
        atualizarValorTotal(idComanda);
    }

    private void atualizarValorTotal(int idComanda) {
        String sql = "UPDATE Comanda SET valor_total = (SELECT COALESCE(SUM(subtotal), 0) FROM ItemComanda WHERE id_comanda = ?) WHERE id = ?";
        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idComanda);
            ps.setInt(2, idComanda);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar valor total da comanda: " + e.getMessage(), e);
        }
    }
    // ADICIONE ESTE MÉTODO DENTRO DA SUA CLASSE ControladorComanda.java

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
    public List<Comanda> listarComandasPorStatus(String status) {
        // A query busca todas as comandas que correspondem ao status pedido
        String sql = "SELECT * FROM Comanda WHERE status = ? ORDER BY data_abertura ASC";
        List<Comanda> comandas = new ArrayList<>();

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);

            try(ResultSet rs = ps.executeQuery()) {
                // Loop para percorrer cada linha do resultado
                while(rs.next()) {
                    // Cria um objeto Comanda para cada linha
                    Comanda comanda = new Comanda();

                    // Preenche o objeto com os dados daquela linha do banco
                    comanda.setId(rs.getInt("id"));
                    comanda.setIdCliente(rs.getString("id_cliente")); // CPF do cliente
                    comanda.setDataAbertura(rs.getTimestamp("data_abertura"));
                    comanda.setDataFechamento(rs.getTimestamp("data_fechamento"));
                    comanda.setValorTotal(rs.getBigDecimal("valor_total"));
                    comanda.setStatus(rs.getString("status"));

                    // Adiciona o objeto preenchido à lista
                    comandas.add(comanda);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar comandas por status: " + e.getMessage(), e);
        }

        // Retorna a lista completa
        return comandas;
    }

    public List<ItemComanda> listarItensPorComanda(int idComanda) {
        String sql = "SELECT * FROM ItemComanda WHERE id_comanda = ?";
        List<ItemComanda> lista = new ArrayList<>();

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idComanda);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ItemComanda item = new ItemComanda();
                    item.setId(rs.getInt("id"));
                    item.setIdComanda(rs.getInt("id_comanda"));
                    item.setIdProduto(rs.getInt("id_produto"));
                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                    item.setSubtotal(rs.getBigDecimal("subtotal"));
                    lista.add(item);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens da comanda: " + e.getMessage(), e);
        }

        return lista;
    }
    
    public void fecharComanda(int idComanda) {
        
        String sql = "UPDATE Comanda SET status = 'FECHADA', data_fechamento = ?, valor_total = (SELECT COALESCE(SUM(subtotal), 0) FROM ItemComanda WHERE id_comanda = ?) WHERE id = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            Timestamp agora = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(1, agora);
            ps.setInt(2, idComanda); // Para somar os subtotais
            ps.setInt(3, idComanda); // Para localizar a comanda

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar comanda: " + e.getMessage(), e);
        }
    }
}