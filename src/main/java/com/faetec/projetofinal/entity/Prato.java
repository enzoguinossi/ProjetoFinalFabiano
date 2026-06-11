package com.faetec.projetofinal.entity;

public class Prato {
    private int codigo;
    private String nome;
    private String descricao;
    private TiposPrato tipo;
    private double preco;

    public Prato() {}

    public Prato(int codigo, String nome, String descricao, TiposPrato tipo, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public TiposPrato getTipo() { return tipo; }
    public void setTipo(TiposPrato tipo) { this.tipo = tipo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Prato{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", preco=" + preco +
                '}';
    }
}