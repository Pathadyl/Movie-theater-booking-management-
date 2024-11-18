package view.customSwing;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class PictureAvatar extends JComponent {
    private Icon image = new ImageIcon(getClass().getResource("/view/icon/null.png"));
    private BufferedImage bufferedImage;
    
    public PictureAvatar() {
        setOpaque(false);
        setPreferredSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
        setMinimumSize(new Dimension(150, 150));
    }
   
    
    public PictureAvatar(Icon image) {
        setOpaque(false);
        setPreferredSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150, 150));
        setMinimumSize(new Dimension(150, 150));
        setImage(image);
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        repaint();  
    }
    
    
    private void createImage() {
        if(image != null) {
            int width = getWidth();
            int height = getHeight();
            if(width > 0 && height > 0) {
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                Rectangle rec = getAutoSize(image);
                g2.drawImage(((ImageIcon)image).getImage(), rec.x, rec.y, rec.width, rec.height, null);
                g2.dispose();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(bufferedImage != null){
            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
            g2.setComposite(AlphaComposite.SrcIn);
            g2.drawImage(bufferedImage, 0, 0, null);
            g2.dispose();
            g.drawImage(img,0,0,null);
        }
//        g.drawImage(bufferedImage, 0, 0, null);
        super.paintComponent(g);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height); 
        createImage();
    }
    
    
    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }
}
