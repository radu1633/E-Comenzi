import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

        
public class Meniu {
    private static Meniu meniu;
    private ManagerFisierMeniu mfm;
    
    private static ArrayList<Produs> produse;
    
    
    
    private Meniu(){
        mfm = new ManagerFisierMeniu();
        produse = mfm.citesteObiecte();
        
    }
    
    public void salveazaMeniu(){ 
            for (Produs p : produse){
                mfm.scrieObiecte(p);
            }
            mfm.inchide(); 
    }
    
    public void stergeProdus(String denumire){
            for(Produs p : produse)
            if(denumire.equals(p.getDenumire())) {
	    produse.remove(p);
	    JOptionPane.showMessageDialog(null, "Produsul a fost sters din meniu!", "Information", JOptionPane.INFORMATION_MESSAGE);
	    return;
	  }
    }
    
    public void adaugaProdus(String denumire, double cantitate, String unitateMasura, double pu, String tipProdus){
        boolean b;
        if(tipProdus.equals("Starter")){
            b = produse.add(new Starter(denumire, cantitate, unitateMasura, pu));
            if(b) JOptionPane.showMessageDialog(null, "Produsul a fost adaugat in meniu", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        if(tipProdus.equals("MainCourse")){
            b = produse.add(new MainCourse(denumire, cantitate, unitateMasura, pu));
            if(b) JOptionPane.showMessageDialog(null, "Produsul a fost adaugat in meniu", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        if(tipProdus.equals("Desert")){
            b = produse.add(new Desert(denumire, cantitate, unitateMasura, pu));
            if(b) JOptionPane.showMessageDialog(null, "Produsul a fost adaugat in meniu", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        if(tipProdus.equals("Racoritoare")){
            b = produse.add(new Racoritoare(denumire, cantitate, unitateMasura, pu));
            if(b) JOptionPane.showMessageDialog(null, "Produsul a fost adaugat in meniu", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        reordoneazaMeniu();
    } 
    
    
    public Produs cautaProdus(String denumire){
        for(Produs p:produse){
            if (p.getDenumire().equals(denumire)) return p;
        }
        return null;
    }
    
    public void schimbaDate(Produs p, String denumire, double cantitate, double pretUnitar){
        for(Produs produs : produse){
            if(produs.getDenumire().equals(p.getDenumire())){
                if(!denumire.equals("")) p.setDenumire(denumire);
                if(cantitate != 0) p.setCantitate(cantitate);
                if(pretUnitar != 0) p.setPret(pretUnitar);
                return;
            }
        }
    }
    
    public void reordoneazaMeniu(){
      ArrayList<Produs> temp = new ArrayList<>();
      for (Produs p : produse) {
          if(p instanceof Starter) temp.add(p);
      }
      for (Produs p : produse) {
          if(p instanceof MainCourse) temp.add(p);
      }
      for (Produs p : produse) {
          if(p instanceof Desert) temp.add(p);
      }
      for (Produs p : produse) {
          if(p instanceof Racoritoare) temp.add(p);
      }
      produse = temp;
}
    
    public String getMeniu(){
        StringBuffer sb =new StringBuffer();
        sb.append("Starter" + "\n\n");
	for(Produs p : produse) {
            if(p.getTipProdus().equals("Starter")) sb.append("      " + p.getInformatiiMeniu() + "\n");
        }
        sb.append("\n\nMainCourse" + "\n\n");
        for(Produs p : produse) {
            if(p.getTipProdus().equals("MainCourse")) sb.append("      " + p.getInformatiiMeniu() + "\n");
        }
        sb.append("\n\nDesert" + "\n\n");
        for(Produs p : produse) {
            if(p.getTipProdus().equals("Desert")) sb.append("      " + p.getInformatiiMeniu() + "\n");
        }
        sb.append("\n\nRacoritoare" + "\n\n");
        for(Produs p : produse) {
            if(p.getTipProdus().equals("Racoritoare")) sb.append("      " + p.getInformatiiMeniu() + "\n");
        }
	return sb.toString();
    }
    
    public ArrayList getListaProduse(String tipProdus){
        //StringBuffer sb = new StringBuffer();
        ArrayList<String> prod = new ArrayList<>();
        
        for(Produs p : produse ){
            if(p.getTipProdus().equals(tipProdus)) {
                prod.add( p.getDenumire());
                
            }
        }
        return prod;
    }
    
    public static Meniu getInstanta(){
        if(meniu == null) meniu = new Meniu();
        return meniu;
    }
    
    

}
