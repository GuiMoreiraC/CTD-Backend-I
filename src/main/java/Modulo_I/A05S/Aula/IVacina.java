package Modulo_I.A05S.Aula;

import java.time.LocalDate;

public interface IVacina {

    void vacinaPessoa(String rg, LocalDate dataVacina, String tipoVacina, LocalDate dataAgendada);
}
