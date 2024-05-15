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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RectangleButtonWithPressEffect extends JButton {
    private final Timer timerPressed;
    private float alpha = 0.3f;
    private boolean pressed;
    private Point pressedLocation;
    private float pressedSize;
    private float sizeSpeed = 1f;
    private float alphaPressed = 0.5f;
    private Color paintedColor;
    private Icon rightIcon;
    
    public RectangleButtonWithPressEffect() {
        setContentAreaFilled(false);
        setFocusable(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.PLAIN, 18));
        setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left by default
        
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
        
        // Set custom border with only top and bottom lines
        setBorder(BorderFactory.createCompoundBorder(
            new TopBottomBorder(), // Custom border with only top and bottom lines
            new EmptyBorder(5, 5, 5, 5) // Padding to maintain text position
        ));
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

    public Icon getRightIcon() {
        return rightIcon;
    }

    public void setRightIcon(Icon rightIcon) {
        this.rightIcon = rightIcon;
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Draw a thin border
        g2.setColor(Color.LIGHT_GRAY); // You can change the color of the border here
        g2.drawRect(0, 0, width + 1, height + 1); // Adjust the dimensions to make the border thinner
        
        g2.setColor(paintedColor);
//        g2.fillRoundRect(0, 0, width, height, height, height);
        g2.fillRect(0, 0, width, height);
        
        if (rightIcon != null) {
            int iconWidth = rightIcon.getIconWidth();
            int iconHeight = rightIcon.getIconHeight();
            int iconX = width - iconWidth - 5; // Adjust the position as needed
            int iconY = (height - iconHeight) / 2;
            rightIcon.paintIcon(this, g2, iconX, iconY);
        }
        
        if(pressed){
            paintPressed(g2);
        }
        g2.dispose();
        g.drawImage(img, 0, 0, null);
        
//        drawMultilineText(g);
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
    
//    private void drawMultilineText(Graphics g) {
//        String text = getText();
//        if (text != null && !text.isEmpty()) {
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//            g2d.setFont(getFont());
//            g2d.setColor(getForeground());
//            Font font = g2d.getFontMetrics().getFont();
//            int lineHeight = g2d.getFontMetrics(font).getHeight();
//            int y = getHeight() / 2 - lineHeight; // Adjust to vertically center the text
//
//            String[] lines = text.split("\n");
//            for (String line : lines) {
//                int x = getInsets().left;
//                y += lineHeight;
//                g2d.drawString(line, x, y);
//            }
//        }
//    }
    
    private static class TopBottomBorder implements Border {
        @Override
        public void paintBorder(java.awt.Component c, Graphics g, int x, int y, int width, int height) {
            Color borderColor = Color.LIGHT_GRAY;
            g.setColor(borderColor);
            g.drawLine(x, y, x + width, y); // Top border
            g.drawLine(x, y + height - 1, x + width, y + height - 1); // Bottom border
        }

        @Override
        public java.awt.Insets getBorderInsets(java.awt.Component c) {
            return new java.awt.Insets(0, 0, 0, 0); // Top and bottom insets, maintain thin border
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }
}
