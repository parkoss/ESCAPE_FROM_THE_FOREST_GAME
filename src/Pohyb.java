import java.util.Scanner;

public class Pohyb implements Command{

    MapaLesa mapaLesa;
    Scanner sc=new Scanner(System.in);

    Inventar inventar;
    Hrac hrac;
    public Pohyb(Inventar inventar, MapaLesa mapaLesa) {
        mapaLesa.nactiMapu();
        mapaLesa.nactiItemy();
        this.inventar=inventar;
        this.mapaLesa=mapaLesa;
    }



    @Override
    public String execute() {
        mapaLesa.zobrazMozneLokace();
        System.out.println("Kam chceš jít?");
        System.out.print("> ");
        String input = sc.nextLine();

        Lokace aktualniLokace=null;



        for (Lokace l : mapaLesa.getVsechnyLokace()) {
            if (l.getNazev().equals(mapaLesa.getMomentalniLokace())) {
                aktualniLokace = l;
                break;
            }
        }


            if (aktualniLokace == null) {
                System.out.println("Chyba");
                return "Zůstal jsi na miste";
            }

            for (Lokace lokace : mapaLesa.getVsechnyLokace()) {
                if (aktualniLokace.getPovolenyLokace().contains(input)) {

                    String potrebnyItem = mapaLesa.najdiLokaci(input).getPotrebnyItem();
                    String finalniLokace = null;

                    if (!potrebnyItem.equals("null") && !inventar.getBatoh().contains(potrebnyItem)) {
                        System.out.println("Pro vstup do lokace '" + input + "' potřebuješ: " + potrebnyItem);
                        return "Nemáš požadovaný předmět.";
                    }


                    mapaLesa.setMomentalniLokace(input);
                    System.out.println("Přesunul jsi se do lokace: " + input);
                    mapaLesa.zobrazMozneLokace();
                    mapaLesa.zobrazItemyVaktualniLokaci();
                    /*if (hrac != null) {
                        hrac.vstupDoBrany();
                        if (finalniLokace.equals("brana")) {
                            System.out.println("gratuluji, vyhral jsi hru");
                        }
                        break;
                    }

                     */

                    if (aktualniLokace.getNazev().equals("brana")){
                        System.out.println("konec hry");
                        System.exit(0);
                    }



                        return "Jsi nyní v " + input;

                }
            }



            return "Zůstal jsi v " + mapaLesa.getMomentalniLokace();




    }


    @Override
    public Boolean exit() {
        return false;
    }

}
