package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.IngredienteAdicional;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredienteAdicionalDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        IngredienteAdicional ia = new IngredienteAdicional(
            res.getInt("id"),
            res.getString("nome"),
            res.getDouble("valor")
        );

        return ia;
    }
}
