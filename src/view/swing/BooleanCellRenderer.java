
package view.swing;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class BooleanCellRenderer extends JLabel implements TableCellRenderer {
    public BooleanCellRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Kiểm tra giá trị của ô và thiết lập biểu diễn tương ứng
        if (value == null) {
            setText("NULL"); // Văn bản mặc định cho giá trị null
        }
        else if ((Boolean) value) {
            setText("✔"); // Icon cho true
        } else {
            setText("❌"); // Icon cho false
        }
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        return this;
    }
}

