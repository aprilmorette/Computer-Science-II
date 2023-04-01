import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
	public static final int LIP_WIDTH = 75;
	public static final int LIP_HEIGHT = 25;
	public static final int X_LIP = 360;
	public static final int Y_LIP = 150;
	
	public static final int X_LEFT_SPOUT = 360;
	public static final int Y_LEFT_SPOUT = 190;
	public static final int X_RIGHT_SPOUT = 435;
	public static final int Y_RIGHT_SPOUT = 190;
	
	public static final int X_LEFT_INNER = 320;
	public static final int Y_LEFT_INNER = 150;
	public static final int X_RIGHT_INNER = 435;
	public static final int Y_RIGHT_INNER = 190;
	
	public static final int X_LEFT_BOTTOM = 275;
	public static final int Y_BOTTOM = 550;
	public static final int X_RIGHT_BOTTOM = 520;
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(X_LIP, Y_LIP, LIP_WIDTH, LIP_HEIGHT);
		g.drawLine(X_LIP, 162, X_LEFT_SPOUT, Y_LEFT_SPOUT);
		g.drawLine(X_RIGHT_SPOUT, 162, X_RIGHT_SPOUT, Y_RIGHT_SPOUT);
		g.drawArc(X_LEFT_INNER, Y_LEFT_INNER, 40, 80, 0, -90);
		g.drawArc(X_RIGHT_INNER, Y_LEFT_INNER, 40, 80, 180, 90);
		g.drawLine(455, 230, 500, 230);
		g.drawLine(340, 230, 295, 230);
		g.drawArc(275, 230, 40, 40, 90, 90);
		g.drawArc(480, 230, 40, 40, 90, -90);
		g.drawLine(275, 250, 275, Y_BOTTOM);
		g.drawLine(X_RIGHT_BOTTOM, 250, X_RIGHT_BOTTOM, Y_BOTTOM);
		g.drawLine(X_LEFT_BOTTOM, Y_BOTTOM, X_RIGHT_BOTTOM, Y_BOTTOM);
		g.drawString("DRINK ME", 370, 350);
	}
}