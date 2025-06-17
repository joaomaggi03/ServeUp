package Controller;

import model.Produto;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe é responsável por todas as operações de banco de dados
 * relacionadas à entidade Produto (CRUD).
 * @author victor
 */
public class ControladorProduto {
    
    /**
     * Insere um novo produto no banco de dados.
     * O ID é gerado automaticamente pelo banco (SERIAL).
     * @param produto O objeto Produto a ser inserido, sem o ID.
     */
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, descricao, codigo_produto) VALUES (?, ?, ?, ?)";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setBigDecimal(2, produto.getPreco()); 
            ps.setString(3, produto.getDescricao());
            ps.setInt(4, produto.getCodigoProduto());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto: " + e.getMessage(), e);
        }
    }

    /**
     * Atualiza os dados de um produto existente no banco.
     * @param produto O objeto Produto com os dados atualizados, incluindo o ID do produto a ser alterado.
     */
    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, preco = ?, descricao = ? WHERE id = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setBigDecimal(2, produto.getPreco());
            ps.setString(3, produto.getDescricao());
            ps.setInt(4, produto.getCodigoProduto()); // O ID é o último parâmetro, para a cláusula WHERE

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    /**
     * Exclui um produto do banco de dados com base no seu ID.
     * @param id O ID do produto a ser excluído.
     */
    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage(), e);
        }
    }

    /**
     * Busca um único produto no banco de dados pelo seu ID.
     * @param id O ID do produto a ser buscado.
     * @return O objeto Produto se encontrado, ou null se não existir.
     */
    public Produto buscarPorId(int id) {
        String sql = "SELECT id, nome, preco, descricao FROM produto WHERE id = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { // Verifica se encontrou algum resultado
                    String nome = rs.getString("nome");
                    BigDecimal preco = rs.getBigDecimal("preco");
                    String descricao = rs.getString("descricao");
                    int codigo_produto = rs.getInt("codigo");
                    // Retorna o objeto Produto preenchido
                    return new Produto(id, nome, preco, descricao, codigo_produto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto por ID: " + e.getMessage(), e);
        }
        
        // Retorna null se não encontrou o produto com o ID especificado
        return null; 
    }
    
    /**
     * Busca todos os produtos cadastrados no banco de dados.
     * @return Uma lista contendo todos os produtos.
     */
    public List<Produto> listarTodos() {
         String sql = "SELECT id, codigo_produto, nome, preco, descricao FROM produto ORDER BY nome";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setCodigoProduto(rs.getInt("codigo_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getBigDecimal("preco"));
                p.setDescricao(rs.getString("descricao"));

                produtos.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage(), e);
        }
        return produtos;
    }
    public Produto buscarPorCodigo(int codigoProduto) {
    // A query busca na tabela 'produto' pela coluna 'codigo_produto'
        String sql = "SELECT * FROM produto WHERE codigo_produto = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Define o parâmetro da busca (o código do produto)
            ps.setInt(1, codigoProduto);

            try (ResultSet rs = ps.executeQuery()) {
                // Verifica se o banco de dados retornou alguma linha
                if (rs.next()) {
                    // Se encontrou, cria um objeto Produto em Java
                    Produto produto = new Produto();
                    
                    produto.setCodigoProduto(rs.getInt("codigo_produto")); // O código que o usuário digitou
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco(rs.getBigDecimal("preco"));
                    produto.setDescricao(rs.getString("descricao"));

                    // Retorna o objeto completo
                    return produto;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto por código: " + e.getMessage(), e);
        }

        // Se o 'if (rs.next())' for falso, significa que não existe produto com aquele código.
        // Nesse caso, o método retorna null.
        return null;
    }
}