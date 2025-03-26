import java.util.Random;
import java.util.Scanner;

public class Boj implements Command{
    Hrac hrac;
    Random rd = new Random();
    Scanner sc =new Scanner(System.in);

    private Nepritel[] prisery = {
            new Nepritel("troll",70,8),
            new Nepritel("lesni skret",30,10),
            new Nepritel("carodejnice",30,15),
            new Nepritel("vlkodlak",20,20),
            new Nepritel("zlobr",80,7),

    };

    public Boj(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute() {
        /**
         * Provádí boj mezi hráčem a náhodně vybraným nepřítelem.
         *
         * @return Výsledek boje
         */
        Nepritel nepritel= prisery[rd.nextInt(prisery.length)];
        System.out.println("Narazil jsi na " + nepritel.getJmeno() + "!");

        while (hrac.getZivoty() > 0 && nepritel.getZivoty() > 0) {
            System.out.println("Co chceš dělat? (útok/útěk)");
            System.out.println("> ");
            String akce = sc.nextLine();

            if (akce.equals("útok")) {
                hrac.utok(nepritel);
                if (nepritel.getZivoty() > 0) {
                    nepritel.utok(hrac);
                }
            } else if (akce.equals("útěk")) {
                System.out.println("Utekl jsi z boje!");
                return "Utekl jsi";
            } else if (akce.isEmpty()) {
                return "špatnej příkaz";
            }

            if (hrac.getZivoty() <= 0) {
                System.out.println("Zemřel jsi! Konec hry.");
                System.exit(0);
            }

            if (nepritel.getZivoty() <= 0) {
                System.out.println("Porazil jsi nepřítele!");
                hrac.setZivoty(hrac.getMaxZivoty());
                System.out.println("tve zdravi bylo plne obnoveno, ale tve brneni bylo zniceno");
                return "Vyhrál jsi boj";
            }
        }
        return "Boj skončil";
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
