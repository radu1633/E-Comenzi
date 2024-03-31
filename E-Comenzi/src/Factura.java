import java.text.*;
import java.util.*;


public class Factura {
    private static int id = 1;
    private int numar;
    private Calendar data;
    private Restaurant r;
    private HashSet<Produs> comanda;
    Masa m;
    private String nume, prenume;
    
    public Factura(int nrOrdine, String nume, String prenume){
        this.nume = nume;
        this.prenume = prenume;
        numar = id++;
        data = Calendar.getInstance();
        r = Restaurant.getInstanta();
        comanda = r.getMasa(nrOrdine).getComanda().getHashSet();
        m = r.getMasa(nrOrdine);
    }
    
    public int numaraProdus(String denumire){
        int nr = 0;
        for(Produs p : comanda){
            if (p.getDenumire().equals(denumire)) nr++;
        }
        return nr;
    }
    
    public String toString(){
        
        String sir = "Factura: " + numar + "\r\n";
        sir+="Data emiterii: "+ DateFormat.getDateInstance(DateFormat.LONG).format(data.getTime())+"\r\n";
        sir+="------------------------------------------------------------------------\r\n\r\n";
        sir+="Chelner: "+nume+" "+ prenume + "\r\n";
        sir+="------------------------------------------------------------------------\r\n\r\n";
        sir+= String.format("%-30s","Denumire")+ String.format("%-16s", "Gramaj") + String.format("%-15s","Pret")+String.format("%-15s","")+ String.format("%-15s","Pret total") + "\r\n\n";
        double total = 0;
        for(Produs p : comanda){
           
           int nr = m.getComanda().numaraProdus(p.getDenumire());
           double pret = p.getPret() * nr;
           total += pret;
           sir += String.format("%-30s",p.getDenumire())  + String.format("%.2f%-15s",p.getCantitate(), p.getUnitateMasura()) + String.format("%-15.2f",p.getPret()) + "x" +String.format("%-15d",nr) + String.format("%-15.2f", pret) + "\r\n";
        }
        sir+="------------------------------------------------------------------------\r\n\r\n";
        sir+="TOTAL\t\t"+String.format("%-20.2f",total)+" lei \r\n";
        
        return sir;
    }
    
    
}
