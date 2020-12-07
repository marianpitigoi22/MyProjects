import java.util.Random;

public class ScutulFermecat {
    private final String nume = "Scutul Fermecat";
    private final int sansaActivare = 20;
    private int dauneInainteDeActivare;
    private int dauneDupaActivare;

    public ScutulFermecat(int daune){
        dauneInainteDeActivare = daune;
        Random random = new Random();
        if(sansaActivare >= random.nextInt(101)){
            dauneDupaActivare = daune >> 1;
        }else dauneDupaActivare = daune;
    }

    public int getDaune(){
        return this.dauneDupaActivare;
    }

    public int getDauneInainteDeActivare(){
        return this.dauneInainteDeActivare;
    }

    @Override
    public String toString() {
        if(dauneInainteDeActivare == dauneDupaActivare << 1 || dauneInainteDeActivare == (dauneDupaActivare << 1) +1) {
            return " {" +
                    nume + '\'' +
                    "daune: " + dauneInainteDeActivare +
                    " -> " + dauneDupaActivare +
                    '}';
        } else return "";
    }
}
