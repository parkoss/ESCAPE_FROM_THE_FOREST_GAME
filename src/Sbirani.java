import java.util.Scanner;
import java.util.ArrayList;
public class Sbirani implements Command {

    Item item;
    Inventar inventar;
    MapaLesa mapaLesa;
    Lokace lokace;
    Hrac hrac;

    Scanner sc =new Scanner(System.in);
    public Sbirani(Inventar inventar, MapaLesa mapaLesa,Lokace lokace,Hrac hrac) {
        this.inventar = inventar;
        this.mapaLesa = mapaLesa;
        this.lokace=lokace;
        this.hrac=hrac;
    }

    /**
     * Provádí akci sbírání předmětu z aktuální lokace.
     *
     * @return Výsledek sbírání.
     */
    @Override
    public String execute() {
        ArrayList<String> dostupneItemy = mapaLesa.getItemyVAktualniLokaci();
        if (dostupneItemy.isEmpty()) {
            return "V této lokaci není žádný předmět.";
        }

        System.out.println("Můžeš sebrat: " + String.join(", ", dostupneItemy));
        System.out.print("Co chceš sebrat? > ");
        String input = sc.nextLine().trim();

        if (dostupneItemy.contains(input)) {
            inventar.pridejItem(input);
            mapaLesa.odeberItemZLokace(input);
            hrac.vstupDoBrany();
            return "Sebral jsi " + input;
        }
        return "Tento předmět zde není.";
    }


    @Override
    public Boolean exit() {
        return null;
    }


}