import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminModificaDateProduseFrame extends JFrame implements ActionListener{
    private Meniu m;
    private JLabel l1, l2, l3;
    private JTextField t1, t2, t3;
    private JButton b1;
    private String denumire;
    
    
    public AdminModificaDateProduseFrame(String denumire){
        super("Modifica date");
        
        this.denumire = denumire;
        
        
        l1 = new JLabel("Denumire noua");
        l2 = new JLabel("Cantitate noua");
        l3 = new JLabel("Pret nou");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        
        b1 = new JButton("Salveaza modificarile");
        
        JPanel p = new JPanel(new GridLayout(2, 4, 10, 10));
        
        p.add(l1); p.add(l2); p.add(l3);
        p.add(t1); p.add(t2); p.add(t3);
        
        this.add(p);
        this.add(b1, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        b1.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent e){ 
        Produs p; double cant = 0, pu = 0;
        m = Meniu.getInstanta();
        if (b1 == e.getSource()){
           p = m.cautaProdus(denumire);
           if(!t2.getText().equals("")) cant = Double.parseDouble(t2.getText());
           if(!t3.getText().equals("")) pu = Double.parseDouble(t3.getText());
           m.schimbaDate(p, t1.getText(), cant, pu);
           dispose();
           JOptionPane.showMessageDialog(null, "Datele au fost schimbate cu succes", "Information", JOptionPane.INFORMATION_MESSAGE);
           
        }
    }
}
