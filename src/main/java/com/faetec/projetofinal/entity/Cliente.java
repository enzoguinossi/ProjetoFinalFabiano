package com.faetec.projetofinal.entity;

public class Cliente {
    private int codigo;
    private String nome;
    private String cidade;
    private String celular;
    private String email;

    public Cliente() {}

    public Cliente(int codigo, String nome, String cidade, String celular, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.celular = celular;
        this.email = email;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}