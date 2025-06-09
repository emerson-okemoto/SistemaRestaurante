package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import model.Delivery;
import model.Entrega;
import model.Pedido;
import model.StatusPedido;
import model.TipoEntrega;

public class EntregaDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Entrega e = new Entrega();
        e.setId(res.getInt("id"));

        // Cliente (instancia mínima com ID)
        Cliente c = new Cliente(res.getInt("cliente_id"));
        e.setCliente(c);

        // TipoEntrega (enum)
        e.setTipoEntrega(TipoEntrega.valueOf(res.getString("tipo_entrega")));

        // Delivery (instancia mínima com ID)
        Delivery d = new Delivery(res.getInt("delivery_id"));
        e.setDelivery(d);

        // Pedido (instancia mínima com ID)
        Pedido p = new Pedido(res.getInt("pedido_id"));
        e.setPedido(p);

        // StatusPedido (instancia mínima com ID)
        StatusPedido sp = new StatusPedido(res.getInt("status_pedido_id"));
        e.setStatusPedido(sp);

        return e;
    }
}
