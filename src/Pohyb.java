import java.util.Scanner;

public class Pohyb implements Command{

    MapaLesa mapaLesa=new MapaLesa();
    Scanner sc=new Scanner(System.in);

    public Pohyb() {
        mapaLesa.nactiMapu();
    }

    @Override
    public String execute() {
        mapaLesa.zobrazMozneLokace();
        System.out.println("kam chces jit?");
        System.out.print("> ");
        String input = sc.nextLine();

        String aktualniLokace = mapaLesa.getMomentalniLokace();

        for (Lokace lokace : mapaLesa.getVsechnyLokace()) {
            if (lokace.getNazev().equals(aktualniLokace) && lokace.getPovolenyLokace().contains(input)) {
                mapaLesa.setMomentalniLokace(input);
                System.out.println("Přesunul jsi se do lokace: " + input);
                mapaLesa.zobrazMozneLokace();
                return "Jsi nyní v " + input;
            }
        }

        System.out.println("Tato cesta není možná.");
        return "Zůstal jsi v " + aktualniLokace;
    }


    @Override
    public Boolean exit() {
        return false;
    }
}
