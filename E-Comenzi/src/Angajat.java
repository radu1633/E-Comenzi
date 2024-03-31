public class Angajat {
    private String nume, prenume, functie;
    private ColectieAngajati ca;
    
    
    public Angajat(String nume, String prenume, String functie){
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
       
    }
    
    public String getNume(){
        return this.nume;
    }
    
    public String getPrenume(){
        return this.prenume;
    }
    
    public String getFunctie(){
        return this.functie;
    }
    
    public void setNume(String nume){
        this.nume = nume;
    }
    
    public void setPrenume(String prenume){
        this.prenume = prenume;
    }
    
    public void setFunctie(String functie){
        this.functie = functie;
    }
    
    public String getInformatii(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.nume);
        sb.append(" ");
        sb.append(this.prenume);
        sb.append(" ");
        sb.append(this.functie);
        
        return sb.toString();
    }
    
}
