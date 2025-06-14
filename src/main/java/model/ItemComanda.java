/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 * Representa um item específico dentro de uma Comanda.
 * Esta classe serve como uma tabela de associação entre Comanda e Produto.
 * @author Aluno
 */
public class ItemComanda {
    
    // Atributos privados para garantir o encapsulamento
    private int id;             // Chave primária do próprio item
    private int idComanda;      // Chave estrangeira para a Comanda (a qual comanda este item pertence)
    private int idProduto;      // Chave estrangeira para o Produto (qual produto é este item)
    private int quantidade;     // Quantos deste produto foram pedidos
    private BigDecimal precoUnitario; // O preço do produto no momento da compra (importante!)
    private BigDecimal subtotal;      // O valor total para este item (quantidade * precoUnitario)

    /**
     * Construtor padrão.
     */
    public ItemComanda() {
    }

    /**
     * Construtor completo para criar um objeto já preenchido.
     */
    public ItemComanda(int id, int idComanda, int idProduto, int quantidade, BigDecimal precoUnitario, BigDecimal subtotal) {
        this.id = id;
        this.idComanda = idComanda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = subtotal;
    }

    // --- Getters e Setters para todos os atributos ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Método toString para facilitar a depuração.
     * Permite imprimir o objeto e ver seus valores de forma legível.
     * @return uma representação em String do objeto ItemComanda.
     */
    @Override
    public String toString() {
        return "ItemComanda{" +
                "id=" + id +
                ", idComanda=" + idComanda +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}