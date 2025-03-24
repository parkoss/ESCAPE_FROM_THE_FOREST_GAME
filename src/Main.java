public class Main {
    public static void main(String[] args) {
        Commands commands=new Commands();
        MapaLesa mapaLesa = new MapaLesa();
        Lokace lokace=new Lokace();
        Hrac hrac = new Hrac(50,10);
        Boj boj=new Boj(hrac);
        commands.start(mapaLesa,hrac,lokace);

    }
}