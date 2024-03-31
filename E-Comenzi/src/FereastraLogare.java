import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FereastraLogare extends JFrame{
    private JLabel l1, l2, l3;
    private JTextField t1, t2;
    private JButton b;
    private ControllerEvenimente ce;
    private JComboBox cb;
    
    public FereastraLogare(){
        super("Fereastra de logare");
        ce = new ControllerEvenimente();
        t1 = new JTextField();
        t2 = new JTextField();
        
        
        l1 = new JLabel("Nume");
        l2 = new JLabel("Prenume");
        l3 = new JLabel("Functie");
        
        b = new JButton("Logare");
        cb = new JComboBox(new String[]{"Toate", "Chelner", "Administrator"});
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 10));
        p.add(l1); p.add(t1);
        p.add(l2); p.add(t2);
        p.add(l3); p.add(cb);
        
        JPanel p1 = new JPanel();
        p1.add(b);
        
        this.add(p);
        this.add(p1, BorderLayout.SOUTH);
        b.addActionListener(ce);
        
        

    }
    
    private class ControllerEvenimente implements ActionListener{
        
        private JFrame f1;
        private ColectieAngajati ca;
        public void actionPerformed(ActionEvent e){
            ca = ColectieAngajati.getInstanta();
            if( e.getSource() == b ){
                String functie = (String)cb.getSelectedItem();
                if(t1.getText().equals("") || t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Completati toate credentialele si alegeti o functie!", "Error", JOptionPane.ERROR_MESSAGE);
                   
                }    
                else if(cb.getSelectedItem().toString().equals("Toate")) JOptionPane.showMessageDialog(null, "Alegeti o functie din lista!", "Error", JOptionPane.ERROR_MESSAGE);
                else if (ca.cautaAngajat(t1.getText(), t2.getText(), (String)cb.getSelectedItem()) != null){
                    if(functie.equals("Administrator")) f1 = new AdminFrame();
                    else if(functie.equals("Chelner")) f1 = new ChelnerFrame(t1.getText(), t2.getText());
                    dispose();
                }  
            
                else if(ca.cautaAngajat(t1.getText(), t2.getText(), (String)cb.getSelectedItem()) == null){
                    JOptionPane.showMessageDialog(null, "Angajatul nu exista in sistem!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    
    
    } 
    
    
    public static void main(String[] args){
        JFrame f = new FereastraLogare();
        f.setSize(400, 170);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
