package dto;

//import java.util.Objects;
import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Cartao;
import model.TipoCartao;

public class CartaoDTO extends InterfaceDTO {

    public String numCartao;
    public String cvv;
    public TipoCartao tipo; // Representa o enum TipoCartao como String

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        CartaoDTO dto = new CartaoDTO();
        Cartao cartao = (Cartao) e;
        dto.id = cartao.getId() + "";
        dto.numCartao = cartao.getNumCartao();
        dto.cvv = cartao.getCvv();
        dto.tipo = cartao.getTipo();
        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Cartao cartao = new Cartao();

        cartao.setId(id == null ? 0 : Integer.valueOf(id));
        cartao.setNumCartao(numCartao);
        cartao.setCvv(cvv);
        cartao.setTipo(tipo);

        return cartao;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Número", "CVV", "Tipo"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, numCartao, cvv, (tipo != null ? tipo.name() : "")};
    }

 
//    @Override
//    public Object[] dadosTable() {
//        String tipoString = "";
//        if (tipo != null) {
//            tipoString = tipo.name();
//        }
//        return new Object[]{id, numCartao, cvv, tipoString};
//    }
//    @Override
//    public Object[] dadosTable() {
//        return new Object[]{id, numCartao, cvv, Objects.toString(tipo, "")};
//    }
    
    
//    private String tipoDeCartaoToString() {
//        return (tipo != null) ? tipo.name() : "";
//    }
//
//    @Override
//    public Object[] dadosTable() {
//        return new Object[]{id, numCartao, cvv, tipoDeCartaoToString()};
//    }

}
