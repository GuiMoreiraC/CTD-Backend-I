package Modulo_I.A01S.Atividade;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String nome;
    private String sobrenome;
    private String eMail;
    private LocalDate dataNascimento; // No exercício pede


    public Person(String nome, String sobrenome, String eMail, LocalDate dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.eMail = eMail;
        this.dataNascimento = dataNascimento;
    }

    public String NomeCompleto(){
        return this.sobrenome + ", " + this.nome;
    }

    public boolean MaiorDeIdade() {
        return Idade() >= 18 ;
    }

    public int Idade() {
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(this.dataNascimento, dataAtual).getYears();
//      int idade = Period.between(this.dataNascimento, LocalDate.of(2021, 09, 21)).getYears();
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
