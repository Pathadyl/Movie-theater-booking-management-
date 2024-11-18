package view.component;

import java.awt.Panel;
import view.customSwing.TestButtonAlignText;


public class ShowTimeDateChooserList extends javax.swing.JLayeredPane {

    public ShowTimeDateChooserList() {
        initComponents();
        
    }
    
    public void addDateChooser(TestButtonAlignText button){
        panel.add(button);
        panel.repaint();
        panel.revalidate();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        scrollBar1 = new view.customSwing.ScrollBar();

        sp.setBorder(null);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sp.setHorizontalScrollBar(scrollBar1);

        panel.setBackground(new java.awt.Color(0, 0, 0));
        panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        sp.setViewportView(panel);

        scrollBar1.setBackground(new java.awt.Color(51, 222, 0));
        scrollBar1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        setLayer(sp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        setLayer(scrollBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(474, 474, 474))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private view.customSwing.ScrollBar scrollBar1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
