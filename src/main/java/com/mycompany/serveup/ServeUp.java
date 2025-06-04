/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serveup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ServeUp {
    
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/aula1";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";
    static Statement st = null;
    
    public static void main(String[] args) {
        
       try{ //bloco para registro do driver
           System.out.println("Carregando o Driver");
           Class.forName(driver);
           System.out.println("Driver carregado com sucesso");
       }catch(Exception e){
           System.out.println("Falha no carregamento do driver");
       }
       
       try{ //bloco para conexão
           System.out.println("Conectando ao bd");
           conn = DriverManager.getConnection(url,user,senha);
           System.out.println("Banco conectado com sucesso");
           
       }catch(Exception e){
           System.out.println("Falha da conexao");
       }
       
       
       
       String sql1 = "CREATE TABLE aluno("
            + "id int primary key not null,"
            + "nome text,"
            + "email text)";
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("Criando a tabela...");
            st = conn.createStatement();
            st.executeUpdate(sql1);
            System.out.println("Tabela criada com sucesso!");
            st.close();
            conn.close();
        
        }catch(Exception ex){
            System.out.println(ex);
        }

        String sql2 = "INSERT INTO aluno VALUES(2,'Joao','joao@utfpr.edu.br')";
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("Inserindo dados...");
            st = conn.createStatement();
            st.executeUpdate(sql2);
            System.out.println("Dados inseridos com sucesso!");
            st.close();
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }    
       
        String sql3 = "SELECT * FROM aluno";
        ResultSet rs = null;
        try{
            Class.forName (driver);
            conn = DriverManager.getConnection(url,user,senha);
            System.out.println("Mostrando os Dados na tabela alunos: ...");
            st = conn.createStatement();
            st.executeUpdate(sql2);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
        
    }
        
}

