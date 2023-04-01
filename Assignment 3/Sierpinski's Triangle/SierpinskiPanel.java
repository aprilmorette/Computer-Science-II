import javax.swing.*;
import java.awt.*;

public class SierpinskiPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight(); 
		int x = 0; 
		int y = 0;
		draw(g, x, y, width, height);
	}
	private void draw(Graphics g, int x, int y, int width, int height) {
		if (width == 1 || height == 1) {
			g.fillRect(x, y, width, height);
			repaint();
		} else {
			draw(g, x, y + (height/2), width / 2, height / 2); //lower left quadrant
			draw(g, x + (width/2), y + (height/2), width / 2, height / 2); //lower right quadrant
			draw(g, x + (width/4), y, width / 2, height / 2); //upper center quadrant
		}
	}
}