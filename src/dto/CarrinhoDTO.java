package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import java.util.LinkedList;
import java.util.List;
import model.Carrinho;
import model.Produto;
import model.IngredienteEscolha;

public class CarrinhoDTO extends InterfaceDTO {

    public String produtoId;
    public String quantidade;
    public String ingredienteEscolhaId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        CarrinhoDTO dto = new CarrinhoDTO();
        Carrinho carrinho = (Carrinho) e;
        dto.id = carrinho.getId() + "";
        dto.produtoId = carrinho.getProduto() != null && carrinho.getProduto().getId() != null
                ? carrinho.getProduto().getId() + "" : "";
        dto.quantidade = carrinho.getQuantidade() + "";
        dto.ingredienteEscolhaId = carrinho.getIngredienteEscolha() != null && carrinho.getIngredienteEscolha().getId() != null
                ? carrinho.getIngredienteEscolha().getId() + "" : "";
        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Carrinho carrinho = new Carrinho();

        carrinho.setId(id == null ? 0 : Integer.valueOf(id));

        Produto produto = new Produto();
        produto.setId(produtoId == null ? 0 : Integer.valueOf(produtoId));
        carrinho.setProduto(produto);

        carrinho.setQuantidade(quantidade == null ? 0 : Integer.parseInt(quantidade));

        IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
        ingredienteEscolha.setId(ingredienteEscolhaId == null ? 0 : Integer.valueOf(ingredienteEscolhaId));
        carrinho.setIngredienteEscolha(ingredienteEscolha);

        return carrinho;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Produto", "Quant"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, produtoId, quantidade};
    }

    @Override
    public List<InterfaceDTO> preencheLista(List<Entidade> e) {
        List<InterfaceDTO> retorno = new LinkedList<>();
        for (Entidade entidade : e) {
            retorno.add(this.buildDTO(entidade));
        }
        return retorno;
    }
}
