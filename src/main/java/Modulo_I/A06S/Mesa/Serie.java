package Modulo_I.A06S.Mesa;

public class Serie implements ISerie {
    private String prefixo = "www.";

    @Override
    public String getSerie(String nomeSerie) {
        return prefixo + nomeSerie;
    }
}
