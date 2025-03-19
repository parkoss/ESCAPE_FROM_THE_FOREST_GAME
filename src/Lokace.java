import java.util.ArrayList;

public class Lokace {
    private String nazev;
    private ArrayList<String> povolenyLokace=new ArrayList<>();
    private ArrayList<String> itemy=new ArrayList<>();
    private String potrebnyItem;




    public Lokace(String nazev,String potrebnyItem,ArrayList<String> povolenyLokace) {
        this.nazev = nazev;
        this.potrebnyItem=potrebnyItem;
        this.povolenyLokace = povolenyLokace;


    }


    public Lokace(){}

    public String getNazev() {
        return nazev;
    }

    public ArrayList<String> getPovolenyLokace() {
        return povolenyLokace;
    }

    public ArrayList<String> getItemy() {
        return itemy;
    }

    public String getPotrebnyItem() {
        return potrebnyItem;
    }


    public void pridejItem(String item) {
        itemy.add(item);
    }


    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public String toString() {
        return "lokaci: " + nazev;
    }


}
