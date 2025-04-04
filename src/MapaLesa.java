import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapaLesa {
    private ArrayList<String> povolenyLokace = new java.util.ArrayList<>();
    private ArrayList<Lokace> vsechnyLokace = new ArrayList<>();
    private String momentalniLokace = "startovniKemp";
    ArrayList<String> sousedniLokace;
    private ArrayList<String> infoOLokacich = new ArrayList<>();
    Lokace lokace;


    /**
     * Načítá mapu ze souboru map.txt
     *
     * @return true, pokud se mapa načetla úspěšně, jinak false.
     */
    public boolean nactiMapu() {
        try (BufferedReader br = new BufferedReader(new FileReader("map.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("-");

                String nazevLokace = lines[0];
                String potrebnyItem = (lines.length > 1) ? lines[1] : "kompas";
                sousedniLokace = new ArrayList<>();


                for (int i = 2; i < lines.length; i++) {
                    sousedniLokace.add(lines[i]);
                }
                lokace = new Lokace(nazevLokace, potrebnyItem, sousedniLokace);
                vsechnyLokace.add(lokace);

            }
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    /**
     * Zobrazuje možné lokace, do kterých se hráč může přesunout.
     */
    public void zobrazMozneLokace() {
        ArrayList<String> unikatniLokace = new ArrayList<>();

        for (Lokace lokace : vsechnyLokace) {
            if (lokace.getNazev().equals(momentalniLokace)) {
                for (String soused : lokace.getPovolenyLokace()) {
                    if (!unikatniLokace.contains(soused)) {
                        unikatniLokace.add(soused);
                    }
                }
                break;
            }
        }

        if (!unikatniLokace.isEmpty()) {
            System.out.print("Z aktuální lokace '" + momentalniLokace + "' můžeš jít do: ");
            System.out.println(String.join(", ", unikatniLokace));
        } else {
            System.out.println("Nejsou dostupné žádné lokace.");
        }
    }


    /**
     * Načítá předměty do aktuální lokace ze souboru itemy.txt.
     *
     * @return Název předmětu, pokud se načetl, jinak null.
     */
    public String nactiItemy() {
        try (BufferedReader br = new BufferedReader(new FileReader("itemy.txt"))) {
            String line;
            String item = null;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("-");

                String nazevLokace = lines[0];





                for (Lokace lokace : vsechnyLokace) {
                    if (lokace.getNazev().equals(nazevLokace)) {
                        for (int i = 1; i < lines.length; i++) {
                            lokace.pridejItem(lines[i]);
                        }
                    }
                }

            }
            return item;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Zobrazuje předměty v aktuální lokaci.
     */
    public void zobrazItemyVaktualniLokaci() {
        for (Lokace lokace : vsechnyLokace) {
            if (lokace.getNazev().equals(momentalniLokace)) {
                ArrayList<String> itemy = lokace.getItemy();
                if (!itemy.isEmpty()) {
                    System.out.println("V této lokaci můžeš najít: " + String.join(", ", itemy));
                } else {
                    System.out.println("V této lokaci nejsou žádné předměty.");
                }
                return;
            }
        }
    }

    /**
     * Získává předměty v aktuální lokaci.
     *
     * @return Seznam předmětů v aktuální lokaci.
     */
    public ArrayList<String> getItemyVAktualniLokaci() {
        for (Lokace lokace : vsechnyLokace) {
            if (lokace.getNazev().equals(momentalniLokace)) {
                return lokace.getItemy();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Odstraňuje předmět z aktuální lokace.
     *
     * @param itemNazev Název předmětu, který se má odstranit.
     */
    public void odeberItemZLokace(String itemNazev) {
        for (Lokace lokace : vsechnyLokace) {
            if (lokace.getNazev().equals(momentalniLokace)) {
                lokace.getItemy().remove(itemNazev);
                break;
            }
        }
    }

    /**
     * Hledá lokaci podle názvu.
     *
     * @param name Název hledané lokace.
     * @return Lokace, pokud byla nalezena, jinak null.
     */
    public Lokace najdiLokaci(String name) {
        for (Lokace l : vsechnyLokace) {
            if (l.getNazev().equals(name)) {
                return l;
            }
        }
        return null;
    }


    public String getMomentalniLokace() {
        return momentalniLokace;
    }

    public void setMomentalniLokace(String momentalniLokace) {
        this.momentalniLokace = momentalniLokace;
    }

    public ArrayList<String> getPovolenyLokace() {
        return povolenyLokace;
    }

    public ArrayList<Lokace> getVsechnyLokace() {
        return vsechnyLokace;
    }




}