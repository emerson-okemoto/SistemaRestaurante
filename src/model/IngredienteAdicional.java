package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredienteAdicional extends Entidade {

    private String nome;
    private Double valor;

    public IngredienteAdicional() {
    }
    
    public IngredienteAdicional(Integer id) {
        setId(id);
    }

    public IngredienteAdicional(Integer id, String nome, Double valor) {
        setId(id);
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO ingrediente_adicional (nome, valor) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE ingrediente_adicional SET nome = ?, valor = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, nome);
        ps.setDouble(2, valor);
        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }
}