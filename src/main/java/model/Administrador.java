package model;

/**
 * Representa um administrador ou funcionário do sistema.
 * Contém dados de identificação e credenciais para login.
 * @author Aluno
 */
public class Administrador {

    private int id;
    private String nome;      // Nome de exibição (ex: "Victor Hugo")
    private String usuario;   // Nome de usuário para login (ex: "vhugo")
    private String senha;     // Senha para login

    /**
     * Construtor padrão (vazio).
     * Importante para flexibilidade na criação de objetos.
     */
    public Administrador() {
    }

    /**
     * Construtor com parâmetros para criar um objeto preenchido.
     */
    public Administrador(int id, String nome, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    // --- Getters e Setters ---

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}