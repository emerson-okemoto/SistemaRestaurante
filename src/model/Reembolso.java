package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reembolso extends Entidade {

    private Pedido pedido;
    private String motivo;

    public Reembolso() {
    }

    public Reembolso(Integer id) {
        setId(id);
    }

    public Reembolso(Integer id, Pedido pedido, String motivo) {
        setId(id);
        this.pedido = pedido;
        this.motivo = motivo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO reembolso (pedido_id, motivo) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE reembolso SET pedido_id = ?, motivo = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setInt(1, pedido != null && pedido.getId() != null ? pedido.getId() : 0);
        ps.setString(2, motivo);

        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }

}
