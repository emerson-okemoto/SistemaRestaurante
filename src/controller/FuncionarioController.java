package controller;

import dao.FuncionarioDAO;
import dto.FuncionarioDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Funcionario;
import java.util.List;

public class FuncionarioController extends InterfaceController {

    private FuncionarioDAO dao; // Declaração do DAO para manipulação dos dados da entidade Funcionario (operações no banco de dados)


    public FuncionarioController() {
        dao = new FuncionarioDAO();
        dto = new FuncionarioDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Funcionario e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Funcionario", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Funcionario e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Funcionario", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Funcionario.class); // Obtém uma lista de entidades Funcionario diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Funcionarios", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Funcionario apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Funcionario funcionario = new Funcionario(id);
            
            dao.remover(funcionario); // Remove o funcionario do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(FuncionarioController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Funcionario", ex);
            return false;
        }
    }
}