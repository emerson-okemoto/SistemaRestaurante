package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Bairro extends Entidade {

    private String nome;
    private List<Endereco> endereco;

    public Bairro() {
    }
    
    public Bairro(Integer id) {
        setId(id);
    }
    
    // Sera usado no DAO
    public Bairro(String nome) {
        this.nome = nome;
    }

    public Bairro(Integer id, String nome, List<Endereco> endereco) {
        this.setId(id); // usa o método herdado de Entidade
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO bairro (nome) VALUES (?)";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, this.nome);
        
        // Se o ID estiver definido, é uma operação de UPDATE
        if (getId() != null && getId() > 0) {
            ps.setInt(2, getId());
        }
    }

    @Override
    public String getUpdate() {
        return "UPDATE bairro SET nome = ? WHERE id = ?";
    }
    
    @Override
    public String toString() {
        return "Bairro{" + "id=" + getId() + ", nome=" + nome + '}';
    }
}
