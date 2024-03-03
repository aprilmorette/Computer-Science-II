import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BrowserPanel extends JPanel {
    BrowserFrame frame;
    JTextArea HTMLdisplay;

    public BrowserPanel(BrowserFrame f) {
        setLayout(new BorderLayout());
        frame = f;
        JTextField userEntry = new JTextField(60);
        HTMLdisplay = new JTextArea();
        add(userEntry, BorderLayout.NORTH);
        add(HTMLdisplay, BorderLayout.CENTER);
        HTMLdisplay.setLineWrap(true);
        HTMLdisplay.setEditable(false);
        JScrollPane scroll = new JScrollPane(HTMLdisplay);
        add(scroll);
        //Font heading = new Font("SansSerif", Font.BOLD, 20);
        //Toolkit kit = Toolkit.getDefaultToolkit();

        userEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String webBrowser = userEntry.getText();
                //Image image; JLabel picture;
                try {
                if (BrowserModel.checkHTTPS(webBrowser) == true) {
                    BrowserModel.getWebAddress(webBrowser);
                    BrowserModel.getFilePath(webBrowser);
                    BrowserModel.setURL(BrowserModel.filePath, BrowserModel.webAddress);
                    frame.setTitle(BrowserModel.getTitle(BrowserModel.webPage));
                    HTMLdisplay.setText(BrowserModel.getBody(BrowserModel.webPage));
                    /*
                    for (int i = 0; i < BrowserModel.webPage.length(); i++) {
                        String URL = BrowserModel.getImage(BrowserModel.webPage.substring(i));
                        image = kit.getImage(URL);
                        picture =  new JLabel(new ImageIcon(image));
                        frame.add(picture);
                        i += URL.length() + 10;
                    } */
                } else {
                    System.out.println("Please use the correct HTTP format: https://");
                    webBrowser = "";
                }
                } catch (StringIndexOutOfBoundsException s) {
                    System.out.println("Please enter a valid URL");
                    webBrowser = "";
                }
            }
        });
    }
}