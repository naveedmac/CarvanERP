/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carvanerp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author NaveedRaza
 */
public class frmViewExchangeRate extends JInternalFrame {

    static final int xOffset = 40, yOffset = 40;
    public frmViewExchangeRate() {
        super("View Exchange Rate" , 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable
        
CarvanERP.openFrameCount=CarvanERP.openFrameCount+1;
JPanel pnlViewExchangeRate = new JPanel();
Vector ViewExchangeRateColumn= new Vector();
        ViewExchangeRateColumn.add("Currency");
        ViewExchangeRateColumn.add("Date");
        ViewExchangeRateColumn.add("Import");
        ViewExchangeRateColumn.add("Export");
DBUtils dbu=new DBUtils();
Vector vecExchangeRate= dbu.fnGetData("Select * from CurrencyRate");

JTable tblViewExchangeRate = new JTable(vecExchangeRate, ViewExchangeRateColumn);

tblViewExchangeRate.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e)
    {
    if (e.getClickCount() == 2) {
      JTable target = (JTable)e.getSource();
      int row = target.getSelectedRow();
      int column = target.getSelectedColumn();
JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), row); 
}
    }
});
JScrollPane scrlpaneViewExchangeRate = new JScrollPane(tblViewExchangeRate);
tblViewExchangeRate.setFillsViewportHeight(true);
pnlViewExchangeRate.add(scrlpaneViewExchangeRate);
add(pnlViewExchangeRate);
setSize(300,100);


        //Set the window's location.
        setLocation(xOffset*CarvanERP.openFrameCount, yOffset*CarvanERP.openFrameCount);


    }

}
