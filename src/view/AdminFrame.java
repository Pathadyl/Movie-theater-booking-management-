
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import model.Admin;
import net.miginfocom.swing.MigLayout;
import view.Components.MenuLayout;
import view.form.MainForm;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.AdminService;
import service.UserService;
import view.Components.Header;
import view.Components.contentPanel;
import view.event.EventMenuSelected;
import view.form.addMovieForm;
import view.form.addTheaterForm;
import view.form.removeMovieForm;
import view.form.removeTheaterForm;
import view.form.showMovieForm;
import view.form.showTheaterForm;
import view.form.updateMovieForm;
import view.form.updateTheaterForm;

/**
 *
 * @author DUC DUNG
 */
public class AdminFrame extends javax.swing.JFrame {
    private final MigLayout layout;
    private final MenuLayout menu;
    private final MainForm main;
    private final Animator animator;
    private final contentPanel content;
    private UserService userServices;
    private addMovieForm addMovie;
    
    public AdminFrame() {
        initComponents();
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        //setBackground(new Color(0, 0, 0, 0));
        userServices = new AdminService(new Admin());
        header.initMoving(AdminFrame.this);
        header.setBorder(null);
        layout = new MigLayout("fill", "0[fill]0", "0[fill]0");
        
        menu = new MenuLayout();
        menu.getMenu().initMoving(AdminFrame.this);
        
        main = new MainForm();
        content = new contentPanel();
        content.add(main);
        
        mainPanel.setBorder(null);
        mainPanel.setLayer(menu, JLayeredPane.POPUP_LAYER);
        mainPanel.setLayout(layout);
        mainPanel.add(menu, "pos -215 0 100% 100%", 0);
        mainPanel.add(content, "pos 35 0 100% 100%", 0);
        
        addMovie = new addMovieForm();
        menu.getMenu().addEventMenuSelected(new EventMenuSelected(){ // Select function in menu bar
            @Override
            public void selected(int index) {
                System.out.println("Select "+ index);
                
                if(index == 1){
                    setForm(new showMovieForm());
                }
                else if(index == 2){
                    setForm(addMovie);
                }
                else if(index == 3){
                    setForm(new removeMovieForm());
                }
                
                else if(index == 6){
                    setForm(new showTheaterForm());
                }
                else if(index == 7){
                    
                    setForm(new addTheaterForm());
                }
                
                else{
                    System.out.println("Nothing in menu");
                }
            }
            
        });
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float x = (fraction * 215);
                float alpha;
                if (menu.isShow()) {
                    x = -x;
                    alpha = 0.5f - (fraction / 2);
                } else {
                    x -= 215;
                    alpha = fraction / 2;
                }
                layout.setComponentConstraints(menu, "pos " + (int) x + " 0 100% 100%");
                if (alpha < 0) {
                    alpha = 0;
                }
                menu.setAlpha(alpha);
                mainPanel.revalidate();
            }

            @Override
            public void end() {
                menu.setShow(!menu.isShow());
                if (!menu.isShow()) {
                    menu.setVisible(false);
                }
            }

        };
        animator = new Animator(200, target);
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    if (!animator.isRunning()) {
                        if (menu.isShow()) {
                            header.setVisible(true);
                            animator.start();
                        }
                    }
                }
            }
        });
        
        header.addEventMenu(new ActionListener() { //
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (!menu.isShow()) {
                        menu.setVisible(true);
                        header.setVisible(false);
                        animator.start();
                    }
                }
            }
        });
    }
    private void setForm(JComponent com){
        content.removeAll();
        content.add(com);
        content.repaint();
        content.revalidate();
    }
    private String getMovieName(){
        return addMovie.getName();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JLayeredPane();
        header = new view.Components.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setOpaque(true);
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 589));

        header.setMaximumSize(new java.awt.Dimension(35, 39));
        header.setOpaque(false);

        mainPanel.setLayer(header, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(965, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 554, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.Components.Header header;
    private javax.swing.JLayeredPane mainPanel;
    // End of variables declaration//GEN-END:variables
}
