public class Hrac {
    private int zivoty;
    private int sila;
    private int maxZivoty=50;
    Inventar inventar;

    public Hrac(int zivoty, int sila) {
        this.zivoty = zivoty;
        this.sila = sila;
        this.inventar=new Inventar();
    }


    /**
     * Kontroluje pokud ma hrac itemy pro vstup do finalni lokace
     */
    public void vstupDoBrany(){
        if (inventar.getBatoh().contains("elfiHulka")&&inventar.getBatoh().contains("mapaKChramu")){
            inventar.pridejItem("vylepsenaMapaKChramu");
        }
    }

    /**
     * Provádí útok na nepřítele a snižuje jeho životy.
     */
    public void utok(Nepritel nepritel) {
        nepritel.setZivoty(nepritel.getZivoty() - this.sila);
        System.out.println("Útočíš na nepřítele! Zbylé životy nepřítele: " + nepritel.getZivoty());
    }

    /**
     * Zpracovává obranu hráče při útoku nepřítele.
     *
     * @param utokNepritele Síla útoku nepřítele.
     */
    public void obrana(int utokNepritele) {
        this.zivoty -= utokNepritele;
        System.out.println("Byl jsi zasažen! Zbylé životy: " + this.zivoty);
    }



    /**
     * Vylepšuje statistiky hráče na základě předmětu.
     *
     * @param item Předmět, který hráč používá k vylepšení.
     */
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
        if (zivoty>maxZivoty){
            this.zivoty=maxZivoty;
        }else{
            this.zivoty=zivoty;
        }
    }

    public int getMaxZivoty() {
        return maxZivoty;
    }
}
