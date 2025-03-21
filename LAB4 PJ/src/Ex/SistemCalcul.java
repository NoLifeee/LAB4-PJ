package Ex;

public class SistemCalcul extends Echipament
{
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistemOperare;

    public SistemCalcul(String denumire, int nr_inv, float pret, String zona_mag, StareEchip stareEchip,String tip_mon, double vit_proc, int c_hdd, SistemOperare sistemOperare)
    {
        super(denumire,nr_inv,pret,zona_mag,stareEchip);
        this.sistemOperare=sistemOperare;
        this.tip_mon=tip_mon;
        this.vit_proc=vit_proc;
        this.c_hdd=c_hdd;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString()
    {
        return (super.toString() + tip_mon + " " + vit_proc + " " + c_hdd + " " + sistemOperare);
    }
}
