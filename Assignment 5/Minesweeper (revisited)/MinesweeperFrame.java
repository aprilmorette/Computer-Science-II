import javax.swing.*;

public class MinesweeperFrame extends JFrame {

	MinesweeperModel model;
	MinesweeperPanel panel;

	public MinesweeperFrame(int level) {
		setTitle("Minesweeper");
		setSize(520, 590);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		model = new MinesweeperModel(level);
		panel = new MinesweeperPanel(this);
		add(panel);
		setVisible(true);
	}

	public MinesweeperModel getModel() {
		return model;
	}
}