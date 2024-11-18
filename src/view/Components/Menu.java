
package view.Components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import view.event.EventMenuSelected;
import view.models.Model_Menu;

/**
 *
 * @author DUC DUNG
 */
public class Menu extends javax.swing.JPanel {
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        init();
    }
    private void init(){
        
        listMenu1.addItem(new Model_Menu("movie", "Movie", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("showMovie", "Show Movie", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("add", "Add Movie", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("remove", "Remove Movie", Model_Menu.MenuType.MENU));
        
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("theater", "Theater", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("showTheater", "Show Theater", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("add", "Add Theater", Model_Menu.MenuType.MENU));
         
        listMenu1.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("showtime", "Show Time", Model_Menu.MenuType.TITLE));
        

        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAppName = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new view.swing.ListMenu<>();

        setPreferredSize(new java.awt.Dimension(240, 539));

        panelAppName.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/logo.png"))); // NOI18N
        jLabel1.setText(" Admin Management");

        javax.swing.GroupLayout panelAppNameLayout = new javax.swing.GroupLayout(panelAppName);
        panelAppName.setLayout(panelAppNameLayout);
        panelAppNameLayout.setHorizontalGroup(
            panelAppNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAppNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAppNameLayout.setVerticalGroup(
            panelAppNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAppNameLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
        );

        listMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAppName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAppName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#24FE41"), 0, getHeight(), Color.decode("#093028"));
        // color on uiGradient
        int height = 140;
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 0);
        f.curveTo(0, 0, 0, 70, 100, 70);
        f.curveTo(180, 70, getWidth(), 70, getWidth(), height);
        f.lineTo(getWidth(), getHeight());
        f.lineTo(0, getHeight());
        g2.setColor(new Color(60,60,60));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setPaint(g);
        g2.fill(f);
        super.paintChildren(grphcs); 
    }
    
    private int x;
    private int y;
    
    public void initMoving(JFrame fram) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private view.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelAppName;
    // End of variables declaration//GEN-END:variables
}
