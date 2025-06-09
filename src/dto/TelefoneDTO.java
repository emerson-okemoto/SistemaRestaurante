package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import java.util.LinkedList;
import java.util.List;
import model.Telefone;

/**
 * DTO para a entidade Telefone.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class TelefoneDTO extends InterfaceDTO {

    public String ddd;
    public String numero;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        TelefoneDTO dto = new TelefoneDTO();
        Telefone telefone = (Telefone) e;

        dto.id = telefone.getId() == null ? "" : telefone.getId() + "";
        dto.ddd = telefone.getDdd();
        dto.numero = telefone.getNumero();

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Telefone telefone = new Telefone();

        telefone.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        telefone.setDdd(ddd);
        telefone.setNumero(numero);

        return telefone;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "DDD", "Número"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, ddd, numero};
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
