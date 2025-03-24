import java.util.ArrayList;

public class Item{
    private String nazev;
    private int utok;
    private int obrana;

    public Item(String nazev, int utok, int obrana) {
        this.nazev = nazev;
        this.utok = utok;
        this.obrana = obrana;
    }

    public int getUtok() {
        return utok;
    }

    public int getObrana() {
        return obrana;
    }


    public String getNazev() {
        return nazev;
    }

}
