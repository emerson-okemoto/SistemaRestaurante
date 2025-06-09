package dto;

import java.time.LocalDate;
import java.time.LocalTime;

import interfaces.Entidade;
import interfaces.InterfaceDTO;

import model.Carrinho;
import model.Cliente;
import model.Entrega;
import model.Pedido;
import model.Reembolso;
import model.StatusPedido;

/**
 * DTO para a entidade Pedido.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class PedidoDTO extends InterfaceDTO {

    public String horaPedido;     // armazenar LocalTime como String (ex: "14:30:00")
    public String dataPedido;     // armazenar LocalDate como String (ex: "2025-05-23")
    public String clienteId;
    public String numeroPedido;
    public String carrinhoId;
    public String statusPedidoId;
    public String entregaId;
    public String reembolsoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        PedidoDTO dto = new PedidoDTO();
        Pedido pedido = (Pedido) e;

        dto.id = pedido.getId() == null ? "" : pedido.getId() + "";
        dto.horaPedido = pedido.getHoraPedido() != null ? pedido.getHoraPedido().toString() : "";
        dto.dataPedido = pedido.getDataPedido() != null ? pedido.getDataPedido().toString() : "";

        Cliente cliente = pedido.getCliente();
        dto.clienteId = (cliente != null && cliente.getId() != null) ? cliente.getId() + "" : "";

        dto.numeroPedido = pedido.getNumeroPedido() != null ? pedido.getNumeroPedido().toString() : "";

        Carrinho carrinho = pedido.getCarrinho();
        dto.carrinhoId = (carrinho != null && carrinho.getId() != null) ? carrinho.getId() + "" : "";

        StatusPedido status = pedido.getStatusPedido();
        dto.statusPedidoId = (status != null && status.getId() != null) ? status.getId() + "" : "";

        Entrega entrega = pedido.getEntrega();
        dto.entregaId = (entrega != null && entrega.getId() != null) ? entrega.getId() + "" : "";

        Reembolso reembolso = pedido.getReembolso();
        dto.reembolsoId = (reembolso != null && reembolso.getId() != null) ? reembolso.getId() + "" : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Pedido pedido = new Pedido();

        pedido.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        
        pedido.setHoraPedido(horaPedido == null || horaPedido.isEmpty() ? null : LocalTime.parse(horaPedido));
        
        pedido.setDataPedido(dataPedido == null || dataPedido.isEmpty() ? null : LocalDate.parse(dataPedido));
        
        if (clienteId != null && !clienteId.isEmpty()) {
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(clienteId));
            pedido.setCliente(cliente);
        }
        
        pedido.setNumeroPedido(numeroPedido == null || numeroPedido.isEmpty() ? null : Integer.valueOf(numeroPedido));
        
        if (carrinhoId != null && !carrinhoId.isEmpty()) {
            Carrinho carrinho = new Carrinho();
            carrinho.setId(Integer.valueOf(carrinhoId));
            pedido.setCarrinho(carrinho);
        }
        
        if (statusPedidoId != null && !statusPedidoId.isEmpty()) {
            StatusPedido status = new StatusPedido();
            status.setId(Integer.valueOf(statusPedidoId));
            pedido.setStatusPedido(status);
        }
        
        if (entregaId != null && !entregaId.isEmpty()) {
            Entrega entrega = new Entrega();
            entrega.setId(Integer.valueOf(entregaId));
            pedido.setEntrega(entrega);
        }
        
        if (reembolsoId != null && !reembolsoId.isEmpty()) {
            Reembolso reembolso = new Reembolso();
            reembolso.setId(Integer.valueOf(reembolsoId));
            pedido.setReembolso(reembolso);
        }

        return pedido;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Hora Pedido", "Data Pedido", "Cliente ID", "Numero Pedido", "Carrinho ID", "Status Pedido ID", "Entrega ID", "Reembolso ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, horaPedido, dataPedido, clienteId, numeroPedido, carrinhoId, statusPedidoId, entregaId, reembolsoId};
    }
}
