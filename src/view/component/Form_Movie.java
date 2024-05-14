package view.component;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import model.Movie;
import view.customSwing.CustomButtonWithPressEffect;
import view.customSwing.PicturePoster;

public class Form_Movie extends javax.swing.JPanel {
    
    private Movie movie;
    
    public Form_Movie(Movie movie) {
        initComponents();
        setOpaque(false);
        setPreferredSize(new Dimension(225, 377));
        setMaximumSize(new Dimension(225, 377));
        setMinimumSize(new Dimension(225, 377));
        
        this.movie = movie;
        setData();
    }
    
    private void setData(){
        movieNameLabel.setText(movie.getTitle());
        durationLabel.setText(movie.getDuration() + " minutes");
        picturePoster.setImage(new ImageIcon(getClass().getResource(movie.getPosterPath())));
    }

    public CustomButtonWithPressEffect getBookingButton() {
        return bookingButton;
    }

    public void setBookingButton(CustomButtonWithPressEffect bookingButton) {
        this.bookingButton = bookingButton;
    }

    public PicturePoster getPicturePoster() {
        return picturePoster;
    }

    public void setPicturePoster(PicturePoster picturePoster) {
        this.picturePoster = picturePoster;
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picturePoster = new view.customSwing.PicturePoster();
        bookingButton = new view.customSwing.CustomButtonWithPressEffect();
        movieNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();

        picturePoster.setImage(new javax.swing.ImageIcon(getClass().getResource("/view/icon/2.png"))); // NOI18N

        bookingButton.setText("Booking");
        bookingButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bookingButton.setPaintedColor(new java.awt.Color(0, 255, 0));
        bookingButton.setSizeSpeed(10.0F);

        movieNameLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        movieNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        movieNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movieNameLabel.setText("Movie Name");
        movieNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/clock.png"))); // NOI18N

        durationLabel.setForeground(new java.awt.Color(255, 255, 255));
        durationLabel.setText("Duration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bookingButton, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(durationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(movieNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(picturePoster, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(picturePoster, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movieNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(durationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.customSwing.CustomButtonWithPressEffect bookingButton;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel movieNameLabel;
    private view.customSwing.PicturePoster picturePoster;
    // End of variables declaration//GEN-END:variables
}
