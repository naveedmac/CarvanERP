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

import java.awt.event.*;
import java.awt.*;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* Used by InternalFrameDemo.java. */
public class frmExchangeRate extends JInternalFrame {
   
    static final int xOffset = 30, yOffset = 30;

    public frmExchangeRate() {
        super("Add Exchange Rate" , 
              false, //resizable
              true, //closable
              false, //maximizable
              true);//iconifiable
CarvanERP.openFrameCount=CarvanERP.openFrameCount+1;
        //...Create the GUI and put it in the window...
JPanel pnlExchangeRate = new JPanel();
pnlExchangeRate.setLayout(new GridLayout(0,2,5,5));

pnlExchangeRate.add(new JLabel("Currency Name:"));
JComboBox cmbCurrencyName= new JComboBox();
pnlExchangeRate.add(cmbCurrencyName);
//pnlExchangeRate.add(Box.createVerticalGlue());

pnlExchangeRate.add(new JLabel("Date:"));
JTextField cmbCurrencyDate= new JTextField(10);
pnlExchangeRate.add(cmbCurrencyDate);
//pnlExchangeRate.add(Box.createVerticalGlue());

pnlExchangeRate.add(new JLabel("Import :"));
JTextField cmbCurrencyRateImport= new JTextField(10);
pnlExchangeRate.add(cmbCurrencyRateImport);
//pnlExchangeRate.add(Box.createVerticalGlue());

pnlExchangeRate.add(new JLabel("Export :"));

JTextField cmbCurrencyRateExport= new JTextField(10);
pnlExchangeRate.add(cmbCurrencyRateExport);
//pnlExchangeRate.add(Box.createVerticalGlue());

        JButton btnSave= new JButton("Save");
        
        pnlExchangeRate.add(btnSave);
        JButton btnCancel= new JButton("Cancel");
        pnlExchangeRate.add(btnCancel);
       
        pnlExchangeRate.setSize(275, 190);
add(pnlExchangeRate);

        //...Then set the window size or call pack...
        setSize(300,200);

        //Set the window's location.
        setLocation(xOffset*CarvanERP.openFrameCount, yOffset*CarvanERP.openFrameCount);
    }
}
