package Modulo_I.A06S.Mesa;

public class SerieProxy implements ISerie {
    private Serie serie = new Serie();
    private int qtdViews = 0;
    private final int maxViews = 5;

    @Override
    public String getSerie(String nomeSerie) {
        if (qtdViews >= maxViews) {
            throw new SerieNaoHabilitadaException();
        }
        qtdViews++;
        return serie.getSerie(nomeSerie);
    }
}