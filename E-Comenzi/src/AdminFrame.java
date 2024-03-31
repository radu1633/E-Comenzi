import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminFrame extends JFrame implements ActionListener{
    private JButton b1, b2;
   
     
    public AdminFrame(){
        b1 = new JButton("Vizualizeaza meniu");
        b1.addActionListener(this);
        b2 = new JButton("Vizualizeaza angajati");
        b2.addActionListener(this);
        
        JPanel p = new JPanel();
        p.add(b1);
        p.add(b2);
        
        this.add(p);
        this.setVisible(true);
        this.setSize(350, 80);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            ColectieAngajati.getInstanta().salveazaLista();
            Meniu.getInstanta().salveazaMeniu();
            System.exit(0);}
        });	
    }
    
    public void actionPerformed(ActionEvent e){
        AdminMeniuFrame f1; AdminAngajatiFrame f2;
        if(e.getSource() == b1) f1 = new AdminMeniuFrame();
        if(e.getSource() == b2) f2 = new AdminAngajatiFrame();
    }
}
