package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pedido;
import model.Reembolso;

public class ReembolsoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Reembolso r = new Reembolso();
        r.setId(res.getInt("id"));

        // Pedido (instancia mínima com ID)
        Integer pedidoId = res.getObject("pedido_id", Integer.class);
        if (pedidoId != null && pedidoId > 0) {
            r.setPedido(new Pedido(pedidoId));
        }

        r.setMotivo(res.getString("motivo"));

        return r;
    }
}
