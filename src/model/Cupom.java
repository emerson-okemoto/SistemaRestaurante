package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class Cupom extends Entidade {

    private Double valorCupom;
    private String codigo;
    private java.util.Date validade;

    public Cupom() {
    }
    
    public Cupom(Integer id) {
        setId(id);
    }
    
    public Cupom(Integer id, Double valorCupom, String codigo, java.util.Date validade) {
        setId(id); // método herdado da classe Entidade
        this.valorCupom = valorCupom;
        this.codigo = codigo;
        this.validade = validade;
    }

    public Double getValorCupom() {
        return valorCupom;
    }

    public void setValorCupom(Double valorCupom) {
        this.valorCupom = valorCupom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public java.util.Date getValidade() {
        return validade;
    }

    public void setValidade(java.util.Date validade) {
        this.validade = validade;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO cupom (valor_cupon, codigo, validade) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setDouble(1, valorCupom);
        ps.setString(2, codigo);
        ps.setDate(3, new Date(validade.getTime())); // convertendo java.util.Date para java.sql.Date

        if (getId() != null && getId() > 0) {
            ps.setInt(4, getId());
        }
    }

    @Override
    public String getUpdate() {
        return "UPDATE cupom SET valor_cupom = ?, codigo = ?, validade = ? WHERE id = ?";
    }
}