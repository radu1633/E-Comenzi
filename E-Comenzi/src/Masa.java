public class Masa {
    private Comanda c;
    private int nrOrdine;
    private int stare; 
    
    public Masa(int nrOrdine){
        this.nrOrdine = nrOrdine;
    }
    
    public int getNrOrdine(){
        return nrOrdine;
    }
    
    
    public void setStare(int stare){
        this.stare = stare;
        if(this.stare == 1) c = new Comanda(nrOrdine);
        else c = null;
    }
    
    
    public Comanda getComanda(){
        return c;
    }
}
