package Ex;

public class Copiator extends Echipament
{
    private int p_ton;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, int nr_inv, float pret, String zona_mag, StareEchip stareEchip, int p_ton, FormatCopiere formatCopiere)
    {
        super(denumire,nr_inv,pret,zona_mag,stareEchip);
        this.formatCopiere=formatCopiere;
        this.p_ton=p_ton;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere)
    {
        this.formatCopiere=formatCopiere;
    }

    @Override
    public String toString()
    {
        return (super.toString() + p_ton + " " + formatCopiere);
    }

}
