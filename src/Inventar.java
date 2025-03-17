import java.util.ArrayList;
import java.util.Scanner;

public class Inventar implements Command{

    private ArrayList<String> batoh = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    @Override
    public String execute() {
        if (batoh.isEmpty()){
            return "nic v batohu nemas";

        }
            String obsahBatohu="V batohu mas: \n";
        System.out.println(toString());


        return obsahBatohu;
    }

    @Override
    public Boolean exit() {
        return null;
    }


    public boolean pridejItem(String item){
        if(item != null){
            batoh.add(item);
            return true;
        }
        return false;
    }

    public boolean odeberItem(Item item){
        for (int i = 0; i < batoh.size(); i++) {
            if(item.equals(batoh.get(i))){
                batoh.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getBatoh() {
        return batoh;
    }

    @Override
    public String toString() {

        return "\n" +
                "-batoh=" + batoh;
    }
}
