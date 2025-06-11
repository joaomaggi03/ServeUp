/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import model.Cliente;
import java.sql.*;
/**
 *
 * @author Aluno
 */

public class ControladorCliente {
    
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/ServeUp";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";
    static Statement st = null;
    
    public void inserir(Cliente cliente){
    
        PreparedStatement ps = null;
        String sql1 = "INSERT INTO cliente(cpf,nome,email) VALUES(?,?,?)";
        try{    
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("Inserindo dados...");
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEmail());
            
        }catch(Exception ex){
            System.out.println(ex);
        }    
    }
}
