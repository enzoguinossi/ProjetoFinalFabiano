package com.faetec.projetofinal.entity;

public class Garcom {
    private int codigo;
    private String nome;
    private String telefone;
    private String cpf;
    private double salario;
    private TurnosTrabalho turno;

    public Garcom() {}

    public Garcom(int codigo, String nome, String telefone, String cpf, double salario, TurnosTrabalho turno) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.salario = salario;
        this.turno = turno;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public TurnosTrabalho getTurno() { return turno; }
    public void setTurno(TurnosTrabalho turno) { this.turno = turno; }

    @Override
    public String toString() {
        return "Garcom{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", turno=" + turno +
                '}';
    }
}