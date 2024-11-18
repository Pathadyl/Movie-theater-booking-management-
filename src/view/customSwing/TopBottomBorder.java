package view.customSwing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

public class TopBottomBorder implements Border {
    private final int thickness;
    private final Color color;

    public TopBottomBorder(int thickness, Color color) {
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        // Top border
        g.fillRect(x, y, width, thickness);
        // Bottom border
        g.fillRect(x, y + height - thickness, width, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, 0, thickness, 0); // Top and bottom insets
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
