/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
    private static final String URL = "jdbc:postgresql://localhost:5432/ServeUp";
    private static final String USER = "victor";
    private static final String SENHA = "2468";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USER, SENHA);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados.", ex);
        }
    }
}