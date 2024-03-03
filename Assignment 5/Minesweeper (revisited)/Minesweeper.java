import java.io.Serializable;

public class Minesweeper implements Serializable {
	static int level = 1;
	public static void main(String[] args) {
		new MinesweeperFrame(level);
	}
}