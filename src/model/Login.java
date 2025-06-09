package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login extends Entidade {
    
    private String usuario;
    private String senha;

    public Login() {
    }
    
    public Login(Integer id) {
        setId(id);
    }

    public Login(Integer id, String usuario, String senha) {
        setId(id);
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO login (usuario, senha) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE login SET usuario = ?, senha = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, usuario);
        ps.setString(2, senha);
        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }
}
