import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChelnerFrame extends JFrame{
    private JComboBox nrMasa;
    private JButton comanda, mutaComanda, selecteaza, vizualizeazaBon, elibereazaMasa;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8;
    private final Color Lgreen = new Color(102,255,102);
    private final Color Lred = new Color(255, 51, 51);
    private ArrayList<JButton> jArray;
    private ControllerButoane ce;
    private String nume, prenume;
    
    
    
    
    
    public ChelnerFrame(String nume, String prenume){
        this.nume = nume;
        this.prenume = prenume;
        ce = new ControllerButoane();
        
        jArray = new ArrayList<>();
        b1 =  new JButton("Masa 1");  b1.addActionListener(ce); jArray.add(b1);
        b2 =  new JButton("Masa 2");  b2.addActionListener(ce); jArray.add(b2);
        b3 =  new JButton("Masa 3");  b3.addActionListener(ce); jArray.add(b3);
        b4 =  new JButton("Masa 4");  b4.addActionListener(ce); jArray.add(b4);
        b5 =  new JButton("Masa 5");  b5.addActionListener(ce); jArray.add(b5);
        b6 =  new JButton("Masa 6");  b6.addActionListener(ce); jArray.add(b6);
        b7 =  new JButton("Masa 7");  b7.addActionListener(ce); jArray.add(b7);
        b8 =  new JButton("Masa 8");  b8.addActionListener(ce); jArray.add(b8);
        
        for(JButton b : jArray){
            b.setBackground(Lgreen);
            b.setFocusable(false);
        }
        
    
        
        //add(b1, BorderLayout.NORTH);
        //add(b2, BorderLayout.NORTH);
        JPanel p = new JPanel();
        //new GridLayout(2, 4, 20, 20)
        p.add(b1); p.add(b2); p.add(b3); p.add(b4);
        p.add(b5); p.add(b6); p.add(b7); p.add(b8);
      
        this.add(p);
        
        nrMasa = new JComboBox(new String[]{"Toate","Masa 1", "Masa 2", "Masa 3", "Masa 4", "Masa 5", "Masa 6", "Masa 7", "Masa 8"});
        nrMasa.addActionListener(ce);
        
        selecteaza = new JButton("Selecteaza");
        
        comanda = new JButton("Comanda");
        comanda.setEnabled(false);
        comanda.addActionListener(ce);
        
        mutaComanda = new JButton("Muta comanda");
        mutaComanda.setEnabled(false);
        mutaComanda.addActionListener(ce);
        
        vizualizeazaBon = new JButton("Vizualizeaza bon");
        vizualizeazaBon.setEnabled(false);
        vizualizeazaBon.addActionListener(ce);
        
        elibereazaMasa = new JButton("Elibereaza masa");
        elibereazaMasa.setEnabled(false);
        elibereazaMasa.addActionListener(ce);
        
        JPanel p1 = new JPanel();
        p1.add(nrMasa);
        p1.add(comanda);
        p1.add(mutaComanda);
        p1.add(vizualizeazaBon);
        p1.add(elibereazaMasa);
        
        this.add(p1, BorderLayout.SOUTH);
        
        setSize(575, 170);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }


    private class ControllerButoane implements ActionListener{
        private Restaurant r;
        private Factura fac;
        private ColectieAngajati ca;
        
    public void actionPerformed(ActionEvent e) {
        r = Restaurant.getInstanta();
        ca = ColectieAngajati.getInstanta();
        Angajat a = ca.cautaAngajat(nume, prenume, "Chelner");
        
        
        
        if(e.getSource() == b1 && b1.getBackground().equals(Lgreen)){
            String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b1.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 1 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if(e.getSource() == b2 && b2.getBackground().equals(Lgreen)){
             String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b2.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 2 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        if(e.getSource() == b3 && b3.getBackground().equals(Lgreen)){
             String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b3.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 3 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        if(e.getSource() == b4 && b4.getBackground().equals(Lgreen)){
             String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b4.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 4 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        if(e.getSource() == b5 && b5.getBackground().equals(Lgreen)){
            String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b5.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 5 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        if(e.getSource() == b6 && b6.getBackground().equals(Lgreen)){
             String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b6.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 6 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
           
        }
        if(e.getSource() == b7 && b7.getBackground().equals(Lgreen)){
             String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b7.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 7 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        if(e.getSource() == b8 && b8.getBackground().equals(Lgreen)){
             String s = JOptionPane.showInputDialog("Introduceti id-ul dumneavoastra: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int id = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(((Chelner)a).getNumarId() != id){
                    JOptionPane.showMessageDialog(null, "Acest id nu exista sau apartine unui alt angajat!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    b8.setBackground(Lred); 
                    JOptionPane.showMessageDialog(null, "Masa 8 a fost ocupata", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
        
        
        
        if(e.getSource() == nrMasa){
            Masa m;
            
            if(b1.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 1")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(1);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b2.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 2")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(2);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b3.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 3")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(3);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b4.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 4")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(4);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b5.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 5")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(5);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b6.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 6")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(6);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b7.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 7")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(7);
                if(m.getComanda() == null) m.setStare(1);
            }
            else if(b8.getBackground().equals(Lred) && nrMasa.getSelectedItem().equals("Masa 8")){
                comanda.setEnabled(true);
                mutaComanda.setEnabled(true);
                vizualizeazaBon.setEnabled(true);
                elibereazaMasa.setEnabled(true);
                m = r.getMasa(8);
                if(m.getComanda() == null) m.setStare(1);
            }
            else {
                comanda.setEnabled(false);
                mutaComanda.setEnabled(false);
                vizualizeazaBon.setEnabled(false);
                elibereazaMasa.setEnabled(false);
            }   
            
        }
        
        
        if(e.getSource() == comanda){
            JFrame f;
            f = new ChelnerComandaFrame(nrMasa.getSelectedItem().toString());
            
        }
        
        if(e.getSource() == mutaComanda){
            Masa m1, m2;
            String nr = nrMasa.getSelectedItem().toString();
            String s2[] = nrMasa.getSelectedItem().toString().split(" ");
            int numarMasa = Integer.parseInt(s2[1]);
            
            String s = JOptionPane.showInputDialog("Tastati numarul mesei pe care vreti sa mutati comanda: ");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String[] s1 = s.split(" ");
                int numarMasa2 = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else if(numarMasa2 != 1 && numarMasa2 != 2 && numarMasa2 != 3 && numarMasa2 != 4 && numarMasa2 != 5 && numarMasa2 != 6 && numarMasa2 != 7 && numarMasa2 != 7 ){
                    JOptionPane.showMessageDialog(null, "Numarul mesei nu exista. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                
                }
                else{
                    m1 = r.getMasa(numarMasa);
                    m2 = r.getMasa(numarMasa2);
                    m2.setStare(1);
                    m2.getComanda().mutaMasa(numarMasa);
                    m2.getComanda().setComanda(m1.getComanda().mutaComanda());
                    m1.setStare(0);
                    for(JButton b : jArray)
                        if(nr.equals(b.getText())){
                        b.setBackground(Lgreen);
                        comanda.setEnabled(false);
                        mutaComanda.setEnabled(false);
                        vizualizeazaBon.setEnabled(false);
                        elibereazaMasa.setEnabled(false);
                    }
                    String masa = "Masa " + numarMasa2;
                    for(JButton b : jArray)
                        if(b.getText().equals(masa))
                            b.setBackground(Lred);
                }
            }    
        }
        
        
        if(e.getSource() == vizualizeazaBon){
            JFrame f;
            String s[] = nrMasa.getSelectedItem().toString().split(" ");
            int numarMasa = Integer.parseInt(s[1]);
            fac = new Factura(numarMasa, nume, prenume);
            f = new FacturaFrame(fac);
            
        }
        
        if(e.getSource() == elibereazaMasa){
            String s[] = nrMasa.getSelectedItem().toString().split(" ");
            int numarMasa = Integer.parseInt(s[1]);
            Masa m = Restaurant.getInstanta().getMasa(numarMasa);
            m.setStare(0);
            for(JButton b : jArray){
                if(nrMasa.getSelectedItem().toString().equals(b.getText())){
                    b.setBackground(Lgreen);
                    comanda.setEnabled(false);
                    mutaComanda.setEnabled(false);
                    vizualizeazaBon.setEnabled(false);
                    elibereazaMasa.setEnabled(false);
                }
            }
        }
    }
    }
}
