/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serveup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ServeUp {
    
    static Connection conn = null;
    static String url = "jdbc:postgresql://localhost:5432/Aula1";
    static String user = "postgres";
    static String senha = "utfpr";
    static String driver = "org.postgresql.Driver";
    
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
    }
}
