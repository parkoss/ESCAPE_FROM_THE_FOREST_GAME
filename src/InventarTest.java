import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarTest {

    @Test
    public void testPridejItem() {
        Inventar inventar = new Inventar();

        inventar.pridejItem("Meč");

        assertTrue(inventar.getBatoh().contains("Meč"));
    }
}