public class Pomoc implements Command{

    @Override
    public String execute() {
        System.out.println("---------------------------------");
        System.out.println("jdi - chuze po mape");
        System.out.println("seber - seber item, ktery lezi na zemi");
        System.out.println("batoh - ukazou se ti itemy, ktere vlastnis");
        System.out.println("staty - ukazou se tvoje staty");
        System.out.println("---------------------------------");

        return "kdykoliv budes chtit zase pomoct, staci napsat";
    }

    @Override
    public Boolean exit() {
        return null;
    }
}
