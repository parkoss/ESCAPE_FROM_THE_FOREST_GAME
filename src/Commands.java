import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Commands{

    private boolean exit=false;
    private HashMap<String, Command> map = new HashMap<>();

    /**
     * Inicializuje příkazy pro hru.
     *
     * @param mapaLesa Mapa lesa, ve které se hráč nachází.
     * @param inventar Inventář hráče.
     * @param lokace Aktuální lokace hráče.
     * @param hrac Hráč, který provádí příkazy.
     */
    public void inicialization(MapaLesa mapaLesa,Inventar inventar,Lokace lokace,Hrac hrac){
        map.put("jdi",new Pohyb(inventar, mapaLesa,hrac));
        map.put("batoh",inventar);
        map.put("seber",new Sbirani(inventar,mapaLesa,lokace,hrac));
        map.put("pomoc",new Pomoc());
        map.put("staty",new Staty(hrac));
    }

    private Scanner sc=new Scanner(System.in);

    /**
     * Zpracovává příkazy zadané hráčem.
     */
    public void doCommand(){
        System.out.println("---------------------------------");
        System.out.println("vitej ve hre ESCAPE THE FOREST");
        System.out.println("---------------------------------");
        System.out.println("pro pomoc s commandama napis: pomoc");
        System.out.println("---------------------------------");
        while(true){
            System.out.print(">>");
            String command = sc.nextLine();
            command = command.trim();
            command = command.toLowerCase();
            if(map.containsKey(command)){
                System.out.println(">> "+map.get(command).execute());
            }else{
                System.out.println(">> neznamy prikaz");
            }
        }

    }


    /**
     * Spouští hru a zpracovává příkazy.
     */
    public void start(MapaLesa mapaLesa,Hrac hrac,Lokace lokace){
        inicialization(mapaLesa,hrac.inventar,lokace,hrac);
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
