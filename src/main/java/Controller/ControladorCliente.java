package Controller;

import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ControladorCliente {

    /**
     * Insere um novo cliente no banco de dados.
     */
    public void inserir(Cliente cliente) {
        
        // Lembre-se: CPF deve ser VARCHAR no banco
        String sql = "INSERT INTO cliente(cpf, nome, email) VALUES (?, ?, ?)";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getCpf()); // CPF como String
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            ps.executeUpdate(); // AGORA SIM, EXECUTANDO A QUERY!

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage(), e);
        }
    }

    /**
     * Retorna uma lista com todos os clientes cadastrados.
     */
    public List<Cliente> listarTodos() {
        String sql = "SELECT cpf, nome, email FROM cliente ORDER BY nome";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                Cliente cliente = new Cliente(cpf, nome, email); // Supondo um construtor
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage(), e);
        }
        return clientes;
    }

    /**
     * Atualiza os dados de um cliente existente, identificado pelo CPF.
     */
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE cpf = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf()); // CPF é o último parâmetro (do WHERE)

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

    /**
     * Deleta um cliente do banco de dados usando o CPF.
     */
    public void deletar(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage(), e);
        }
    }
    public Cliente buscarPorCpf(String cpf) {
     
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        String cpfApenasNumeros = cpf.replaceAll("[^0-9]", ""); // Limpa o CPF

        try (Connection conn = FabricaDeConexoes.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpfApenasNumeros);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    // Supondo que o modelo Cliente não tem ID, se tiver, adicione o rs.getInt("id") aqui
                    return cliente;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente por CPF: " + e.getMessage(), e);
        }
        return null; // Retorna null se não encontrou
    }   
}