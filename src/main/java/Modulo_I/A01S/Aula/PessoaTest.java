package Modulo_I.A01S.Aula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    Pessoa p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;

    @BeforeEach
    void doBefore() {
        p1 = new Pessoa("Ivo", "Ganda");
        p1.setIdade(LocalDate.of(2016, 3, 23));
        p2 = new Pessoa("Ana", "Musk");
        p2.setIdade(LocalDate.of(1966, 1, 03));
        p3 = new Pessoa("Joe", "Morello");
        p3.setIdade(LocalDate.of(2010, 12, 04));
        p4 = new Pessoa("Rob", "Johnson");
        p4.setIdade(LocalDate.of(1976, 10, 25));
        p5 = new Pessoa("Ted", "Trujillo");
        p5.setIdade(LocalDate.of(2014, 5, 14));
        p6 = new Pessoa("Robert", "Traids");
        p6.setIdade(LocalDate.of(2000, 3, 30));
        p7 = new Pessoa("Renata", "Castro");
        p7.setIdade(LocalDate.of(2010, 1, 18));
        p8 = new Pessoa("Murilo", "Bianch");
        p8.setIdade(LocalDate.of(2015, 7, 11));
        p9 = new Pessoa("Candido", "Silveira");
        p9.setIdade(LocalDate.of(1975, 9, 01));
        p10 = new Pessoa("Camila", "Porto");
        p10.setIdade(LocalDate.of(2014, 5, 25));
    }

    @Test
    void imprimirObjetos() {
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println(p7.toString());
        System.out.println(p8.toString());
        System.out.println(p9.toString());
        System.out.println(p10.toString());
    }

    @Test
    void adicionarColecao() {
        p1.adicionarNomes(p1);
        p2.adicionarNomes(p2);
        p3.adicionarNomes(p3);
        p4.adicionarNomes(p4);
        p5.adicionarNomes(p5);
        p6.adicionarNomes(p6);
        p7.adicionarNomes(p7);
        p8.adicionarNomes(p8);
        p9.adicionarNomes(p9);
        p10.adicionarNomes(p10);
        System.out.println();
        System.out.println("Quantidade de elementos inseridos na lista:  " + Pessoa.getColecao().size());

        assertEquals(Pessoa.getColecao().size() == 2, true);
    }
}
