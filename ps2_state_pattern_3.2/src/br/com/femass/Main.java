package br.com.femass;

import br.com.femass.models.Conta;

public class Main {

    public static void main(String[] args) {
        Conta conta = new Conta();
        System.out.println(conta.toString());
        conta.getEstado().Depositar(23.04);
        conta.getEstado().Sacar(23.10);
        conta.getEstado().Sacar(100.10);
        conta.getEstado().Sacar(100.10);
        conta.getEstado().Depositar(100.10);

    }
}
