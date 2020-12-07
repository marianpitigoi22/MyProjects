import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestErou {
    Erou erou;

    private Caracteristici getCaracteristici() {
        Caracteristici caracteristici = new Caracteristici();
        caracteristici.setViata(60,70);
        caracteristici.setPutere(50,80);
        caracteristici.setAparare(30,40);
        caracteristici.setViteza(40,50);
        caracteristici.setNoroc(20,30);
        return caracteristici;
    }

    @Test
    void testCreateErou(){
        Erou erou = new Erou();
        assertNotNull(erou);
    }

    @Test
    void testCreateErouCuParametrii(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        assertNotNull(erou);
        assertEquals(caracteristici, erou.getCaracteristici());
    }

    @Test
    void testFortaDragonului(){
        FortaDragonului fortaDragonului = new FortaDragonului(10);
        assertTrue(fortaDragonului.getPutere() == fortaDragonului.getPutereInainteDeActivare()
                || 2*fortaDragonului.getPutereInainteDeActivare() == fortaDragonului.getPutere());
    }

    @Test
    void testActiveazaFortaDragonului(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        erou.setCaracteristiciInLupta();
        int putereInainteDeActivare = erou.getCaracteristiciInLupta().getPutere();
        erou.activeazaFortaDragonului();
        int putereDupaActivare = erou.getCaracteristiciInLupta().getPutere();
        assertTrue(putereDupaActivare == putereInainteDeActivare
                || putereDupaActivare == putereInainteDeActivare << 1);
    }

    @Test
    void testDezactiveazaFortaDragonului(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        erou.setCaracteristiciInLupta();
        int putereInainteDeActivare = erou.getCaracteristiciInLupta().getPutere();
        erou.activeazaFortaDragonului();
        int putereDupaActivare = erou.getCaracteristiciInLupta().getPutere();
        erou.dezactiveazaFortaDragonului();
        int putereDupaDezactivare = erou.getCaracteristiciInLupta().getPutere();
        assertEquals(putereInainteDeActivare, putereDupaDezactivare);
    }

    @Test
    void testErouFolosesteScutulFermecat(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        erou.setCaracteristiciInLupta();
        Caracter caracter = new Caracter("Bestie", caracteristici);
        caracter.setCaracteristiciInLupta();
        int daune = caracter.ataca(erou);
        int dauneDupaActivareScutulFermecat = erou.ScutulFermecat(daune);
        assertTrue(daune == dauneDupaActivareScutulFermecat
                || daune == dauneDupaActivareScutulFermecat << 1
                || daune == (dauneDupaActivareScutulFermecat << 1) + 1);
    }

    @Test
    void testCaracterApara(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        erou.setCaracteristiciInLupta();
        Caracter caracter = new Caracter("Bestie", caracteristici);
        caracter.setCaracteristiciInLupta();
        int daune = erou.ataca(caracter);
        int viataInainteDeAparare = erou.getCaracteristiciInLupta().getViata();
        int viataDupaAparare = viataInainteDeAparare - erou.apara(daune);

//        assertFalse(viataDupaAparare < 0);
        assertTrue(viataInainteDeAparare >= viataDupaAparare);
    }

    @Test
    void testErouAtacaCaracterSiCaracterApara(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        erou.setCaracteristiciInLupta();
        Caracter caracter = new Caracter("Bestie", caracteristici);
        caracter.setCaracteristiciInLupta();
        int dauneDateDeErou = erou.ataca(caracter);
        int dauneSuferiteDeCaracter = caracter.apara(dauneDateDeErou);
        assertTrue(dauneSuferiteDeCaracter == dauneDateDeErou
            || dauneSuferiteDeCaracter == 0);
    }

    @Test
    void testCaracterAtacaErouSiErouApara(){
        Caracteristici caracteristici = getCaracteristici();
        Erou erou = new Erou("Carl", caracteristici);
        erou.setCaracteristiciInLupta();
        Caracter caracter = new Caracter("Bestie", caracteristici);
        caracter.setCaracteristiciInLupta();

        int dauneDateDeCaracter = caracter.ataca(erou);
        int dauneSuferiteDeErou = erou.apara(dauneDateDeCaracter);
        assertTrue(dauneSuferiteDeErou == dauneDateDeCaracter
            || dauneSuferiteDeErou == 0
            || dauneSuferiteDeErou == dauneDateDeCaracter >> 1);
    }
}
