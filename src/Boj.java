import java.util.Random;
import java.util.Scanner;

public class Boj implements Command{
    Hrac hrac;
    Random rd = new Random();
    Scanner sc =new Scanner(System.in);

    public Boj(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute() {
        Nepritel nepritel = new Nepritel("Lesní bestie", 30, 10);
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
