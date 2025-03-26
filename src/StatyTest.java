import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatyTest {

    @Test
    public void execute() {
        Hrac hrac = new Hrac(50, 10);
        Staty staty = new Staty(hrac);
        String result = staty.execute();
        assertTrue(result.contains("staty vypsany"));
    }
}