package view.customSwing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class CustomJPasswordField extends JPasswordField {
    
    private final Animator animator;
    private boolean animatedHintText = true;
    private float location;
    private boolean show;
    private boolean mouseOver = false;
    private String labelText = "Label";
    private Color lineColor = new Color(3, 155, 216);
    private final Image eye;
    private final Image eye_hide;
    private boolean hide = true;
    
    
    public CustomJPasswordField() {
        setBorder(new EmptyBorder(20, 3, 10, 30));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = getWidth() - 30;
                if(new Rectangle(x, 0, 30, 30).contains(e.getPoint())) {
                    hide = !hide;
                    if(hide){
                        setEchoChar('*');
                    } else {
                        setEchoChar((char) 0);
                    }
                    repaint();
                } 
            }
            
            
            
        });
        
        addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e) {
                showing(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                showing(true);
            }
            
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = getWidth() - 30;
                if(new Rectangle(x, 0, 30, 30).contains(e.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            }
        });
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                animatedHintText = String.valueOf(getPassword()).equals("");
            }

            @Override
            public void timingEvent(float fraction) {
                location = fraction;
                repaint();
            }
            
            
            
        };
        
        eye = new ImageIcon(getClass().getResource("/view/icon/eye.png")).getImage();
        eye_hide = new ImageIcon(getClass().getResource("/view/icon/eye_hide.png")).getImage();
        
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
    
    
    
    private void showing(boolean action) {
        if(animator.isRunning()){
            animator.stop();
        }else{
            location = 1;
        }
        animator.setStartFraction(1f - location);
        show = action;
        location = 1f - location;
        animator.start();
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        if(mouseOver) {
            g2.setColor(lineColor);
        } else {
            g2.setColor(new Color(150, 150, 150));
        }
        g2.fillRect(2, height - 1, width - 4, 1);
        createdHintText(g2);
        createLineStyle(g2);
        createShowHide(g2);
        g2.dispose();
    }
    
    
    private void createShowHide(Graphics2D g2){
        int x = getWidth() - 30 + 5;
        int y = (getHeight() - 20)/2;
        g2.drawImage(hide?eye_hide : eye, x, y, null);
        
    }
    
    private void createdHintText(Graphics2D g2){
        Insets in = getInsets();
        g2.setColor(new Color(150, 150, 150));
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(labelText, g2);
        double height = getHeight() - in.top - in.bottom;
        double textY = (height - r2.getHeight())/2;
        double size;
        if(animatedHintText){
            if(show){
                size = (18 * (1 - location));
            } else {
                size = 18 * location;
            }
        } else {
            size = 18;
        }
        g2.drawString(labelText,in.left, (int) (in.top + textY + ft.getAscent() - size));
    }
    
    private void createLineStyle(Graphics2D g2){
        if(isFocusOwner()){
            double width = getWidth() - 4;
            int height = getHeight();
            g2.setColor(lineColor);
            double size;
            if(show){
                size = width * (1 - location);
            } else {
                size = width * location;
            }
            double x = width * location;
            g2.fillRect((int) (x * 2), height - 2, (int) size, 2);
        }
    }
    
    @Override
    public void setText(String t) {
        if(!String.valueOf(getPassword()).equals(t)){
            showing(t.equals(""));
        }
        super.setText(t);
    }
    
    
    
}
