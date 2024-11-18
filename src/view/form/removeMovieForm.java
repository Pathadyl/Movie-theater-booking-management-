/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.form;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Admin;
import model.Movie;
import service.AdminService;
import view.swing.BooleanCellRenderer;


public class removeMovieForm extends javax.swing.JPanel {

    private AdminService Service;
    public removeMovieForm() {
        initComponents();
        initData();
        
    }

    public void initData(){
        DefaultTableModel model = (DefaultTableModel) movieTable1.getModel();
        Service = new AdminService(new Admin());
        List<Movie> LMovie = Service.getAllMovie();
        for(Movie m:LMovie){
            Object[] rowData = {m.getId(), m.getTitle(), m.getDirector(), m.getGenre(), m.getDuration(), m.getPrice(), m.isVisibility(), m.isAvailability()};
            model.addRow(rowData);
            movieTable1.getColumnModel().getColumn(6).setCellRenderer(new BooleanCellRenderer());
            movieTable1.getColumnModel().getColumn(7).setCellRenderer(new BooleanCellRenderer());
        }
        
        movieTable1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                    int index = movieTable1.getSelectedRow();
                    int id = (int)movieTable1.getValueAt(index, 0);
                    System.out.println("id");
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this movie?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        if (Service.deleteMovieFromDB(id)) {
                            ((DefaultTableModel) movieTable1.getModel()).removeRow(index);
                            JOptionPane.showMessageDialog(null, "Delete movie successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to delete movie!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        movieTable1 = new view.swing.MovieTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        movieTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Title ", "Director", "Genre", "Duration", "Price", "Visibility", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(movieTable1);
        if (movieTable1.getColumnModel().getColumnCount() > 0) {
            movieTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            movieTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            movieTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            movieTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            movieTable1.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Movie To Remove");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.swing.MovieTable movieTable1;
    // End of variables declaration//GEN-END:variables
}
