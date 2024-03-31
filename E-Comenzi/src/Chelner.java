public class Chelner extends Angajat{
    
    private static int id = 0;
    private int numarId;
      
    public Chelner(String nume, String prenume, String functie, int id){
        super(nume, prenume, "Chelner");
        if(id == 0)numarId = ++this.id;
        else {
            numarId = id;
            this.id = id;
        }
    }
    
    public int getNumarId(){
        return numarId;
    }
    
}
