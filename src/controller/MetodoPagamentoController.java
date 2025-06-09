package controller;

import dao.MetodoPagamentoDAO;
import dto.MetodoPagamentoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.MetodoPagamento;
import java.util.List;

public class MetodoPagamentoController extends InterfaceController {

    private MetodoPagamentoDAO dao; // Declaração do DAO para manipulação dos dados da entidade MetodoPagamento (operações no banco de dados)

    public MetodoPagamentoController() {
        dao = new MetodoPagamentoDAO();
        dto = new MetodoPagamentoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade MetodoPagamento e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(MetodoPagamentoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar MetodoPagamento", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade MetodoPagamento e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(MetodoPagamentoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar MetodoPagamento", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(MetodoPagamento.class); // Obtém uma lista de entidades MetodoPagamento diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(MetodoPagamentoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar MetodoPagamentos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de MetodoPagamento apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            MetodoPagamento metodoPagamento = new MetodoPagamento(id);
            
            dao.remover(metodoPagamento); // Remove o metodoPagamento do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(MetodoPagamentoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover MetodoPagamento", ex);
            return false;
        }
    }
}