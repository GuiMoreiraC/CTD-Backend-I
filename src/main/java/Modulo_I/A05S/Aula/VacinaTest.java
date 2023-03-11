package Modulo_I.A05S.Aula;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VacinaTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    @DisplayName("Deve efetuar a vacinação")
    void vacinar(){
        LocalDate dataAplicacao = LocalDate.parse("16/02/2023",formatter);
        LocalDate dataMarcada = LocalDate.parse("16/02/2023",formatter);

        Pessoa p1 = new Pessoa("Jorge", "Lucas","3131351465846", dataAplicacao, dataMarcada, "Pfizer");
        IVacina vacinar = new ServicoVacinarProxy();
        vacinar.vacinaPessoa(p1.getRg(), p1.getDataAplicacao(), p1.getNomeVacina(),p1.getDataAgendada());
        System.out.println(p1.getNome() + " " + p1.getSobrenome() + ", portador do RG: " + p1.getRg() +
                ", foi vacinado com sucesso" + " no dia " + p1.getDataAplicacao());
        System.out.println("------------------------------------------------------------------------------");

    }

    @Test
    @DisplayName("Deve efetuar a vacinação")
    void vacinarEmDataPosteriorDataMarcada(){
        LocalDate dataAplicacao = LocalDate.parse("16/02/2023",formatter);
        LocalDate dataMarcada = LocalDate.parse("10/02/2023",formatter);

        Pessoa p1 = new Pessoa("Maria", "Silva","856465131", dataAplicacao, dataMarcada, "Pfizer");
        IVacina vacinar = new ServicoVacinarProxy();
        vacinar.vacinaPessoa(p1.getRg(), p1.getDataAplicacao(), p1.getNomeVacina(),p1.getDataAgendada());
        System.out.println(p1.getNome() + " " + p1.getSobrenome() + ", portador do RG: " + p1.getRg() +
                ", foi vacinado com sucesso" + " no dia " + p1.getDataAplicacao());
        System.out.println("------------------------------------------------------------------------------");
    }

    @Test
    @DisplayName("Não deve efetuar a vacinação")
    void vacinarEmDataAnteriorDataMarcada(){
        LocalDate dataAplicacao = LocalDate.parse("10/02/2023",formatter);
        LocalDate dataMarcada = LocalDate.parse("16/02/2023",formatter);

        Pessoa p1 = new Pessoa("Talia", "Oliveira","4659684469", dataAplicacao, dataMarcada, "Pfizer");
        IVacina vacinar = new ServicoVacinarProxy();
        vacinar.vacinaPessoa(p1.getRg(), p1.getDataAplicacao(), p1.getNomeVacina(),p1.getDataAgendada());
        System.out.println(p1.getNome() + " " + p1.getSobrenome() + ", portador do RG: " + p1.getRg() +
                ", foi vacinado com sucesso" + " no dia " + p1.getDataAplicacao());
        System.out.println("------------------------------------------------------------------------------");
    }

}
