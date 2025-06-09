package controller;

import dao.ReembolsoDAO;
import dto.ReembolsoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Reembolso;
import java.util.List;

public class ReembolsoController extends InterfaceController {

    private ReembolsoDAO dao; // Declaração do DAO para manipulação dos dados da entidade Reembolso (operações no banco de dados)


    public ReembolsoController() {
        dao = new ReembolsoDAO();
        dto = new ReembolsoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Reembolso e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Reembolso", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Reembolso e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Reembolso", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Reembolso.class); // Obtém uma lista de entidades Reembolso diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Reembolsos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Reembolso apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Reembolso reembolso = new Reembolso(id);
            
            dao.remover(reembolso); // Remove o Reembolso do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(ReembolsoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Reembolso", ex);
            return false;
        }
    }
}