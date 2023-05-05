package br.com.guizinhobank.model;

import br.com.guizinhobank.pessoa.model.Pessoa;

public class ContaPoupanca extends Conta{

    private int aniversario;


    public ContaPoupanca() {
    }

    public ContaPoupanca(String numero, Agencia agencia, Pessoa titular, double saldo, int aniversario) {
        super(agencia, titular, saldo, numero);
        this.aniversario = aniversario;
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "aniversario=" + aniversario +
                "} " + super.toString();
    }
}
