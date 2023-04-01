/** should only be a few lines */

import javax.swing.*;

public class MinesweeperFrame extends JFrame {

	MinesweeperModel model;
	MinesweeperPanel panel;

	public MinesweeperFrame() {
		setTitle("Minesweeper");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = new MinesweeperModel();
		panel = new MinesweeperPanel(this);
		add(panel);
		setVisible(true);
	}
	public MinesweeperModel getModel() {
		return model;
	}
}