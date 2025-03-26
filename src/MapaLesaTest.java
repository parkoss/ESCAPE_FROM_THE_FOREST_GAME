import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaLesaTest {

    @Test
    public void testNactiMapu() {
        MapaLesa mapaLesa = new MapaLesa();

        boolean vysledek = mapaLesa.nactiMapu();

        assertTrue(vysledek);
        assertFalse(mapaLesa.getVsechnyLokace().isEmpty());
    }


    @Test
    public void testZobrazMozneLokace() {
        MapaLesa mapaLesa = new MapaLesa();
        mapaLesa.nactiMapu();
        mapaLesa.setMomentalniLokace("startovniKemp");

        mapaLesa.zobrazMozneLokace();
    }
}