package view.component;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import view.customSwing.RectangleButtonWithPressEffect;

public class personalMenuButton extends RectangleButtonWithPressEffect {
    private Icon leftIcon = null;
    
    
    public personalMenuButton() {
        setPaintedColor(Color.BLACK);
        setVerticalTextPosition(CENTER);
        setRightIcon(new ImageIcon(getClass().getResource("/view/icon/arrow.png")));
        
        if(this.getText() != null) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setIconSelected();
                    setIcon(leftIcon);
                    setForeground(new Color(58,181,75));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setIconNormal();
                    setIcon(leftIcon);
                    setForeground(Color.WHITE);
                    System.out.println();
                }
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    setIconSelected();
                    setIcon(leftIcon);
                    setForeground(new Color(58,181,75));
                    setBackground(Color.WHITE);
                }
                
            });
        }
    }
            
    private void setIconNormal() {
        leftIcon = new ImageIcon(getClass().getResource("/view/icon/" + this.getText().toLowerCase() + ".png"));
        setRightIcon(new ImageIcon(getClass().getResource("/view/icon/arrow.png")));
    }
    
    private void setIconSelected() {
        leftIcon = new ImageIcon(getClass().getResource("/view/icon/" + this.getText().toLowerCase() + "_selected.png"));
        setRightIcon(new ImageIcon(getClass().getResource("/view/icon/arrow_selected.png")));
    }
    
    
    
}
