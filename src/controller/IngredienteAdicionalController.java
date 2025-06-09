package controller;

import dao.IngredienteAdicionalDAO;
import dto.IngredienteAdicionalDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.IngredienteAdicional;
import java.util.List;

public class IngredienteAdicionalController extends InterfaceController {

    private IngredienteAdicionalDAO dao; // Declaração do DAO para manipulação dos dados da entidade IngredienteAdicional (operações no banco de dados)


    public IngredienteAdicionalController() {
        dao = new IngredienteAdicionalDAO();
        dto = new IngredienteAdicionalDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade IngredienteAdicional e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteAdicionalController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar IngredienteAdicional", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade IngredienteAdicional e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteAdicionalController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar IngredienteAdicional", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(IngredienteAdicional.class); // Obtém uma lista de entidades IngredienteAdicional diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(IngredienteAdicionalController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar IngredienteAdicionals", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de IngredienteAdicional apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            IngredienteAdicional ingredienteAdicional = new IngredienteAdicional(id);
            
            dao.remover(ingredienteAdicional); // Remove o ingredienteAdicional do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteAdicionalController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover IngredienteAdicional", ex);
            return false;
        }
    }
}