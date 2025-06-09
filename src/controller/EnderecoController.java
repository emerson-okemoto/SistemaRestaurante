package controller;

import dao.EnderecoDAO;
import dto.EnderecoDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Endereco;
import java.util.List;

public class EnderecoController extends InterfaceController {

    private EnderecoDAO dao; // Declaração do DAO para manipulação dos dados da entidade Endereco (operações no banco de dados)


    public EnderecoController() {
        dao = new EnderecoDAO();
        dto = new EnderecoDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Endereco e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Endereco", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Endereco e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Endereco", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Endereco.class); // Obtém uma lista de entidades Endereco diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Enderecos", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Endereco apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Endereco endereco = new Endereco(id);
            
            dao.remover(endereco); // Remove o endereco do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(EnderecoController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Endereco", ex);
            return false;
        }
    }
}