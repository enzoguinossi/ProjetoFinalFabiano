package com.faetec.projetofinal.entity;

public class ItemPedido {
    private int quantidade;
    private double precoUnitario;
    private double subtotal;
    private Prato prato;

    public ItemPedido() {}

    public ItemPedido(int quantidade, Prato prato) {
        this.quantidade = quantidade;
        this.prato = prato;
        this.precoUnitario = prato.getPreco();
        this.subtotal = quantidade * precoUnitario;
    }

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

    @Override
    public String toString() {
        return "ItemPedido{" +
                "prato=" + (prato != null ? prato.getNome() : null) +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}