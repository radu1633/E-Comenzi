import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class ChelnerComandaFrame extends JFrame{
    
    private JTextArea comandaArea;
    private JComboBox categorie, produs, nrProduse;
    private JLabel alegeCategorie, alegeProdus, numarulDeProduse, nul1, nul2;
    private JButton butonPlus, butonMinus;
    private Controller ce;
    private int nrMasa;
    private Restaurant r = Restaurant.getInstanta();
    
    
    public ChelnerComandaFrame(String nrMasa){
        super("Comanda " + nrMasa);
        String s[] = nrMasa.split(" ");
        
        this.nrMasa = Integer.parseInt(s[1]);
        
        
        comandaArea = new JTextArea();
        comandaArea.setFont(new Font("Arial", Font.PLAIN, 13));
        comandaArea.setEditable(false);
        comandaArea.append(r.getMasa(this.nrMasa).getComanda().getInformatiiComanda());
        
        
        this.add(comandaArea);
        
        
        ce = new Controller();
        
        categorie = new JComboBox(new String[]{"Toate", "Starter", "MainCourse", "Desert", "Racoritoare"});
        categorie.addActionListener(ce);
        produs = new JComboBox(new String[]{});
        nrProduse = new JComboBox(new String[]{"1", "2", "3", "4", "5"});
        
        alegeCategorie = new JLabel("Alege Categorie");
        alegeProdus = new JLabel ("Alege produs");
        numarulDeProduse = new JLabel("Numar produse");
        nul1 = new JLabel();
        nul2 = new JLabel();
       
   
        butonPlus = new JButton("+");
        butonPlus.addActionListener(ce);
       
        butonMinus = new JButton("-");
        butonMinus.addActionListener(ce);
        
        
        JPanel panel = new JPanel(new GridLayout(2, 4, 5, 5));
        JPanel p = new JPanel(); p.add(butonPlus); p.add(butonMinus);
        panel.add(alegeCategorie); panel.add(alegeProdus); panel.add(numarulDeProduse); panel.add(nul1);
        panel.add(categorie); panel.add(produs); panel.add(nrProduse); panel.add(p);
        this.add(panel, BorderLayout.SOUTH);
        
       setSize(400, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private class Controller implements ActionListener{
        
        private Comanda c;
        private Restaurant r = Restaurant.getInstanta();
        
        private Meniu m = Meniu.getInstanta();
        
        public void actionPerformed (ActionEvent e){
            
           
            c = r.getMasa(nrMasa).getComanda();
             
            if(e.getSource() == categorie){
                
                if(categorie.getSelectedItem().equals("Starter")){
                    
                    produs.removeAllItems();
                    ArrayList<String> s = m.getListaProduse("Starter");
                    for(String item : s) produs.addItem(item);
                }
                if(categorie.getSelectedItem().equals("MainCourse")){
                    produs.removeAllItems();
                    ArrayList<String> s = m.getListaProduse("MainCourse");
                    for(String item : s) produs.addItem(item);
                }
                if(categorie.getSelectedItem().equals("Desert")){
                    produs.removeAllItems();
                    ArrayList<String> s = m.getListaProduse("Desert");
                    for(String item : s) produs.addItem(item);
                }
                if(categorie.getSelectedItem().equals("Racoritoare")){
                    produs.removeAllItems();
                    ArrayList<String> s = m.getListaProduse("Racoritoare");
                    for(String item : s) produs.addItem(item);
                }
            }
            
            if(e.getSource() == butonPlus){
                
                if(nrProduse.getSelectedItem().equals("Toate")){
                    JOptionPane.showMessageDialog(null, "Aceasta comanda poate fi folosita numai la stergerea produselor!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    int n =Integer.parseInt(nrProduse.getSelectedItem().toString());
                    c.adaugaProdus((String)produs.getSelectedItem(), n);
                    comandaArea.setText(c.getInformatiiComanda());
                }
            }
            
            if(e.getSource() == butonMinus){
                    int n =Integer.parseInt(nrProduse.getSelectedItem().toString());
                    c.eliminaProdus((String)produs.getSelectedItem(), n);
                    comandaArea.setText(c.getInformatiiComanda());
                    
                
            }
        }
    }
}
