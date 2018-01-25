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
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Used by InternalFrameDemo.java. */
public class frmAddCompanyDetails extends JInternalFrame implements ActionListener{
   private DBUtils dbu=new DBUtils();
   private ArrayList arrSwingControls=new ArrayList();
   private jdbCombo cmbCompanyType=null;
   private JTextField txtCompanyType=null;
   private JTextField txtCompanyName=null;
   private JButton btnCancel=null;
   private JButton btnSave=null;
   private JPanel pnlAddCompanyDetials =null;
    static final int xOffset = 30, yOffset = 30;

    public frmAddCompanyDetails() {super("Add Company Details" , 
              false, //resizable
              false, //closable
              false, //maximizable
              true);//iconifiable

    this.setVisible(false); //necessary as of 1.3
//    try {
//            CarvanERP.frame1.setSelected(true);
//        } 
//        catch (java.beans.PropertyVetoException ex) {}
    }
    public frmAddCompanyDetails(int iCompanyID,String strCompanyType,String strCompanyName) {
        super("Add Company Details" , 
              false, //resizable
              false, //closable
              false, //maximizable
              true);//iconifiable
CarvanERP.openFrameCount=CarvanERP.openFrameCount+1;
this.removeAll();
pnlAddCompanyDetials=new JPanel();
pnlAddCompanyDetials.removeAll();
        //...Create the GUI and put it in the window...
//JPanel pnlAddCompanyDetials = new JPanel();
//setSize(450,400);
pnlAddCompanyDetials.setLayout(new GridLayout(0,2,5,5));
//pnlAddCompanyDetials.setSize(275, 400);
ArrayList arrFormFields=dbu.arrCompanyField(iCompanyID);
setSize(450,40*(arrFormFields.size()+3));
pnlAddCompanyDetials.add(new JLabel("Company Type:"));

txtCompanyType= new JTextField(10);
txtCompanyType.setText(strCompanyType);
txtCompanyType.setEditable(false);
pnlAddCompanyDetials.add(txtCompanyType);

pnlAddCompanyDetials.add(new JLabel("Company Name:"));
txtCompanyName= new JTextField(10);
txtCompanyName.setText(strCompanyName);
txtCompanyName.setEditable(false);
pnlAddCompanyDetials.add(txtCompanyName);

for (int i = 0; i < arrFormFields.size(); i++)
{
    ArrayList arrField=(ArrayList)arrFormFields.get(i);
//    buttons[i] = new JButton();
    pnlAddCompanyDetials.add(new JLabel(arrField.get(2).toString()));
    switch (arrField.get(4).toString()) {
            case "TEXT":  
                JTextField txtTextField= new JTextField(10);
                arrField.add(txtTextField);
                pnlAddCompanyDetials.add(txtTextField);
                     break;
            
            default: 
                     break;
     }
//    (String[]) arr.toArray(new String[arr.size()]);  
//this.repaint();
    System.out.println(arrField.get(2).toString());
}



/*
pnlAddCompanyDetials.add(new JLabel("Select Comapany Type:"));
cmbCompanyType= new jdbCombo("Select CompanyType_Id,CompanyType_Details from CompanyType");
cmbCompanyType.setActionCommand("CompanyType");
cmbCompanyType.addActionListener(this);
pnlAddCompany.add(cmbCompanyType);
pnlAddCompany.add(new JLabel("Company Name:"));
txtCompanyName= new JTextField(10);
pnlAddCompany.add(txtCompanyName);*/
btnSave= new JButton("Add Company Details");
btnSave.setActionCommand("AddCompanyDetails");
btnSave.addActionListener(this);
pnlAddCompanyDetials.add(btnSave);
btnCancel= new JButton("Cancel");
btnCancel.setActionCommand("Cancel");
btnCancel.addActionListener(this);
pnlAddCompanyDetials.add(btnCancel);

pnlAddCompanyDetials.setVisible(true);
add(pnlAddCompanyDetials);

        //...Then set the window size or call pack...
        setSize(450,40*(arrFormFields.size()+3));;
pnlAddCompanyDetials.setSize(450,40*(arrFormFields.size()+3));
        //Set the window's location.
        setLocation(xOffset*CarvanERP.openFrameCount, yOffset*CarvanERP.openFrameCount);
        
    }
    public void AddCompanyDetails(int iCompanyID,String strCompanyType,String strCompanyName) {
        
CarvanERP.openFrameCount=CarvanERP.openFrameCount+1;
        //...Create the GUI and put it in the window...
JPanel pnlAddCompanyDetials = new JPanel();
//setSize(450,400);
pnlAddCompanyDetials.setLayout(new GridLayout(0,2,5,5));
//pnlAddCompanyDetials.setSize(275, 400);

pnlAddCompanyDetials.add(new JLabel("Company Type:"));

txtCompanyType= new JTextField(10);
txtCompanyType.setText(strCompanyType);
txtCompanyType.setEditable(false);
pnlAddCompanyDetials.add(txtCompanyType);

pnlAddCompanyDetials.add(new JLabel("Company Name:"));
txtCompanyName= new JTextField(10);
txtCompanyName.setText(strCompanyName);
txtCompanyName.setEditable(false);
pnlAddCompanyDetials.add(txtCompanyName);
ArrayList arrFormFields=dbu.arrCompanyField(iCompanyID);
setSize(450,40*(arrFormFields.size()+3));
for (int i = 0; i < arrFormFields.size(); i++)
{
    ArrayList arrField=(ArrayList)arrFormFields.get(i);
//    buttons[i] = new JButton();
    pnlAddCompanyDetials.add(new JLabel(arrField.get(2).toString()));
    switch (arrField.get(4).toString()) {
            case "TEXT":  
                JTextField txtTextField= new JTextField(10);
                arrField.add(txtTextField);
                pnlAddCompanyDetials.add(txtTextField);
                     break;
            
            default: 
                     break;
     }
//    (String[]) arr.toArray(new String[arr.size()]);  

    System.out.println(arrField.get(2).toString());
}



/*
pnlAddCompanyDetials.add(new JLabel("Select Comapany Type:"));
cmbCompanyType= new jdbCombo("Select CompanyType_Id,CompanyType_Details from CompanyType");
cmbCompanyType.setActionCommand("CompanyType");
cmbCompanyType.addActionListener(this);
pnlAddCompany.add(cmbCompanyType);
pnlAddCompany.add(new JLabel("Company Name:"));
txtCompanyName= new JTextField(10);
pnlAddCompany.add(txtCompanyName);*/
btnSave= new JButton("Add Company Details");
btnSave.setActionCommand("AddCompanyDetails");
btnSave.addActionListener(this);
pnlAddCompanyDetials.add(btnSave);
btnCancel= new JButton("Cancel");
btnCancel.setActionCommand("Cancel");
btnCancel.addActionListener(this);
pnlAddCompanyDetials.add(btnCancel);
add(pnlAddCompanyDetials);
pnlAddCompanyDetials.setVisible(true);
this.repaint();
        //...Then set the window size or call pack...
        setSize(450,40*(arrFormFields.size()+3));
pnlAddCompanyDetials.setSize(50, 40*(arrFormFields.size()+3));
        //Set the window's location.
        setLocation(xOffset*CarvanERP.openFrameCount, yOffset*CarvanERP.openFrameCount);
        
    }
   public void actionPerformed(ActionEvent e) {
       
//      JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),e.getActionCommand());
      switch (e.getActionCommand()) {
            case "AddCompanyDetails":  
                if(dbu.bInsertCompany (dbu.intfngetLastCompanyID(),txtCompanyName.getText(),cmbCompanyType.selectedPrimaryKey()))
//                dbu.fnSetData("insert into Company values (" +(dbu.intfnGetLastRecord("select TOP 1 CompanyId from Company order by CompanyId desc")+1)+" , '"+txtCompanyName.getText()+"',"+cmbCompanyType.selectedPrimaryKey()+")");
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Company saved succesfully");
                else
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Company not saved.");    
                     break;
            case "Cancel": 
//                pnlAddCompanyDetials.removeAll();
//               this.removeAll();
               this.dispose();
               
                     break;
            default: ;
                     break;
      }
   } 
}
