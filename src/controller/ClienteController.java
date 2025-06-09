package controller;

import dao.ClienteDAO;
import dto.ClienteDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Cliente;
import java.util.List;

public class ClienteController extends InterfaceController {

    private ClienteDAO dao; // Declaração do DAO para manipulação dos dados da entidade Cliente (operações no banco de dados)


    public ClienteController() {
        dao = new ClienteDAO();
        dto = new ClienteDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Cliente e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Cliente", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Cliente e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Cliente", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Cliente.class); // Obtém uma lista de entidades Cliente diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Clientes", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Cliente apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Cliente cliente = new Cliente(id);
            
            dao.remover(cliente); // Remove o Cliente do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(ClienteController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Cliente", ex);
            return false;
        }
    }
}