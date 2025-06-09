package controller;

import dao.BairroDAO;
import dto.BairroDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Bairro;
import java.util.List;

/**
 * Classe responsável pelo controle das operações relacionadas à entidade Bairro.
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
public class BairroController extends InterfaceController {

    // Declaração do DAO para manipulação dos dados da entidade Bairro (operações no banco de dados)
    private BairroDAO dao;

    /**
     * Construtor da classe BairroController.
     * Inicializa o DAO e o DTO necessários para o processamento dos dados.
     * 
     * No momento em que a tela é aberta, o Controller é criado e já fica pronto para manipular os dados.
     */
    public BairroController() {
        dao = new BairroDAO();
        dto = new BairroDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    /**
     * Método para salvar um novo Bairro no banco de dados.
     * 
     * O método pega os dados armazenados no DTO, converte para uma entidade Bairro
     * e aciona o método salvar do DAO.
     * 
     * @return true se o salvamento for bem-sucedido, false caso ocorra erro.
     */
    @Override
    public Boolean salvar() {
        try {
            // Converte o DTO para entidade Bairro e salva no banco
            dao.salvar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            // Captura e registra o erro caso o salvamento falhe
            System.getLogger(BairroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Bairro", ex);
            return false;
        }
    }

    /**
     * Método para editar um Bairro existente no banco de dados.
     * 
     * O método atualiza os dados de um Bairro já cadastrado no banco.
     * 
     * @return true se a edição for bem-sucedida, false em caso de erro.
     */
    @Override
    public Boolean editar() {
        try {
            // Converte o DTO para entidade Bairro e atualiza no banco
            dao.editar(dto.buildEntidade());
            return true;
        } catch (Exception ex) {
            System.getLogger(BairroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Bairro", ex);
            return false;
        }
    }

    /**
     * Método para listar todos os bairros cadastrados.
     * 
     * Este método é geralmente utilizado para exibir a lista de bairros em uma tabela ou combo box na tela.
     * 
     * @return Lista de objetos DTO representando os bairros.
     */
    @Override
    public List<InterfaceDTO> listar() {
        try {
            // Obtém uma lista de entidades Bairro diretamente do banco de dados
            List lista = dao.listarTodos(Bairro.class);
            
            // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
            return dto.preencheLista(lista);
        } catch (Exception ex) {
            System.getLogger(BairroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Bairros", ex);
            return null;
        }
    }

    /**
     * Método para remover um bairro do banco de dados.
     * 
     * Este método é utilizado quando o usuário deseja excluir um bairro da lista de cadastrados.
     * 
     * @param id Identificador do bairro a ser removido (chave primária).
     * @return true se a remoção for bem-sucedida, false em caso de erro.
     */
    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Bairro apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Bairro bairro = new Bairro(id);
            
            dao.remover(bairro); // Remove o bairro do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(BairroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Bairro", ex);
            return false;
        }
    }
}