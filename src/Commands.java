import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Commands{

    private boolean exit=false;
    private HashMap<String, Command> map = new HashMap<>();
    public void inicialization(MapaLesa mapaLesa,Inventar inventar,Lokace lokace,Hrac hrac){


        map.put("jdi",new Pohyb(inventar, mapaLesa));
        map.put("batoh",inventar);
        map.put("seber",new Sbirani(inventar,mapaLesa,lokace,hrac));
        map.put("boj",new Boj());
        map.put("pomoc",new Pomoc());
    }

    private Scanner sc=new Scanner(System.in);

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
