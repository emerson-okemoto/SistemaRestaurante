package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Produto;

/**
 * DTO para a entidade Produto.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class ProdutoDTO extends InterfaceDTO {

    public String nome;
    public String valorUnitario;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        ProdutoDTO dto = new ProdutoDTO();
        Produto produto = (Produto) e;

        dto.id = produto.getId() == null ? "" : produto.getId() + "";
        dto.nome = produto.getNome();
        dto.valorUnitario = produto.getValorUnitario() != null ? produto.getValorUnitario().toString() : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Produto produto = new Produto();

        produto.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        produto.setNome(nome);
        produto.setValorUnitario(valorUnitario == null || valorUnitario.isEmpty() ? null : Double.valueOf(valorUnitario));

        return produto;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Nome", "Valor Unitário"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, nome, valorUnitario};
    }
}
