import br.com.guizinhobank.model.*;
import br.com.guizinhobank.pessoa.model.PessoaFisica;
import br.com.guizinhobank.pessoa.model.PessoaJuridica;

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
        mae.setNascimento(LocalDate.of(1969,04,21));
        mae.setCPF("114.014.378-68");


        PessoaFisica gui = new PessoaFisica();
        gui.setCPF("427.500.568-60");
        gui.setNascimento(LocalDate.of(2001,2,10));

        ContaCorrente cc = new ContaCorrente();
        cc.setAgencia(osasco);
        cc.setTitular(gui);
        cc.setSaldo(1_000_000);
        cc.setLimite(5_000_000);
        cc.setNumero("1-9");

        ContaPoupanca cp = new ContaPoupanca();
        cp.setNumero("2-8");
        cp.setAniversario(21);
        cp.setAgencia(osasco);
        cp.setSaldo(500_000);
        cp.setTitular(mae);

        PessoaJuridica holding = new PessoaJuridica();
        holding.setCNPJ("5871354/0001-07");
        holding.setNascimento(LocalDate.of(1988, 10, 5));
        holding.setNome("Guizinho Holding");
        holding.setRazaoSocial("Benezinho Holding S.A");

        ContaCorrente ccH = new ContaCorrente();
        ccH.setNumero("3-7");
        ccH.setLimite(800_000_000);
        ccH.setSaldo(1_000_000_000);
        ccH.setTitular(holding);
        ccH.setAgencia(osasco);

        System.out.println(ccH);







    }
}