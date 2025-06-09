package dao;

import interfaces.Entidade;
import interfaces.InterfaceDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Carrinho;
import model.IngredienteEscolha;
import model.Produto;

public class CarrinhoDAO extends InterfaceDAO {

    @Override
    public Entidade preencheDados(ResultSet res) throws SQLException {
        Carrinho c = new Carrinho();
        c.setId(res.getInt("id"));

        // Instancia mínima de Produto e IngredienteEscolha apenas com ID
        Produto p = new Produto(res.getInt("produto_id"));
        c.setProduto(p);

        c.setQuantidade(res.getInt("quantidade"));

        IngredienteEscolha ie = new IngredienteEscolha(res.getInt("ingrediente_escolha_id"));
        c.setIngredienteEscolha(ie);

        return c;
    }
}
