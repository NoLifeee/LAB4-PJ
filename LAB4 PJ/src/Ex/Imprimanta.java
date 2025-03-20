package Ex;

enum ModTiparire{
    COLOR,
    ALBNEGRU
}

public class Imprimanta extends Echipament
{
    private int ppm;
    private String dpi;
    private int p_car;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, StareEchip stareEchip, int ppm, String dpi, int p_car, ModTiparire modTiparire)
    {
        super(denumire,nr_inv,pret,zona_mag,stareEchip);
        this.modTiparire=modTiparire;
        this.p_car=p_car;
        this.dpi=dpi;
        this.ppm=ppm;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }
    @Override
    public String toString()
    {
        return (super.toString() + ppm + " " + dpi + " " + p_car + " " + modTiparire);
    }
}
