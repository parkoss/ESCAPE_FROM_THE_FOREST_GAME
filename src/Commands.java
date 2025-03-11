import java.util.HashMap;
import java.util.Scanner;

public class Commands{

    private boolean exit=false;
    private HashMap<String, Command> map = new HashMap<>();

    public void inicialization(){
        map.put("jdi",new Pohyb());
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
            System.out.println(">> Nondefined command");
        }
    }


    public void start(){
        inicialization();
        //String text = Text.loadFile();
        //System.out.println(text);
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
