import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Truhla {
    Random rd = new Random();
    Scanner sc=new Scanner(System.in);
    Hrac hrac;
    private Item[] predmety = {
            new Item("Meč", 5, 0),
            new Item("Štít", 0, 8),
            new Item("Helma", 0, 5),
            new Item("Brnění", 0, 10),
            new Item("Luk", 4, 0),
            new Item("Sekera",5,0),
    };

    /**
     * Hráč najde předmět v truhle a rozhodne se, zda si ho vezme.
     *
     * @return Výsledek akce jako řetězec.
     */
    public String najdiPredmet(Hrac hrac) {
        Item item= predmety[rd.nextInt(predmety.length)];
        System.out.println("v truhle se nachazi: "+ item.getNazev());
        System.out.println("chces ho sebrat? ano/ne");

        while (true){
        String akce=sc.nextLine().trim().toLowerCase();

            if (akce.equals("ano")) {
                hrac.inventar.pridejItem(String.valueOf(item));
                System.out.println("sebral jsi " + item.getNazev());
                hrac.vylepsiStaty(item);
                return "sebral jsi " + item.getNazev();

            } else if (akce.equals("ne")) {
                System.out.println("pro item pribehl skritek a ukradl ti ho, smula :(");
                return "predmet zmizel";

            }else{
                System.out.println("spatny prikaz, zadej pouze ano/ne");
            }
        }

    }


    @Override
    public String toString() {
        return Arrays.toString(predmety);


    }
}
