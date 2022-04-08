package br.com.femass.models;

import java.text.DecimalFormat;

public class Bloqueada extends ContaEstado {

    public Bloqueada(Conta conta) {
        super(conta);
    }

    @Override
    public void Sacar(Double valor) {
        System.out.println(this.toString());
    }

    @Override
    public void Depositar(Double valor) {
        DecimalFormat deciamlFormat = new DecimalFormat("#,###.##");

        Double depositoAtual = this.conta.getSaldo() + valor;
        this.conta.setSaldo(depositoAtual);

        if(depositoAtual > 0) {
            this.conta.setEstado(new Positiva(this.conta));
        } else {
            this.conta.setEstado(new Negativa(this.conta));
        }

        System.out.println("Depósito de R$ " +  deciamlFormat.format(valor) + " realizado!\nSaldo atual: R$ " + deciamlFormat.format(this.conta.getSaldo()));
        System.out.println(this.conta.toString());

    }

    @Override
    public String toString() {
        return "Conta Bloqueada";
    }
}
