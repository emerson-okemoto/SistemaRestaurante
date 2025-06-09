package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dinheiro extends Entidade {

    private Double valorEntregado;

    public Dinheiro() {
    }

    public Dinheiro(Integer id) {
        setId(id);
    }

    public Dinheiro(Integer id, Double valorEntregado) {
        setId(id); // usa o método herdado de Entidade
        this.valorEntregado = valorEntregado;
    }

    public Double getValorEntregado() {
        return valorEntregado;
    }

    public void setValorEntregado(Double valorEntregado) {
        this.valorEntregado = valorEntregado;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO dinheiro (valor_entregado) VALUES (?)";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setDouble(1, valorEntregado != null ? valorEntregado : 0.0);

        Integer id = getId();
        if (id != null && id > 0) {
            ps.setInt(2, getId());
        }
    }

    @Override
    public String getUpdate() {
        return "UPDATE dinheiro SET valor_entregado = ? WHERE id = ?";
    }
}
