package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cupom;
import model.MetodoPagamento;
import model.Pagamento;
import model.Pedido;

public class PagamentoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Pagamento p = new Pagamento();
        p.setId(res.getInt("id"));

        // MetodoPagamento (instancia mínima com ID)
        Integer metodoPagamentoId = res.getObject("metodo_pagamento_id", Integer.class);
        if (metodoPagamentoId != null && metodoPagamentoId > 0) {
            p.setMet_pagamento(new MetodoPagamento(metodoPagamentoId));
        }

        // Cupom (instancia mínima com ID)
        Integer cupomId = res.getObject("cupom_id", Integer.class);
        if (cupomId != null && cupomId > 0) {
            p.setCupom(new Cupom(cupomId));
        }

        // Pedido (instancia mínima com ID)
        Integer pedidoId = res.getObject("pedido_id", Integer.class);
        if (pedidoId != null && pedidoId > 0) {
            p.setPedido(new Pedido(pedidoId));
        }

        return p;
    }
}
