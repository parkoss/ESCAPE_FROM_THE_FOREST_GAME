import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Commands{

    private boolean exit=false;
    private HashMap<String, Command> map = new HashMap<>();
    public void inicialization(MapaLesa mapaLesa,Inventar inventar,Lokace lokace){


        map.put("jdi",new Pohyb(inventar, mapaLesa));
        map.put("batoh",new Inventar());
        map.put("seber",new Sbirani(inventar,mapaLesa,lokace));
        map.put("boj",new Boj());
    }

    private Scanner sc=new Scanner(System.in);

    public void doCommand(){
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


    public void start(MapaLesa mapaLesa,Inventar inventar,Lokace lokace){
        inicialization(mapaLesa, inventar,lokace);
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
