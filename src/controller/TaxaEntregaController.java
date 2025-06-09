package controller;

import dao.TaxaEntregaDAO;
import dto.TaxaEntregaDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.TaxaEntrega;
import java.util.List;

/**
 * Classe responsável pelo controle das operações relacionadas à entidade TaxaEntrega.
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
public class TaxaEntregaController extends InterfaceController {

    // Declaração do DAO para manipulação dos dados da entidade TaxaEntrega (operações no banco de dados)
    private TaxaEntregaDAO dao;

    /**
     * Construtor da classe TaxaEntregaController.
     * Inicializa o DAO e o DTO necessários para o processamento dos dados.
     * 
     * No momento em que a tela é aberta, o Controller é criado e já fica pronto para manipular os dados.
     */
    public TaxaEntregaController() {
        dao = new TaxaEntregaDAO();
        dto = new TaxaEntregaDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    /**
     * Método para salvar um novo TaxaEntrega no banco de dados.
     * 
     * O método pega os dados armazenados no DTO, converte para uma entidade TaxaEntrega
     * e aciona o método salvar do DAO.
     * 
     * @return true se o salvamento for bem-sucedido, false caso ocorra erro.
     */
    @Override
    public Boolean salvar() {
        try {
            // Converte o DTO para entidade TaxaEntrega e salva no banco
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            // Captura e registra o erro caso o salvamento falhe
            System.getLogger(TaxaEntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar TaxaEntrega", ex);
            return false;
        }
    }

    /**
     * Método para editar um TaxaEntrega existente no banco de dados.
     * 
     * O método atualiza os dados de um TaxaEntrega já cadastrado no banco.
     * 
     * @return true se a edição for bem-sucedida, false em caso de erro.
     */
    @Override
    public Boolean editar() {
        try {
            // Converte o DTO para entidade TaxaEntrega e atualiza no banco
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar TaxaEntrega", ex);
            return false;
        }
    }

    /**
     * Método para listar todos os taxaEntregas cadastrados.
     * 
     * Este método é geralmente utilizado para exibir a lista de taxaEntregas em uma tabela ou combo box na tela.
     * 
     * @return Lista de objetos DTO representando os taxaEntregas.
     */
    @Override
    public List<InterfaceDTO> listar() {
        try {
            // Obtém uma lista de entidades TaxaEntrega diretamente do banco de dados
            List lista = dao.listarTodos(TaxaEntrega.class);
            
            // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
            return dto.preencheLista(lista);
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar TaxaEntregas", ex);
            return null;
        }
    }

    /**
     * Método para remover um taxaEntrega do banco de dados.
     * 
     * Este método é utilizado quando o usuário deseja excluir um taxaEntrega da lista de cadastrados.
     * 
     * @param id Identificador do taxaEntrega a ser removido (chave primária).
     * @return true se a remoção for bem-sucedida, false em caso de erro.
     */
    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de TaxaEntrega apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            TaxaEntrega taxaEntrega = new TaxaEntrega(id);
            
            dao.remover(taxaEntrega); // Remove o taxaEntrega do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(TaxaEntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover TaxaEntrega", ex);
            return false;
        }
    }
}