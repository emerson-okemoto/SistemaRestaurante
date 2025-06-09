package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Endereco;
import model.TaxaEntrega;

public class TaxaEntregaDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        TaxaEntrega te = new TaxaEntrega();
        te.setId(res.getInt("id"));

        // Endereco (instancia mínima com ID)
        Integer enderecoId = res.getObject("endereco_id", Integer.class);
        if (enderecoId != null && enderecoId > 0) {
            te.setEndereco(new Endereco(enderecoId));
        }

        te.setValorTaxaEntrega(res.getDouble("valor_taxa_entrega"));

        return te;
    }
}
