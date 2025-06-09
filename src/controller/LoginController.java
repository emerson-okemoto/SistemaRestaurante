package controller;

import dao.LoginDAO;
import dto.LoginDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Login;
import java.util.List;

public class LoginController extends InterfaceController {

    private LoginDAO dao; // Declaração do DAO para manipulação dos dados da entidade Login (operações no banco de dados)


    public LoginController() {
        dao = new LoginDAO();
        dto = new LoginDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Login e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(LoginController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Login", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Login e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(LoginController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Login", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Login.class); // Obtém uma lista de entidades Login diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(LoginController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Logins", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Login apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Login login = new Login(id);
            
            dao.remover(login); // Remove o login do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(LoginController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Login", ex);
            return false;
        }
    }
}