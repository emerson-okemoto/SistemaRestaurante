package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Cupom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe responsável por transferir dados da entidade Cupom
 * entre as camadas da aplicação.
 */
public class CupomDTO extends InterfaceDTO {

    public String valorCupom;
    public String codigo;
    public String validade; // Data no formato String para facilitar a manipulação na UI

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        CupomDTO dto = new CupomDTO();
        Cupom cupom = (Cupom) e;
        dto.id = cupom.getId() == null ? "" : String.valueOf(cupom.getId());
        dto.valorCupom = String.valueOf(cupom.getValorCupon());
        dto.codigo = cupom.getCodigo();
        dto.validade = cupom.getValidade() != null ? sdf.format(cupom.getValidade()) : "";
        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Cupom cupom = new Cupom();

        cupom.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        cupom.setValorCupon(valorCupom == null || valorCupom.isEmpty() ? 0.0 : Double.valueOf(valorCupom));
        cupom.setCodigo(codigo);

        if (validade != null && !validade.isEmpty()) {
            try {
                Date data = sdf.parse(validade);
                cupom.setValidade(data);
            } catch (ParseException e) {
                cupom.setValidade(null); // ou tratar com uma data padrão
            }
        } else {
            cupom.setValidade(null);
        }

        return cupom;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Valor", "Código", "Validade"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, valorCupom, codigo, validade};
    }
}
