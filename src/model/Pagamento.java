package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pagamento extends Entidade {

    private MetodoPagamento met_pagamento;
    private Cupom cupom;
    private Pedido pedido;

    public Pagamento() {
    }
    
    public Pagamento(Integer id) {
        setId(id);
    }

    public Pagamento(Integer id, MetodoPagamento met_pagamento, Cupom cupom, Pedido pedido) {
        setId(id);
        this.met_pagamento = met_pagamento;
        this.cupom = cupom;
        this.pedido = pedido;
    }

    public MetodoPagamento getMet_pagamento() {
        return met_pagamento;
    }

    public void setMet_pagamento(MetodoPagamento met_pagamento) {
        this.met_pagamento = met_pagamento;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO pagamento (metodo_pagamento_id, cupom_id, pedido_id) VALUES (?, ?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE pagamento SET metodo_pagamento_id = ?, cupom_id = ?, pedido_id = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setObject(1, met_pagamento != null ? met_pagamento.getId() : null);
        ps.setObject(2, cupom != null ? cupom.getId() : null);
        ps.setObject(3, pedido != null ? pedido.getId() : null);
        
        if (getId() != null && getId() > 0) {
            ps.setInt(4, getId());
        }
    }
}
