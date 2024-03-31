import java.util.*;
import javax.swing.JOptionPane;

public class ColectieAngajati{
    private ArrayList<Angajat> al;
   private static ColectieAngajati ca;
    private ManagerFisierAngajati mfa;
    
    private ColectieAngajati(){
        mfa = new ManagerFisierAngajati();
        al = mfa.citesteObiecte();
        
    }
    
    public void salveazaLista(){
            for (Angajat a : al) {
                mfa.scrieObiecte(a);
            }
            mfa.inchide();
        
    }
    
    public Angajat cautaAngajat(String nume, String prenume, String functie){
	   Angajat a=null;
           Iterator<Angajat> it=al.iterator();
		while (it.hasNext()){
			a=it.next();
                        if(nume.equals(a.getNume()) && prenume.equals(a.getPrenume()) && functie.equals(a.getFunctie())) return a;  
		}	
            return null;
    }
    
    public void adaugaAngajat(String nume, String prenume, String functie){
        boolean b;
        if(functie.equals("Chelner")){
            b = al.add(new Chelner(nume, prenume, functie, 0));
            if(b) JOptionPane.showMessageDialog(null, "Angajatul a fost adaugat in sistem", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(functie.equals("Administrator")){
            b = al.add(new Administrator(nume, prenume, functie));
            if(b) JOptionPane.showMessageDialog(null, "Angajatul a fost adaugat in sistem", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    } 
    
    public void stergeAngajat(String nume, String prenume, String functie){
            for(Angajat a : al)
            if(nume.equals(a.getNume()) && prenume.equals(a.getPrenume()) && functie.equals(a.getFunctie())) {
	    al.remove(a);
	    JOptionPane.showMessageDialog(null, "Angajatul a fost sters din sistem!", "Information", JOptionPane.INFORMATION_MESSAGE);
	    return;
	  }
    }
    
    public void schimbaDate(Angajat a, String nume, String prenume, String functie){
        for(Angajat angajat : al)
            if(angajat.getNume().equals(a.getNume()) && angajat.getPrenume().equals(a.getPrenume()) && angajat.getFunctie().equals(a.getFunctie())){
                if(!nume.equals("")) a.setNume(nume);
                if(!prenume.equals("")) a.setPrenume(prenume);
                if(!(a.getFunctie().equals(functie))) a.setFunctie(functie);
                
                return;
            }
    }
    
 
    
    public String getAngajati(){
	StringBuffer sb =new StringBuffer();
	for(Angajat a : al){
            if (a.getFunctie().equals("Chelner")) sb.append(a.getInformatii() + " " + ((Chelner)a).getNumarId() + "\n");
            else sb.append(a.getInformatii() + "\n");
        }
	return sb.toString();
    }
    
    
    public static ColectieAngajati getInstanta(){
	if (ca==null) ca=new ColectieAngajati();
	return ca;
    }	
             
    
}

