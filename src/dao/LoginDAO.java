package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Login;

public class LoginDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Login login = new Login();
        login.setId(res.getInt("id"));
        login.setUsuario(res.getString("usuario"));
        login.setSenha(res.getString("senha"));

        return login;
    }
}
