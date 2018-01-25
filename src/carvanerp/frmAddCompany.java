/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package carvanerp;

import javax.swing.JInternalFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Used by InternalFrameDemo.java. */
public class frmAddCompany extends JInternalFrame implements ActionListener{
   private DBUtils dbu=new DBUtils();
   private jdbCombo cmbCompanyType=null;
   private JTextField txtCompanyName=null;
   private JButton btnCancel=null;
   private JButton btnSave=null;
   public frmAddCompanyDetails frame1= new frmAddCompanyDetails();
    static final int xOffset = 30, yOffset = 30;

    public frmAddCompany() {
        super("Add Company" , 
              true, //resizable
              true, //closable
              false, //maximizable
              true);//iconifiable
CarvanERP.openFrameCount=CarvanERP.openFrameCount+1;
        //...Create the GUI and put it in the window...
JPanel pnlAddCompany = new JPanel();
setSize(450,130);
pnlAddCompany.setLayout(new GridLayout(0,2,5,5));
pnlAddCompany.setSize(275, 190);

pnlAddCompany.add(new JLabel("Select Comapany Type:"));

// Vector vecCompanyType= dbu.fnGetData("Select CompanyType_Details from CompanyType");
cmbCompanyType= new jdbCombo("Select CompanyType_Id,CompanyType_Details from CompanyType");
cmbCompanyType.setActionCommand("CompanyType");
cmbCompanyType.addActionListener(this);
/*Working Action Listner for combao
 * cmbCompanyType.addActionListener( new ActionListener(){
    @Override                
    public void actionPerformed(ActionEvent e){
{
      jdbCombo combo = (jdbCombo)e.getSource();
     JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),  combo.selectedPrimaryKey());
     
       } }});*/

/*Object[] s=vecCompanyType.toArray();
        for (int i = 0; i < 4; i++) {
           cmbCompanyType.addItem(s[i]);
        }*/
//for (   Object element : vecCompanyType)
//{
//    System.out.println(element);
//    cmbCompanyType.addItem(vecCompanyType.toString());
//}

pnlAddCompany.add(cmbCompanyType);
//pnlExchangeRate.add(Box.createVerticalGlue());

pnlAddCompany.add(new JLabel("Company Name:"));
txtCompanyName= new JTextField(10);
pnlAddCompany.add(txtCompanyName);
//pnlExchangeRate.add(Box.createVerticalGlue());

        btnSave= new JButton("Add Company");
        btnSave.setActionCommand("AddCompany");
        btnSave.addActionListener(this);
        
        pnlAddCompany.add(btnSave);
        
        btnCancel= new JButton("Cancel");
        
        btnCancel.setActionCommand("Cancel");
        btnCancel.addActionListener(this);
        
        pnlAddCompany.add(btnCancel);
       
        
add(pnlAddCompany);

        //...Then set the window size or call pack...
        

        //Set the window's location.
        setLocation(xOffset*CarvanERP.openFrameCount, yOffset*CarvanERP.openFrameCount);
    }
   public void actionPerformed(ActionEvent e) {
       
//      JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),e.getActionCommand());
      switch (e.getActionCommand()) {
            case "AddCompany":  
    frame1.AddCompanyDetails(cmbCompanyType.selectedPrimaryKey(),cmbCompanyType.getSelectedItem().toString(),txtCompanyName.getText());
    CarvanERP.MainWindow.add(frame1);
    frame1.setVisible(true); //necessary as of 1.3

    try {
           frame1.setSelected(true);
           
        } 
        catch (java.beans.PropertyVetoException ex) {}
                this.dispose();
                break;
            case "Cancel":  
               
                     break;
            default: ;
                     break;
      }
   } 
}
