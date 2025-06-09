package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredienteEscolha extends Entidade {

    private IngredienteAdicional ingredienteAdicional;
    private IngredienteRemover ingredienteRemover;

    public IngredienteEscolha() {
    }
    
    public IngredienteEscolha(Integer id) {
        setId(id);
    }

    public IngredienteEscolha(Integer id, IngredienteAdicional ingredienteAdicional, IngredienteRemover ingredienteRemover) {
        setId(id);
        this.ingredienteAdicional = ingredienteAdicional;
        this.ingredienteRemover = ingredienteRemover;
    }

    public IngredienteAdicional getIngredienteAdicional() {
        return ingredienteAdicional;
    }

    public void setIngredienteAdicional(IngredienteAdicional ingredienteAdicional) {
        this.ingredienteAdicional = ingredienteAdicional;
    }

    public IngredienteRemover getIngredienteRemover() {
        return ingredienteRemover;
    }

    public void setIngredienteRemover(IngredienteRemover ingredienteRemover) {
        this.ingredienteRemover = ingredienteRemover;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO ingrediente_escolha (ingrediente_adicional_id, ingrediente_remover_id) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE ingrediente_escolha SET ingrediente_adicional_id = ?, ingrediente_remover_id = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        if (ingredienteAdicional != null && ingredienteAdicional.getId() != null) {
            ps.setInt(1, ingredienteAdicional.getId());
        } else {
            ps.setNull(1, java.sql.Types.INTEGER);
        }

        if (ingredienteRemover != null && ingredienteRemover.getId() != null) {
            ps.setInt(2, ingredienteRemover.getId());
        } else {
            ps.setNull(2, java.sql.Types.INTEGER);
        }

        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }
}
