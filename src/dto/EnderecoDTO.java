package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Bairro;
import model.Endereco;

/**
 * Classe responsável por transferir dados da entidade Endereco entre as camadas
 * da aplicação.
 */
public class EnderecoDTO extends InterfaceDTO {

    public String rua;
    public String cep;
    public Bairro bairro; // Nome ajustado para não confundir com ID
    public String distancia; // Armazenada como String para facilitar manipulação na UI

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        Endereco endereco = (Endereco) e;

        id = endereco.getId() == null ? "" : String.valueOf(endereco.getId());
        rua = endereco.getRua();
        cep = endereco.getCep();
        distancia = String.valueOf(endereco.getDistancia());
        bairro = endereco.getBairro();

        return this;
    }

    @Override
    public Entidade buildEntidade() {
        Endereco endereco = new Endereco();

        endereco.setId(id == null || id.isEmpty() ? 0 : Integer.valueOf(id));
        endereco.setRua(rua);
        endereco.setCep(cep);

        try {
            endereco.setDistancia(distancia == null || distancia.isEmpty() ? 0f : Float.parseFloat(distancia));
        } catch (NumberFormatException e) {
            endereco.setDistancia(0f); // fallback seguro
        }

        endereco.setBairro(bairro);

        return endereco;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Rua", "CEP", "Distância", "ID Bairro"};
    }

    @Override
    public Object[] dadosTable() {

        // Verifica se o Bairro está definido e obtém seu ID para exibição
        String bairroIdString = "";
        if (bairro != null && bairro.getId() != null) {
            bairroIdString = String.valueOf(bairro.getId());
        }

        // Retorna os dados da tabela
        return new Object[]{id, rua, cep, distancia, bairroIdString};
    }
}
