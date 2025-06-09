package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.Bairro;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BairroDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Bairro b = new Bairro(res.getString("nome"));
        b.setId(res.getInt("id"));
        return b;
    }
}