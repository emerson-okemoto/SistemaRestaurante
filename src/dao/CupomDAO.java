package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cupom;

public class CupomDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Cupom c = new Cupom();
        c.setId(res.getInt("id"));
        c.setValorCupom(res.getDouble("valor_cupom"));
        c.setCodigo(res.getString("codigo"));
        c.setValidade(res.getDate("validade")); // ResultSet.getDate já retorna java.sql.Date, que herda de java.util.Date

        return c;
    }
}
