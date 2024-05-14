package view.component;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import view.customSwing.CustomButtonWithPressEffect;


public class MenuButton extends CustomButtonWithPressEffect {
   
    private Icon iconButton = null;
    
    public MenuButton() { 
        setPaintedColor(new Color(40, 40, 40));
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM);
        
        if(this.getText() != null) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIconSelected();
                    setIcon(iconButton);
                    setForeground(new Color(58,181,75));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setIconNormal();
                    setIcon(iconButton);
                    setForeground(Color.WHITE);
                }
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    setIconSelected();
                    setIcon(iconButton);
                    setForeground(new Color(58,181,75));
                    setBackground(Color.WHITE);
                }
                
            });
        }
        
    }
    
    private void setIconNormal() {
        iconButton = new ImageIcon(getClass().getResource("/view/icon/" + this.getText().toLowerCase() + ".png"));
    }
    
    private void setIconSelected() {
        if (this.getText() != null)
        iconButton = new ImageIcon(getClass().getResource("/view/icon/" + this.getText().toLowerCase() + "_selected.png"));
    }

}
    
