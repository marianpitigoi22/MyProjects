import java.util.Random;

public class Erou extends Caracter{

    private FortaDragonului fortaDragonului;
    private ScutulFermecat scutulFermecat;

    public Erou(){}
    public Erou(String nume, Caracteristici caracteristici){
        super(nume, caracteristici);
    }

    public void activeazaFortaDragonului() {
        fortaDragonului = new FortaDragonului(this.getCaracteristiciInLupta().getPutere());
        this.getCaracteristiciInLupta().setPutere(fortaDragonului.getPutere());
    }

    public void dezactiveazaFortaDragonului(){
        if(fortaDragonului != null){
            if(fortaDragonului.getPutereInainteDeActivare() < fortaDragonului.getPutere()){
                this.getCaracteristiciInLupta().setPutere(fortaDragonului.getPutereInainteDeActivare());
            }
        }
    }

    public int ScutulFermecat(int daunePrimite) {
        scutulFermecat = new ScutulFermecat(daunePrimite);
        int dauneReduse = scutulFermecat.getDaune();
        return dauneReduse;
    }

    public int ataca(Caracter caracterAtacat){
        if(caracterAtacat != null) {
            scutulFermecat = null; // Pentru ca Scutul Fermecat sa nu fie activ atunci cand Eroul se apara
            int aparareCaracterAtacat = caracterAtacat.getCaracteristiciInLupta().getAparare();
            this.activeazaFortaDragonului();
            int putereAtac = this.getCaracteristiciInLupta().getPutere();
            this.dezactiveazaFortaDragonului();
            int daune = putereAtac - aparareCaracterAtacat;
            if (daune > 100) daune = 100;
            if (daune < 0) daune = 0;

            return daune;
        } else throw new NullPointerException("Caracter: atacaCaracter(caracterAtacat) -> caracterAtacat == null");
    }

    public int apara(int daune){
        fortaDragonului = null; // Pentru ca Forta Dragonului sa nu fie activa atunci cand Eroul se apara
        Random random = new Random();
        int noroc = this.getCaracteristiciInLupta().getNoroc();
        boolean blocheazaAtac = random.nextInt(101) <= noroc ? true : false;
        int dauneSuferite = 0;
        if (!blocheazaAtac) {
            dauneSuferite = daune;
            int dauneSuferiteScutFermecat = this.ScutulFermecat(dauneSuferite);
            dauneSuferite = dauneSuferiteScutFermecat;
        }
        return dauneSuferite;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("'" +
                            nume + '\'' +
                             " = " + caracteristiciInLupta);
        if(this.fortaDragonului != null) stringBuffer.append(fortaDragonului);
        if(this.scutulFermecat != null) stringBuffer.append(scutulFermecat);
        return stringBuffer.toString();
    }
}
