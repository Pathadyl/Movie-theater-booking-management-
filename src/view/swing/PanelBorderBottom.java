/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author DUC DUNG
 */
public class PanelBorderBottom extends javax.swing.JPanel {

    /**
     * Creates new form PanelBorderBottom
     */
    public PanelBorderBottom() {
        initComponents();
        setOpaque(false);
    }

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        // Vẽ hình chữ nhật không bo góc trên
        g2.fillRect(0, 0, getWidth(), getHeight() - 15);

        // Vẽ hai nửa hình tròn ở góc dưới
        g2.fillArc(0, getHeight() - 30, 30, 30, 180, 90);
        g2.fillArc(getWidth() - 30, getHeight() - 30, 30, 30, 270, 90);

        // Vẽ phần dưới hình chữ nhật
        g2.fillRect(15, getHeight() - 15, getWidth() - 30, 15);
        
    super.paintChildren(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
