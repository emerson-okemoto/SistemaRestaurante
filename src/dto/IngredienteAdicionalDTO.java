package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import java.util.LinkedList;
import java.util.List;
import model.IngredienteAdicional;

/**
 * DTO para a entidade IngredienteAdicional.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class IngredienteAdicionalDTO extends InterfaceDTO {

    public String nome;
    public String valor;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        IngredienteAdicionalDTO dto = new IngredienteAdicionalDTO();
        IngredienteAdicional ingrediente = (IngredienteAdicional) e;

        dto.id = ingrediente.getId() == null ? "" : ingrediente.getId() + "";
        dto.nome = ingrediente.getNome();
        dto.valor = ingrediente.getValor() != null ? ingrediente.getValor().toString() : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        IngredienteAdicional ingrediente = new IngredienteAdicional();

        ingrediente.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        ingrediente.setNome(nome);
        ingrediente.setValor(valor == null || valor.isEmpty() ? null : Double.valueOf(valor));

        return ingrediente;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome", "Valor"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, nome, valor};
    }

    @Override
    public List<InterfaceDTO> preencheLista(List<Entidade> e) {
        List<InterfaceDTO> retorno = new LinkedList<>();
        for (Entidade entidade : e) {
            retorno.add(this.buildDTO(entidade));
        }
        return retorno;
    }
}
