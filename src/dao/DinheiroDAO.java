package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.Dinheiro;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DinheiroDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        // Cria o objeto Dinheiro com os campos básicos
        Dinheiro d = new Dinheiro(
            res.getInt("id"),
            res.getDouble("valor_entregado")
        );

        return d;
    }
}