package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cartao;
import model.Dinheiro;
import model.MetodoPagamento;

public class MetodoPagamentoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        MetodoPagamento mp = new MetodoPagamento();
        mp.setId(res.getInt("id"));
        mp.setPix(res.getDouble("pix"));

        // Dinheiro (instancia mínima com ID)
        Integer dinheiroId = res.getObject("dinheiro_id", Integer.class);
        if (dinheiroId != null && dinheiroId > 0) {
            mp.setDinheiro(new Dinheiro(dinheiroId));
        }

        // Cartao (instancia mínima com ID)
        Integer cartaoId = res.getObject("cartao_id", Integer.class);
        if (cartaoId != null && cartaoId > 0) {
            mp.setCartao(new Cartao(cartaoId));
        }

        return mp;
    }
}
