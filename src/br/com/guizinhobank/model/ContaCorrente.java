package br.com.guizinhobank.model;

import br.com.guizinhobank.pessoa.model.Pessoa;

public class ContaCorrente extends Conta{

    private double limite;

    public ContaCorrente() {
    }

    public ContaCorrente(String numero, Agencia agencia, Pessoa titular, double saldo, double limite) {
        super(agencia, titular, saldo, numero);
        this.limite = limite;

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limite=" + limite +
                "} " + super.toString();
    }
}
