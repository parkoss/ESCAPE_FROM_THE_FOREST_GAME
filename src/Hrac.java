public class Hrac {
    private int zivoty;
    private int sila;
    Inventar inventar;

    public Hrac(int zivoty, int sila) {
        this.zivoty = zivoty;
        this.sila = sila;
        this.inventar=new Inventar();
    }



    public void vstupDoBrany(){
        if (inventar.getBatoh().contains("elfiHulka")&&inventar.getBatoh().contains("mapaKChramu")){
            inventar.pridejItem("vylepsenaMapaKChramu");
        }
    }



    public void utok(Nepritel nepritel) {
        nepritel.setZivoty(nepritel.getZivoty() - this.sila);
        System.out.println("Útočíš na nepřítele! Zbylé životy nepřítele: " + nepritel.getZivoty());
    }

    public void obrana(int utokNepritele) {
        this.zivoty -= utokNepritele;
        System.out.println("Byl jsi zasažen! Zbylé životy: " + this.zivoty);
    }

    public void vylepsiStaty(Item item) {
        this.sila += item.getUtok();
        this.zivoty+= item.getObrana();
    }

    public int getZivoty() {
        return zivoty;
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
