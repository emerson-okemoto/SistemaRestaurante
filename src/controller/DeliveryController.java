package controller;

import dao.DeliveryDAO;
import dto.DeliveryDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Delivery;
import java.util.List;

public class DeliveryController extends InterfaceController {

    private DeliveryDAO dao; // Declaração do DAO para manipulação dos dados da entidade Delivery (operações no banco de dados)


    public DeliveryController() {
        dao = new DeliveryDAO();
        dto = new DeliveryDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Delivery e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Delivery", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Delivery e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Delivery", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Delivery.class); // Obtém uma lista de entidades Delivery diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Deliverys", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Delivery apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Delivery delivery = new Delivery(id);
            
            dao.remover(delivery); // Remove o delivery do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(DeliveryController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Delivery", ex);
            return false;
        }
    }
}