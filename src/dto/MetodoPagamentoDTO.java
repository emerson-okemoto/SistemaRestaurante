package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import java.util.LinkedList;
import java.util.List;
import model.MetodoPagamento;
import model.Dinheiro;
import model.Cartao;

/**
 * DTO para a entidade MetodoPagamento.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class MetodoPagamentoDTO extends InterfaceDTO {

    public String pix;
    public String dinheiroId;
    public String cartaoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        MetodoPagamentoDTO dto = new MetodoPagamentoDTO();
        MetodoPagamento metodo = (MetodoPagamento) e;

        dto.id = metodo.getId() == null ? "" : metodo.getId() + "";
        dto.pix = metodo.getPix() != null ? metodo.getPix().toString() : "";

        Dinheiro dinheiro = metodo.getDinheiro();
        dto.dinheiroId = (dinheiro != null && dinheiro.getId() != null) ? dinheiro.getId() + "" : "";

        Cartao cartao = metodo.getCartao();
        dto.cartaoId = (cartao != null && cartao.getId() != null) ? cartao.getId() + "" : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        MetodoPagamento metodo = new MetodoPagamento();

        metodo.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        metodo.setPix(pix == null || pix.isEmpty() ? null : Double.valueOf(pix));

        Dinheiro dinheiro = new Dinheiro();
        dinheiro.setId(dinheiroId == null || dinheiroId.isEmpty() ? null : Integer.valueOf(dinheiroId));
        metodo.setDinheiro(dinheiro);

        Cartao cartao = new Cartao();
        cartao.setId(cartaoId == null || cartaoId.isEmpty() ? null : Integer.valueOf(cartaoId));
        metodo.setCartao(cartao);

        return metodo;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Pix", "Dinheiro ID", "Cartao ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, pix, dinheiroId, cartaoId};
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
