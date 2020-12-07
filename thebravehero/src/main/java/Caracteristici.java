import java.util.Arrays;

public class Caracteristici {
    private int[] viata;
    private int[] putere;
    private int[] aparare;
    private int[] viteza;
    private int[] noroc;

    public Caracteristici(){
        this.viata = new int[2];
        this.putere = new int[2];
        this.aparare = new int[2];
        this.viteza = new int[2];
        this.noroc = new int[2];
    }

    public void setViata(int min, int max) {
        if(min <= max) {
            this.viata[0] = min;
            this.viata[1] = max;
        }else System.err.println("Caracteristici -> setViata(min,max) -> min > max");
    }
    
    public int getViataMin(){
        return this.viata[0];
    }

    public int getViataMax() {
        return this.viata[1];
    }

    public void setPutere(int min, int max) {
        if(min <= max) {
            this.putere[0] = min;
            this.putere[1] = max;
        }else System.err.println("Caracteristici -> setPutere(min,max) -> min > max");
    }

    public int getPutereMin(){
        return this.putere[0];
    }

    public int getPutereMax(){
        return this.putere[1];
    }

    public void setAparare(int min, int max) {
        if(min <= max) {
            this.aparare[0] = min;
            this.aparare[1] = max;
        }else System.err.println("Caracteristici -> setAparare(min,max) -> min > max");
    }

    public int getAparareMin(){
        return this.aparare[0];
    }

    public int getAparareMax(){
        return this.aparare[1];
    }

    public void setViteza(int min, int max) {
        if(min <= max) {
            this.viteza[0] = min;
            this.viteza[1] = max;
        } else System.err.println("Caracteristici -> setViteza(min,max) -> min > max");
    }

    public int getVitezaMin(){
        return this.viteza[0];
    }

    public int getVitezaMax(){
        return this.viteza[1];
    }

    public void setNoroc(int min, int max) {
        if(min <= max) {
            this.noroc[0] = min;
            this.noroc[1] = max;
        }else System.err.println("Caracteristici -> setNoroc(min,max) -> min > max");
    }

    public int getNorocMin(){
        return this.noroc[0];
    }

    public int getNorocMax(){
        return this.noroc[1];
    }

    @Override
    public String toString() {
        return "Caracteristici{" +
                "viata=" + Arrays.toString(viata) +
                ", putere=" + Arrays.toString(putere) +
                ", aparare=" + Arrays.toString(aparare) +
                ", viteza=" + Arrays.toString(viteza) +
                ", noroc=" + Arrays.toString(noroc) +
                '}';
    }
}
