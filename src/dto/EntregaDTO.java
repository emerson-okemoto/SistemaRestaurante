package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Entrega;
import model.Cliente;
import model.Pedido;
import model.Delivery;
import model.TipoEntrega;
import model.StatusPedido;

/**
 * Classe responsável por transferir dados da entidade Entrega
 * entre as camadas da aplicação.
 */
public class EntregaDTO extends InterfaceDTO {

    public String clienteId;
    public String tipoEntrega;
    public String deliveryId;
    public String pedidoId;
    public String statusPedido;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        EntregaDTO dto = new EntregaDTO();
        Entrega entrega = (Entrega) e;

        dto.id = entrega.getId() == null ? "" : entrega.getId() + "";

        Cliente cliente = entrega.getCliente();
        dto.clienteId = (cliente != null && cliente.getId() != null) ? cliente.getId() + "" : "";

        dto.tipoEntrega = entrega.getTipoEntrega() != null ? entrega.getTipoEntrega().name() : "";

        Delivery delivery = entrega.getDelivery();
        dto.deliveryId = (delivery != null && delivery.getId() != null) ? delivery.getId() + "" : "";

        Pedido pedido = entrega.getPedido();
        dto.pedidoId = (pedido != null && pedido.getId() != null) ? pedido.getId() + "" : "";

        StatusPedido status = entrega.getStatusPedido();
        dto.statusPedido = (status != null) ? status.getProgresso() : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Entrega entrega = new Entrega();

        entrega.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));

        Cliente cliente = new Cliente();
        cliente.setId(clienteId == null || clienteId.isEmpty() ? null : Integer.valueOf(clienteId));
        entrega.setCliente(cliente);

        entrega.setTipoEntrega(tipoEntrega == null || tipoEntrega.isEmpty() ? null : TipoEntrega.valueOf(tipoEntrega));

        Delivery delivery = new Delivery();
        delivery.setId(deliveryId == null || deliveryId.isEmpty() ? null : Integer.valueOf(deliveryId));
        entrega.setDelivery(delivery);

        Pedido pedido = new Pedido();
        pedido.setId(pedidoId == null || pedidoId.isEmpty() ? null : Integer.valueOf(pedidoId));
        entrega.setPedido(pedido);

        StatusPedido status = new StatusPedido();
        status.setProgresso(statusPedido);
        entrega.setStatusPedido(status);

        return entrega;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Cliente ID", "Tipo Entrega", "Delivery ID", "Pedido ID", "Status Pedido"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, clienteId, tipoEntrega, deliveryId, pedidoId, statusPedido};
    }
}
