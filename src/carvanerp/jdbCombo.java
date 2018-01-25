/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carvanerp;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author NaveedRaza
 */
public class jdbCombo   extends JComboBox{
    private List<Integer> primaryKeyList= new ArrayList<Integer>();
    
    public jdbCombo (String Query){
//        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), Query);
        ResultSet rsjdbCombo=null;                       
        DBUtils dbu=new DBUtils();
        try{
            
        rsjdbCombo=dbu.resultsetfnGetData(Query);
         while (rsjdbCombo.next()) {
//             System.out.println(rsjdbCombo.getInt(1));
//             System.out.println(rsjdbCombo.getString(2));
         primaryKeyList.add(rsjdbCombo.getInt(1));
         this.addItem(rsjdbCombo.getString(2));
         
         }        
        }
         
         catch (SQLException ex) {
//           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
           }
    }
    public int selectedPrimaryKey(){
        
        return primaryKeyList.get(this.getSelectedIndex());
    }
//     public static void main(String args[]) 
// {
//     jdbCombo j=new jdbCombo();
//    j
// }
}
