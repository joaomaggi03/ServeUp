package Controller;
import java.util.List;
import model.Comanda;
import model.ItemComanda;
import model.Administrador;



public class ControladorAdministrador {

    // O ControladorAdministrador vai USAR os outros controladores para trabalhar
    private final ControladorComanda ctrlComanda;
    private final ControladorItemComanda ctrlItemComanda;
    private final ControladorProduto ctrlProduto;

    public ControladorAdministrador() {
        // Ele inicializa os ajudantes que vai precisar
        this.ctrlComanda = new ControladorComanda();
        this.ctrlItemComanda = new ControladorItemComanda();
        this.ctrlProduto = new ControladorProduto();
    }

    /**
     * Busca no banco de dados todas as comandas com status 'ABERTA' ou 'EM_PREPARO'.
     * Esta é a "fila de pedidos" da cozinha.
     * @return Uma lista de comandas ativas.
     */
    public List<Comanda> verFilaDePedidos() {
        // Ele delega a tarefa para o controlador especialista no assunto "Comanda"
        return ctrlComanda.listarComandasPorStatus("ABERTA");
    }

    /**
     * Busca os itens específicos de uma comanda para exibir os detalhes.
     * @param idComanda O ID da comanda que a cozinha quer ver.
     * @return A lista de itens daquela comanda.
     */
    public List<ItemComanda> verItensDeUmaComanda(int idComanda) {
        return ctrlItemComanda.listarItensPorComanda(idComanda);
    }

    /**
     * Permite que a cozinha atualize o andamento de um pedido.
     * @param idComanda O ID da comanda a ser atualizada.
     * @param novoStatus O novo status (ex: "EM PREPARO", "PRONTO").
     */
    public void atualizarStatusDoPedido(int idComanda, String novoStatus) {
        ctrlComanda.atualizarStatus(idComanda, novoStatus);
    }

 
    public Administrador fazerLogin(String usuario, String senha) {
        // Aqui iria a lógica para buscar um administrador no banco com aquele usuário e senha.
        // Se encontrar, retorna o objeto. Se não, retorna null.
        // Exemplo: return daoAdministrador.buscarPorLoginESenha(usuario, senha);
        return null; // Apenas para ilustrar
    }
}