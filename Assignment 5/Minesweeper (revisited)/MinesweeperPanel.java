import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperPanel extends JPanel {

	MinesweeperFrame frame;
	MinesweeperModel model;
	Buttons buttons;
	JLabel bombsRemainingCount;
	JMenuItem newOption;
	JMenuItem saveOption;
	JMenuItem loadOption;
	JMenuItem quitOption;
	JMenuItem easy;
	JMenuItem normal;
	JMenuItem hard;
	JFileChooser fc;
	
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
		JPanel board = new JPanel(new GridLayout(10, 10));
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttons = new Buttons(i, j, f);
				buttons.setPreferredSize(new Dimension(50, 50));
				board.add(buttons);
			}
		}
		JPanel mineCountHeader = new JPanel(new BorderLayout());
		mineCountHeader.add(board, BorderLayout.CENTER);
		bombsRemainingCount = new JLabel();
		mineCountHeader.add(bombsRemainingCount, BorderLayout.NORTH);
		add(mineCountHeader);
		frame = f;
		JMenuBar mb = new JMenuBar();
		frame.setJMenuBar(mb);
		JMenu fileMenu = new JMenu("File");
		mb.add(fileMenu);
		newOption = new JMenu("New");
		saveOption = new JMenuItem("Save");
		loadOption = new JMenuItem("Load");
		quitOption = new JMenuItem("Quit");
		
		easy = new JMenuItem("Easy");
		normal = new JMenuItem("Normal");
		hard = new JMenuItem("Hard");

		MenuHandler mh = new MenuHandler();
		newOption.addActionListener(mh);
		saveOption.addActionListener(mh);
		loadOption.addActionListener(mh);
		quitOption.addActionListener(mh);

		easy.addActionListener(mh);
		normal.addActionListener(mh);
		hard.addActionListener(mh);

		fileMenu.add(newOption);
		fileMenu.addSeparator();
		fileMenu.add(saveOption);
		fileMenu.addSeparator();
		fileMenu.add(loadOption);
		fileMenu.addSeparator();
		fileMenu.add(quitOption);

		newOption.add(easy);
		fileMenu.addSeparator();
		newOption.add(normal);
		fileMenu.addSeparator();
		newOption.add(hard);
	}

	private class MenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == easy) { // new game, level easy
				frame.dispose();
				new MinesweeperFrame(1);
				revalidate();
				repaint();
			} else if (e.getSource() == normal) { // new game, level normal
				frame.dispose();
				new MinesweeperFrame(2);
				revalidate();
				repaint();
			} else if (e.getSource() == hard) { // new game, level hard
				frame.dispose();
				new MinesweeperFrame(3);
				revalidate();
				repaint();
			} else if (e.getSource() == saveOption) { // save game
				fc = new JFileChooser();
				int file = fc.showSaveDialog(null);
				if (file == JFileChooser.APPROVE_OPTION) {
					frame.getModel().saveGame(fc.getSelectedFile());
				}
			} else if (e.getSource() == loadOption) { // load game
				fc = new JFileChooser();
				int file = fc.showOpenDialog(null);
				if (file == JFileChooser.APPROVE_OPTION) {
					removeAll();
					frame.getModel().loadGame(fc.getSelectedFile());
					revalidate();
					frame.repaint();
				}
			} else if (e.getSource() == quitOption) { // quit game
				System.exit(0);
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
						f.getModel().revealAll();
						f.repaint();
						JOptionPane.showMessageDialog(f, "GAME OVER");
						f.repaint();
					} else if (f.getModel().getState(row, col) == f.getModel().safeHidden && f.getModel().getNumber(row, col) != 0) {
						f.getModel().safeHit(row, col);
					    f.repaint();
				   } else if (f.getModel().getState(row, col) == f.getModel().safeHidden && f.getModel().getNumber(row, col) == 0) {
					f.getModel().flood(row, col);
					f.repaint();
				   }
				}
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			bombsRemainingCount.setText("Bombs remaining: " + String.valueOf(f.getModel().minesLeft()));

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