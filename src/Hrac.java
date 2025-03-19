public class Hrac {
    private int zivoty;
    private int sila;
    private int endGameItemy;
    private boolean maObaItemy=false;
    Inventar inventar;

    public Hrac(int zivoty, int sila) {
        this.zivoty = zivoty;
        this.sila = sila;
    }



    public void vstupDoBrany(){
        if (inventar.getBatoh().contains("elfiHulka")&&inventar.getBatoh().contains("mapaKChramu")){
            inventar.pridejItem("vylepsenaMapaKChramu");
        }
    }

    public void test(){
        inventar.pridejItem("elfiHulka");
        inventar.pridejItem("mapaKChramu");
    }

    public int getZivoty() {
        return 50;
    }

    public int getSila() {
        return 10;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
