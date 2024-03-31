import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import javax.swing.text.*;

public class AdminMeniuFrame extends JFrame{
    private JTextPane ta;
    private Meniu m;
    private JButton b1, b2, b3, b4;
    private JLabel l1, l2, l3, l4, l5;
    private JTextField t1, t2, t3, t4;
    private JComboBox cb;
    private ControllerEven ce;
    private JScrollPane ps;
    
    public AdminMeniuFrame(){
        super("Date meniu");
        
        SimpleAttributeSet bSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setItalic(bSet, true);
        StyleConstants.setFontFamily(bSet, "Arial");
        StyleConstants.setFontSize(bSet, 14);
        
        m = Meniu.getInstanta();
        ta = new JTextPane();
        ta.setText(m.getMeniu());
        StyledDocument doc = ta.getStyledDocument();
        doc.setParagraphAttributes(0, 15000, bSet, false);
        ce = new ControllerEven();
        add(new JLabel("Meniu"), BorderLayout.NORTH);
        ta.setEditable(false);
        ta.setBackground(Color.white);
        ps = new JScrollPane(ta);
        this.add(ps);
       
        JPanel p2 = new JPanel();
        Box box = Box.createVerticalBox();

        //new GridLayout(4, 1, 5, 5)
        b1 = new JButton("Adauga produs");
        b1.setMaximumSize(new Dimension(150,30));
        b2 = new JButton("StergeProdus");
        b2.setMaximumSize(new Dimension(150,30));
        b3 = new JButton("Modifica date");
        b3.setMaximumSize(new Dimension(150,30));
        b4 = new JButton("Print");
        b4.setMaximumSize(new Dimension(150,30));
        
        box.add(b1); 
        
        box.add(b2); 
        
        box.add(b3);
        
        box.add(b4);
        
        this.add(box, BorderLayout.EAST);
        
        l1 = new JLabel("Tipul Produsului");
        l2 = new JLabel("Denumire");
        l3 = new JLabel("Cantitate");
        l4 = new JLabel("Pret");
        l5 = new JLabel();
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        cb = new JComboBox(new String[]{"Toate", "Starter", "MainCourse", "Desert", "Racoritoare"});
        
        t3.setEditable(false);
        t3.setBackground(Color.white);
        
        JPanel p3 = new JPanel(new GridLayout(2, 5, 10, 10));
        
        p3.add(l1); p3.add(l2); p3.add(l3); p3.add(l5); p3.add(l4);
        p3.add(cb); p3.add(t1); p3.add(t2); p3.add(t3); p3.add(t4);
        
        
        this.add(p3, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        b1.addActionListener(ce);
        b2.addActionListener(ce);
        b3.addActionListener(ce);
        b4.addActionListener(ce);
        cb.addActionListener(ce);
    }
    
    private class ControllerEven implements ActionListener{
        //Meniu m1 = Meniu.getInstanta();
        JFrame f;
        
        public void actionPerformed(ActionEvent e){
            String unit = (String)cb.getSelectedItem();
            
            if (cb == e.getSource()){
                if(cb.getSelectedItem().equals("Racoritoare")) t3.setText("ml");
                else t3.setText("g");
            }
            
            if (b1 == e.getSource()){
                if(cb.getSelectedItem().toString().equals("Toate")) JOptionPane.showMessageDialog(null, "Alegeti o categorie din lista!", "Error", JOptionPane.ERROR_MESSAGE);
                else if(!t1.getText().equals("")) {
                    m.adaugaProdus(t1.getText(), Double.parseDouble(t2.getText()), t3.getText(), Double.parseDouble(t4.getText()), (String)cb.getSelectedItem());
                    t1.setText(null);
                    t2.setText(null);
                    t4.setText(null);
                    ta.setText(m.getMeniu());
                }
                
                else JOptionPane.showMessageDialog(null, "Nu ati tastat niciun produs", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if (b2 == e.getSource()){
                if(t1.getText().equals("")) JOptionPane.showMessageDialog(null, "Nu ati tastat niciun produs", "Error", JOptionPane.ERROR_MESSAGE);
                else if(m.cautaProdus(t1.getText()) == null){
                    JOptionPane.showMessageDialog(null, "Produsul nu exista in sistem!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!t1.getText().equals("")) {
                    m.stergeProdus(t1.getText());
                    t1.setText(null);
                    t2.setText(null);
                    t4.setText(null);
                    ta.setText(m.getMeniu());
                }
                
            }
            
            if(b3 == e.getSource()){
                if(t1.getText().equals("")) JOptionPane.showMessageDialog(null, "Nu ati tastat niciun produs", "Error", JOptionPane.ERROR_MESSAGE);
                else if(m.cautaProdus(t1.getText()) == null){
                    JOptionPane.showMessageDialog(null, "Produsul nu exista in sistem!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!t1.getText().equals("")) {
                    f = new AdminModificaDateProduseFrame(t1.getText());
                    f.addWindowListener(new WindowAdapter() {
                        public void windowClosed(WindowEvent e) {
                            t1.setText(null);
                            t2.setText(null);
                            t4.setText(null);
                            ta.setText(m.getMeniu());
                        }
                        });
                }
                
                
            }
            
            if(b4 == e.getSource()){
                PrinterJob imprimanta=PrinterJob.getPrinterJob();
                Book bk=new Book();
                bk.append(new PanouContinut(),imprimanta.defaultPage());
                imprimanta.setPageable(bk);
                if(imprimanta.printDialog()){
                try{
                    imprimanta.print();
                }catch (PrinterException pe){
                
                ta.repaint();
            }
            catch(ArrayIndexOutOfBoundsException ae){
            System.out.println("Ce se printeaza???");
            }
            }
            }
        }
        
        public void setText(){
           ta.setText(m.getMeniu());
        }
    }
    
    class PanouContinut extends JPanel implements Printable{
        private BufferedReader br;
        private String sir="";
        public int print(Graphics g, PageFormat pf,int pageIndex)
        throws PrinterException{
            g.setColor(Color.black);
        try{
        StringReader continut=new StringReader(ta.getText());
        br=new BufferedReader(continut);
        int i=0;
        while((sir=br.readLine())!=null) {
            if (sir.length()==0) sir=" ";
            g.drawString(sir,100,100+i);i+= 20;
        }
        }catch(IOException io){}
        catch (IllegalArgumentException ie){}
        return Printable.PAGE_EXISTS;
 }
}
}