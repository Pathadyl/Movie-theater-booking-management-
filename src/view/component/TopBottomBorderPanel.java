package view.component;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import view.customSwing.TopBottomBorder;

public class TopBottomBorderPanel extends JPanel {
    public TopBottomBorderPanel() {
        setBorder(BorderFactory.createCompoundBorder(
            new TopBottomBorder(1, Color.LIGHT_GRAY), // Change thickness and color as needed
            BorderFactory.createEmptyBorder(5, 5, 5, 5) // Optional padding inside the panel
        ));
    }
}
