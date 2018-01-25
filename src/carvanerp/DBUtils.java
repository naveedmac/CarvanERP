/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carvanerp;


import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author NaveedRaza
 */
public class DBUtils {
  private Connection con;
  private PreparedStatement ps;
  
  private static Connection conn() throws ClassNotFoundException,SQLException
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url="jdbc:odbc:DBCarvanERP";
        return DriverManager.getConnection(url,"sa","sa");
    }
   public ResultSet resultsetfnGetData(String Query) {  
       ResultSet rsData = null;
        // TODO add your handling code here:
     try {
          con=conn();
          ps=con.prepareStatement(Query);
          rsData=ps.executeQuery();
         } 
         catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "This exception");
        } 
         catch (SQLException ex) {
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
           }
        return rsData;
    }
   public int intfngetLastCompanyID(){
           return (intfnGetLastRecord("select TOP 1 CompanyId from Company order by CompanyId desc")+1);
           }
   public boolean bInsertCompany (int iCompanyId, String strCompanyName,int iCompanyType){
    
   return fnSetData("insert into Company values (" +iCompanyId+" , '"+ strCompanyName+"',"+iCompanyType+")");
   }
   
   public int intfnGetLastRecord(String Query) {  
       ResultSet rsData = null;
       int iLastPrimaryKey=0;
        // TODO add your handling code here:
     try {
          con=conn();
          ps=con.prepareStatement(Query);
          rsData=ps.executeQuery();
          rsData.next();
            iLastPrimaryKey=rsData.getInt(1);
            //JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),  "From DBUtils : " +iLastPrimaryKey);
     } 
         catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "This exception");
        } 
         catch (SQLException ex) {
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
           }
        return iLastPrimaryKey;
    }
   /*public ArrayList arrCompanyField(int iCompanyType){
       return arrfnGetData("SELECT CompanyType_CompanyField.CompanyType_ID, CompanyField.CompanyField_ID, CompanyField.CompanyField_Name, CompanyField.CompanyField_DataType, CompanyField.CompanyField_ControlType FROM CompanyType_CompanyField INNER JOIN CompanyField\n" +
"ON CompanyType_CompanyField.CompanyField_ID=CompanyField.CompanyField_ID where CompanyType_CompanyField.CompanyType_ID="+iCompanyType);
//                       select * from vCompanyType_Companyfield where CompanyType_ID=1
   }*/
       public ArrayList arrCompanyField(int iCompanyType) {                                           
        // TODO add your handling code here:
           ArrayList arrResultSet=new ArrayList();
         ResultSet rsData=null;
         try {
            DBUtils dbu=new DBUtils();
            rsData=dbu.resultsetfnGetData("SELECT CompanyType_CompanyField.CompanyType_ID, CompanyField.CompanyField_ID, CompanyField.CompanyField_Name, CompanyField.CompanyField_DataType, CompanyField.CompanyField_ControlType FROM CompanyType_CompanyField INNER JOIN CompanyField\n" +
"ON CompanyType_CompanyField.CompanyField_ID=CompanyField.CompanyField_ID where CompanyType_CompanyField.CompanyType_ID="+iCompanyType); 
//            ResultSetMetaData RSMD=rsData.getMetaData();
        
          while (rsData.next()) {
                ArrayList arrResultSetRow=new ArrayList();
//                System.out.println("Primary KEY :" + rsData.getString(3));
//                System.out.println("Primary KEY :" + rsData.getString(4));
//                System.out.println("Primary KEY :" + rsData.getString(5));
//                for (int i=1;i<=(RSMD.getColumnCount());i++){
//                   vecResultSetRow.addElement(rsData.getObject(i));
                  arrResultSetRow.add(rsData.getInt(1));
                  arrResultSetRow.add(rsData.getInt(2));
                  arrResultSetRow.add(rsData.getString(3));
                  arrResultSetRow.add(rsData.getString(4));
                  arrResultSetRow.add(rsData.getString(5));
                      
//                   System.out.println("Primary KEY :" + vecResultSetRow.get(i-1));
//                   System.out.println("Primary KEY :" + rsData.getObject(i));
//                    }
                  arrResultSet.add(arrResultSetRow);                              
            }
            
        } 
         
         catch (SQLException ex) {
          // JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage());
               JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
          //  JOptionPane.getRootFrame();
        }
        return arrResultSet;
        
    }  
    public Vector fnGetData(String Query) {                                           
        // TODO add your handling code here:
         Vector vecResultSet= new Vector();
         ResultSet rsData=null;
         try {
            DBUtils dbu=new DBUtils();
            rsData=dbu.resultsetfnGetData(Query); 
            ResultSetMetaData RSMD=rsData.getMetaData();
        
          while (rsData.next()) {
                Vector vecResultSetRow=new Vector();
//                System.out.println("Primary KEY :" + rsData.getString(3));
//                System.out.println("Primary KEY :" + rsData.getString(4));
//                System.out.println("Primary KEY :" + rsData.getString(5));
                for (int i=1;i<=(RSMD.getColumnCount());i++){
//                   vecResultSetRow.addElement(rsData.getObject(i));
                  vecResultSetRow.add(rsData.getObject(i));
//                   System.out.println("Primary KEY :" + vecResultSetRow.get(i-1));
//                   System.out.println("Primary KEY :" + rsData.getObject(i));
                    }
                  vecResultSet.addElement(vecResultSetRow);                              
            }
            
        } 
         
         catch (SQLException ex) {
          // JOptionPane.showMessageDialog(rootPane, ex.getLocalizedMessage());
               JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
          //  JOptionPane.getRootFrame();
        }
        return vecResultSet;
        
    }    
   public boolean fnSetData (String Query){
//       ResultSet rsData = null;
       int iNumberofupdatedRows=0;
       try {
       con=conn(); 
       ps=con.prepareStatement(Query);
       iNumberofupdatedRows=ps.executeUpdate();
//       iNumberofupdatedRows=ps.executeQuery();
           
       }
       
         catch (ClassNotFoundException ex) {
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "This exception");
        } 
         catch (SQLException ex) {
           JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
           }
       if (iNumberofupdatedRows>0)return true;
       else
         return false;
   }
//    public static void main(String args[]) 
//   {
//       
//       
//       /*
//        * Testing resultsetfnGetData
//       DBUtils dbu=new DBUtils();
//       ResultSet rstest=null;
//       Vector vecRs= new Vector();
//       vecRs= dbu.fnGetData("Select * from CurrencyRate");*/
//        
//       /*
//        * Testing resultsetfnGetData
//       try {
//       rstest=dbu.resultsetfnGetData("Select * from CurrencyRate"); 
//              while (rstest.next()) {
//                 System.out.println(rstest.getDate(2));
//                 }
//              
//       }
//       catch (SQLException ex) {
//          JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getLocalizedMessage());
//         }*/
//   }
}
