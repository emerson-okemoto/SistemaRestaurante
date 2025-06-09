package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.IngredienteEscolha;
import model.IngredienteAdicional;
import model.IngredienteRemover;

/**
 * DTO para a entidade IngredienteEscolha. Responsável por transferir os dados
 * entre as camadas da aplicação.
 */
public class IngredienteEscolhaDTO extends InterfaceDTO {

    public String ingredienteAdicionalId;
    public String ingredienteRemoverId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        IngredienteEscolhaDTO dto = new IngredienteEscolhaDTO();
        IngredienteEscolha escolha = (IngredienteEscolha) e;

        dto.id = escolha.getId() == null ? "" : escolha.getId() + "";

        IngredienteAdicional adicional = escolha.getIngredienteAdicional();
        dto.ingredienteAdicionalId = (adicional != null && adicional.getId() != null) ? adicional.getId() + "" : "";

        IngredienteRemover remover = escolha.getIngredienteRemover();
        dto.ingredienteRemoverId = (remover != null && remover.getId() != null) ? remover.getId() + "" : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        IngredienteEscolha escolha = new IngredienteEscolha();

        escolha.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));

        IngredienteAdicional adicional = new IngredienteAdicional();
        adicional.setId(ingredienteAdicionalId == null || ingredienteAdicionalId.isEmpty() ? null : Integer.valueOf(ingredienteAdicionalId));
        escolha.setIngredienteAdicional(adicional);

        IngredienteRemover remover = new IngredienteRemover();
        remover.setId(ingredienteRemoverId == null || ingredienteRemoverId.isEmpty() ? null : Integer.valueOf(ingredienteRemoverId));
        escolha.setIngredienteRemover(remover);

        return escolha;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Ingrediente Adicional ID", "Ingrediente Remover ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, ingredienteAdicionalId, ingredienteRemoverId};
    }
}
