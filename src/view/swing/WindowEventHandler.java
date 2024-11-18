
package view.swing;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent evt) {
        // Lấy ra cửa sổ đang đóng
        JFrame frame = (JFrame) evt.getSource();
        // Ẩn cửa sổ thay vì đóng nó
        frame.setVisible(false);
    }
}
