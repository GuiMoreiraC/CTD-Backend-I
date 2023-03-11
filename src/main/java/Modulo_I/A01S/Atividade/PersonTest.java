package Modulo_I.A01S.Atividade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class PersonTest {

    private static List<Person> pessoas;

    @BeforeAll
    static void doBefore() {
        pessoas = new ArrayList<>();

        pessoas.add(new Person("João", "Silva", "joao.silva@email.com", LocalDate.of(1990, 5, 10)));
        pessoas.add(new Person("Maria", "Souza", "maria.souza@email.com", LocalDate.of(1985, 8, 22)));
        pessoas.add(new Person("Pedro", "Santos", "pedro.santos@email.com", LocalDate.of(2005, 1, 5)));
        pessoas.add(new Person("Lucas", "Ferreira", "lucas.ferreira@email.com", LocalDate.of(2009, 7, 17)));
        pessoas.add(new Person("Ana", "Oliveira", "ana.oliveira@email.com", LocalDate.of(1992, 3, 28)));
        pessoas.add(new Person("Bruno", "Almeida", "bruno.almeida@email.com", LocalDate.of(1991, 11, 14)));
        pessoas.add(new Person("Carla", "Costa", "carla.costa@email.com", LocalDate.of(1988, 9, 7)));
        pessoas.add(new Person("Diego", "Gomes", "diego.gomes@email.com", LocalDate.of(1987, 4, 29)));
        pessoas.add(new Person("Fernanda", "Lima", "fernanda.lima@email.com", LocalDate.of(1993, 2, 1)));
        pessoas.add(new Person("Gabriel", "Nascimento", "gabriel.nascimento@email.com", LocalDate.of(1996, 6, 12)));
    }

    @Test
    void testNomeCompleto() {
        for (Person pessoa : pessoas) {
            String nomeCompleto = pessoa.NomeCompleto();
            String expected = pessoa.getSobrenome() + ", " + pessoa.getNome();
            Assertions.assertEquals(expected, nomeCompleto, "O nome completo de " + pessoa.getNome() + " está incorreto.");
        }
    }

    @Test
    void testMaiorDeIdade() {
        for (Person pessoa : pessoas) {
            boolean maiorDeIdade = pessoa.MaiorDeIdade();
            boolean expected = pessoa.Idade() >= 18;
            Assertions.assertEquals(expected, maiorDeIdade, "A idade de " + pessoa.getNome() + " está incorreta.");
        }
    }
}
