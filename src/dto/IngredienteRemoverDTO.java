package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.IngredienteRemover;

/**
 * DTO para a entidade IngredienteRemover.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class IngredienteRemoverDTO extends InterfaceDTO {

    public String nome;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        IngredienteRemoverDTO dto = new IngredienteRemoverDTO();
        IngredienteRemover ingrediente = (IngredienteRemover) e;

        dto.id = ingrediente.getId() == null ? "" : ingrediente.getId() + "";
        dto.nome = ingrediente.getNome();

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        IngredienteRemover ingrediente = new IngredienteRemover();

        ingrediente.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        ingrediente.setNome(nome);

        return ingrediente;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, nome};
    }

}
