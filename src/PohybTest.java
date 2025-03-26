import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PohybTest {

    @Test
    public void testPohybDoPovoleneLokace() {
        MapaLesa mapaLesa = new MapaLesa();
        mapaLesa.nactiMapu();
        Hrac hrac = new Hrac(50, 10);
        Inventar inventar = new Inventar();
        Pohyb pohyb = new Pohyb(inventar, mapaLesa, hrac);

        String vysledek = pohyb.execute();

        assertTrue(vysledek.contains("Přesunul jsi se do lokace: "));
    }




}