package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Bairro;
import model.Endereco;

public class EnderecoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Endereco e = new Endereco();
        e.setId(res.getInt("id"));
        e.setRua(res.getString("rua"));
        e.setCep(res.getString("cep"));
        e.setDistancia(res.getFloat("distancia"));

        // Instancia mínima de Bairro com ID
        Bairro b = new Bairro(res.getInt("bairro_id"));
        e.setBairro(b);

        return e;
    }
}
