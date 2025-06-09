package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.IngredienteRemover;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredienteRemoverDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        IngredienteRemover ir = new IngredienteRemover(
            res.getInt("id"),
            res.getString("nome")
        );

        return ir;
    }
}
