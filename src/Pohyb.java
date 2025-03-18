import java.util.Scanner;

public class Pohyb implements Command{

    MapaLesa mapaLesa;
    Scanner sc=new Scanner(System.in);

    Inventar inventar;
    public Pohyb(Inventar inventar, MapaLesa mapaLesa) {
        mapaLesa.nactiMapu();
        mapaLesa.nactiItemy();
        this.inventar=inventar;
        this.mapaLesa=mapaLesa;
    }



    @Override
    public String execute() {
        mapaLesa.zobrazMozneLokace();
        System.out.println("kam chces jit?");
        System.out.print("> ");
        String input = sc.nextLine();

        Lokace aktualniLokace = null;

        for (Lokace l : mapaLesa.getVsechnyLokace()) {
            if (l.getNazev().equals(mapaLesa.getMomentalniLokace())) {
                aktualniLokace = l;
                break;
            }
        }

        if (inventar.getBatoh().contains(aktualniLokace.getPotrebnyItem())||aktualniLokace.getPotrebnyItem().equals("nane")){


            if (aktualniLokace == null) {
                System.out.println("chyba");
                return "zustal jsi na miste";
            }

            for (Lokace lokace : mapaLesa.getVsechnyLokace()) {
                if (aktualniLokace.getPovolenyLokace().contains(input)) {
                    mapaLesa.setMomentalniLokace(input);
                    System.out.println("Přesunul jsi se do lokace: " + input);
                    mapaLesa.zobrazMozneLokace();
                    mapaLesa.zobrazItemyVaktualniLokaci();
                    return "Jsi nyní v " + input;
                }
            }

        }
            System.out.println("Tato cesta není možná, protoze nemas: " + aktualniLokace.getPotrebnyItem());

            return "Zůstal jsi v " + aktualniLokace;




    }


    @Override
    public Boolean exit() {
        return false;
    }

}
