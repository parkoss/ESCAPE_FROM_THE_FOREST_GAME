import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Commands commands=new Commands();
        MapaLesa mapaLesa = new MapaLesa();
        Inventar inventar=new Inventar();
        Lokace lokace=new Lokace();
        commands.start(mapaLesa,inventar,lokace );

    }
}