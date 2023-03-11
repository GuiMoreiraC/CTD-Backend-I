package Modulo_I.A08S.Mesa.modd;

import java.util.Date;

public class Hotel {
    private String nome;
    private String cidade;
    private Date dataEntrada;
    private Date dataSaida;

    public Hotel(String nome, String cidade, Date dataEntrada, Date dataSaida) {
        this.nome = nome;
        this.cidade = cidade;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }


}
