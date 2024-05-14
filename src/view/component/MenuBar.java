package view.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuBar extends javax.swing.JPanel {

    public MenuBar() {
        initComponents();
        setOpaque(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphs) {
        Graphics2D g2 = (Graphics2D) grphs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint g = new GradientPaint(0, 0, Color.decode("#414345"), 0, getHeight(), Color.decode("#232526"));
//        g2.setPaint(g);
        g2.setColor(new Color(40,40,40));
        g2.fillRoundRect(0, 0, getWidth(),getHeight(),15, 15);
        g2.fillRect(0,-10 , getWidth(), getHeight());
        super.paintChildren(grphs); 
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
