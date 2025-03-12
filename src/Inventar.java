import java.util.ArrayList;
import java.util.Scanner;

public class Inventar implements Command{

    private ArrayList<Item> batoh = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    @Override
    public String execute() {
        if (batoh.isEmpty()){
            return "nic v batohu nemas";

        }
            String obsahBatohu="V batohu mas: \n";
            for (Item item:batoh){
                obsahBatohu += "- " + item.getNazev() + "\n";
            }

        return obsahBatohu;
    }

    @Override
    public Boolean exit() {
        return null;
    }


    public boolean pridejItem(Item item){
        if(item != null){
            batoh.add(item);
            return true;
        }
        return false;
    }

    public boolean odeberItem(Item item){
        for (int i = 0; i < batoh.size(); i++) {
            if(item == batoh.get(i)){
                batoh.remove(i);
                return true;
            }
        }
        return false;
    }
}
