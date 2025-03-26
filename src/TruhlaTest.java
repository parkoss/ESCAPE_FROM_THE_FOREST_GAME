import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruhlaTest {

    @Test
    public void testNajdiPredmet() {
        Hrac hrac = new Hrac(50, 10);
        Truhla truhla = new Truhla();

        String result = truhla.najdiPredmet(hrac);

        assertTrue(result.contains("chces ho sebrat? ano/ne"));
    }
}