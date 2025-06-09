package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Carrinho extends Entidade {

    private Produto produto; // Um único produto
    private int quantidade;
    private IngredienteEscolha ingredienteEscolha;

    public Carrinho() {
    }

    public Carrinho(Integer id) {
        setId(id);
    }
    
    public Carrinho(Integer id, Produto produto, int quantidade, IngredienteEscolha ingredienteEscolha) {
        setId(id); // usa o método herdado de Entidade
        this.produto = produto;
        this.quantidade = quantidade;
        this.ingredienteEscolha = ingredienteEscolha;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public IngredienteEscolha getIngredienteEscolha() {
        return ingredienteEscolha;
    }

    public void setIngredienteEscolha(IngredienteEscolha ingredienteEscolha) {
        this.ingredienteEscolha = ingredienteEscolha;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO carrinho (produto_id, quantidade, ingrediente_escolha_id) VALUES (?, ?, ?)";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setInt(1, produto.getId());
        ps.setInt(2, quantidade);
        ps.setInt(3, ingredienteEscolha.getId());

        // Se for uma operação de UPDATE, define o ID no final
        if (getId() != null && getId() > 0) {
            ps.setInt(4, getId());
        }
    }

    @Override
    public String getUpdate() {
        return "UPDATE carrinho SET produto_id = ?, quantidade = ?, ingrediente_escolha_id = ? WHERE id = ?";
    }
}
