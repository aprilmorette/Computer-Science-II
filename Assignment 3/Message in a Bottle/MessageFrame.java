import javax.swing.*;

public class MessageFrame extends JFrame {
	public MessageFrame() {
		setTitle("Message in a Bottle");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MessagePanel();
		add(panel);
		setVisible(true);
	}
}