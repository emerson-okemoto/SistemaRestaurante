package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.Cliente;
import model.Telefone;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        // Cria o Cliente com id e nome
        Cliente c = new Cliente(
            res.getInt("id"),
            res.getString("nome")
        );

        // Se houver telefone_id, associamos o Telefone
        Integer telefoneId = res.getObject("telefone_id") != null ? res.getInt("telefone_id") : null;
        if (telefoneId != null) {
            c.setTelefone(new Telefone(telefoneId));
        }

        return c;
    }
}