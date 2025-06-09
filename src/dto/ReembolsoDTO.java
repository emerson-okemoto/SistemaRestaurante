package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Reembolso;
import model.Pedido;

/**
 * DTO para a entidade Reembolso.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class ReembolsoDTO extends InterfaceDTO {

    public String pedidoId;
    public String motivo;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        ReembolsoDTO dto = new ReembolsoDTO();
        Reembolso reembolso = (Reembolso) e;

        dto.id = reembolso.getId() == null ? "" : reembolso.getId() + "";
        dto.motivo = reembolso.getMotivo();

        Pedido pedido = reembolso.getPedido();
        dto.pedidoId = (pedido != null && pedido.getId() != null) ? pedido.getId() + "" : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Reembolso reembolso = new Reembolso();

        reembolso.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        reembolso.setMotivo(motivo);

        Pedido pedido = new Pedido();
        pedido.setId(pedidoId == null || pedidoId.isEmpty() ? null : Integer.valueOf(pedidoId));
        reembolso.setPedido(pedido);

        return reembolso;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Pedido ID", "Motivo"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, pedidoId, motivo};
    }
}