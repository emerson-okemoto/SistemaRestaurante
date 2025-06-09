package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Delivery;
import model.Endereco;

public class DeliveryDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Delivery d = new Delivery();
        d.setId(res.getInt("id"));
        d.setChaveEntrega(res.getString("chave_entrega"));
        d.setNumero(res.getString("numero"));
        d.setComplemento(res.getString("complemento"));

        // Instancia mínima de Endereco com ID
        Endereco e = new Endereco(res.getInt("endereco_id"));
        d.setEndereco(e);

        return d;
    }
}
