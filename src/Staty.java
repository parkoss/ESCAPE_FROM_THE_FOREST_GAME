public class Staty implements Command {

    Hrac hrac;

    public Staty(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Zobrazuje statistiky hráče.
     *
     * @return Informace o statistikách hráče.
     */
    @Override
    public String execute() {
        System.out.println("tve staty:");
        System.out.println("zivoty: " + hrac.getZivoty());
        System.out.println("sila: " + hrac.getSila());
        return "staty vypsany";

    }

    @Override
    public Boolean exit() {
        return null;
    }


}
