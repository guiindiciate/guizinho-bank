import br.com.guizinhobank.model.*;
import br.com.guizinhobank.pessoa.model.Pessoa;
import br.com.guizinhobank.pessoa.model.PessoaFisica;
import br.com.guizinhobank.pessoa.model.PessoaJuridica;

import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Banco guizinho = new Banco("Guizinho Bank");

        Agencia osasco = new Agencia();
        osasco.setBanco(guizinho);
        osasco.setNome("Osasco");
        osasco.setNumero("1-9");

        PessoaFisica mae = new PessoaFisica();
        mae.setNome("Francisca Meiry Tavares Indiciate");
        mae.setNascimento(LocalDate.of(1969, 04, 21));
        mae.setCPF("114.014.378.64");

        // Não precisa de var, enquanto já tem no topo.
        PessoaFisica gui = new PessoaFisica();
        gui.setCPF("427.500.568-60");
        gui.setNascimento(LocalDate.of(2001, 2, 10));
        gui.setMae(mae);

        PessoaFisica ana = new PessoaFisica();
        ana.setCPF("456.741.951.56");
        ana.setNome("Ana Beatriz Pastori dos Santos");
        gui.setNascimento(LocalDate.of(2004, 12, 16));
        ana.setMae(mae);

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(gui);
        cc.setSaldo(1_500);
        cc.setLimite(1_200);
        cc.setNumero("1-9");

        ContaPoupanca cp = new ContaPoupanca();
        cp.setAgencia(osasco);
        cp.setAniversario(21);
        cp.setTitular(mae);
        cp.setSaldo(500_000);
        cp.setNumero("2-8");

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("5871354/0001-07");
        holding.setNascimento(LocalDate.of(1988, 10, 5));
        holding.setNome("Guizinho Holding");
        holding.setRazaoSocial("Guizinho Holding S.A");


        Pessoa[] socios = new Pessoa[3];
        socios[0] = gui;
        socios[1] = mae;
        socios[2] = ana;

        holding.setSocios(socios);


        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(300);
        ccH.setSaldo(1200);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        // System.out.println(ccH);
        // System.out.println(cp);
        // System.out.println(cc);
        System.out.println(socios[2]);

        for (int i = 0; i < socios.length; i++) {
            System.out.println(socios[i]);
        }

        int continua = 0;


        do {
            System.out.println("Saldo anterior: " + ccH.getSaldo());
            System.out.println("Limite: " + ccH.getLimite());
            System.out.println("Disponível: " + (ccH.getSaldo() + ccH.getLimite()));

            double valor = Double.parseDouble((JOptionPane.showInputDialog("Informe o valor que deseja sacar")));
            boolean saquei = ccH.sacar(valor);

            if (saquei) {
                System.out.println("Saque efetuado com sucesso!");
            } else {
                System.out.println("Erro no saque!");
            }

            String texto = """
                                        
                    Deseja realizar um novo saque?
                                        
                    [ 1 ] SIM
                    [ 2 ] NÃO
                                        
                    """;

            continua = Integer.parseInt(JOptionPane.showInputDialog(texto));

        } while (continua == 1);
    }
}