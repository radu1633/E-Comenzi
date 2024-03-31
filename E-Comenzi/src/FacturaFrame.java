import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.print.*;

public class FacturaFrame extends JFrame implements ActionListener{
    private JButton print;
    private JTextArea area;
    private Factura factura;
    private JPanel p;
    private JScrollPane pa;
    
    
    
    public FacturaFrame(Factura f){
        super("Bon fiscal");
        
        factura = f;
        
        p = new JPanel();
        area=new JTextArea(factura.toString(), 10, 50);
        area.setEditable(false);
        pa = new JScrollPane(area);
        
        
        this.add(pa);
        
        print = new JButton("Print");
        JPanel p1 = new JPanel();
        p1.add(print);
        
        this.add(p1, BorderLayout.SOUTH);
        print.addActionListener(this);
        
        setSize(450,430);
        setVisible(true);
        setResizable(false);
    }
    
    

    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == print){
            PrinterJob imprimanta=PrinterJob.getPrinterJob();
            Book bk=new Book();
            bk.append(new PanouContinut(),imprimanta.defaultPage());
            imprimanta.setPageable(bk);
            if(imprimanta.printDialog()){
                try{
                    imprimanta.print();
                }catch (PrinterException pe){
            area.append("Imprimanta nu exista");
            area.repaint();
        }
        catch(ArrayIndexOutOfBoundsException ae){
        System.out.println("Ce se printeaza???");
        }
        }
        }
    }
    
    class PanouContinut extends JPanel implements Printable{
        private BufferedReader br;
        private String sir="";
        public int print(Graphics g, PageFormat pf,int pageIndex)
        throws PrinterException{
        g.setColor(Color.black);
        try{
            StringReader continut=new StringReader(area.getText());
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
