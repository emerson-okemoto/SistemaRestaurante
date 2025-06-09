package controller;

import dao.IngredienteEscolhaDAO;
import dto.IngredienteEscolhaDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.IngredienteEscolha;
import java.util.List;

public class IngredienteEscolhaController extends InterfaceController {

    private IngredienteEscolhaDAO dao; // Declaração do DAO para manipulação dos dados da entidade IngredienteEscolha (operações no banco de dados)


    public IngredienteEscolhaController() {
        dao = new IngredienteEscolhaDAO();
        dto = new IngredienteEscolhaDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade IngredienteEscolha e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar IngredienteEscolha", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade IngredienteEscolha e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar IngredienteEscolha", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(IngredienteEscolha.class); // Obtém uma lista de entidades IngredienteEscolha diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar IngredienteEscolhas", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de IngredienteEscolha apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            IngredienteEscolha ingredienteEscolha = new IngredienteEscolha(id);
            
            dao.remover(ingredienteEscolha); // Remove o ingredienteEscolha do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(IngredienteEscolhaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover IngredienteEscolha", ex);
            return false;
        }
    }
}