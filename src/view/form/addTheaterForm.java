/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import model.Admin;
import net.miginfocom.swing.MigLayout;
import service.AdminService;
import view.swing.MyTextField;

/**
 *
 * @author DUC DUNG
 */
public class addTheaterForm extends javax.swing.JPanel {

    private MyTextField addName;
    private MyTextField addLocation;
    private JLabel visibility;
    private JComboBox addVisibility;
    private MyTextField addAvatarPath;
    private MyTextField addImagePath;
    private JButton submit;
    private AdminService adminServices;
    public addTheaterForm() {
        adminServices = new AdminService(new Admin());
        initComponents();
        initAdd();
    }
    private void initAdd(){
        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0, 200), 5); // Màu đen với độ mờ 100
        jPanel1.setBorder(border);
        jPanel1.setPreferredSize(new Dimension(450, 520));
        jPanel1.setLayout(new MigLayout("wrap 1, alignx center, aligny center, gapy 10", "[grow]", "[]35[]"));
        JLabel label = new JLabel("ADD NEW THEATER");
        label.setFont(new Font("sansserif", 1, 26));
        label.setForeground(new Color(58,181,75));
        jPanel1.add(label, "align center");
        
        addName = new MyTextField();
        addName.setHint("Theater's name...");
        jPanel1.add(addName, "w 70%, grow 0, align center");
        
        addLocation = new MyTextField();
        addLocation.setHint("Theater's location...");
        jPanel1.add(addLocation, "w 70%, grow 0, align center");
        
        visibility = new JLabel("Availability");
        visibility.setFont(new Font("sansserif", 0, 14));
        jPanel1.add(visibility, "w 70%, sg, wrap 2, grow 0, align center");
        
        addVisibility = new JComboBox();
        addVisibility.addItem("true");
        addVisibility.addItem("false");
        addVisibility.setFont(new Font("sansserif", 0, 14));
        jPanel1.add(addVisibility, "w 70%, grow 0, align center");
        
        addAvatarPath = new MyTextField();
        addAvatarPath.setHint("Theater's avatar path...");
        jPanel1.add(addAvatarPath, "w 70%, grow 0, align center");
        
        addImagePath = new MyTextField();
        addImagePath.setHint("Theater's image path...");
        jPanel1.add(addImagePath, "w 70%, grow 0, align center");
        
        submit = new JButton();
        submit.setText("Add");
        submit.setForeground(Color.WHITE);
        submit.setBackground(new Color(0,204,51));
        submit.setFont(new Font("sansserif", 1, 18));
        submit.setPreferredSize(new Dimension(150, 40));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức xử lý sự kiện khi nút được nhấp
                if(addName.getText().isEmpty() || addLocation.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name or location can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                }
                else{
                    if(adminServices.addTheaterToDB(addName.getText(), addLocation.getText(), 
                            Boolean.valueOf(addVisibility.getSelectedItem().toString()),
                            addAvatarPath.getText(), addImagePath.getText())){
                        JOptionPane.showMessageDialog(null, "Add theater successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        clearFields();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to add movie!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        jPanel1.add(submit, "span 2, align center");
    }
    private void clearFields() {
        addName.setText("");
        addLocation.setText("");
        addVisibility.setSelectedIndex(0); // Chọn lại giá trị mặc định
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("unchecked")
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
