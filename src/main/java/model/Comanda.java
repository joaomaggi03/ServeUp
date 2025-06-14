/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma comanda ou pedido de um cliente.
 * Contém informações sobre o cliente, status, datas e valor total.
 * @author Aluno
 */
public class Comanda {
    
    private int id;
    private int idCliente; // Chave estrangeira para saber de qual cliente é a comanda
    private Timestamp dataAbertura;
    private Timestamp dataFechamento; // Pode ser nulo se a comanda estiver aberta
    private BigDecimal valorTotal;
    private String status; // Ex: "ABERTA", "FECHADA", "PAGA"

    // Atributo extra para carregar os itens junto com a comanda (boa prática de POO)
    private List<ItemComanda> itens;

    /**
     * Construtor padrão.
     * Inicializa a lista de itens para evitar NullPointerException.
     */
    public Comanda() {
        this.itens = new ArrayList<>();
    }

    // --- Getters e Setters para todos os atributos ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Timestamp getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Timestamp dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemComanda> getItens() {
        return itens;
    }

    public void setItens(List<ItemComanda> itens) {
        this.itens = itens;
    }
}