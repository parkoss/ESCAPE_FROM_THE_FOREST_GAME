import java.util.HashMap;
import java.util.Scanner;

public class Commands{

    private boolean exit=false;
    private HashMap<String, Command> map = new HashMap<>();
    Inventar inventar;

    public void inicialization(){
        map.put("jdi",new Pohyb());
        map.put("batoh",new Inventar());
        map.put("seber",new Sbirani(inventar));
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


    public void start(){
        inicialization();
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void game(){
        inicialization();
        System.out.println("vitej ve hre ESCAPE THE FOREST \n tvym ukolem je utect z lesa \n porad si po svem");
    }

}
