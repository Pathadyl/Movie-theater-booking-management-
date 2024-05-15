package view.customSwing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class MyCustomComboBox extends JComboBox<String> {

    public MyCustomComboBox() {
        super();
        applyCustomUI();
    }

    public MyCustomComboBox(String[] items) {
        super(items);
        applyCustomUI();
    }

    private void applyCustomUI() {
        setUI(new CustomComboBoxUI());
        setBorder(BorderFactory.createEmptyBorder());
    }

    static class CustomComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton arrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, Color.WHITE, Color.BLACK, Color.BLACK, Color.WHITE) {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.setColor(Color.BLACK);
                    int x = getWidth() / 2;
                    int y = getHeight() / 2;
                    int size = Math.min(getWidth(), getHeight()) / 2;
                    Polygon arrow = new Polygon();
                    arrow.addPoint(x - size / 2, y - size / 2);
                    arrow.addPoint(x + size / 2, y - size / 2);
                    arrow.addPoint(x, y + size / 2);
                    g.fillPolygon(arrow);
                }
            };
            arrowButton.setBorder(BorderFactory.createEmptyBorder());
            arrowButton.setContentAreaFilled(false);
            return arrowButton;
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            // Do not paint background
        }

        @Override
        public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
            // Customize value painting if needed
            super.paintCurrentValue(g, bounds, hasFocus);
        }

        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            listBox.setBorder(BorderFactory.createEmptyBorder());
            arrowButton.setBorder(BorderFactory.createEmptyBorder());
            comboBox.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}