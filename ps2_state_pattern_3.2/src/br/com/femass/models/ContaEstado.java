package br.com.femass.models;

public abstract class ContaEstado {

    protected Conta conta;

    public ContaEstado(Conta conta) {
        this.conta = conta;
    }

    public abstract void Sacar(Double valor);

    public abstract void Depositar(Double valor);
}
