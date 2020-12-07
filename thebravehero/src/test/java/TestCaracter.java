import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCaracter {

    private Caracter caracter = new Caracter();
    private Caracteristici caracteristici = new Caracteristici();
    private CaracteristiciInLupta caracteristiciInLupta = new CaracteristiciInLupta();

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
    void testCaracterNotNull(){
        assertNotNull(caracter);
    }

    @Test
    void testCaracteristiciNotNull(){
        assertNotNull(caracteristici);
    }

    @Test
    void testCaracteristiciInLuptaNotNull(){
        assertNotNull(caracteristiciInLupta);
    }

    @Test
    void testViataCaracteristici(){
        caracteristici.setViata(65, 95);
        assertArrayEquals(new int[]{65, 95}, new int[]{caracteristici.getViataMin(), caracteristici.getViataMax()});
    }

    @Test
    void testPutereCaracteristici(){
        caracteristici.setPutere(60,70);
        assertArrayEquals(new int[]{60, 70}, new int[]{caracteristici.getPutereMin(), caracteristici.getPutereMax()});
    }

    @Test
    void testAparareCaracteristici(){
        caracteristici.setAparare(40,50);
        assertArrayEquals(new int[]{40, 50}, new int[]{caracteristici.getAparareMin(), caracteristici.getAparareMax()});
    }

    @Test
    void testVitezaCaracteristici(){
        caracteristici.setViteza(40,50);
        assertArrayEquals(new int[]{40,50}, new int[]{caracteristici.getVitezaMin(), caracteristici.getVitezaMax()});
    }

    @Test
    void testNorocCaracteristici(){
        caracteristici.setNoroc(10, 30);
        assertArrayEquals(new int[]{10,30}, new int[]{caracteristici.getNorocMin(), caracteristici.getNorocMax()});
    }

    @Test
    void testCaracteristiciCaracter(){
        caracteristici.setViata(10, 20);
        caracteristici.setPutere(30, 40);
        caracteristici.setAparare(50, 60);
        caracteristici.setViteza(70, 80);
        caracteristici.setNoroc(90, 100);

        caracter.setCaracteristici(caracteristici);
        assertEquals(caracteristici, caracter.getCaracteristici());
    }

    @Test
    void testCaracteristiciInLupta(){
        caracteristiciInLupta.setViata(10);
        assertEquals(10, caracteristiciInLupta.getViata());

        caracteristiciInLupta.setPutere(20);
        assertEquals(20, caracteristiciInLupta.getPutere());

        caracteristiciInLupta.setAparare(30);
        assertEquals(30, caracteristiciInLupta.getAparare());

        caracteristiciInLupta.setViteza(40);
        assertEquals(40, caracteristiciInLupta.getViteza());

        caracteristiciInLupta.setNoroc(50);
        assertEquals(50, caracteristiciInLupta.getNoroc());
    }

    @Test
    void testConstructorCaracteristiciInLupta(){
        Caracteristici caracteristici1 = getCaracteristici();
        CaracteristiciInLupta caracteristiciInLupta1 = new CaracteristiciInLupta(caracteristici1);

        assertTrue(caracteristiciInLupta1.getViata() >= caracteristici1.getViataMin()
                && caracteristiciInLupta1.getViata() <= caracteristici1.getViataMax());
        assertTrue(caracteristiciInLupta1.getPutere() >= caracteristici1.getPutereMin()
                && caracteristiciInLupta1.getPutere() <= caracteristici1.getPutereMax());
        assertTrue(caracteristiciInLupta1.getAparare() >= caracteristici1.getAparareMin()
                && caracteristiciInLupta1.getAparare() <= caracteristici1.getAparareMax());
        assertTrue(caracteristiciInLupta1.getViteza() >= caracteristici1.getVitezaMin()
                && caracteristiciInLupta1.getViteza() <= caracteristici1.getVitezaMax());
        assertTrue(caracteristiciInLupta1.getNoroc() >= caracteristici1.getNorocMin()
                && caracteristiciInLupta1.getNoroc() <= caracteristici1.getNorocMax());
    }

    @Test
    void testCaracteristiciInLuptaCaracter(){
        Caracteristici caracteristici = getCaracteristici();
        Caracter caracter = new Caracter("Carl",caracteristici);
        caracter.setCaracteristiciInLupta();
        assertNotNull(caracter.getCaracteristiciInLupta());
    }

    @Test
    void testCaracterAtacaCaracter(){
        Caracteristici caracteristici = getCaracteristici();
        Caracter caracter1 = new Caracter("Carl", caracteristici);
        caracter1.setCaracteristiciInLupta();
        Caracter caracter2 = new Caracter("Bestie", caracteristici);
        caracter2.setCaracteristiciInLupta();
        int daune = caracter1.ataca(caracter2);
        assertTrue(daune >= 0);
        assertTrue(daune <= 100);
    }

    @Test
    void testCaracterApara(){
        Caracteristici caracteristici = getCaracteristici();
        Caracter caracter1 = new Caracter("Carl", caracteristici);
        caracter1.setCaracteristiciInLupta();
        Caracter caracter2 = new Caracter("Bestie", caracteristici);
        caracter2.setCaracteristiciInLupta();
        int daune = caracter2.ataca(caracter1);
        int dauneSuferiteCaracter1 = caracter1.apara(daune);
        int putereCaracter2 = caracter2.getCaracteristiciInLupta().getPutere();
        int aparareCaracter1 = caracter1.getCaracteristiciInLupta().getAparare();
        int dauneSuferiteCaracter1Calculate = putereCaracter2 - aparareCaracter1;
        if(dauneSuferiteCaracter1Calculate < 0) dauneSuferiteCaracter1Calculate = 0;
        if(dauneSuferiteCaracter1Calculate > 100) dauneSuferiteCaracter1Calculate = 100;
        assertTrue(dauneSuferiteCaracter1 >= 0);
        assertTrue(dauneSuferiteCaracter1 <= 100);
        assertTrue(dauneSuferiteCaracter1 == dauneSuferiteCaracter1Calculate
            || dauneSuferiteCaracter1 == 0);
    }

    @Test
    void testCaracter1AtacaCaracter2SiCaracter2Apara(){
        Caracteristici caracteristici = getCaracteristici();
        Caracter caracter1 = new Caracter("Carl", caracteristici);
        caracter1.setCaracteristiciInLupta();
        Caracter caracter2 = new Caracter("Bestie", caracteristici);
        caracter2.setCaracteristiciInLupta();
        int dauneDateDeCaracter1 = caracter1.ataca(caracter2);
        int dauneSuferiteDeCaracter2 = caracter2.apara(dauneDateDeCaracter1);
        assertTrue(dauneDateDeCaracter1 == dauneSuferiteDeCaracter2
            || dauneSuferiteDeCaracter2 == 0);
    }
}
