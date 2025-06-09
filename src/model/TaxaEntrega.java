package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaxaEntrega extends Entidade {

    private Endereco endereco;
    private Double valorTaxaEntrega;

    // Construtor padrão
    public TaxaEntrega() {
    }

    // Construtor com parâmetro
    public TaxaEntrega(Integer id) {
        setId(id);
    }

    // Construtor com parâmetros
    public TaxaEntrega(Integer id, Endereco endereco, Double valorTaxaEntrega) {
        setId(id);
        this.endereco = endereco;
        this.valorTaxaEntrega = valorTaxaEntrega;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getValorTaxaEntrega() {
        return valorTaxaEntrega;
    }

    public void setValorTaxaEntrega(Double valorTaxaEntrega) {
        this.valorTaxaEntrega = valorTaxaEntrega;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO taxa_entrega (endereco_id, valor_taxa_entrega) VALUES (?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE taxa_entrega SET endereco_id = ?, valor_taxa_entrega = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        if (endereco != null && endereco.getId() != null && endereco.getId() > 0) {
            ps.setInt(1, endereco.getId());
        } else {
            throw new SQLException("TaxaEntrega deve estar associada a um Endereco válido com ID > 0.");
        }

        ps.setDouble(2, valorTaxaEntrega != null ? valorTaxaEntrega : 0.0);

        if (getId() != null && getId() > 0) {
            ps.setInt(3, getId());
        }
    }

    // Método toString() útil para exibição em logs e testes
    @Override
    public String toString() {
        return "TaxaEntrega{"
                + "id=" + getId()
                + ", endereco=" + endereco
                + ", valorTaxaEntrega=" + valorTaxaEntrega
                + '}';
    }
}
