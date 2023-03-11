package Modulo_I.A06S.Mesa;

public class SerieNaoHabilitadaException extends RuntimeException {
    public SerieNaoHabilitadaException() {
        super("Excede o número de reproduções permitidas.");
    }
}
