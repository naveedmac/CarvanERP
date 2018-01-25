/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carvanerp;

import static carvanerp.SignInForm.conn;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author NaveedRaza
 */
public class  CarvanERP extends javax.swing.JFrame implements ActionListener {

    
   /* private String language = new String("en");
    private String country = new String("EN");
    private Locale currentLocale = new Locale(language, country);
    private ResourceBundle messages=ResourceBundle.getBundle("carvanerp/MessagesBundle",currentLocale);
//    messages =ResourceBundle.getBundle("carvanerp/MessagesBundle",currentLocale);*/
    private I18nCERP localkey= new I18nCERP(); 
//    public frmAddCompanyDetails frame1= new frmAddCompanyDetails();
    /**
     * Creates new form CarvanERP
     */
    static int openFrameCount = 0;
    public CarvanERP() {
        super(java.util.ResourceBundle.getBundle("carvanerp/MessagesBundle").getString("CARVAN ERP - MAIN WINDOW"));
        initComponents();
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds(inset, inset,screenSize.width  - inset*2,screenSize.height - inset*2);
        Dimension minDimension= new Dimension(screenSize.width  - inset*2,screenSize.height - inset*2);
        setMinimumSize(minDimension);
        setExtendedState(MAXIMIZED_BOTH);
        setJMenuBar(createMenuBar());
        

    }
    
    public static Connection conn() throws ClassNotFoundException,SQLException
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url="jdbc:odbc:DBCarvanERP";
        return DriverManager.getConnection(url,"sa","sa");
    }
    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        //menuBar.add(createMenu("Document",KeyEvent.VK_D));
       Vector vecMenuDefination= MenuDefination();
        for(int j=0;j<vecMenuDefination.size();j++){ 
//         JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), j);
         Vector vecSubMenuDefination=(Vector) vecMenuDefination.get(j);
         menuBar.add(createMenu(vecSubMenuDefination));        
         

        }
//        menuBar.add(createMenu(MenuDefination()));
        return menuBar;
    }

    protected Vector MenuDefination(){
    Vector vecMenuDefination= new Vector();
    Vector vecSubMenuDefination= new Vector();
    
    vecSubMenuDefination.add(0,localkey.strGetLocale("Document"));
    vecSubMenuDefination.add(1,KeyEvent.VK_D);
    vecSubMenuDefination.add(2,localkey.strGetLocale("New"));
    vecSubMenuDefination.add(3,KeyEvent.VK_N);
    vecSubMenuDefination.add(4,localkey.strGetLocale("Add_Company"));
    vecSubMenuDefination.add(5,KeyEvent.VK_A);
    vecSubMenuDefination.add(6,localkey.strGetLocale("Quit"));
    vecSubMenuDefination.add(7,KeyEvent.VK_Q);
    vecSubMenuDefination.add(8,localkey.strGetLocale("Job_Details"));
    vecSubMenuDefination.add(9,KeyEvent.VK_J);
    vecMenuDefination.add(0,vecSubMenuDefination);
    
   /* vecSubMenuDefination= new Vector();
    
    vecSubMenuDefination.add(0,"1 Document");
    vecSubMenuDefination.add(1,KeyEvent.VK_F);
    vecSubMenuDefination.add(2,"2 New");
    vecSubMenuDefination.add(3,KeyEvent.VK_E);
    vecMenuDefination.add(1,vecSubMenuDefination);*/

    return vecMenuDefination;
    
}

protected JMenu createMenu(Vector vecSubMenuDefination ){
        JMenu menu = null ;

    
        menu = new JMenu(vecSubMenuDefination.get(0).toString());
        menu.setMnemonic(((int)vecSubMenuDefination.get(1)));

        for(int i=2;i<vecSubMenuDefination.size();i=i+2  ){ 
        menu.add(createSubMenuBar(vecSubMenuDefination.get(i).toString(),((int)vecSubMenuDefination.get(i+1))));
        }

               
        return menu;
}

    
protected JMenuItem createSubMenuBar(String subMenuName,int iMnemonic) {
        JMenuItem menuItem = new JMenuItem(subMenuName);
        menuItem.setMnemonic(iMnemonic);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                iMnemonic, ActionEvent.ALT_MASK));
        menuItem.setActionCommand(subMenuName);
        menuItem.addActionListener(this);
        return menuItem;
}   
     
public void actionPerformed(ActionEvent e) {
     switch (e.getActionCommand()) {
            case "New":  
                createFrame();
                     break;
            case "Add Company":  
                createFrameAddCompany();
                     break;
            case "Job Details":  
                createFrameJobDetails();
                     break;
            default: quit();
                     break;
     }

        }
protected void createFrameJobDetails(){
    
        frmJobDetails frame= new  frmJobDetails();
               
        frame.setVisible(true); //necessary as of 1.3
        MainWindow.add(frame);
        try {
            frame.setSelected(true);
        } 
        catch (java.beans.PropertyVetoException e) {}
    }

protected void createFrameAddCompany(){
    
        frmAddCompany frame= new frmAddCompany();
        
        frame.setVisible(true); //necessary as of 1.3
        
        MainWindow.add(frame);
//        MainWindow.add(frame1);
        try {
            frame.setSelected(true);
        } 
        catch (java.beans.PropertyVetoException e) {}
    }

 //Create a new internal frame.
    protected void createFrame()  {
        frmViewExchangeRate frame= new frmViewExchangeRate();
//        frmAddCompany frame= new frmAddCompany();
        //frmExchangeRate frame = new frmExchangeRate();
        frame.setVisible(true); //necessary as of 1.3
        MainWindow.add(frame);
        try {
            frame.setSelected(true);
        } 
        catch (java.beans.PropertyVetoException e) {}
    }
 protected void quit() {
        System.exit(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainWindow = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainWindow.setBackground(new java.awt.Color(192, 192, 192));
        MainWindow.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarvanERP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarvanERP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarvanERP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarvanERP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarvanERP().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane MainWindow;
    // End of variables declaration//GEN-END:variables
}
