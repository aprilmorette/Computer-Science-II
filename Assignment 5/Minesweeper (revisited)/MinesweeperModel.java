import java.io.Serializable;
import java.io.*;

public class MinesweeperModel implements Serializable {

	int[][] cellState; // array representing the cell's state (there are five possibilities)
	int[][] board; // the original board
	int row; int col; int mineCount;
	final int safeHidden = 0;
	final int mineHidden = 1;
	final int flaggedAndSafe = 2;
	final int flaggedAndMine = 3;
	final int safeRevealed = 4;
	final int mineRevealed = 5;
	final int easy = 1;
	final int normal = 2;
	final int hard = 3;
	
	public MinesweeperModel(int level) {
		newGame(level);
	}
	// set up game
	public void newGame(int level) {
		if (level == 1) {
			easySetupBoard();
		} else if (level == 2) {
			normalSetupBoard();
		} else {
			hardSetupBoard();
		}
	}
	// save game
	public void saveGame(File fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName, false);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException x) {
			x.printStackTrace();
		}
	}
	// load game
	public void loadGame(File fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			newGame((MinesweeperModel)in.readObject());
			in.close();
			fileIn.close();
		} catch (IOException x) {
			System.out.println("Could not read file");
		} catch (ClassNotFoundException x) {
			System.out.println("Not a valid file");
		}
	}
	public void newGame(MinesweeperModel model) {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				this.board[row][col] = model.board[row][col];
				this.cellState[row][col] = model.cellState[row][col];
			}
		}
	}
	// difficulty level: easy
	public void easySetupBoard() {  
		cellState = new int[10][10]; 
		board = new int[10][10];
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) { // probability of being a mine = 5%
				int rand = (int)(Math.random()*100) + 1;
				this.cellState[row][col] = (rand < 5) ? mineHidden : safeHidden; // assigns 1 if mine
				if (this.cellState[row][col] == 1) {
					mineCount++;
				}
				this.board[row][col] = this.cellState[row][col];
			}
		}
		for (int row = 0; row < 10; row++) {  // populating board with remaining numbers
			for (int col = 0; col < 10; col++) {
				if (this.board[row][col] == mineHidden) {
					this.board[row][col] = 100;
				} else {
					this.board[row][col] = getMineCount(row, col);
				}
			}
		}
	}
	// difficulty level: normal
	public void normalSetupBoard() {  
		cellState = new int[10][10]; 
		board = new int[10][10];
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) { // probability of being a mine = 15%
				int rand = (int)(Math.random()*100) + 1;
				this.cellState[row][col] = (rand < 15) ? mineHidden : safeHidden; // assigns 1 if mine
				if (this.cellState[row][col] == 1) {
					mineCount++;
				}
				this.board[row][col] = this.cellState[row][col];
			}
		}
		for (int row = 0; row < 10; row++) {  // populating board with remaining numbers
			for (int col = 0; col < 10; col++) {
				if (this.board[row][col] == mineHidden) {
					this.board[row][col] = 100;
				} else {
					this.board[row][col] = getMineCount(row, col);
				}
			}
		}
	}
	// difficulty level: hard
	public void hardSetupBoard() {  
		cellState = new int[10][10]; 
		board = new int[10][10];
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) { // probability of being a mine = 25%
				int rand = (int)(Math.random()*100) + 1;
				this.cellState[row][col] = (rand < 25) ? mineHidden : safeHidden; // assigns 1 if mine
				if (this.cellState[row][col] == 1) {
					mineCount++;
				}
				this.board[row][col] = this.cellState[row][col];
			}
		}
		for (int row = 0; row < 10; row++) {  // populating board with remaining numbers
			for (int col = 0; col < 10; col++) {
				if (this.board[row][col] == mineHidden) {
					this.board[row][col] = 100;
				} else {
					this.board[row][col] = getMineCount(row, col);
				}
			}
		}
	}
	// checks if cell is a mine
	public int isMine(int row, int col) {
		if (cellState[row][col] == mineHidden || cellState[row][col] == flaggedAndMine) {
			return 1;
		} else {
			return 0;
		}
	}
	// counts how many mines are surrounding the cell
	public int getMineCount(int row, int col) {
		if (row == 0) {
			if (col == 0) {
				return isMine(0, 1) + isMine(1, 0) + isMine(1, 1);
			} else if (col == 9) {
				return isMine(0, 8) + isMine(1, 9) + isMine(1, 8); 
			} else {
				return isMine(0, col-1) + isMine(0, col+1) + isMine(1, col-1) + isMine(1, col) + isMine(1, col+1);
			}
		} else if (row == 9) {
			if (col == 0) {
				return isMine(9, 1) + isMine(8, 0) + isMine(8, 1);
			} else if (col == 9) {
				return isMine(9, 8) + isMine(8, 9) + isMine(8, 8);
			} else {
				return isMine(9, col-1) + isMine(9, col+1) + isMine(8, col-1) + isMine(8, col) + isMine(8, col+1);
			}
		} else if (col == 0 && row != 0 && row != 9) {
			return isMine(row-1, 0) + isMine(row+1, 0) + isMine(row-1, 1) + isMine(row, 1) + isMine(row+1, 1);
		} else if (col == 9 && row != 0 && row !=9) {
			return isMine(row-1, 9) + isMine(row+1, 9) + isMine(row-1, 8) + isMine(row, 8) + isMine(row+1, 8);
		} else {
			return isMine(row-1, col-1) + isMine(row-1, col) + isMine(row-1, col+1) + isMine(row, col-1) + isMine(row, col+1) + isMine(row+1, col+1) + isMine(row+1, col) + isMine(row+1, col-1);
		}
	}
	// changes the cell's state when the user left clicks
	public void mineHit(int row, int col) {
			cellState[row][col] = mineRevealed;
	}
	public void safeHit(int row, int col) {
		cellState[row][col] = safeRevealed;
	}
	// changes the cell's state when the user right clicks (either flag or unflag)
	public void flag(int row, int col) {
		if (cellState[row][col] == safeHidden) {
			cellState[row][col] = flaggedAndSafe;
		} else if (cellState[row][col] == mineHidden) {
			cellState[row][col] = flaggedAndMine;
		}
	}
	public void unflag(int row, int col) {
		if (cellState[row][col] == flaggedAndSafe) {
			cellState[row][col] = safeHidden;
		} else if (cellState[row][col] == flaggedAndMine) {
			cellState[row][col] = mineHidden;
		}
	}
	// floods board with zeros if one is revealed by user
	public void flood(int row, int col) {
		if (row < 0 || row >= 10 || col < 0 || col >= 10) {
			return;
		}
		if (this.board[row][col] == 0 && this.cellState[row][col] != 4) {
			this.cellState[row][col] = safeRevealed;
			flood(row - 1, col - 1);
            flood(row, col - 1);
            flood(row + 1, col - 1);
            flood(row - 1, col);
            flood(row + 1, col);
            flood(row - 1, col);
            flood(row, col + 1);
            flood(row + 1, col + 1);
		} else {
			return;
		}
	}
	// gets the state of the cell
	public int getState(int row, int col) {
		return this.cellState[row][col];
	}
	// gets the number on the cell 
	public int getNumber(int row, int col) {
		return this.board[row][col];
	}
	// gets the mine count
	public int minesLeft() {
		return mineCount;
	}
	// reveals all the cells
	public void revealAll() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (this.cellState[row][col] == 0 || this.cellState[row][col] == 2) {
					this.cellState[row][col] = 4;
				} else if (this.cellState[row][col] == 1 || this.cellState[row][col] == 3) {
					this.cellState[row][col] = 5;
				}
			}
		}
	}
	// resets the game once it ends
	public void resetGame() {
		mineCount = 0;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				this.board[row][col] = 0;
				this.cellState[row][col] = 0;
			}
		}
		easySetupBoard();
	}
}