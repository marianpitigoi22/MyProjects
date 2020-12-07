import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSimulare {
    private SimulareLupta simulareLupta;
    private Erou carl;
    private Caracter bestie;

    private Caracteristici getCaracteristici() {
        Caracteristici caracteristici = new Caracteristici();
        caracteristici.setViata(60,70);
        caracteristici.setPutere(50,80);
        caracteristici.setAparare(30,40);
        caracteristici.setViteza(40,50);
        caracteristici.setNoroc(0,100);
        return caracteristici;
    }

    @Test
    void testInitializareCaractere(){
        carl = simulareLupta.initializareCarl();
        bestie = simulareLupta.initializareBestie();
        assertNotNull(carl);
        assertNotNull(bestie);
    }

    @Test
    void testAlegePrimulCaracter(){
        Caracteristici caracteristici = getCaracteristici();
        Caracter caracter1 = new Caracter("Carl", caracteristici);
        Caracter caracter2 = new Caracter("Bestie", caracteristici);
        caracter1.setCaracteristiciInLupta();
        caracter1.setCaracteristiciInLupta();

        int primulCaracterCareAtaca = simulareLupta.alegePrimulAtacator(caracter1, caracter2);
        assertTrue(primulCaracterCareAtaca == 0 || primulCaracterCareAtaca == 1);
    }

}
