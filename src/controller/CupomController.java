package controller;

import dao.CupomDAO;
import dto.CupomDTO;
import interfaces.InterfaceController;
import interfaces.InterfaceDTO;
import model.Cupom;
import java.util.List;

public class CupomController extends InterfaceController {

    private CupomDAO dao; // Declaração do DAO para manipulação dos dados da entidade Cupom (operações no banco de dados)


    public CupomController() {
        dao = new CupomDAO();
        dto = new CupomDTO(); // DTO usado para trocar informações entre View e Controller/Model
    }

    @Override
    public Boolean salvar() {
        try {
            dao.salvar(dto.buildEntidade()); // Converte o DTO para entidade Cupom e salva no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(CupomController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao salvar Cupom", ex);
            return false;
        }
    }

    @Override
    public Boolean editar() {
        try {
            dao.editar(dto.buildEntidade()); // Converte o DTO para entidade Cupom e atualiza no banco
            return true;
        } catch (Exception ex) {
            System.getLogger(CupomController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao editar Cupom", ex);
            return false;
        }
    }

    @Override
    public List<InterfaceDTO> listar() {
        try {
            List lista = dao.listarTodos(Cupom.class); // Obtém uma lista de entidades Cupom diretamente do banco de dados
            return dto.preencheLista(lista); // Converte a lista de entidades em uma lista de DTOs que será utilizada na camada de visualização
        } catch (Exception ex) {
            System.getLogger(CupomController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao listar Cupoms", ex);
            return null;
        }
    }

    @Override
    public Boolean remover(Integer id) {
        try {
            // Cria uma instância de Cupom apenas com o ID
            // (o DAO normalmente só precisa do ID para fazer a exclusão)
            Cupom cupom = new Cupom(id);
            
            dao.remover(cupom); // Remove o Cupom do banco de dados
            return true;
        } catch (Exception ex) {
            System.getLogger(CupomController.class.getName())
                  .log(System.Logger.Level.ERROR, "Erro ao remover Cupom", ex);
            return false;
        }
    }
}