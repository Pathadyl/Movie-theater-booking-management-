/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.Admin;
import model.Theater;
import net.miginfocom.swing.MigLayout;
import service.AdminService;

/**
 *
 * @author DUC DUNG
 */
public class showTheaterForm extends javax.swing.JPanel {

    private AdminService adminServices;
    public showTheaterForm() {
        initComponents();
        initData();
    }

    private void initData(){
        jPanel1.removeAll();
        jPanel1.revalidate(); // Đảm bảo bố cục được cập nhật lại
        jPanel1.repaint();
        adminServices = new AdminService(new Admin());
        List<Theater> LTheater = adminServices.getAllTheater();
        jPanel1.setLayout(new MigLayout("wrap 4, alignx center, aligny center, gapy 10", "[]40[]", "[]25[]"));
        
        JLabel label = new JLabel("THEATER SYSTEM");
        label.setFont(new Font("sansserif", 1, 26));
        //label.setForeground(new Color(58,181,75));
        label.setForeground(Color.white);
        //jPanel1.add(label, "span 2, align center");
        jPanel1.add(label, "span 4, align center, gaptop 20");
        
        for(Theater t:LTheater){
            Border border = BorderFactory.createLineBorder(new Color(0,205,0), 5); // Màu đen với độ mờ 200
            JPanel panel = new JPanel();
            panel.setLayout(new MigLayout("wrap 2, alignx center, aligny center, gapy 10", "[]0[]", "[]10[]"));
            panel.setPreferredSize(new Dimension(180, 360));
            panel.setBackground(new Color(0, 0, 0));
            
            JLabel theaterImage = new JLabel("Image");
            theaterImage.setPreferredSize(new Dimension(160, 220)); // cắt ảnh 160 200 ở DB
            theaterImage.setForeground(Color.WHITE);
            theaterImage.setBackground(new Color(58,181,75));
            theaterImage.setBorder(border);
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
            
            JLabel theaterName = new JLabel(t.getName());
            theaterName.setFont(new Font("sansserif", 1, 14));
            theaterName.setBackground(Color.BLACK);
            theaterName.setForeground(Color.WHITE);
            if(Boolean.valueOf(t.isVisibility())){
                theaterName.setIcon(new ImageIcon(getClass().getResource("/view/icon/true.png")));
            }
            else{
                theaterName.setIcon(new ImageIcon(getClass().getResource("/view/icon/false.png")));
            }
            JTextArea theaterLocation = new JTextArea();
            theaterLocation.setText(t.getLocation());
            theaterLocation.setFont(new Font("sansserif", 0, 12));
            theaterLocation.setLineWrap(true); // This makes the text area wrap lines if they are too long
            theaterLocation.setWrapStyleWord(true); // This makes the text area wrap lines at word boundaries
            theaterLocation.setEditable(false);
            theaterLocation.setBackground(new Color(0,0,0));
            theaterLocation.setForeground(new Color(204,204,204));
            
            
            JScrollPane scrollPane = new JScrollPane(theaterLocation);
            scrollPane.setPreferredSize(new Dimension(160, 70));
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            
            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(new Color(0,205,0));
            deleteButton.setForeground(Color.WHITE);
            deleteButton.setFont(new Font("sansserif", 1, 14));
            
            JButton updateButton = new JButton("Update");
            updateButton.setBackground(new Color(0,205,0));
            updateButton.setForeground(Color.WHITE);
            updateButton.setFont(new Font("sansserif", 1, 14));
            
            deleteButton.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    if(e.getClickCount()==2){
                        System.out.println("id cua theate nay la: "+t.getId());
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this movie?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            if (adminServices.deleteTheater(t.getId())) {
                                JOptionPane.showMessageDialog(null, "Delete theater successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                initData();
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete theater!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            });
            
            updateButton.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    if(e.getClickCount()==2){
                        updateTheater ut = new updateTheater(t.getId());
                        ut.setDefaultCloseOperation(movieDetail.DISPOSE_ON_CLOSE);
                        ut.setVisible(true);
                        ut.setLocationRelativeTo(null);
                    }
                }
            });
            
            panel.add(theaterImage, "w 100%, span 2, align center");
            panel.add(theaterName, "w 100%,span 2, align center");
            panel.add(scrollPane, "w 100%, span 2, align center");
            panel.add(deleteButton, "w 30%");
            panel.add(updateButton, "w 30%");
            
            jPanel1.add(panel);
        }
    }
    private void resetData(){
        initData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 102));

        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 828, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
