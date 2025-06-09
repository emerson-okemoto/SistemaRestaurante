package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pedido;
import model.StatusPedido;

public class StatusPedidoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        StatusPedido sp = new StatusPedido();
        sp.setId(res.getInt("id"));

        // Pedido (instancia mínima com ID)
        Integer pedidoId = res.getObject("pedido_id", Integer.class);
        if (pedidoId != null && pedidoId > 0) {
            sp.setPedido(new Pedido(pedidoId));
        }

        sp.setProgresso(res.getString("progresso"));

        return sp;
    }
}
