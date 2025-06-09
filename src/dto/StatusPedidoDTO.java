package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Pedido;
import model.StatusPedido;

/**
 * DTO para a entidade StatusPedido.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class StatusPedidoDTO extends InterfaceDTO {

    public String pedidoId;
    public String progresso;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        StatusPedidoDTO dto = new StatusPedidoDTO();
        StatusPedido statusPedido = (StatusPedido) e;

        dto.id = statusPedido.getId() == null ? "" : statusPedido.getId() + "";

        Pedido pedido = statusPedido.getPedido();
        dto.pedidoId = (pedido != null && pedido.getId() != null) ? pedido.getId() + "" : "";

        dto.progresso = statusPedido.getProgresso();

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        StatusPedido statusPedido = new StatusPedido();

        statusPedido.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));

        Pedido pedido = new Pedido();
        pedido.setId(pedidoId == null || pedidoId.isEmpty() ? null : Integer.valueOf(pedidoId));
        statusPedido.setPedido(pedido);

        statusPedido.setProgresso(progresso);

        return statusPedido;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Pedido ID", "Progresso"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, pedidoId, progresso};
    }
}
