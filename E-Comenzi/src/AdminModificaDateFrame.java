import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminModificaDateFrame extends JFrame implements ActionListener{
    private ColectieAngajati ca;
    private JTextField t1, t2;
    private JComboBox cb;
    private JLabel l1, l2, l3;
    private JButton b;
    
    private String nume, prenume, functie;
    
    public AdminModificaDateFrame(String nume, String prenume, String functie){
        super("Modifica date");
        
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
        
        t1 = new JTextField(15);
        t2 = new JTextField(15);
        cb = new JComboBox(new String[]{"Chelner", "Administrator"});
        
        l1 = new JLabel("Modifica nume");
        l2 = new JLabel("Modifica prenume");
        l3 = new JLabel("Modifica functie");
        
        b = new JButton("Salveaza");
        
        JPanel p = new JPanel(new GridLayout(3, 2, 10 ,10));
        p.add(l1); p.add(t1);
        p.add(l2); p.add(t2);
        p.add(l3); p.add(cb);
        
        this.add(p);
        this.add(b, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        b.addActionListener(this);
        
        
    }

    
    public void actionPerformed(ActionEvent e){
        Angajat a = null;
        ca = ColectieAngajati.getInstanta();
        if (e.getSource() == b){
            
            String fun = (String) cb.getSelectedItem();
            
            a = ca.cautaAngajat(nume, prenume, functie);
            ca.schimbaDate(a, t1.getText(), t2.getText(), fun);
            dispose();
            JOptionPane pane = new JOptionPane("Datele au fost schimbate cu succes", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Datele au fost schimbate cu succes", "Information", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog(null, "Title");
            dialog.setModal(false);
            dialog.setVisible(true);
            
            new Timer(2000, new ActionListener() {
            
                public void actionPerformed(ActionEvent e) {
                    dialog.setVisible(false);
                }
            }).start();

            
        }
    }
}
