public class Produs {
    private String denumire;
    private double pretUnitar;
    private double cantitate;
    private String unitateMasura;
    private String tipProdus;
    
    public Produs(String denumire, double cantitate, String unitateMasura, double pu , String tipProdus){
        this.denumire = denumire;
        this.pretUnitar = pu;
        this.cantitate = cantitate;
        this.unitateMasura = unitateMasura;
        this.tipProdus = tipProdus;
    }
    
    public String getDenumire(){
        return this.denumire;
    }
    
    public double getPret(){
        return this.pretUnitar;
    }
    
    public double getCantitate(){
        return this.cantitate;
    }
    
    public String getUnitateMasura(){
        return this.unitateMasura;
    }
    
    public String getTipProdus(){
        return this.tipProdus;
    }
    
    public void setDenumire(String den){
        this.denumire = den;
    }
    
    public void setCantitate(double cant){
        this.cantitate = cant;
    }
    
    public void setPret(double pu){
        this.pretUnitar = pu;
    }
    
    
    
    public String getInformatiiFisier(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.denumire);
        sb.append(" ");
        sb.append(this.cantitate);
        sb.append(" ");
        sb.append(this.unitateMasura);
        sb.append(" ");
        sb.append(this.pretUnitar);
        sb.append(" ");
        sb.append(this.tipProdus);
        return sb.toString();
    }
    
    public String getInformatiiMeniu(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.denumire);
        sb.append("     ");
        sb.append(this.cantitate);
        sb.append(this.unitateMasura);
        sb.append("     ");
        sb.append(this.pretUnitar);
        sb.append(" lei");
        return sb.toString();
    }
}
