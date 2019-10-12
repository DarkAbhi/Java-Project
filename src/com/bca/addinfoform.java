/*
 * Created by JFormDesigner on Sat Oct 12 23:30:41 IST 2019
 */

package com.bca;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class addinfoform {
    public addinfoform() {
        initComponents();
    }

    JFrame frame = new JFrame("Additional Information");

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        addinfopanel = new JPanel();

        //======== addinfopanel ========
        {
            addinfopanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
            .BOLD,12),java.awt.Color.red),addinfopanel. getBorder()));addinfopanel. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r"
            .equals(e.getPropertyName()))throw new RuntimeException();}});

            GroupLayout addinfopanelLayout = new GroupLayout(addinfopanel);
            addinfopanel.setLayout(addinfopanelLayout);
            addinfopanelLayout.setHorizontalGroup(
                addinfopanelLayout.createParallelGroup()
                    .addGap(0, 845, Short.MAX_VALUE)
            );
            addinfopanelLayout.setVerticalGroup(
                addinfopanelLayout.createParallelGroup()
                    .addGap(0, 575, Short.MAX_VALUE)
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel addinfopanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void createForm2() {
        frame.setContentPane(new addinfoform().addinfopanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
