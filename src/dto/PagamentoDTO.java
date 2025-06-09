package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Pagamento;
import model.MetodoPagamento;
import model.Cupom;
import model.Pedido;

/**
 * DTO para a entidade Pagamento.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class PagamentoDTO extends InterfaceDTO {

    public String metodoPagamentoId;
    public String cupomId;
    public String pedidoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        PagamentoDTO dto = new PagamentoDTO();
        Pagamento pagamento = (Pagamento) e;

        dto.id = pagamento.getId() == null ? "" : pagamento.getId() + "";

        MetodoPagamento metodoPagamento = pagamento.getMet_pagamento();
        dto.metodoPagamentoId = (metodoPagamento != null && metodoPagamento.getId() != null) ? metodoPagamento.getId() + "" : "";

        Cupom cupom = pagamento.getCupom();
        dto.cupomId = (cupom != null && cupom.getId() != null) ? cupom.getId() + "" : "";

        Pedido pedido = pagamento.getPedido();
        dto.pedidoId = (pedido != null && pedido.getId() != null) ? pedido.getId() + "" : "";

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Pagamento pagamento = new Pagamento();

        pagamento.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));

        MetodoPagamento metodoPagamento = new MetodoPagamento();
        metodoPagamento.setId(metodoPagamentoId == null || metodoPagamentoId.isEmpty() ? null : Integer.valueOf(metodoPagamentoId));
        pagamento.setMet_pagamento(metodoPagamento);

        Cupom cupom = new Cupom();
        cupom.setId(cupomId == null || cupomId.isEmpty() ? null : Integer.valueOf(cupomId));
        pagamento.setCupom(cupom);

        Pedido pedido = new Pedido();
        pedido.setId(pedidoId == null || pedidoId.isEmpty() ? null : Integer.valueOf(pedidoId));
        pagamento.setPedido(pedido);

        return pagamento;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Metodo Pagamento ID", "Cupom ID", "Pedido ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, metodoPagamentoId, cupomId, pedidoId};
    }
}
