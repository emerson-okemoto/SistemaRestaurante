package controller;

import dao.CartaoDAO;
import dto.CartaoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Cartao;
import java.util.List;

public class CartaoController extends InterfaceController {

    private CartaoDAO dao; // Declaração do DAO para manipulação dos dados da entidade Cartao (operações no banco de dados)


    public CartaoController() {
        dao = new CartaoDAO();
        dto = new CartaoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Cartao e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(CartaoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Cartao", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Cartao e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(CartaoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Cartao", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Cartao.class); // Obtém uma lista de entidades Cartao diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(CartaoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Cartaos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Cartao apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Cartao cartao = new Cartao(id);
            
            dao.remover(cartao);
            return true;
        } catch (Exception ex) {
            System.getLogger(CartaoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Cartao", ex);
            return false;
        }
    }
}