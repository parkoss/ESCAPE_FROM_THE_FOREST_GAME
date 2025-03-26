import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BojTest {

    @Test
    public void testBojVyhra(){
        Hrac hrac = new Hrac(50, 10);
        Boj boj = new Boj(hrac);
        Nepritel nepritel = new Nepritel("troll", 10, 5);

        String result = boj.execute();

        assertTrue(result.contains("Vyhrál jsi boj"));
    }

    @Test
    public void testUtokNepritele() {
        Hrac hrac = new Hrac(50, 10);
        Nepritel nepritel = new Nepritel("troll", 20, 5);

        nepritel.utok(hrac);

        assertEquals(45, hrac.getZivoty());
    }

}