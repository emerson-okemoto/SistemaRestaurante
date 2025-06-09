package controller;

import dao.ProdutoDAO;
import dto.ProdutoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Produto;
import java.util.List;

public class ProdutoController extends InterfaceController {

    private ProdutoDAO dao; // Declaração do DAO para manipulação dos dados da entidade Produto (operações no banco de dados)


    public ProdutoController() {
        dao = new ProdutoDAO();
        dto = new ProdutoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Produto e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Produto", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Produto e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Produto", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Produto.class); // Obtém uma lista de entidades Produto diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Produtos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Produto apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Produto produto = new Produto(id);
            
            dao.remover(produto);
            return true;
        } catch (Exception ex) {
            System.getLogger(ProdutoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Produto", ex);
            return false;
        }
    }
}