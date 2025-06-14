package model;
import java.math.BigDecimal; // Importação necessária para usar BigDecimal

/**
 *
 * @author victor
 */
public class Produto {
 
    // 1. Atributos agora são PRIVATE para garantir o encapsulamento.
    private int id;
    private String nome;
    private BigDecimal preco;   // 2. Preço agora usa BigDecimal para precisão monetária.
    private String descricao; // 3. 'desc' foi renomeado para 'descricao'.

    // Construtor padrão (vazio)
    public Produto() {
    }
    
    // Construtor com parâmetros, já com os tipos e nomes corretos
    public Produto(int id, String nome, BigDecimal preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Getters e Setters para todos os atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}