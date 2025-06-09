package controller;

import dao.EntregaDAO;
import dto.EntregaDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Entrega;
import java.util.List;

public class EntregaController extends InterfaceController {

    private EntregaDAO dao; // Declaração do DAO para manipulação dos dados da entidade Entrega (operações no banco de dados)


    public EntregaController() {
        dao = new EntregaDAO();
        dto = new EntregaDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Entrega e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(EntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Entrega", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Entrega e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(EntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Entrega", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Entrega.class); // Obtém uma lista de entidades Entrega diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(EntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Entregas", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Entrega apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Entrega entrega = new Entrega(id);
            
            dao.remover(entrega); // Remove o entrega do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(EntregaController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Entrega", ex);
            return false;
        }
    }
}