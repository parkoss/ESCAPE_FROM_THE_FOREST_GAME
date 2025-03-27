import java.util.Random;
import java.util.Scanner;

public class Pohyb implements Command{

    MapaLesa mapaLesa;
    Scanner sc=new Scanner(System.in);

    Inventar inventar;
    Hrac hrac;
    private Random rd=new Random();
    public Pohyb(Inventar inventar, MapaLesa mapaLesa,Hrac hrac) {
        mapaLesa.nactiMapu();
        mapaLesa.nactiItemy();
        this.inventar=inventar;
        this.mapaLesa=mapaLesa;
        this.hrac=hrac;

    }



    /**
     * Provádí pohyb hráče do zvolené lokace.
     *
     * @return Výsledek pohybu
     */
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

                    if (!potrebnyItem.equals("null") && !inventar.getBatoh().contains(potrebnyItem)) {
                        System.out.println("Pro vstup do lokace '" + input + "' potřebuješ: " + potrebnyItem);
                        System.out.println("Nemáš požadovaný předmět.");
                        return "zustal jsi v "+ mapaLesa.getMomentalniLokace();
                    }



                    int sance= rd.nextInt(100);
                    if (sance<15){
                        System.out.println("narazil jsi na nepřítele!");
                        Boj boj=new Boj(hrac);
                        boj.execute();
                    } else if (sance<25) {
                        System.out.println("narazil jsi na truhlu");
                        Truhla truhla=new Truhla();
                        truhla.najdiPredmet(hrac);
                    }


                    mapaLesa.setMomentalniLokace(input);
                    System.out.println("Přesunul jsi se do lokace: " + input);
                    mapaLesa.zobrazMozneLokace();
                    mapaLesa.zobrazItemyVaktualniLokaci();



                    if (aktualniLokace.getNazev().equals("brana")){
                        System.out.println("konec hry");
                        System.exit(0);
                    }

                    if (aktualniLokace.getNazev().equals("chram")){
                        Rebus rebus=new Rebus();
                        rebus.execute();
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
