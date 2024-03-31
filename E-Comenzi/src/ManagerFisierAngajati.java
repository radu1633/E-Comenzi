import java.io.*;
import java.util.*;

public class ManagerFisierAngajati implements ManagerFisiere{
    
    private BufferedReader br;
    private PrintWriter pw;
    private ArrayList<Angajat> al;
    private String l;
    
    public ArrayList citesteObiecte(){
        File f=new File("D:\\JavaProjectVSCode\\OOP\\E-Comenzi\\angajati.txt");
        al = new ArrayList<>();
        Chelner c;
        Administrator a;
        if (f.exists()){
        try{
            if(br == null) br = new BufferedReader(new FileReader(f));
            
            while((l = br.readLine()) != null ){
                
                String[] s = l.split(" ");
                if(s.length > 1){
                    if(s[2].equals("Administrator")){
                        a = new Administrator(s[0], s[1], s[2]);
                        al.add(a);
                    }
                    if(s[2].equals("Chelner")){
                        c = new Chelner(s[0], s[1], s[2], Integer.parseInt(s[3]));
                        al.add(c);
                    }
                }
            }
        }catch(IOException io){io.printStackTrace();}
        
        }
        return al;
    }
    
    public void scrieObiecte(Object o){
        try{
            if(pw == null) pw = new PrintWriter(new FileWriter("D:\\JavaProjectVSCode\\OOP\\E-Comenzi\\angajati.txt"));
            Angajat a = (Angajat) o;
            if (a.getFunctie().equals("Chelner")) pw.println(a.getInformatii() + " " + ((Chelner)a).getNumarId());
                else pw.println(a.getInformatii());
            //pw.flush();
    }catch(IOException io){io.printStackTrace();}
        
    }
    
    
    public void inchide(){
        pw.close();
    }
}
