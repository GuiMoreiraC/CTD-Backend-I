package Modulo_I.A01S.Aula;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private LocalDate idade;
    private static List<Pessoa> colecao = new ArrayList<>();

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public static List<Pessoa> getColecao() {
        return colecao;
    }

    public List<Pessoa> adicionarNomes(Pessoa p) {
//        int var = p.getNome().length();
//        int idade = p.Idade();

        if (p.getNome().length() < 5 && p.Idade() >= 18) {
            colecao.add(p);
            System.out.println("Lista de pessoas que satisfazem as duas condições: " + colecao);
        }

        return colecao;
    }

    public int Idade() {
        int idade = Period.between(this.idade, LocalDate.of(2023, 02, 13)).getYears();
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
//                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + Idade() +
                '}';
    }
}
