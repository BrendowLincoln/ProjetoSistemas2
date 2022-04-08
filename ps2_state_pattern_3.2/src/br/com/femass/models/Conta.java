package br.com.femass.models;

import java.text.DecimalFormat;
import java.time.*;

public class Conta {

    private int codigo;
    private Double saldo;
    private LocalDate dataCriacao;
    private ContaEstado estado;

    public Conta() {
        this.codigo = (int) (Math.random() * 100);
        this.saldo = 0.0;
        this.dataCriacao = LocalDate.now();
        this.estado = new Positiva(this);
    }

    public Conta(Double depositoInicial) {
        this.codigo = (int) (Math.random() * 100);
        this.saldo = depositoInicial;
        this.dataCriacao = LocalDate.now();
        this.estado = new Positiva(this);
    }


    public Double getSaldo() {
        return saldo;
    }

    protected void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public ContaEstado getEstado() {
        return estado;
    }

    public void setEstado(ContaEstado estado) {
        this.estado = estado;
    }

    public int getCodigo() { return codigo; }


    @Override
    public String toString() {

        DecimalFormat deciamlFormat = new DecimalFormat("#,###.##");

        return "Conta#" + this.codigo + "- Saldo: R$ " + deciamlFormat.format(this.saldo) + " - Estado: " + this.estado.toString() + ".\n";
    }
}
