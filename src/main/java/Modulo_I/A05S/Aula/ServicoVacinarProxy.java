package Modulo_I.A05S.Aula;

import java.time.LocalDate;

public class ServicoVacinarProxy implements  IVacina{

    @Override
    public void vacinaPessoa(String rg, LocalDate dataVacina, String tipoVacina, LocalDate dataAgendada) {
        if (dataVacina.isEqual(dataAgendada) || dataVacina.isAfter(dataAgendada)){
            IVacina vacinar = new ServicoVacinar();
            vacinar.vacinaPessoa(rg,dataVacina,tipoVacina,dataAgendada);
            System.out.println("Deu Bom");
        }else {
            System.out.println("Deu rui");
        }

    }
}
