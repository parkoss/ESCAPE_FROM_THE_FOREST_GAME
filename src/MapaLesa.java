import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapaLesa {
    private ArrayList<String> povolenyLokace=new java.util.ArrayList<>();
    private ArrayList<Lokace>vsechnyLokace=new ArrayList<>();
    private String momentalniLokace="startovniKemp";
    Lokace lokace;

    public boolean nactiMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("map.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] lines = line.split("-");
                String nazevLokace =lines[0];
                for (int i = 0; i < lines.length; i++) {
                    povolenyLokace.add(lines[i]);
                }
                lokace=new Lokace(lines[0],povolenyLokace);
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
