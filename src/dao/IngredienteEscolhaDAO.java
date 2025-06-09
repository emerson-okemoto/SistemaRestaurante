package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.IngredienteEscolha;
import model.IngredienteAdicional;
import model.IngredienteRemover;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredienteEscolhaDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        IngredienteEscolha ie = new IngredienteEscolha(
            res.getInt("id"),
            null, // Vamos atribuir IngredienteAdicional abaixo
            null  // Vamos atribuir IngredienteRemover abaixo
        );

        // Se tiver ingrediente_adicional_id, associamos com apenas o id
        Integer adicionalId = res.getObject("ingrediente_adicional_id") != null ? res.getInt("ingrediente_adicional_id") : null;
        if (adicionalId != null) {
            ie.setIngredienteAdicional(new IngredienteAdicional(adicionalId));
        }

        // Se tiver ingrediente_remover_id, associamos com apenas o id
        Integer removerId = res.getObject("ingrediente_remover_id") != null ? res.getInt("ingrediente_remover_id") : null;
        if (removerId != null) {
            ie.setIngredienteRemover(new IngredienteRemover(removerId));
        }

        return ie;
    }
}
