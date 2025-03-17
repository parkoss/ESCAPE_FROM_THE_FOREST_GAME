import java.util.Scanner;

public class Sbirani implements Command {

    Item item;
    Inventar inventar;
    MapaLesa mapaLesa;
    Lokace lokace;

    Scanner sc =new Scanner(System.in);
    public Sbirani(Inventar inventar, MapaLesa mapaLesa,Lokace lokace) {
        this.inventar = inventar;
        this.mapaLesa = mapaLesa;
        this.lokace=lokace;
    }

    @Override
    public String execute() {
        String item=mapaLesa.nactiItemy();
        inventar.pridejItem(item);



        return "item byl pridan";

    }

    @Override
    public Boolean exit() {
        return null;
    }
}