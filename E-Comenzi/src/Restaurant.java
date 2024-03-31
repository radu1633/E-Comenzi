import java.util.*;
import javax.swing.JFrame;

public class Restaurant {
    private ArrayList<Masa> mArray;
    private static Restaurant r;
    
    
    private Restaurant(){
        mArray = new ArrayList<>();
        for(int i = 1; i<=8; i++){
            mArray.add(new Masa(i));
        }
    }
   
    
    public Masa getMasa(int nrOrdine){
        for(Masa masa : mArray){
            if(masa.getNrOrdine() == nrOrdine) return masa;
        }
        return null;
    }
    
    
    public static Restaurant getInstanta(){
        if(r == null) r = new Restaurant();
        return r;
    }
    
    
}
