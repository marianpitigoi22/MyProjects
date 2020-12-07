import java.util.Random;

public class Caracter {
    protected String nume;
    protected Caracteristici caracteristici;
    protected CaracteristiciInLupta caracteristiciInLupta;

    public Caracter(){}

    public Caracter(String nume, Caracteristici caracteristici){
        this.nume = nume;
        this.caracteristici = caracteristici;
    }

    public void setNume(String nume){
        this.nume = nume;
    }

    public String getNume(){
        return this.nume;
    }

    public void setCaracteristici(Caracteristici caracteristici){
        if(caracteristici != null) {
            this.caracteristici = caracteristici;
        } else throw new NullPointerException("Caracter " + this.nume
                + ": setCaracteristici(caracteristici) -> caracteristici == null");
    }

    public Caracteristici getCaracteristici(){
        if(this.caracteristici != null) return this.caracteristici;
        else throw new NullPointerException("Caracter" + this.nume + ": caracteristici == null");
    }

    public void setCaracteristiciInLupta() {
        this.caracteristiciInLupta = new CaracteristiciInLupta(this.caracteristici);
    }

    public CaracteristiciInLupta getCaracteristiciInLupta() {
        if(this.caracteristiciInLupta != null) return this.caracteristiciInLupta;
        else throw  new NullPointerException("Caracter " + this.nume + ": caracteristiciInLupta == null");
    }

    public int ataca(Caracter caracterAtacat) {
        if(caracterAtacat != null) {
            int aparareCaracterAtacat = caracterAtacat.getCaracteristiciInLupta().getAparare();
            int putereAtac = this.getCaracteristiciInLupta().getPutere();
            int daune = putereAtac - aparareCaracterAtacat;
            if (daune > 100) daune = 100;
            if (daune < 0) daune = 0;
            return daune;
        } else throw new NullPointerException("Caracter " + this.nume
                + " : atacaCaracter(caracterAtacat) -> caracterAtacat == null");
    }

    public int apara(int daune) {
        Random random = new Random();
        int noroc = this.getCaracteristiciInLupta().getNoroc();
        boolean blocheazaAtac = random.nextInt(101) <= noroc ? true : false;
        int dauneSuferite = 0;
        if (!blocheazaAtac) {
            dauneSuferite = daune;
        }
        return dauneSuferite;
    }

    public void actualizeazaViata(int dauneSuferite) {
        int viata = this.getCaracteristiciInLupta().getViata();
        int viataDupaDauneleSuferite = viata - dauneSuferite;
        this.getCaracteristiciInLupta().setViata(viataDupaDauneleSuferite);

        if(this.getCaracteristiciInLupta().getViata() < 0)
            this.getCaracteristiciInLupta().setViata(0);
    }

    @Override
    public String toString() {
        return "'" + nume + '\'' +
                " = " + caracteristiciInLupta;
    }
}
