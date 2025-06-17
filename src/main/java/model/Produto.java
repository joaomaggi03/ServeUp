package model;
import java.math.BigDecimal; // Importação necessária para usar BigDecimal

/**
 *
 * @author victor
 */
public class Produto {
 
    // 1. Atributos agora são PRIVATE para garantir o encapsulamento.
    private int id;
    private int codigo_produto;
    private String nome;
    private BigDecimal preco;   // 2. Preço agora usa BigDecimal para precisão monetária.
    private String descricao; // 3. 'desc' foi renomeado para 'descricao'.

    // Construtor padrão (vazio)
    public Produto() {
    }
    
    // Construtor com parâmetros, já com os tipos e nomes corretos
    public Produto(int id, String nome, BigDecimal preco, String descricao, int codigo_produto) {
        this.id = id;
        this.codigo_produto = codigo_produto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    
    public int getCodigo_produto() {
        return codigo_produto;
    }

    // Getters e Setters para todos os atributos
    public void setCodigo_produto(int codigo_produto) {    
        this.codigo_produto = codigo_produto;
    }

    public int getCodigoProduto() {
        return codigo_produto;
    }

    public void setCodigoProduto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}