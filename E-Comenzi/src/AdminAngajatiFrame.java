import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminAngajatiFrame extends JFrame implements ActionListener{
    private JTextArea ta;
    private ColectieAngajati ca;
    private JButton b1, b2, b3;
    private JTextField t1, t2;
    private JComboBox cb;
    private JLabel l1, l2, l3;
    private JScrollPane pa;
    
    
    public AdminAngajatiFrame(){
        super ("Date angajati");
        
        add(new JLabel("Angajati"), BorderLayout.NORTH);
        JPanel p1 = new JPanel();
        ta = new JTextArea();
        p1.setBackground(Color.white);
        ca = ColectieAngajati.getInstanta();
        ta.setText(ca.getAngajati());
        ta.setEditable(false);
        pa = new JScrollPane(ta);
        this.add(pa);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2 ,10 ,10));
        l1 = new JLabel("Nume");
        l2 = new JLabel("Prenume");
        l3 = new JLabel("Functie");
        
        t1 = new JTextField(15);
        t2 = new JTextField(15);
        cb = new JComboBox(new String[]{"Chelner", "Administrator"});
        
        p2.add(l1); p2.add(t1);
        p2.add(l2); p2.add(t2);
        p2.add(l3); p2.add(cb);
        
        
        
        this.add(p2, BorderLayout.EAST);
        
        JPanel p3 = new JPanel();
        b1 = new JButton("Adauga angajat"); b2 = new JButton("Sterge date"); b3 = new JButton("Modifica date");
        p3.add(b1); p3.add(b2); p3.add(b3);
        
        this.add(p3, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(700, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
    }
    
    
        
    public void actionPerformed(ActionEvent e){
        ca = ColectieAngajati.getInstanta(); 
        JFrame f;
        if(e.getSource() == b1) {
            if(t1.getText().equals("") || t2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Completati toate credentialele si alegeti o functie!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                ca.adaugaAngajat(t1.getText(), t2.getText(), (String)cb.getSelectedItem());
                t1.setText(null);
                t2.setText(null);
                ta.setText(ca.getAngajati());
            }
        }
        if(e.getSource() == b2) {
             if(t1.getText().equals("") || t2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Completati toate credentialele si alegeti o functie!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(ca.cautaAngajat(t1.getText(), t2.getText(), cb.getSelectedItem().toString()) == null){
                JOptionPane.showMessageDialog(null, "Angajatul nu exista in sistem!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                ca.stergeAngajat(t1.getText(), t2.getText(), (String)cb.getSelectedItem());
                t1.setText(null);
                t2.setText(null);
                ta.setText(ca.getAngajati());
            }
        }
        if(e.getSource() == b3) {
            String functie = (String) cb.getSelectedItem();
            if(t1.getText().equals("") || t2.getText().equals("")) JOptionPane.showMessageDialog(null, "Completati toate credentialele si alegeti o functie!", "Error", JOptionPane.ERROR_MESSAGE);
            else if(ca.cautaAngajat(t1.getText(), t2.getText(), functie) == null) JOptionPane.showMessageDialog(null, "Angajatul nu exista in sistem!", "Error", JOptionPane.ERROR_MESSAGE);
            else {
                f = new AdminModificaDateFrame(t1.getText(), t2.getText(), functie);
                f.addWindowListener(new WindowAdapter() {
                        public void windowClosed(WindowEvent e) {
                            t1.setText(null);
                            t2.setText(null);
                            ta.setText(ca.getAngajati());
                        }
                        });
             
            }
        }
    }
    
    
}
