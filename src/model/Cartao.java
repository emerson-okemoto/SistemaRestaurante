package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cartao extends Entidade {

    private String numCartao;
    private String cvv;
    private TipoCartao tipo;

    public Cartao() {
    }
    
    public Cartao(Integer id) {
        setId(id);
    }
    
    public Cartao(Integer id, String numCartao, String cvv, TipoCartao tipo) {
        setId(id); // usa método herdado
        this.numCartao = numCartao;
        this.cvv = cvv;
        this.tipo = tipo;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public TipoCartao getTipo() {
        return tipo;
    }

    public void setTipo(TipoCartao tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO cartao (num_cartao, cvv, tipo) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, numCartao);
        ps.setString(2, cvv);
        ps.setString(3, tipo.name()); // grava como string (CREDITO/DEBITO)

        // Se for UPDATE, adiciona o id no final
        if (getId() != null && getId() > 0) {
            ps.setInt(4, getId());
        }
    }

    @Override
    public String getUpdate() {
        return "UPDATE cartao SET num_cartao = ?, cvv = ?, tipo = ? WHERE id = ?";
    }
}
