/*
 * Created by JFormDesigner on Mon Oct 07 22:37:07 IST 2019
 */

package com.bca;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Abhishek AN
 */
public class booking {
    public booking() {
        initComponents();
        table_update();
    }

    Connection connect;
    PreparedStatement insert;

    private void table_update() {
        int c;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String userName = "abhi";
            String password = "abhi123";
            String url = "jdbc:MySQL://localhost/trafficoffenders";

            connect = DriverManager.getConnection (url, userName, password);
            insert = connect.prepareStatement("select * from booking");

            ResultSet rs = insert.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();


            DefaultTableModel DFTM = (DefaultTableModel)table1.getModel();
            DFTM.setRowCount(0);

            while (rs.next()) {
                Vector vec = new Vector();
                for (int i=1;i<=c;i++) {
                    vec.add(rs.getString("id"));
                    vec.add(rs.getString("offendername"));
                    vec.add(rs.getString("licensenumber"));
                    vec.add(rs.getString("dob"));
                    vec.add(rs.getString("address"));
                }
                DFTM.addRow(vec);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }



    private void button1ActionPerformed(ActionEvent e) {
        String offendername = textname.getText();
        String licensenumber = textlno.getText();
        String dob = textdob.getText();
        String address = textaddr.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String userName = "abhi";
            String password = "abhi123";
            String url = "jdbc:MySQL://localhost/trafficoffenders";
            connect = DriverManager.getConnection (url, userName, password);

            insert = connect.prepareStatement("insert into booking(offendername,licensenumber,dob,address)values(?,?,?,?)");
            insert.setString(1,offendername);
            insert.setString(2,licensenumber);
            insert.setString(3,dob);
            insert.setString(4,address);
            insert.executeUpdate();

            JOptionPane.showMessageDialog(abcpanel,"Record Added");
            table_update();

            textname.setText("");
            textlno.setText("");
            textdob.setText("");
            textaddr.setText("");
            textname.requestFocus();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void table1MouseClicked(MouseEvent e) {
        DefaultTableModel DFTM = (DefaultTableModel)table1.getModel();
        int selectedIndex = table1.getSelectedRow();

        textname.setText(DFTM.getValueAt(selectedIndex,1).toString());
        textlno.setText(DFTM.getValueAt(selectedIndex,2).toString());
        textdob.setText(DFTM.getValueAt(selectedIndex,3).toString());
        textaddr.setText(DFTM.getValueAt(selectedIndex,4).toString());
    }

    private void button3ActionPerformed(ActionEvent e) {
        DefaultTableModel DFTM = (DefaultTableModel)table1.getModel();
        int selectedIndex = table1.getSelectedRow();

        try {
            int id = Integer.parseInt(DFTM.getValueAt(selectedIndex,0).toString());
            String offendername = textname.getText();
            String licensenumber = textlno.getText();
            String dob = textdob.getText();
            String address = textaddr.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");

            String userName = "abhi";
            String password = "abhi123";
            String url = "jdbc:MySQL://localhost/trafficoffenders";
            connect = DriverManager.getConnection (url, userName, password);

            insert = connect.prepareStatement("update booking set offendername=?,licensenumber=?,dob=?,address=? where id=?");
            insert.setString(1,offendername);
            insert.setString(2,licensenumber);
            insert.setString(3,dob);
            insert.setString(4,address);
            insert.setInt(5,id);


            insert.executeUpdate();

            JOptionPane.showMessageDialog(abcpanel,"Record Updated");
            table_update();

            textname.setText("");
            textlno.setText("");
            textdob.setText("");
            textaddr.setText("");
            textname.requestFocus();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void scrollPane1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        abcpanel = new JPanel();
        bookingtitle = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textname = new JTextField();
        textlno = new JTextField();
        textdob = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        textaddr = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== abcpanel ========
        {
            abcpanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),abcpanel. getBorder()));abcpanel. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".
            equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- bookingtitle ----
            bookingtitle.setText("Offender Booking");
            bookingtitle.setFont(new Font("Times New Roman", Font.BOLD, 20));

            //======== panel1 ========
            {
                panel1.setBorder(new TitledBorder(null, "Book Offender", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Courier New", Font.PLAIN, 14)));

                //---- label1 ----
                label1.setText("Name");

                //---- label2 ----
                label2.setText("License Number");

                //---- label3 ----
                label3.setText("DOB");

                //---- button1 ----
                button1.setText("Add");
                button1.addActionListener(e -> button1ActionPerformed(e));

                //---- button2 ----
                button2.setText("Delete");

                //---- button3 ----
                button3.setText("Edit");
                button3.addActionListener(e -> button3ActionPerformed(e));

                //---- label4 ----
                label4.setText("Address");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label4, GroupLayout.Alignment.LEADING)
                                        .addComponent(label2, GroupLayout.Alignment.LEADING)
                                        .addComponent(label1, GroupLayout.Alignment.LEADING)
                                        .addComponent(label3, GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textdob, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                        .addComponent(textlno, GroupLayout.Alignment.LEADING)
                                        .addComponent(textname, GroupLayout.Alignment.LEADING)
                                        .addComponent(textaddr))
                                    .addGap(0, 38, Short.MAX_VALUE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(button1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                    .addComponent(button2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                    .addComponent(button3)))
                            .addContainerGap(16, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(textlno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(textdob, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(label4))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(textaddr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(button1)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button3)
                                    .addComponent(button2)))
                            .addGap(31, 31, 31))
                );
            }

            //======== scrollPane1 ========
            {
                scrollPane1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        scrollPane1MouseClicked(e);
                    }
                });

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "ID", "Name", "License No.", "DOB", "Address"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, String.class, String.class, String.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                table1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        table1MouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(table1);
            }

            GroupLayout abcpanelLayout = new GroupLayout(abcpanel);
            abcpanel.setLayout(abcpanelLayout);
            abcpanelLayout.setHorizontalGroup(
                abcpanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, abcpanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(abcpanelLayout.createParallelGroup()
                            .addComponent(bookingtitle)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
            abcpanelLayout.setVerticalGroup(
                abcpanelLayout.createParallelGroup()
                    .addGroup(abcpanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(bookingtitle)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(abcpanelLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel abcpanel;
    private JLabel bookingtitle;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textname;
    private JTextField textlno;
    private JTextField textdob;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JTextField textaddr;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("booking");
        frame.setContentPane(new booking().abcpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
