package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Endereco;
import model.TaxaEntrega;

/**
 * DTO para a entidade TaxaEntrega.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class TaxaEntregaDTO extends InterfaceDTO {

    public String enderecoId;
    public String valorTaxaEntrega;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        TaxaEntregaDTO dto = new TaxaEntregaDTO();
        TaxaEntrega taxaEntrega = (TaxaEntrega) e;

        dto.id = taxaEntrega.getId() == null ? "" : taxaEntrega.getId() + "";

        Endereco endereco = taxaEntrega.getEndereco();
        dto.enderecoId = (endereco != null && endereco.getId() != null) ? endereco.getId() + "" : "";

        dto.valorTaxaEntrega = taxaEntrega.getValorTaxaEntrega() != null ? taxaEntrega.getValorTaxaEntrega().toString() : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        TaxaEntrega taxaEntrega = new TaxaEntrega();

        taxaEntrega.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));

        Endereco endereco = new Endereco();
        endereco.setId(enderecoId == null || enderecoId.isEmpty() ? null : Integer.valueOf(enderecoId));
        taxaEntrega.setEndereco(endereco);

        taxaEntrega.setValorTaxaEntrega(valorTaxaEntrega == null || valorTaxaEntrega.isEmpty() ? null : Double.valueOf(valorTaxaEntrega));

        return taxaEntrega;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Endereco ID", "Valor Taxa Entrega"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, enderecoId, valorTaxaEntrega};
    }

}
