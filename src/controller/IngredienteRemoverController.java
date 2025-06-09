package controller;

import dao.IngredienteRemoverDAO;
import dto.IngredienteRemoverDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.IngredienteRemover;
import java.util.List;

public class IngredienteRemoverController extends InterfaceController {

    private IngredienteRemoverDAO dao; // Declaração do DAO para manipulação dos dados da entidade IngredienteRemover (operações no banco de dados)


    public IngredienteRemoverController() {
        dao = new IngredienteRemoverDAO();
        dto = new IngredienteRemoverDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade IngredienteRemover e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar IngredienteRemover", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade IngredienteRemover e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar IngredienteRemover", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(IngredienteRemover.class); // Obtém uma lista de entidades IngredienteRemover diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar IngredienteRemovers", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de IngredienteRemover apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            IngredienteRemover ingredienteRemover = new IngredienteRemover(id);
            
            dao.remover(ingredienteRemover); // Remove o ingredienteRemover do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteRemoverController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover IngredienteRemover", ex);
            return false;
        }
    }
}