package com.faetec.projetofinal.entity;

public class ItemPedido {
    private int quantidade;
    private double precoUnitario;
    private double subtotal;
    private Prato prato;

    private void recalcularSubtotal() {
        this.subtotal = this.quantidade * this.precoUnitario;
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        recalcularSubtotal();
    }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
        recalcularSubtotal();
    }

    public double getSubtotal() { return subtotal; }

    public Prato getPrato() { return prato; }
    public void setPrato(Prato prato) { this.prato = prato; }
}