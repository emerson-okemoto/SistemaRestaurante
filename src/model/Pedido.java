package model;

import interfaces.Entidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Date; // Representa data (ano, mês, dia) num formato que pode ser usado com bancos de dados SQL.
import java.sql.Time; // Representa horário (hora, minuto, segundo) num formato que pode ser usado com bancos de dados SQL.
import java.time.LocalDate; // Representa data sem informações de fuso horário (ano, mês, dia) e é parte da nova API de data e hora do Java (Java 8 em diante).
import java.time.LocalTime; // Representa um horário sem informações de data ou fuso horário (hora, minuto, segundo) e também faz parte da nova API de data e hora do Java.

public class Pedido extends Entidade {

    private Integer id;
    private LocalTime horaPedido;
    private LocalDate dataPedido;
    private Cliente cliente;
    private Integer numeroPedido;
    private Carrinho carrinho;
    private StatusPedido statusPedido;
    private Entrega entrega;
    private Reembolso reembolso;

    public Pedido() {
    }

    public Pedido(Integer id) {
        setId(id);
    }

    public Pedido(Integer id, LocalTime horaPedido, LocalDate dataPedido,
            Cliente cliente, Integer numeroPedido, Carrinho carrinho,
            StatusPedido statusPedido, Entrega entrega, Reembolso reembolso) {
        setId(id);
        this.horaPedido = horaPedido;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.numeroPedido = numeroPedido;
        this.carrinho = carrinho;
        this.statusPedido = statusPedido;
        this.entrega = entrega;
        this.reembolso = reembolso;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Reembolso getReembolso() {
        return reembolso;
    }

    public void setReembolso(Reembolso reembolso) {
        this.reembolso = reembolso;
    }

    @Override
    public String getInsert() {
        return "INSERT INTO pedido (hora_pedido, data_pedido, cliente_id, numero_pedido, carrinho_id, status_pedido_id, entrega_id, reembolso_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdate() {
        return "UPDATE pedido SET hora_pedido = ?, data_pedido = ?, cliente_id = ?, numero_pedido = ?, carrinho_id = ?, status_pedido_id = ?, entrega_id = ?, reembolso_id = ? WHERE id = ?";
    }

    @Override
    public void setParameter(PreparedStatement ps) throws SQLException {
        ps.setTime(1, Time.valueOf(horaPedido));
        ps.setDate(2, Date.valueOf(dataPedido));
        ps.setInt(3, cliente != null && cliente.getId() != null ? cliente.getId() : 0);
        ps.setInt(4, numeroPedido);
        ps.setInt(5, carrinho != null && carrinho.getId() != null ? carrinho.getId() : 0);
        ps.setObject(6, statusPedido != null && statusPedido.getId() != null ? statusPedido.getId() : null);
        ps.setObject(7, entrega != null && entrega.getId() != null ? entrega.getId() : null);
        ps.setObject(8, reembolso != null && reembolso.getId() != null ? reembolso.getId() : null);

        if (getId() != null && getId() > 0) {
            ps.setInt(9, getId());
        }
    }

}
