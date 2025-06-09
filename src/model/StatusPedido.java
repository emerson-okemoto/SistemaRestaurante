package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatusPedido extends Entidade {

    private Pedido pedido;
    private String progresso;

    public StatusPedido() {
    }

    public StatusPedido(Integer id) {
        setId(id);
    }

    public StatusPedido(Integer id, Pedido pedido, String progresso) {
        setId(id);
        this.pedido = pedido;
        this.progresso = progresso;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO status_pedido (pedido_id, progresso) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE status_pedido SET pedido_id = ?, progresso = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setInt(1, pedido != null && pedido.getId() != null ? pedido.getId() : 0);
        ps.setString(2, progresso);

        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }
    
}
