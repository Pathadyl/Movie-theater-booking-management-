
package view.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import view.models.Model_Menu;

/**
 *
 * @author DUC DUNG
 */
public class MenuItem extends javax.swing.JPanel {

    private boolean selected;
    private boolean over;

    
    
    public MenuItem(Model_Menu data) {
        initComponents();
        setOpaque(false);
        if(data.getType() == Model_Menu.MenuType.MENU){
            IbIcon.setIcon(data.toIcon());
            IbName.setText(data.getName());
            Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
            this.setBorder(border);
        }
        else if(data.getType() == Model_Menu.MenuType.TITLE){
            IbName.setText(data.getName());
            IbName.setFont(new Font("sansserif", 3, 16));
            
        }
        else {
            IbName.setText(" ");
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
    
    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics grphcs) {
        if(selected || over){
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (selected){
                g2.setColor(new Color(255, 255, 255, 80));
            }
            else{
                g2.setColor(new Color(255, 255, 255, 20));
            }
            g2.fillRoundRect(0, 0, getWidth() , getHeight(), 0, 0);
            
        }
        super.paintComponents(grphcs);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IbIcon = new javax.swing.JLabel();
        IbName = new javax.swing.JLabel();

        IbIcon.setForeground(new java.awt.Color(255, 255, 255));

        IbName.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        IbName.setForeground(new java.awt.Color(255, 255, 255));
        IbName.setText("Menu name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IbName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IbName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(IbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbIcon;
    private javax.swing.JLabel IbName;
    // End of variables declaration//GEN-END:variables
}
