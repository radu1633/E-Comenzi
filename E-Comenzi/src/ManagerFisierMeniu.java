import java.io.*;
import java.util.*;

public class ManagerFisierMeniu implements ManagerFisiere{
    private BufferedReader br;
    private PrintWriter pw;
    private ArrayList<Produs> produse;
    private String l;
    
    public ArrayList citesteObiecte(){
        File f = new File("D:\\JavaProjectVSCode\\OOP\\E-Comenzi\\meniu.txt");
        produse = new ArrayList<>();
        
        Produs p = null;
        
        if (f.exists()){
        try{
            if(br == null) br = new BufferedReader(new FileReader(f));
            while((l = br.readLine()) != null ){
                String[] s = l.split(" ");
                if(s[4].equals("Starter")) p = new Starter(s[0], Double.parseDouble(s[1]), s[2], Double.parseDouble(s[3]));
                else if(s[4].equals("MainCourse")) p = new MainCourse(s[0], Double.parseDouble(s[1]), s[2], Double.parseDouble(s[3]));
                else if(s[4].equals("Desert")) p = new Desert(s[0], Double.parseDouble(s[1]), s[2], Double.parseDouble(s[3]));
                else if(s[4].equals("Racoritoare")) p = new Racoritoare(s[0], Double.parseDouble(s[1]), s[2], Double.parseDouble(s[3]));
                produse.add(p);
            }
            
            }catch(IOException io){io.printStackTrace();}
        
        }
        return produse;
    }
    
    public void scrieObiecte(Object o){
        try{
            if(pw == null) pw = new PrintWriter(new FileWriter("D:\\JavaProjectVSCode\\OOP\\E-Comenzi\\meniu.txt"));
            Produs p = (Produs) o;
            pw.println(p.getInformatiiFisier());
            
        }catch(IOException e) {e.printStackTrace();}
    }
    
     public void inchide(){
        pw.close();
    }
}