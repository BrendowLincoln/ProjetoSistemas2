package br.com.femass.models;

import java.text.DecimalFormat;
import java.util.logging.ErrorManager;

public class Positiva extends ContaEstado {

    public Positiva(Conta conta) {
        super(conta);
    }

    @Override
    public void Sacar(Double valor) {

        Double saqueAtual = this.conta.getSaldo() - valor;

        if(saqueAtual >= -100) {
            DecimalFormat deciamlFormat = new DecimalFormat("#,###.##");
            this.conta.setSaldo(saqueAtual);

            if(saqueAtual < 0 ) {
                this.conta.setEstado(new Negativa(this.conta));
            }

            System.out.println("Saque de R$ " +  deciamlFormat.format(valor) + " realizado!\n Saldo atual: R$ " + deciamlFormat.format(this.conta.getSaldo()));
        } else {
            System.out.println("Valor de saque ultrapassa o permitido!");
        }

        System.out.println(this.conta.toString());

    }

    @Override
    public void Depositar(Double valor) {
        DecimalFormat deciamlFormat = new DecimalFormat("#,###.##");

        Double depositoAtual = this.conta.getSaldo() + valor;
        this.conta.setSaldo(depositoAtual);

        System.out.println("Depósito de R$ " +  deciamlFormat.format(valor) + " realizado!\n Saldo atual: R$ " + deciamlFormat.format(this.conta.getSaldo()));
        System.out.println(this.conta.toString());
    }

    @Override
    public String toString() {
        return "Conta Positiva";
    }
}
