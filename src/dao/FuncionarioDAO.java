package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import model.Funcionario;
import model.Login;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        // Cria o objeto Funcionario com campos básicos
        Funcionario f = new Funcionario(
                res.getInt("id"),
                res.getString("nome"),
                res.getString("cpf"),
                res.getString("rg"),
                null, // Telefones não são carregados aqui
                null // Vamos atribuir Login abaixo
        );

//        // Se houver telefone_id, associamos o Telefone
//        Integer telefoneId = res.getObject("telefone_id") != null ? res.getInt("telefone_id") : null;
//        if (telefoneId != null) {
//            f.setTelefone(new Telefone(telefoneId)); // Correto
//        }
        // Se houver login_id, associamos o Login
        Integer loginId = res.getObject("login_id") != null ? res.getInt("login_id") : null;
        if (loginId != null) {
            f.setLogin(new Login(loginId));
        }

        return f;
    }
}
