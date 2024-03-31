import java.util.*;

public class Comanda {
    private int nrMasa;
    private Meniu m;
    private ArrayList<Produs> comanda = new ArrayList<>();
    private HashSet<Produs> hashSet = new HashSet<>();
    
    public Comanda(int nrMasa){
        this.nrMasa = nrMasa;
        m = Meniu.getInstanta();
    }
    
    public void adaugaProdus(String denumire, int n){
        for(int i = 1; i <= n; i++){
            Produs p = m.cautaProdus(denumire);
            comanda.add(p);
        }
        
    }
    
    public void eliminaProdus(String denumire, int n){
            for(int i = 1; i <= n; i++){
            Produs p = m.cautaProdus(denumire);
            comanda.remove(p);
        }
    }
    
    public HashSet<Produs> getHashSet(){
        return hashSet;
    }
    
    public void mutaMasa(int nrMasaNoua){
        this.nrMasa = nrMasaNoua;
    }
   
    public int numaraProdus(String denumire){
        int nr = 0;
        for(Produs p : comanda){
            if (p.getDenumire().equals(denumire)) nr++;
        }
        return nr;
    }
    
    public void setComanda(ArrayList<Produs> x){
        comanda = x;
    }
    
    public ArrayList mutaComanda(){
        return comanda;
    }
    
    public String getInformatiiComanda(){
        StringBuffer sb = new StringBuffer();
        for(Produs p : comanda){
            hashSet.add(p);
        }
        for(Produs h : hashSet){
            sb.append("        " + getInformatii(h) + "\n");
        }
        return sb.toString();
    }
    
    public String getInformatii(Produs p){
            if(numaraProdus(p.getDenumire()) == 0) return "";
            StringBuffer sb = new StringBuffer();
        
            sb.append(p.getDenumire());
            sb.append("     ");
            sb.append(p.getCantitate());
            sb.append(p.getUnitateMasura());
            sb.append("     ");
            sb.append(p.getPret());
            sb.append(" lei");
            sb.append("     ");
            sb.append("x" + numaraProdus(p.getDenumire()));
            
            return sb.toString();
            
         
    }
}