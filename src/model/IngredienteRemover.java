package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredienteRemover extends Entidade {

    private String nome;

    public IngredienteRemover() {
    }

    public IngredienteRemover(Integer id) {
        setId(id);
    }

    public IngredienteRemover(Integer id, String nome) {
        setId(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO ingrediente_remover (nome) VALUES (?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE ingrediente_remover SET nome = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, nome);
        if (getId() != null && getId() > 0) {
            ps.setInt(2, getId());
        }
    }
}
