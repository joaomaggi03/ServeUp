/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import model.ItemComanda;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe gerencia as operações de banco de dados para os itens de uma comanda.
 * Ela é responsável por adicionar, remover, atualizar e listar os produtos
 * associados a uma comanda específica.
 */
public class ControladorItemComanda {

    /**
     * Adiciona um novo item (um produto com quantidade) a uma comanda existente.
     * @param item O objeto ItemComanda contendo id_comanda, id_produto, quantidade, etc.
     */
    public void adicionarItem(ItemComanda item) {
        String sql = "INSERT INTO ItemComanda(id_comanda, id_produto, quantidade, preco_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, item.getIdComanda());
            ps.setInt(2, item.getIdProduto());
            ps.setInt(3, item.getQuantidade());
            ps.setBigDecimal(4, item.getPrecoUnitario());
            ps.setBigDecimal(5, item.getSubtotal());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar item na comanda: " + e.getMessage(), e);
        }
    }

    /**
     * Remove um item específico de uma comanda (ex: o cliente desistiu de um produto).
     * @param idItemComanda O ID do registro na tabela ItemComanda a ser removido.
     */
    public void removerItem(int idItemComanda) {
        String sql = "DELETE FROM ItemComanda WHERE id = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idItemComanda);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover item da comanda: " + e.getMessage(), e);
        }
    }
    
    /**
     * Busca todos os itens associados a uma única comanda.
     * Essencial para mostrar o extrato da comanda para o cliente ou para a cozinha.
     * @param idComanda O ID da comanda cujos itens você quer listar.
     * @return Uma lista de objetos ItemComanda.
     */
    public List<ItemComanda> listarItensPorComanda(int idComanda) {
        String sql = "SELECT id, id_produto, quantidade, preco_unitario, subtotal FROM ItemComanda WHERE id_comanda = ?";
        List<ItemComanda> itens = new ArrayList<>();

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idComanda);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ItemComanda item = new ItemComanda();
                    item.setId(rs.getInt("id"));
                    item.setIdComanda(idComanda); // Já temos o id da comanda
                    item.setIdProduto(rs.getInt("id_produto"));
                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                    item.setSubtotal(rs.getBigDecimal("subtotal"));
                    
                    itens.add(item);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens da comanda: " + e.getMessage(), e);
        }
        return itens;
    }
}