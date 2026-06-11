package com.faetec.projetofinal.entity;

public class Mesa {
    private int codigo;
    private int quantidadeLugares;
    private String setor;
    private StatusMesa status;

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public int getQuantidadeLugares() { return quantidadeLugares; }
    public void setQuantidadeLugares(int quantidadeLugares) { this.quantidadeLugares = quantidadeLugares; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public StatusMesa getStatus() { return status; }
    public void setStatus(StatusMesa status) { this.status = status; }
}