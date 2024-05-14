package view.customSwing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CustomHeader extends javax.swing.JPanel {
    
    private Color colorPaint;
    
    public CustomHeader() {
        initComponents();
        setOpaque(false);
    }

    public Color getColorPaint() {
        return colorPaint;
    }

    public void setColorPaint(Color colorPaint) {
        this.colorPaint = colorPaint;
    }

    
    @Override
    protected void paintChildren(Graphics grphs) {
        Graphics2D g2 = (Graphics2D) grphs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(colorPaint);
        g2.fillRoundRect(0, 0, getWidth(),getHeight(),15, 15);
        g2.fillRect(0,50 , getWidth(), getHeight());
        super.paintChildren(grphs); 
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
            .addGap(0, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
