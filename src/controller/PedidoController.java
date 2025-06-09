package controller;

import dao.PedidoDAO;
import dto.PedidoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Pedido;
import java.util.List;

public class PedidoController extends InterfaceController {

    private PedidoDAO dao; // Declaração do DAO para manipulação dos dados da entidade Pedido (operações no banco de dados)


    public PedidoController() {
        dao = new PedidoDAO();
        dto = new PedidoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Pedido e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(PedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Pedido", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Pedido e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(PedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Pedido", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Pedido.class); // Obtém uma lista de entidades Pedido diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(PedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Pedidos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Pedido apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Pedido pedido = new Pedido(id);
            
            dao.remover(pedido); // Remove o pedido do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(PedidoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Pedido", ex);
            return false;
        }
    }
}