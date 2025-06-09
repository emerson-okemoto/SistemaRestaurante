package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalTime;
import java.time.LocalDate;
import model.Carrinho;
import model.Cliente;
import model.Entrega;
import model.Pedido;
import model.Reembolso;
import model.StatusPedido;

public class PedidoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Pedido p = new Pedido();
        p.setId(res.getInt("id"));

        // hora_pedido
        Time time = res.getTime("hora_pedido");
        if (time != null) {
            p.setHoraPedido(time.toLocalTime());
        }

        // data_pedido
        Date date = res.getDate("data_pedido");
        if (date != null) {
            p.setDataPedido(date.toLocalDate());
        }

        // Cliente (instancia mínima com ID)
        Integer clienteId = res.getObject("cliente_id", Integer.class);
        if (clienteId != null && clienteId > 0) {
            p.setCliente(new Cliente(clienteId));
        }

        // numero_pedido
        p.setNumeroPedido(res.getInt("numero_pedido"));

        // Carrinho (instancia mínima com ID)
        Integer carrinhoId = res.getObject("carrinho_id", Integer.class);
        if (carrinhoId != null && carrinhoId > 0) {
            p.setCarrinho(new Carrinho(carrinhoId));
        }

        // StatusPedido (instancia mínima com ID)
        Integer statusPedidoId = res.getObject("status_pedido_id", Integer.class);
        if (statusPedidoId != null && statusPedidoId > 0) {
            p.setStatusPedido(new StatusPedido(statusPedidoId));
        }

        // Entrega (instancia mínima com ID)
        Integer entregaId = res.getObject("entrega_id", Integer.class);
        if (entregaId != null && entregaId > 0) {
            p.setEntrega(new Entrega(entregaId));
        }

        // Reembolso (instancia mínima com ID)
        Integer reembolsoId = res.getObject("reembolso_id", Integer.class);
        if (reembolsoId != null && reembolsoId > 0) {
            p.setReembolso(new Reembolso(reembolsoId));
        }

        return p;
    }
}
