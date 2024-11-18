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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import model.Admin;
import model.Movie;
import net.miginfocom.swing.MigLayout;
import service.AdminService;
import service.UserService;
import view.swing.MyTextField;

/**
 *
 * @author DUC DUNG
 */
public class addMovieForm extends javax.swing.JPanel {
    private MyTextField addId;
    private MyTextField addTitle;
    private MyTextField addDescription;
    private MyTextField addDirector;
    private MyTextField addGenre;
    private MyTextField addDuration;
    private MyTextField addPrice;
    private MyTextField addPosterPath;
    private MyTextField addCoverPath;
    private JComboBox addVisibility;
    private JComboBox addAvailability;
    private JLabel visibility;
    private JLabel availability;
    private JButton submit;
    private AdminService adminServices;
    private Movie newMovie;
    
    public addMovieForm() {
        adminServices = new AdminService(new Admin());
        initComponents();
        initAdd();
    }
    private void initAdd(){
        this.setLayout(new MigLayout("wrap 1, alignx center, aligny center, gapy 10", "[]40[]", "[]25[]"));
        
        JLabel label = new JLabel("ADD NEW MOVIE");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(58,181,75));
        //jPanel1.add(label, "span 2, align center");
        this.add(label, "span 2, align center");
        
        jPanel1.setLayout(new MigLayout("wrap 2, alignx center, aligny center, gapy 10", "[]40[]", "[]25[]"));
        jPanel1.setPreferredSize(new Dimension(700, 450));
        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0, 200), 5); // Màu đen với độ mờ 200
        jPanel1.setBorder(border);
        this.add(jPanel1);
        
        
//        addId = new MyTextField();
//        addId.setHint("Movie's ID...");
//        this.add(addId, "w 30%");  
        
        addTitle = new MyTextField();
        addTitle.setHint("Movie's title...");
        jPanel1.add(addTitle, "w 40%");
        
        addDescription = new MyTextField();
        addDescription.setHint("Movie's description...");
        jPanel1.add(addDescription, "w 40%");
        //this.add(addDescription, "w 64%, span 2, align center");// long
        
        addDirector = new MyTextField();
        addDirector.setHint("Director's name...");
        jPanel1.add(addDirector, "w 40%");
        
        addGenre = new MyTextField();
        addGenre.setHint("Genre...");
        jPanel1.add(addGenre, "w 40%");
        
        
        
        addDuration = new MyTextField();
        addDuration.setHint("Duration...");
        jPanel1.add(addDuration, "w 40%");
        
        addPrice = new MyTextField();
        addPrice.setHint("Price...");
        jPanel1.add(addPrice, "w 40%");
        
        addPosterPath = new MyTextField();
        addPosterPath.setHint("Poster path...");
        jPanel1.add(addPosterPath, "w 40%");
        
        addCoverPath = new MyTextField();
        addCoverPath.setHint("Cover path...");
        jPanel1.add(addCoverPath, "w 40%");
        
        visibility = new JLabel("Visibility");
        visibility.setFont(new Font("sansserif", 0, 14));
        jPanel1.add(visibility, "w 40%, sg");
                
        availability = new JLabel("Availability");
        availability.setFont(new Font("sansserif", 0, 14));
        jPanel1.add(availability, "w 40%, sg, wrap 2");
        
        addVisibility = new JComboBox();
        addVisibility.addItem("true");
        addVisibility.addItem("false");
        addVisibility.setFont(new Font("sansserif", 0, 14));
        jPanel1.add(addVisibility, "w 40%");
        
        addAvailability = new JComboBox();
        addAvailability.addItem("true");
        addAvailability.addItem("false"); 
        addAvailability.setFont(new Font("sansserif", 0, 14));
        jPanel1.add(addAvailability, "w 40%");
        
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
                onSubmitClicked();
            }
        });
        jPanel1.add(submit, "span 2, align center");
        
        
    }
    public void onSubmitClicked() {
        if(addTitle.getText().isEmpty() || addPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Title or price can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
        else if(isNotDouble(addPrice.getText())){
            JOptionPane.showMessageDialog(this, "Price must be a double", "Error", JOptionPane.ERROR_MESSAGE);
            clearFields();
        }
        else {
            newMovie = new Movie(0, addTitle.getText(),
                                addDescription.getText(), addDirector.getText(),
                                addGenre.getText(), addDuration.getText(),
                                Double.valueOf(addPrice.getText()),
                                addPosterPath.getText(), addCoverPath.getText(),
                                Boolean.valueOf(addVisibility.getSelectedItem().toString()),
                                Boolean.valueOf(addAvailability.getSelectedItem().toString()));
            if(adminServices.addMovieToDB(newMovie)){
                JOptionPane.showMessageDialog(this, "Add movie successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                System.out.println("Submit button clicked, add success!");
            }else {
                JOptionPane.showMessageDialog(this, "Failed to add movie!", "Error", JOptionPane.ERROR_MESSAGE);
            };
        }
    }
    private static boolean isNotDouble(String text) {
        try {
            Double.parseDouble(text);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
    private void clearFields() {
        addTitle.setText("");
        addDescription.setText("");
        addDirector.setText("");
        addGenre.setText("");
        addDuration.setText("");
        addPrice.setText("");
        addPosterPath.setText("");
        addCoverPath.setText("");
        addVisibility.setSelectedIndex(0); // Chọn lại giá trị mặc định
        addAvailability.setSelectedIndex(0); // Chọn lại giá trị mặc định
    }

    public MyTextField getAddId() {
        return addId;
    }

    public void setAddId(MyTextField addId) {
        this.addId = addId;
    }

    public MyTextField getAddTitle() {
        return addTitle;
    }

    public void setAddTitle(MyTextField addTitle) {
        this.addTitle = addTitle;
    }

    public MyTextField getAddDescription() {
        return addDescription;
    }

    public void setAddDescription(MyTextField addDescription) {
        this.addDescription = addDescription;
    }

    public MyTextField getAddDirector() {
        return addDirector;
    }

    public void setAddDirector(MyTextField addDirector) {
        this.addDirector = addDirector;
    }

    public MyTextField getAddGenre() {
        return addGenre;
    }

    public void setAddGenre(MyTextField addGenre) {
        this.addGenre = addGenre;
    }

    public MyTextField getAddDuration() {
        return addDuration;
    }

    public void setAddDuration(MyTextField addDuration) {
        this.addDuration = addDuration;
    }

    public MyTextField getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(MyTextField addPrice) {
        this.addPrice = addPrice;
    }

    public MyTextField getAddPosterPath() {
        return addPosterPath;
    }

    public void setAddPosterPath(MyTextField addPosterPath) {
        this.addPosterPath = addPosterPath;
    }

    public MyTextField getAddCoverPath() {
        return addCoverPath;
    }

    public void setAddCoverPath(MyTextField addCoverPath) {
        this.addCoverPath = addCoverPath;
    }

    public JComboBox getAddVisibility() {
        return addVisibility;
    }

    public void setAddVisibility(JComboBox addVisibility) {
        this.addVisibility = addVisibility;
    }

    public JComboBox getAddAvailability() {
        return addAvailability;
    }

    public void setAddAvailability(JComboBox addAvailability) {
        this.addAvailability = addAvailability;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public UserService getUserServices() {
        return adminServices;
    }

    public void setUserServices(AdminService adminServices) {
        this.adminServices = adminServices;
    }

    public Movie getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(Movie newMovie) {
        this.newMovie = newMovie;
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
