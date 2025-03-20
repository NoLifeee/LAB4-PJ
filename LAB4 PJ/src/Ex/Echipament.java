package Ex;

import java.io.Serializable;
import java.util.Scanner;

enum StareEchip{
    ACHIZITIONAT,
    EXPUS,
    VANDUT
}
public class Echipament implements Serializable
{
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private StareEchip stareEchip;

    public Echipament(String denumire, int nr_inv, float pret, String zona_mag, StareEchip stareEchip){
        this.zona_mag=zona_mag;
        this.pret=pret;
        this.stareEchip=stareEchip;
        this.nr_inv=nr_inv;
        this.denumire=denumire;
    }

    public StareEchip getStareEchip()
    {
        return stareEchip;
    }

    public int getNr_inv()
    {
        return nr_inv;
    }

    public void setStare(StareEchip stare)
    {
        this.stareEchip=stare;
    }

    @Override
    public String toString()
    {
        return (denumire + " " + nr_inv + " " + pret + " " + zona_mag + " " + stareEchip + " ");
    }
}
