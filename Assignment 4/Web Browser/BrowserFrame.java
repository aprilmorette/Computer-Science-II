import javax.swing.*;
import java.awt.*;

public class BrowserFrame extends JFrame {

    BrowserPanel panel;
    BrowserModel model;

    public BrowserFrame() {
        setTitle("Web Browser");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setSize(screenSize.width/2, screenSize.height/2);
        model = new BrowserModel();
        panel = new BrowserPanel(this);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public BrowserModel getModel() {
        return model;
    }
}