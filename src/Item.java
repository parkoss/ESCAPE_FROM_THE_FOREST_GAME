import java.util.ArrayList;

public class Item{
    private String nazev;
    private boolean muzesSebrat;
    private ArrayList<String>itemy=new ArrayList<>();



    public Item(String nazev) {
        this.nazev = nazev;
    }

    public String getNazev() {
        return nazev;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nazev='" + nazev + '\'' +
                '}';
    }
}
