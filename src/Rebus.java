import java.util.Scanner;

public class Rebus implements Command{
    Scanner sc = new Scanner(System.in);

    /**
     * Spouští rébus, kde hráč musí udělat správnou kombinanci
     *
     * @return Konec hry
     */
    @Override
    public String execute() {
        System.out.println("Narazil jsi na rébus.");
        System.out.println("Máš 3 páčky a musíš z nich vytvořit správnou kombinaci (nahoru/dolu).");

        boolean packa1 = false;
        boolean packa2 = false;
        boolean packa3 = false;

        do {
            while (true) {
                System.out.println("Zadáváš první páčku, napiš nahoru/dolu:");
                String volba1 = sc.nextLine().trim().toLowerCase();
                if (volba1.equals("nahoru")) {
                    packa1 = true;
                    break;
                } else if (volba1.equals("dolu")) {
                    packa1 = false;
                    break;
                } else {
                    System.out.println("Špatný příkaz! Zadej pouze 'nahoru' nebo 'dolu'.");
                }
            }

            while (true) {
                System.out.println("Zadáváš druhou páčku, napiš nahoru/dolu:");
                String volba2 = sc.nextLine().trim().toLowerCase();
                if (volba2.equals("nahoru")) {
                    packa2 = true;
                    break;
                } else if (volba2.equals("dolu")) {
                    packa2 = false;
                    break;
                } else {
                    System.out.println("Špatný příkaz! Zadej pouze 'nahoru' nebo 'dolu'.");
                }
            }

            while (true) {
                System.out.println("Zadáváš třetí páčku, napiš nahoru/dolu:");
                String volba3 = sc.nextLine().trim().toLowerCase();
                if (volba3.equals("nahoru")) {
                    packa3 = true;
                    break;
                } else if (volba3.equals("dolu")) {
                    packa3 = false;
                    break;
                } else {
                    System.out.println("Špatný příkaz! Zadej pouze 'nahoru' nebo 'dolu'.");
                }
            }

            if (!(packa1 == true && packa2 == false && packa3 == true)) {
                System.out.println("Špatná kombinace, zkus to znovu!\n");
            }

        } while (!(packa1 == true && packa2 == false && packa3 == true));

        System.out.println("Úspěšně jsi vyřešil rébus!");
        System.out.println("zadal jsi spravnou kombinanci a uspesne jsi utekl z lesa, gratuluji");
        System.exit(0);
        return "";
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
