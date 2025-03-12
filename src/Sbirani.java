public class Sbirani implements Command{

    Item item;
    Inventar inventar;

    public Sbirani(Inventar inventar) {
        this.inventar = inventar;
    }

    @Override
    public String execute() {
        if (item != null) {
            inventar.pridejItem(item);
            return "Sebral jsi: " + item.getNazev();
        }
        return "Není co sebrat.";
    }

    @Override
    public Boolean exit() {
        return null;
    }
}