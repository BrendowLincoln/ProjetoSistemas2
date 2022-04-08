package br.com.femass.models;

import java.text.DecimalFormat;

public class Negativa extends ContaEstado {

    public Negativa(Conta conta) {
        super(conta);
    }

    @Override
    public void Sacar(Double valor) {
        DecimalFormat deciamlFormat = new DecimalFormat("#,###.##");
        Double saqueAtual = this.conta.getSaldo() - valor;

        if(saqueAtual < -100) {
            this.conta.setEstado(new Bloqueada(this.conta));
            System.out.println("Conta foi BLOQUEADA por tentativa de saque sem fundos suficiente!");

        } else {

            this.conta.setSaldo(saqueAtual);
            System.out.println("Saque de R$ " +  deciamlFormat.format(valor) + " realizado!\n Saldo atual: R$ " + deciamlFormat.format(this.conta.getSaldo()));
        }


        System.out.println(this.conta.toString());

    }

    @Override
    public void Depositar(Double valor) {
        DecimalFormat deciamlFormat = new DecimalFormat("#,###.##");

        Double depositoAtual = this.conta.getSaldo() + valor;
        this.conta.setSaldo(depositoAtual);
        if(depositoAtual > 0) {
            this.conta.setEstado(new Positiva(this.conta));
        }

        System.out.println("Depósito de R$ " +  deciamlFormat.format(valor) + " realizado!\n Saldo atual: R$ " + deciamlFormat.format(this.conta.getSaldo()));
        System.out.println(this.conta.toString());
    }

    @Override
    public String toString() {
        return "Conta Negativa";
    }
}
