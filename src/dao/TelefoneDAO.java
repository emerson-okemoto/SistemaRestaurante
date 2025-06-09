package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import model.Funcionario;
import model.Telefone;

public class TelefoneDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Telefone t = new Telefone();
        t.setId(res.getInt("id"));
        t.setDdd(res.getString("ddd"));
        t.setNumero(res.getString("numero"));

        // Se tiver campos de FK (funcionario_id, cliente_id), preenche as associações com apenas o id
        Integer funcionarioId = res.getObject("funcionario_id") != null ? res.getInt("funcionario_id") : null;
        if (funcionarioId != null) {
            t.setFuncionario(new Funcionario(funcionarioId));
        }

        Integer clienteId = res.getObject("cliente_id") != null ? res.getInt("cliente_id") : null;
        if (clienteId != null) {
            t.setCliente(new Cliente(clienteId));
        }

        return t;
    }
}