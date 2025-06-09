package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Produto;

public class ProdutoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Produto p = new Produto();
        p.setId(res.getInt("id"));
        p.setNome(res.getString("nome"));
        p.setValorUnitario(res.getDouble("valor_unitario"));

        return p;
    }
}
