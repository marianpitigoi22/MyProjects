import java.util.Random;

public class CaracteristiciInLupta {
    private int viata;
    private int putere;
    private int aparare;
    private int viteza;
    private int noroc;

    public CaracteristiciInLupta(){}

    public CaracteristiciInLupta(Caracteristici caracteristici){
        Random random = new Random();
        this.viata = caracteristici.getViataMax() == caracteristici.getViataMin() ? caracteristici.getViataMin() :
                random.nextInt(caracteristici.getViataMax() - caracteristici.getViataMin() + 1)
                + caracteristici.getViataMin();
        this.putere = caracteristici.getPutereMax() == caracteristici.getPutereMin() ? caracteristici.getPutereMin() :
                random.nextInt(caracteristici.getPutereMax() - caracteristici.getPutereMin() + 1)
                + caracteristici.getPutereMin();
        this.aparare = caracteristici.getAparareMax() == caracteristici.getAparareMin() ? caracteristici.getAparareMin() :
                random.nextInt(caracteristici.getAparareMax() - caracteristici.getAparareMin() + 1)
                + caracteristici.getAparareMin();
        this.viteza = caracteristici.getVitezaMax() == caracteristici.getVitezaMin() ? caracteristici.getVitezaMin() :
                random.nextInt(caracteristici.getVitezaMax() - caracteristici.getVitezaMin() + 1)
                + caracteristici.getVitezaMin();
        this.noroc = caracteristici.getNorocMax() == caracteristici.getNorocMin() ? caracteristici.getNorocMin() :
                random.nextInt(caracteristici.getNorocMax() - caracteristici.getNorocMin() + 1)
                + caracteristici.getNorocMin();
    }

    public void setViata(int viata){
        this.viata = viata;
    }

    public int getViata(){
        return viata;
    }

    public void setPutere(int putere){
        this.putere = putere;
    }

    public int getPutere(){
        return  this.putere;
    }

    public void setAparare(int aparare){
        this.aparare = aparare;
    }

    public int getAparare(){
        return this.aparare;
    }

    public void setViteza(int viteza){
        this.viteza = viteza;
    }

    public int getViteza(){
        return this.viteza;
    }

    public void setNoroc(int noroc){
        this.noroc = noroc;
    }

    public int getNoroc(){
        return this.noroc;
    }

    @Override
    public String toString() {
        return "{" +
                "viata=" + viata +
                ", putere=" + putere +
                ", aparare=" + aparare +
                ", viteza=" + viteza +
                ", noroc=" + noroc +
                '}';
    }
}
