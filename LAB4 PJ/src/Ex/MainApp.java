package Ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException {
        List<Echipament> listaEchipament = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Scanner scannerFisier = new Scanner(new File("src/Ex/Echipament.txt"));
        int opt;

        while(true)
        {
            System.out.println("1.Afisarea tuturor echipamentelor");
            System.out.println("2.Afisarea imprimantelor");
            System.out.println("3.Afisarea copiatoarelor");
            System.out.println("4.Afisarea sistemelor de calcul");
            System.out.println("5.Modificarea starii in care se afla un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println(("7.Setarea unui format de copiere pentru copiatoare"));
            System.out.println("8.Instalarea unui anumit sistem de operare pentru un sistem de calcul");
            System.out.println("9.Afisarea echipamentelor vandute");
            System.out.println("10.Serializeaza colectia de obiecte");
            System.out.println("11.Deserializeaza colectia de obiecte");
            System.out.println("0.Iesire");
            System.out.print("Dati optiune: ");
            opt=scanner.nextInt();
            while(scannerFisier.hasNextLine())
            {
                String linie = scannerFisier.nextLine();
                String [] date = linie.split(";");
                String denumire = date[0];
                int nr_inv=Integer.parseInt(date[1]);
                float pret=Float.parseFloat(date[2]);
                String zona_mag= date[3];
                StareEchip stare = StareEchip.valueOf(date[4].toUpperCase());
                switch (date[5].toLowerCase())
                {
                    case "imprimanta":
                        listaEchipament.add(new Imprimanta(denumire,nr_inv,pret,zona_mag,stare,Integer.parseInt(date[6]),date[7],Integer.parseInt(date[8]),ModTiparire.valueOf(date[9].toUpperCase())));
                        break;
                    case "copiator":
                        listaEchipament.add(new Copiator(denumire,nr_inv,pret,zona_mag,stare,Integer.parseInt(date[6]),FormatCopiere.valueOf(date[7].toUpperCase())));
                        break;
                    case "sistem de calcul":
                        listaEchipament.add(new SistemCalcul(denumire,nr_inv,pret,zona_mag,stare,date[6],Double.parseDouble(date[7]),Integer.parseInt(date[8]),SistemOperare.valueOf(date[9].toUpperCase())));
                        break;
                }
            }
            switch(opt)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    for( Echipament e : listaEchipament)
                        System.out.println(e);
                    break;
                case 2:
                    for(Echipament e : listaEchipament)
                        if( e instanceof  Imprimanta)
                        System.out.println(e);
                    break;
                case 3:
                    for(Echipament e : listaEchipament)
                        if(e instanceof Copiator)
                            System.out.println(e);
                    break;
                case 4:
                    for(Echipament e : listaEchipament)
                        if(e instanceof SistemCalcul)
                            System.out.println(e);
                    break;
                case 5:
                {
                    int stare,nr_inv;
                    System.out.print("Dati numarul de inventar al produsului: ");
                    nr_inv=scanner.nextInt();
                    for(Echipament e : listaEchipament)
                        if(nr_inv==e.getNr_inv())
                        {
                            do
                            {
                                System.out.print("Dati starea echipamentului: (1-Achizitionat, 2-Expus, 3-Vandut): ");
                                stare =scanner.nextInt();
                            }while(stare != 1 && stare !=2 && stare !=3);
                            switch (stare)
                            {
                                case 1:
                                    e.setStare(StareEchip.valueOf("ACHIZITIONAT"));
                                    break;
                                case 2:
                                    e.setStare(StareEchip.valueOf("EXPUS"));
                                    break;
                                case 3:
                                    e.setStare(StareEchip.valueOf("VANDUT"));
                                default:
                                    System.out.println("Optiune invalida");
                            }
                        }
                }
                    break;
                case 6:
                {
                    int modTiparire, nr_inv;

                    System.out.print("Dati numarul de inventar al produsului: ");
                    nr_inv = scanner.nextInt();
                    for (Echipament e : listaEchipament)
                        if (nr_inv == e.getNr_inv() && e instanceof Imprimanta) {
                            do {
                                System.out.print("Dati modul de tiparire dorit: (1-Alb Negru, 2-Color): ");
                                modTiparire = scanner.nextInt();
                            } while (modTiparire != 1 && modTiparire != 2 && modTiparire != 3);
                            switch (modTiparire) {
                                case 1:
                                    ((Imprimanta) e).setModTiparire(ModTiparire.valueOf("ALBNEGRU"));
                                    break;
                                case 2:
                                    ((Imprimanta) e).setModTiparire(ModTiparire.valueOf("COLOR"));
                                    break;
                                default:
                                    System.out.println("Optiune invalida");
                            }
                        }
                }
                    break;
                case 7:
                {
                    int formatCopiere, nr_inv;

                    System.out.print("Dati numarul de inventar al produsului: ");
                    nr_inv = scanner.nextInt();
                    for (Echipament e : listaEchipament)
                        if (nr_inv == e.getNr_inv() && e instanceof Copiator) {
                            do {
                                System.out.print("Dati sistemul de operare dorit: (1-A3, 2-A4): ");
                                formatCopiere = scanner.nextInt();
                            } while (formatCopiere != 1 && formatCopiere != 2 && formatCopiere != 3);
                            switch (formatCopiere) {
                                case 1:
                                    ((Copiator) e).setFormatCopiere(FormatCopiere.valueOf("A3"));
                                    break;
                                case 2:
                                    ((Copiator) e).setFormatCopiere(FormatCopiere.valueOf("A4"));
                                    break;
                                default:
                                    System.out.println("Optiune invalida");
                            }
                        }
                }
                    break;
                case 8:
                {
                    int sistemOperare, nr_inv;

                    System.out.print("Dati numarul de inventar al produsului: ");
                    nr_inv = scanner.nextInt();
                    for (Echipament e : listaEchipament)
                        if (nr_inv == e.getNr_inv() && e instanceof SistemCalcul) {
                            do {
                                System.out.print("Dati sistemul de operare dorit: (1-Windows, 2-Linux): ");
                                sistemOperare = scanner.nextInt();
                            } while (sistemOperare != 1 && sistemOperare != 2 && sistemOperare != 3);
                            switch (sistemOperare) {
                                case 1:
                                    ((SistemCalcul) e).setSistemOperare(SistemOperare.valueOf("WINDOWS"));
                                    break;
                                case 2:
                                    ((SistemCalcul) e).setSistemOperare(SistemOperare.valueOf("LINUX"));
                                    break;
                                default:
                                    System.out.println("Optiune invalida");
                            }
                        }
                }
                    break;
                case 9:
                    for(Echipament e : listaEchipament)
                        if(e.getStareEchip()==StareEchip.valueOf("VANDUT"))
                            System.out.println(e);
                    break;
                case 10:
                    serializeaza(listaEchipament,"echip.bin");
                    break;
                case 11:
                    List<Echipament> listaDeserializata = (List<Echipament>) deserializeaza("echip.bin");
                    for(Echipament e : listaDeserializata)
                        System.out.println(e);
                    break;
                default:
                    System.out.println("Optiune invalida");
            }
        }
    }
    static void serializeaza(Object o,String fis)
    {
        try{
            FileOutputStream f= new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    static Object deserializeaza(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o = ois.readObject();
            ois.close();
            f.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
