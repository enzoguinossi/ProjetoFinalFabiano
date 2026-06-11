package com.faetec.projetofinal.entity;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private int codigo;
    private LocalDate data;
    private StatusPedido status;
    private Cliente cliente;
    private Garcom garcom;
    private Mesa mesa;
    private List<ItemPedido> itens;

    public Pedido() {}

    public Pedido(int codigo, LocalDate data, StatusPedido status, Cliente cliente, Garcom garcom, Mesa mesa) {
        this.codigo = codigo;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.garcom = garcom;
        this.mesa = mesa;
    }

    public double calcularTotal() {
        return itens == null ? 0.0 : itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Garcom getGarcom() { return garcom; }
    public void setGarcom(Garcom garcom) { this.garcom = garcom; }

    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }

    public List<ItemPedido> getItens() { return itens; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }
    public void addItem(ItemPedido item) { this.itens.add(item); }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", data=" + data +
                ", status=" + status +
                ", cliente=" + (cliente != null ? cliente.getNome() : null) +
                ", garcom=" + (garcom != null ? garcom.getNome() : null) +
                ", mesa=" + (mesa != null ? mesa.getCodigo() : null) +
                ", itens=" + (itens != null ? itens.size() : 0) +
                ", total=" + calcularTotal() +
                '}';
    }
}