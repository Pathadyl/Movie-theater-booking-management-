package view.Panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;



public class CardLayoutPanel extends javax.swing.JPanel {
    
    public CardLayoutPanel() {
        initComponents();
        setOpaque(false);
    }
    
    @Override
    protected void paintChildren(Graphics grphs) {
        Graphics2D g2 = (Graphics2D) grphs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(),getHeight(),15, 15);
        g2.fillRect(0,110 , getWidth(), getHeight());
        super.paintChildren(grphs); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
