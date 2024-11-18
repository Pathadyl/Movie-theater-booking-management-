/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import model.Admin;
import model.Theater;
import net.miginfocom.swing.MigLayout;
import service.AdminService;

/**
 *
 * @author DUC DUNG
 */
public class updateTheater extends javax.swing.JFrame {

    private AdminService adminServices;
    
    public updateTheater() {
        initComponents();
    }
    public updateTheater(int id) {
        initComponents();
        initData(id);
    }

    private void initData(int id){
        adminServices = new AdminService(new Admin());
        Theater t = adminServices.getTheaterByID(id);
        
        Border border = BorderFactory.createLineBorder(new Color(204,204,204), 1); // Màu đen với độ mờ 200
        
        //jPanel1.setLayout(new MigLayout("wrap 2, alignx center, aligny center, gapy 10", "[]20[]", "[]10[]"));
        //jPanel1.setPreferredSize(new Dimension(400, 600));
        jPanel1.setBorder(border);
        
        //JLabel label = new JLabel("UPDATE THEATER");
        label.setFont(new Font("sansserif", 1, 18));
        label.setForeground(Color.white);
        //jPanel1.add(label, "span 2, align center");
        
        
        
        //JLabel theaterImage = new JLabel("Image");
        theaterImage.setPreferredSize(new Dimension(200, 250)); // cắt ảnh 160 200 ở DB
        theaterImage.setForeground(Color.WHITE);
        try{
            if(getClass().getResource(t.getImage_path())!=null){
               theaterImage.setIcon(new ImageIcon(getClass().getResource(t.getImage_path())));
               theaterImage.setText("");
            } 
            else{
               theaterImage.setIcon(null); // Xóa icon nếu có
               theaterImage.setText("Can not find image!");
            }
        }
        catch (Exception e){
            theaterImage.setIcon(null); // Xóa icon nếu có
            theaterImage.setText("Can not find image!");
        }
        
        //JTextField theaterName = new JTextField(t.getName());
        theaterName.setFont(new Font("sansserif", 1, 14));
        theaterName.setBackground(Color.BLACK);
        theaterName.setForeground(Color.WHITE);
        theaterName.setText(t.getName());
        
        //JTextArea theaterLocation = new JTextArea();
        theaterLocation.setText(t.getLocation());
        theaterLocation.setFont(new Font("sansserif", 0, 12));
        theaterLocation.setLineWrap(true); // This makes the text area wrap lines if they are too long
        theaterLocation.setWrapStyleWord(true);
        theaterLocation.setBackground(new Color(0,0,0));
        theaterLocation.setForeground(new Color(204,204,204));
        theaterLocation.setBorder(border);
        
        //JScrollPane scrollPane = new JScrollPane(theaterLocation);
        //scrollPane.setPreferredSize(new Dimension(180, 70));
        //scrollPane.setBorder(BorderFactory.createEmptyBorder());
        
        //JComboBox visibility = new JComboBox();
        visibility.setFont(new Font("sansserif", 0, 14));
        if(t.isVisibility()){
            visibility.setSelectedIndex(0);
        }
        else{
            visibility.setSelectedIndex(1);
        }
        
        //JTextField theaterImagePath = new JTextField(t.getImage_path());
        theaterImagePath.setFont(new Font("sansserif", 0, 14));
        theaterImagePath.setBackground(Color.BLACK);
        theaterImagePath.setForeground(Color.WHITE);
        theaterImagePath.setText(t.getImage_path());
        
        theaterAvatarPath.setFont(new Font("sansserif", 0, 14));
        theaterAvatarPath.setBackground(Color.BLACK);
        theaterAvatarPath.setForeground(Color.WHITE);
        theaterAvatarPath.setText(t.getAvatar_path());
        
        //JButton exitButton = new JButton("Delete");
        exitButton.setBackground(new Color(0,205,0));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("sansserif", 1, 14));

        //JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(0,205,0));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("sansserif", 1, 14));
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure all the fields are correct?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    if(theaterName.getText().isEmpty() || theaterLocation.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name or location can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        if(adminServices.updateTheater(id, theaterName.getText(),
                                theaterLocation.getText(),
                                Boolean.valueOf(visibility.getSelectedItem().toString()),
                                theaterAvatarPath.getText(),
                                theaterImagePath.getText())){
                            JOptionPane.showMessageDialog(null, "Update theater successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Failed to update movie!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        theaterImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        theaterLocation = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        visibility = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        theaterImagePath = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        theaterName = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        ava = new javax.swing.JLabel();
        theaterAvatarPath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        theaterImage.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");

        theaterLocation.setColumns(20);
        theaterLocation.setRows(5);
        jScrollPane1.setViewportView(theaterLocation);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Visibility");

        visibility.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "fasle", " " }));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Image path");

        theaterImagePath.setText("jTextField1");

        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("UPDATE THEATER");

        theaterName.setText("jTextField2");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        ava.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ava.setForeground(new java.awt.Color(255, 255, 255));
        ava.setText("Avatar path");

        theaterAvatarPath.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visibility, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(theaterImagePath)
                    .addComponent(theaterName)
                    .addComponent(theaterAvatarPath))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(theaterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(theaterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(theaterName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibility, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ava, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theaterAvatarPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theaterImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(updateTheater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateTheater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateTheater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateTheater.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateTheater().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ava;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JTextField theaterAvatarPath;
    private javax.swing.JLabel theaterImage;
    private javax.swing.JTextField theaterImagePath;
    private javax.swing.JTextArea theaterLocation;
    private javax.swing.JTextField theaterName;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox<String> visibility;
    // End of variables declaration//GEN-END:variables
}
