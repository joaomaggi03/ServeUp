/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aluno
 */
public class Cliente {
    
    private int cpf;
    private String nome;
    private String Email; 
    
    public Cliente(int cpf, String nome, String Email) {
        this.cpf = cpf;
        this.nome = nome;
        this.Email = Email;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    

}
