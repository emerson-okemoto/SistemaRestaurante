package controller;

import dao.DinheiroDAO;
import dto.DinheiroDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Dinheiro;
import java.util.List;

public class DinheiroController extends InterfaceController {

    private DinheiroDAO dao; // Declaração do DAO para manipulação dos dados da entidade Dinheiro (operações no banco de dados)


    public DinheiroController() {
        dao = new DinheiroDAO();
        dto = new DinheiroDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Dinheiro e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Dinheiro", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Dinheiro e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Dinheiro", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Dinheiro.class); // Obtém uma lista de entidades Dinheiro diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Dinheiros", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Dinheiro apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Dinheiro dinheiro = new Dinheiro(id);
            
            dao.remover(dinheiro); // Remove o dinheiro do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(DinheiroController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Dinheiro", ex);
            return false;
        }
    }
}