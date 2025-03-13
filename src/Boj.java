import java.util.Random;

public class Boj implements Command{
    Hrac hrac;
    private int nepritelZivoty;
    private int nepritelSila;
    Random rd = new Random();

    @Override
    public String execute() {
        System.out.println("zacina boj!");
        nepritelSila= rd.nextInt(4+8);
        int hraczivoty= hrac.getZivoty();
        nepritelZivoty=rd.nextInt(31)+40;

        while(hrac.getZivoty()>0 && nepritelZivoty>0){
            int hracUtok=hrac.getSila()*rd.nextInt(5);
            nepritelZivoty-=hracUtok;
            System.out.println("uderil si nepritele za: "+ hracUtok + " zivotu");
            if (nepritelZivoty<=0){
                System.out.println("zabil si nepritele!");
            }
            int nepritelUtok=rd.nextInt(4)+8;
            hraczivoty-=nepritelUtok;
            System.out.println("nepritel uderil za: " + nepritelUtok + " zivotu");

            if (hraczivoty>=0){
                System.out.println("jses mrtvy");
            }
        }



        return "chyba v boji";
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
