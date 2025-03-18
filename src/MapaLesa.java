import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapaLesa {
    private ArrayList<String> povolenyLokace=new java.util.ArrayList<>();
    private ArrayList<Lokace>vsechnyLokace=new ArrayList<>();
    private String momentalniLokace="startovniKemp";
    private ArrayList<String>itemyVLokaci;
    ArrayList<String>sousedniLokace;
    Lokace lokace;

    public boolean nactiMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("map.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] lines = line.split("-");

                String nazevLokace =lines[0];
                String potrebnyItem = (lines.length > 1)? lines[1] : "nane";


                sousedniLokace=new ArrayList<>();


                for (int i = 2; i < lines.length; i++) {
                    sousedniLokace.add(lines[i]);
                }
                lokace=new Lokace(nazevLokace,potrebnyItem,sousedniLokace);
                vsechnyLokace.add(lokace);
            }
            return true;
        }catch (IOException e){
            return false;
        }

    }
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


    public String nactiItemy(){
        try (BufferedReader br = new BufferedReader(new FileReader("itemy.txt"))) {
            String line;
            String item = null;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("-");

                String nazevLokace = lines[0];
                //item = lines[1];

                itemyVLokaci=new ArrayList<>();

                /*for (int i = 1; i < lines.length; i++) {
                    itemyVLokaci.add(lines[i]);
                }

                 */

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

    public ArrayList<String> getItemyVAktualniLokaci() {
        for (Lokace lokace : vsechnyLokace) {
            if (lokace.getNazev().equals(momentalniLokace)) {
                return lokace.getItemy();
            }
        }
        return new ArrayList<>();
    }

    public void odeberItemZLokace(String itemNazev) {
        for (Lokace lokace : vsechnyLokace) {
            if (lokace.getNazev().equals(momentalniLokace)) {
                lokace.getItemy().remove(itemNazev);
                break;
            }
        }
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
