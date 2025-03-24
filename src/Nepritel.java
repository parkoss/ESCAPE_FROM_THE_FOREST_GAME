public class Nepritel {
    private String jmeno;
    private int zivoty;
    private int sila;

    public Nepritel(String jmeno, int zivoty, int sila) {
        this.jmeno = jmeno;
        this.zivoty = zivoty;
        this.sila = sila;
    }

    public void utok(Hrac hrac) {
        hrac.obrana(this.sila);
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getSila() {
        return sila;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
