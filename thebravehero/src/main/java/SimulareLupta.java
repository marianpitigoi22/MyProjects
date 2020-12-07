import java.util.Random;

public class SimulareLupta {

    public Erou initializareCarl(){
        Caracteristici caracteristici = new Caracteristici();
        caracteristici.setViata(65, 95);
        caracteristici.setPutere(60, 70);
        caracteristici.setAparare(40, 50);
        caracteristici.setViteza(40, 50);
        caracteristici.setNoroc(10, 30);
        Erou carl = new Erou("Carl", caracteristici);
        carl.setCaracteristiciInLupta();
        return carl;
    }

    public Caracter initializareBestie(){
        Caracteristici caracteristici = new Caracteristici();
        caracteristici.setViata(55, 80);
        caracteristici.setPutere(50, 80);
        caracteristici.setAparare(35, 55);
        caracteristici.setViteza(40, 60);
        caracteristici.setNoroc(25, 40);
        Caracter bestie = new Caracter("Bestie", caracteristici);
        bestie.setCaracteristiciInLupta();
        return bestie;
    }

    public int alegePrimulAtacator(Caracter caracter1, Caracter caracter2){
        int vitezaAtacErou = 0;
        int vitezaAtacBestie = 0;
        int norocErou = 0;
        int norocBestie = 0;
        if(caracter1 != null){
            vitezaAtacErou = caracter1.getCaracteristiciInLupta().getViteza();
            norocErou = caracter1.getCaracteristiciInLupta().getNoroc();
        } else throw new NullPointerException("SimulareLupta - AlegePrimulAtacator(...) -> carl == null");
        if(caracter2 != null){
            vitezaAtacBestie = caracter2.getCaracteristiciInLupta().getViteza();
            norocBestie = caracter2.getCaracteristiciInLupta().getNoroc();
        }else throw  new NullPointerException("SimulareLupta - AlegePrimulAtacator(...) -> bestie == null");
        if(vitezaAtacErou > vitezaAtacBestie) return 0;
        else if(vitezaAtacErou < vitezaAtacBestie) return 1;
        if(norocErou > norocBestie) return 0;
        else if(norocErou < norocBestie) return 1;
        Random random = new Random();
           return random.nextInt(2);
    }

    public void erouAtacaCaracter(Erou carl, Caracter bestie){
        int viataBestieInainteDeAtac = bestie.getCaracteristiciInLupta().getViata();
        int daune = carl.ataca(bestie);
        int dauneSuferite = bestie.apara(daune);
        bestie.actualizeazaViata(dauneSuferite);
        int viataBestie = bestie.getCaracteristiciInLupta().getViata();
        System.out.println(carl);
        System.out.println(bestie);
        System.out.println("Daune: " + daune);
        if (dauneSuferite == 0) System.out.println("Atacul lui Carl a esuat!");
        else System.out.println("Daune suferite de Bestie: " + dauneSuferite
                + "\nViata Bestiei a scazut de la " + viataBestieInainteDeAtac + " la " + viataBestie);
        System.out.println();

    }

    public void caracterAtacaErou(Erou carl, Caracter bestie){
        int viataCarlInainteDeAtac = carl.getCaracteristiciInLupta().getViata();
        int daune = bestie.ataca(carl);
        int dauneSuferite = carl.apara(daune);
        carl.actualizeazaViata(dauneSuferite);
        int viataCarl = carl.getCaracteristiciInLupta().getViata();
        System.out.println(carl);
        System.out.println(bestie);
        System.out.println("Daune: " + daune);
        if (dauneSuferite == 0) System.out.println("Atacul bestiei ai esuat!");
        else System.out.println("Daune suferite de Carl: " + dauneSuferite
                + "\nViata lui Carl a scazut de la " + viataCarlInainteDeAtac + " la " + viataCarl);
        System.out.println();
    }

    public void activeazaBuclaErouAtacaCaracter(int numarRunde, Erou erou, Caracter caracter){
        do {
            System.out.println("========== Runda: " + numarRunde +" ==========");
            if(numarRunde %2 == 0) {
                System.out.println(caracter.getNume() + " ataca!");
                caracterAtacaErou(erou, caracter);

            }else {
                System.out.println(erou.getNume() + " ataca!");
                erouAtacaCaracter(erou, caracter);
            }
            ++numarRunde;
        }while(numarRunde <= 20 && erou.getCaracteristiciInLupta().getViata() > 0
                && caracter.getCaracteristiciInLupta().getViata() > 0);
    }

    public void activeazaBuclaCaracterAtacaErou(int numarRunde, Erou erou, Caracter caracter){
        do {
            System.out.println("========== Runda: " + numarRunde +" ==========");
            if(numarRunde %2 ==0) {
                System.out.println(erou.getNume() + " ataca!");
                erouAtacaCaracter(erou, caracter);

            }else {
                System.out.println(caracter.getNume() + " ataca!");
                caracterAtacaErou(erou, caracter);
            }
            ++numarRunde;
        } while(numarRunde <= 20 && erou.getCaracteristiciInLupta().getViata() > 0
                && caracter.getCaracteristiciInLupta().getViata() > 0);
    }

    public void start(){
        Erou carl = this.initializareCarl();
        Caracter bestie = this.initializareBestie();
        System.out.println("Carl: " + carl.caracteristici);
        System.out.println("Bestie: " + bestie.caracteristici);
        System.out.println();
        System.out.println(carl);
        System.out.println(bestie);

        System.out.println("\n");
        int numarRunde = 1;
        int primulCaracterCareAtaca = alegePrimulAtacator(carl, bestie);
        if((primulCaracterCareAtaca & (~primulCaracterCareAtaca)-1) == 1)
            activeazaBuclaErouAtacaCaracter(numarRunde, carl, bestie);
            // if(primulCaracterCareAtaca % 2 == 1)
            // Daca primul atac == 1 -> Bestia ataca prima, altfel Carl ataca primul
        else activeazaBuclaCaracterAtacaErou(numarRunde, carl, bestie);

        System.out.println("---------------------------------------");
        if(carl.getCaracteristiciInLupta().getViata() <= 0){
            System.out.println("***** Casticator: Bestie *****");
        }
        if(bestie.getCaracteristiciInLupta().getViata() <= 0){
            System.out.println("***** Casticator: Carl *****");
        }
    }

}
