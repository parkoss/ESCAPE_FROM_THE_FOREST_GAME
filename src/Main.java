public class Main {
    public static void main(String[] args) {
        Commands commands=new Commands();
        MapaLesa mapaLesa = new MapaLesa();
        Inventar inventar=new Inventar();
        Lokace lokace=new Lokace();
        commands.start(mapaLesa,inventar,lokace);

    }
}