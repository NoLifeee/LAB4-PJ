package Ex;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Firma comercializează următoarele tipuri de echipamente: imprimante, copiatoare şi sisteme de calcul.
 * @author Muntean Cristian-Miodrag
 * @version 1
 * @since 2025
 */

public class Echipament implements Serializable
{
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private StareEchip stareEchip;



    public Echipament(String denumire, int nr_inv, float pret, String zona_mag, StareEchip stareEchip){
        /**
         * Constructorul clasei Echipament
         * @param denumire denumirea echipamentului
         * @param nr_inv numarul de inventar
         * @param pret pretul
         * @param zona_mag zona din magazin unde se afla
         * @param stareEchip in care se afla (Achizitionat,Expus,Vandut)
         */
        this.zona_mag=zona_mag;
        this.pret=pret;
        this.stareEchip=stareEchip;
        this.nr_inv=nr_inv;
        this.denumire=denumire;
    }

    public StareEchip getStareEchip()
    {
        /**
         * Getter care da acces de citire a starii echipamentului
         * @return Starea Echipamentului
         */
        return stareEchip;
    }

    public int getNr_inv()
    {
        /**
         * Getter care da acces de citire la numarul de inventar
         * @return numarul de inventar
         */
        return nr_inv;
    }

    public void setStare(StareEchip stare)
    {
        /**
         * Setter care da acces de scriere a starii echipamentului
         * @param stare starea echipamentului
         */
        this.stareEchip=stare;
    }

    @Override
    public String toString()
    {
        /**
         * Redefinirea metodei toString() din clasa de baza Object
         * @return sir de caractere cu toti parametrii clasei separati prin spatiu
         */
        return (denumire + " " + nr_inv + " " + pret + " " + zona_mag + " " + stareEchip + " ");
    }
}
