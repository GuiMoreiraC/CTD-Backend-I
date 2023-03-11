package Modulo_I.A08S.Mesa.modd;

import java.util.Date;

public class Voo {

    private String origem;
    private String destino;
    private Date dataPartida;
    private Date dataRetorno;

    public Voo(String origem, String destino, Date dataPartida, Date dataRetorno) {
        this.origem = origem;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

}
