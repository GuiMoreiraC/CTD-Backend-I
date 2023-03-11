package Modulo_I.A05S.Aula;

import java.time.LocalDate;

public class ServicoVacinar implements IVacina {


    @Override
    public void vacinaPessoa(String rg, LocalDate dataVacina, String tipoVacina, LocalDate dataAgendada) {
        System.out.println("O usiariocom com RG: " + rg + "Foi vacinado(a) em: " + dataVacina + "com sucesso");
    }
}
