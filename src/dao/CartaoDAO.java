package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cartao;
import model.TipoCartao;

public class CartaoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Cartao c = new Cartao();
        c.setId(res.getInt("id"));
        c.setNumCartao(res.getString("num_cartao"));
        c.setCvv(res.getString("cvv"));
        c.setTipo(TipoCartao.valueOf(res.getString("tipo"))); // converte de String para Enum

        return c;
    }
}
