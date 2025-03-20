public class Main {
    public static void main(String[] args) {
        Commands commands=new Commands();
        MapaLesa mapaLesa = new MapaLesa();
        Lokace lokace=new Lokace();
        Hrac hrac = new Hrac(50,10);
        commands.start(mapaLesa,hrac,lokace);

    }
}