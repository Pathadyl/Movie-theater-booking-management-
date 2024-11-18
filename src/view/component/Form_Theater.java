
package view.component;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import model.Theater;

public class Form_Theater extends javax.swing.JPanel {
    
    private Theater theater;
    
    public Form_Theater(Theater theater) {
        initComponents();
        this.theater = theater;
        
        setOpaque(false);
        setPreferredSize(new Dimension(1220, 150));
        setMaximumSize(new Dimension(1220, 150));
        setMinimumSize(new Dimension(1220, 150));
        
        setData();
    }
    
    private void setData(){
        pictureAvatar.setImage(new ImageIcon(getClass().getResource(theater.getAvatar_path())));
        testButton.setText(theater.getName() + "\n" + theater.getLocation());
        testButton.setIcon(new ImageIcon(getClass().getResource("/view/icon/location.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureAvatar = new view.customSwing.PictureAvatar();
        testButton = new view.customSwing.TestButton();

        pictureAvatar.setImage(new javax.swing.ImageIcon(getClass().getResource("/view/icon/ava1.png"))); // NOI18N

        testButton.setPaintedColor(new java.awt.Color(0, 0, 0));
        testButton.setRightIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/arrow.png"))); // NOI18N
        testButton.setSizeSpeed(10.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pictureAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(testButton, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureAvatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(testButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.customSwing.PictureAvatar pictureAvatar;
    private view.customSwing.TestButton testButton;
    // End of variables declaration//GEN-END:variables
}
