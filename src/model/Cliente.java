package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente extends Entidade {

    private String nome;
    private Telefone telefone;

    public Cliente() {
    }

    public Cliente(Integer id) {
        setId(id); // método herdado da classe Entidade
    }

    public Cliente(Integer id, String nome) {
        setId(id);
        this.nome = nome;
    }

    public Cliente(Integer id, String nome, Telefone telefone) {
        setId(id);
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO cliente (nome, telefone_id) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE cliente SET nome = ?, telefone_id = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, nome);
        ps.setObject(2, telefone != null && telefone.getId() != null ? telefone.getId() : null);

        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }

}
