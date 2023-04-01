import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperPanel extends JPanel {

	MinesweeperFrame frame;
	Buttons buttons;
	ImageIcon hidden = new ImageIcon("hidden.png");
	ImageIcon flag = new ImageIcon("flag.png");
	ImageIcon bomb = new ImageIcon("bomb.jpg");
	ImageIcon blank = new ImageIcon("blank.png");
	ImageIcon one = new ImageIcon("one.png");
	ImageIcon two = new ImageIcon("two.png");
	ImageIcon three = new ImageIcon("three.png");
	ImageIcon four = new ImageIcon("four.png");
	ImageIcon five = new ImageIcon("five.png");
	ImageIcon six = new ImageIcon("six.png");

	public MinesweeperPanel(MinesweeperFrame f) {
		setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons = new Buttons(i, j, f);
				add(buttons);
			}
		} 
	}
	public class Buttons extends JButton {
		private int row;
		private int col;
		MinesweeperFrame f;

		public Buttons(int row, int col, MinesweeperFrame frame) {
			this.row = row;
			this.col = col;
			f = frame;
			addMouseListener(new MouseHandler());
		}
		// mouse listeners 
		public class MouseHandler extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				Buttons selected = (Buttons) e.getSource();
				int row = selected.row;
				int col = selected.col;

				if (e.getButton() == MouseEvent.BUTTON3) {   // right click
					if ((f.getModel().getState(row, col) == f.getModel().safeHidden || f.getModel().getState(row, col) == f.getModel().mineHidden) && f.getModel().getState(row, col) != 4 && f.getModel().getState(row, col) != 5) {
						f.getModel().flag(row, col);
						f.repaint();
					} else { 
						f.getModel().unflag(row, col);
						f.repaint();
					}
				} else if (e.getButton() == MouseEvent.BUTTON1) {   // left click
					if (f.getModel().getState(row, col) == f.getModel().mineHidden) {
						f.getModel().mineHit(row, col);
						f.repaint();
					} else if (f.getModel().getState(row, col) == f.getModel().safeHidden) {
						f.getModel().safeHit(row, col);
					   f.repaint();
				   } 
				}
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (f.getModel().getState(this.row, this.col) == f.getModel().safeRevealed || f.getModel().getState(this.row, this.col) == f.getModel().mineRevealed) {
				if (f.getModel().getState(this.row, this.col) == f.getModel().safeRevealed) {
					if (f.getModel().getNumber(this.row, this.col) == 0) {
						this.setIcon(blank);
					}else if (f.getModel().getNumber(this.row, this.col) == 1) {
						this.setIcon(one);
					} else if (f.getModel().getNumber(this.row, this.col) == 2) {
						this.setIcon(two);
					} else if (f.getModel().getNumber(this.row, this.col) == 3) {
						this.setIcon(three);
					} else if (f.getModel().getNumber(this.row, this.col) == 4) {
						this.setIcon(four);
					} else if (f.getModel().getNumber(this.row, this.col) == 5) {
						this.setIcon(five);
					} else if (f.getModel().getNumber(this.row, this.col) == 6) {
						this.setIcon(six);
					} else {
						this.setIcon(bomb);
					}
				} else {
					this.setIcon(bomb);
				}
			} else if (f.getModel().getState(row, col) == f.getModel().safeHidden || f.getModel().getState(row, col) == f.getModel().mineHidden) {
				this.setIcon(hidden);
			} else if (f.getModel().getState(row, col) == f.getModel().flaggedAndSafe || f.getModel().getState(row, col) == f.getModel().flaggedAndMine) {
				this.setIcon(flag);
			}
		}
	}
}