package controller;

import dao.StatusPedidoDAO;
import dto.StatusPedidoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.StatusPedido;
import java.util.List;

/**
 * Classe responsável pelo controle das operações relacionadas à entidade StatusPedido.
 * Atua como intermediário entre a camada de visualização (View) e a camada de persistência (DAO).
 * 
 * Faz parte da camada Controller no padrão de projeto MVC (Model-View-Controller).
 * 
 * Os métodos desta classe são geralmente chamados pelas telas ou painéis da aplicação
 * (por exemplo, quando o usuário clica em "Salvar", "Editar", "Remover", ou "Listar").
 * 
 * A lógica da Controller é converter um DTO em uma Entidade (ou o contrário) e acionar os métodos do DAO.
 * 
 * @author S
 */
public class StatusPedidoController extends InterfaceController {

    // Declaração do DAO para manipulação dos dados da entidade StatusPedido (operações no banco de dados)
    private StatusPedidoDAO dao;

    /**
     * Construtor da classe StatusPedidoController.
     * Inicializa o DAO e o DTO necessários para o processamento dos dados.
     * 
     * No momento em que a tela é aberta, o Controller é criado e já fica pronto para manipular os dados.
     */
    public StatusPedidoController() {
        dao = new StatusPedidoDAO();
        dto = new StatusPedidoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    /**
     * Método para salvar um novo StatusPedido no banco de dados.
     * 
     * O método pega os dados armazenados no DTO, converte para uma entidade StatusPedido
     * e aciona o método salvar do DAO.
     * 
     * @return true se o salvamento for bem-sucedido, false caso ocorra erro.
     */
    @Override
    public Boolean salvar() {
        try {
            // Converte o DTO para entidade StatusPedido e salva no banco
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            // Captura e registra o erro caso o salvamento falhe
            System.getLogger(StatusPedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar StatusPedido", ex);
            return false;
        }
    }

    /**
     * Método para editar um StatusPedido existente no banco de dados.
     * 
     * O método atualiza os dados de um StatusPedido já cadastrado no banco.
     * 
     * @return true se a edição for bem-sucedida, false em caso de erro.
     */
    @Override
    public Boolean editar() {
        try {
            // Converte o DTO para entidade StatusPedido e atualiza no banco
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(StatusPedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar StatusPedido", ex);
            return false;
        }
    }

    /**
     * Método para listar todos os statusPedidos cadastrados.
     * 
     * Este método é geralmente utilizado para exibir a lista de statusPedidos em uma tabela ou combo box na tela.
     * 
     * @return Lista de objetos DTO representando os statusPedidos.
     */
    @Override
    public List<InterfaceDTO> listar() {
        try {
            // Obtém uma lista de entidades StatusPedido diretamente do banco de dados
            List lista = dao.listarTodos(StatusPedido.class);
            
            // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
            return dto.preencheLista(lista);
        } catch (Exception ex) {
            System.getLogger(StatusPedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar StatusPedidos", ex);
            return null;
        }
    }

    /**
     * Método para remover um statusPedido do banco de dados.
     * 
     * Este método é utilizado quando o usuário deseja excluir um statusPedido da lista de cadastrados.
     * 
     * @param id Identificador do statusPedido a ser removido (chave primária).
     * @return true se a remoção for bem-sucedida, false em caso de erro.
     */
    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de StatusPedido apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            StatusPedido statusPedido = new StatusPedido(id);
            
            dao.remover(statusPedido); // Remove o statusPedido do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(StatusPedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover StatusPedido", ex);
            return false;
        }
    }
}