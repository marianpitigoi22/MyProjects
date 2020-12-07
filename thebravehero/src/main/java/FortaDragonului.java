import java.util.Random;

public class FortaDragonului {
    private final String nume = "Forta dragonului";
    private final int sansaActivare = 10;
    private int putereInainteDeActivare;
    private int putereDupaActivare;

    public FortaDragonului(int putere){
        putereInainteDeActivare = putere;
        Random random = new Random();
        if (sansaActivare >= random.nextInt(101)){
            putereDupaActivare = putereInainteDeActivare << 1;
        } else putereDupaActivare = putere;
    }

    public int getPutere(){
        return this.putereDupaActivare;
    }

    public int getPutereInainteDeActivare(){
        return this.putereInainteDeActivare;
    }

    @Override
    public String toString() {
        if (putereDupaActivare == putereInainteDeActivare << 1){
            return " {" +
                    nume + '\'' +
                    "putere: " + putereInainteDeActivare +
                    " -> " + putereDupaActivare +
                    '}';
        }else return "";
    }
}
