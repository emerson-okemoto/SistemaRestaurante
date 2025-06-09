package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Dinheiro;

/**
 * Classe responsável por transferir dados da entidade Dinheiro
 * entre as camadas da aplicação.
 */
public class DinheiroDTO extends InterfaceDTO {

    public String valorEntregado;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        DinheiroDTO dto = new DinheiroDTO();
        Dinheiro dinheiro = (Dinheiro) e;
        dto.id = dinheiro.getId() == null ? "" : dinheiro.getId() + "";
        dto.valorEntregado = dinheiro.getValorEntregado() == null ? "" : dinheiro.getValorEntregado() + "";
        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Dinheiro dinheiro = new Dinheiro();
        dinheiro.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        dinheiro.setValorEntregado(valorEntregado == null || valorEntregado.isEmpty() ? null : Double.valueOf(valorEntregado));

        return dinheiro;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Valor Entregue"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, valorEntregado};
    }
}
