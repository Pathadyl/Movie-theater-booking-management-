package view.customSwing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class CustomButtonWithPressEffect extends JButton {
    private final Timer timerPressed;
    private float alpha = 0.3f;
    private boolean pressed;
    private Point pressedLocation;
    private float pressedSize;
    private float sizeSpeed = 1f;
    private float alphaPressed = 0.5f;
    private Color paintedColor;
    private boolean showBorder = true; 
    
    public CustomButtonWithPressEffect() {
        setContentAreaFilled(false);
        setFocusable(false);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.PLAIN, 12));

        if(this.getText() != null) {
            addMouseListener(new MouseAdapter() {
                
                @Override
                public void mousePressed(MouseEvent e) {
                    pressedSize = 0;
                    alphaPressed = 0.5f;
                    pressed = true;
                    pressedLocation = e.getPoint();
                    timerPressed.setDelay(0);
                    timerPressed.start();
                }
                
                
            });
        }
        
        timerPressed = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedSize += sizeSpeed;
                if(alphaPressed <= 0){
                    pressed = false;
                    timerPressed.stop();
                } else {
                    repaint();
                }
            }
        });
    }

    public boolean isShowBorder() {
        return showBorder;
    }

    public void setShowBorder(boolean showBorder) {
        this.showBorder = showBorder;
        repaint();
    }
    
    
    
    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public Point getPressedLocation() {
        return pressedLocation;
    }

    public void setPressedLocation(Point pressedLocation) {
        this.pressedLocation = pressedLocation;
    }

    public float getPressedSize() {
        return pressedSize;
    }

    public void setPressedSize(float pressedSize) {
        this.pressedSize = pressedSize;
    }

    public float getSizeSpeed() {
        return sizeSpeed;
    }

    public void setSizeSpeed(float sizeSpeed) {
        this.sizeSpeed = sizeSpeed;
    }

    public float getAlphaPressed() {
        return alphaPressed;
    }

    public void setAlphaPressed(float alphaPressed) {
        this.alphaPressed = alphaPressed;
    }

    public Color getPaintedColor() {
        return paintedColor;
    }

    public void setPaintedColor(Color paintedColor) {
        this.paintedColor = paintedColor;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (showBorder) { // Draw border only if showBorder is true
            g2.setColor(Color.WHITE); // Set border color to white
            int borderThickness = 1; // Set border thickness
            g2.fillRoundRect(borderThickness, borderThickness, width - 2 * borderThickness, height - 2 * borderThickness, height, height);
        }
        g2.setColor(paintedColor);
        g2.fillRoundRect(showBorder ? 2 : 0, showBorder ? 2 : 0, width - (showBorder ? 4 : 0), height - (showBorder ? 4 : 0), height - (showBorder ? 4 : 0), height - (showBorder ? 4 : 0));
        if(pressed){
            paintPressed(g2);
        }
        g2.dispose();
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    private void paintPressed(Graphics2D g2) {
        if((pressedLocation.x - (pressedSize/2) < 0) && (pressedLocation.x + (pressedSize/2)) > getWidth()){
            timerPressed.setDelay(20);
            alphaPressed -= 0.05f;
            if(alphaPressed < 0){
                alphaPressed = 0;
            }
        }
        g2.setColor(Color.LIGHT_GRAY);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed));
        float x = (pressedLocation.x - (pressedSize/2));
        float y = (pressedLocation.y - (pressedSize/2));
        g2.fillOval((int) x, (int) y, (int) pressedSize, (int) pressedSize);
    }
}
