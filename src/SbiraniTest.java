import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SbiraniTest {

    @Test
    public void testSebratPredmet() {
        Inventar inventar = new Inventar();
        MapaLesa mapaLesa = new MapaLesa();
        Hrac hrac = new Hrac(50, 10);

        Lokace lokace=new Lokace("startovniKemp","kompas",new ArrayList<>());
        mapaLesa.getVsechnyLokace().add(lokace);
        mapaLesa.setMomentalniLokace("startovniKemp");
        lokace.pridejItem("Meč");


        Sbirani sbirani = new Sbirani(inventar, mapaLesa, lokace, hrac);

        String result = sbirani.execute();
        assertTrue(result.contains("Sebral jsi Meč"),"Předmět nebyl správně sebrán!");
    }

}