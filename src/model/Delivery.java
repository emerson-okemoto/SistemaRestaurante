package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delivery extends Entidade {

    private String chaveEntrega;
    private String numero;
    private String complemento;
    private Endereco endereco;

    public Delivery() {
    }
    
    public Delivery(Integer id) {
        setId(id);
    }

    public Delivery(Integer id, String chaveEntrega, String numero, String complemento, Endereco endereco) {
        setId(id); // herdado de Entidade
        this.chaveEntrega = chaveEntrega;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }

    public String getChaveEntrega() {
        return chaveEntrega;
    }

    public void setChaveEntrega(String chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO delivery (chave_entrega, numero, complemento, endereco_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setString(1, chaveEntrega);
        ps.setString(2, numero);
        ps.setString(3, complemento);
        ps.setInt(4, endereco != null && endereco.getId() != null ? endereco.getId() : 0);

        if (getId() != null && getId() > 0) {
            ps.setInt(5, getId());
        }
    }

    @Override
    public String getUpdate() {
        return "UPDATE delivery SET chave_entrega = ?, numero = ?, complemento = ?, endereco_id = ? WHERE id = ?";
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + getId() +
                ", chaveEntrega='" + chaveEntrega + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}