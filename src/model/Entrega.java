package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Entrega extends Entidade {

    private Cliente cliente;
    private TipoEntrega tipoEntrega;
    private Delivery delivery;
    private Pedido pedido;
    private StatusPedido statusPedido;

    // Construtor vazio 
    public Entrega() {
    }

    // Construtor com parametro
    public Entrega(Integer id) {
        setId(id); // usa o método herdado da classe Entidade
    }

    public Entrega(Integer id, Cliente cliente, TipoEntrega tipoEntrega, Delivery delivery, Pedido pedido, StatusPedido statusPedido) {
        setId(id); // usa o método herdado da classe Entidade
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.delivery = delivery;
        this.pedido = pedido;
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO entrega (cliente_id, tipo_entrega, delivery_id, pedido_id, status_pedido_id) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE entrega SET cliente_id = ?, tipo_entrega = ?, delivery_id = ?, pedido_id = ?, status_pedido_id = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setInt(1, cliente != null && cliente.getId() != null ? cliente.getId() : 0);
        ps.setString(2, tipoEntrega != null ? tipoEntrega.name() : null);
        ps.setInt(3, delivery != null && delivery.getId() != null ? delivery.getId() : 0);
        ps.setInt(4, pedido != null && pedido.getId() != null ? pedido.getId() : 0);
        ps.setInt(5, statusPedido != null && statusPedido.getId() != null ? statusPedido.getId() : 0);

        if (getId() != null && getId() > 0) {
            ps.setInt(6, getId());
        }
    }
}
