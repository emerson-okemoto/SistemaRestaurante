package controller;

import dao.CarrinhoDAO;
import dto.CarrinhoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Carrinho;
import java.util.List;

public class CarrinhoController extends InterfaceController {

    private CarrinhoDAO dao; // Declaração do DAO para manipulação dos dados da entidade Carrinho (operações no banco de dados)


    public CarrinhoController() {
        dao = new CarrinhoDAO();
        dto = new CarrinhoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Carrinho e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(CarrinhoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Carrinho", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Carrinho e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(CarrinhoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Carrinho", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Carrinho.class); // Obtém uma lista de entidades Carrinho diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(CarrinhoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Carrinhos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Carrinho apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Carrinho carrinho = new Carrinho(id);
            
            dao.remover(carrinho); // Remove o Carrinho do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(CarrinhoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Carrinho", ex);
            return false;
        }
    }
}