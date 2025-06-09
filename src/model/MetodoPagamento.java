/**
 * CREATE TABLE metodo_pagamento (
 * id SERIAL PRIMARY KEY,
 * pix NUMERIC(10,2),
 * dinheiro_id INTEGER,
 * cartao_id INTEGER,
 * FOREIGN KEY (dinheiro_id) REFERENCES dinheiro(id),
 * FOREIGN KEY (cartao_id) REFERENCES cartao(id)
 * );
 *
 * */
package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetodoPagamento extends Entidade {

    private Double pix; // valor via Pix
    private Dinheiro dinheiro;
    private Cartao cartao;

    public MetodoPagamento() {
    }

    public MetodoPagamento(Integer id) {
        setId(id);
    }

    public MetodoPagamento(Integer id, Double pix, Dinheiro dinheiro, Cartao cartao) {
        setId(id);
        this.pix = pix;
        this.dinheiro = dinheiro;
        this.cartao = cartao;
    }

    public Double getPix() {
        return pix;
    }

    public void setPix(Double pix) {
        this.pix = pix;
    }

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO metodo_pagamento (pix, dinheiro_id, cartao_id) VALUES (?, ?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE metodo_pagamento SET pix = ?, dinheiro_id = ?, cartao_id = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setObject(1, pix);
        ps.setObject(2, dinheiro != null ? dinheiro.getId() : null);
        ps.setObject(3, cartao != null ? cartao.getId() : null);
        if (getId() != null && getId() > 0) {
            ps.setInt(4, getId());
        }
    }

    @Override
    public String toString() {
        return "MetodoPagamento{"
                + "id=" + getId()
                + ", pix=" + pix
                + ", dinheiro=" + (dinheiro != null ? dinheiro.getValorEntregado() : "null")
                + ", cartao=" + (cartao != null ? cartao.getTipo() : "null")
                + '}';
    }
}
