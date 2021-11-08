import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Board {
	String[][] masterBoard;
	String[][] playerBoard;
	ArrayList<String> mineList = new ArrayList<>();
	int numMines;

	Board() {
		this.createMasterBoard();
		this.generateMines();
		this.createPlayerBoard();
	}

	@SuppressWarnings ("CommentedOutCode")
	void createMasterBoard() {
//		Scanner scnr = new Scanner(System.in);
		int columns = 9;
		int rows = 9;
//        while (true){
//            System.out.println("Enter number of columns");
//            try {
//                columns = scnr.nextInt();
//            }catch (NumberFormatException e) {
//                System.out.println("Not a valid input. Try Again");
//                continue;
//            }
//            System.out.println("Enter number of rows");
//            try {
//                rows = scnr.nextInt();
//                break;
//            }catch (NumberFormatException e) {
//                System.out.println("Not a valid input. Try Again");
//            }
//        }
		this.masterBoard = new String[rows][columns];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				masterBoard[y][x] = ".";
			}
		}
	}

	void generateMines() {
		Scanner scnr = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("How many mines do you want on the field?");
				this.numMines = scnr.nextInt();
			} catch (Exception e) {
				System.out.println("Error: not a valid int");
				continue;
			}
			if (numMines < 0) {
				System.out.println("Error: Can't insert negative number of mines");
				scnr.nextLine();
			} else if (numMines > this.masterBoard.length * this.masterBoard[0].length) {
				System.out.println("Error: must have less mines than board spaces");
				scnr.nextLine();
			} else {
				break;
			}
		}
		Random randomRow = new Random();
		Random randomColumn = new Random();
		for (int m = 0; m < this.numMines; m++) {
			int randRow = randomRow.nextInt(masterBoard.length) + 1;
			int randCol = randomColumn.nextInt(masterBoard[0].length) + 1;
			System.out.println(randRow + " " + randCol);
			if (this.getSpotMasterBoard(randRow, randCol).equals(".")) {
				this.setMineMasterBoard(randRow, randCol);
				mineList.add(randRow + " " + randCol);
			} else {
				m--;
			}
		}

	}

//	void hintGenWholeBoard() {
//
//		for (int y = 0; y < this.masterBoard.length; y++) {
//			for (int x = 0; x < this.masterBoard[y].length; x++) {
//				if (masterBoard[y][x].equals("X")) continue;
//				int currNum = 0;
//				String right = y + " " + (x + 1);
//				String belowRight = (y - 1) + " " + (x + 1);
//				String aboveRight = (y + 1) + " " + (x + 1);
//				String left = y + " " + (x - 1);
//				String belowLeft = (y - 1) + " " + (x - 1);
//				String aboveLeft = (y + 1) + " " + (x - 1);
//				String below = (y - 1) + " " + x;
//				String above = (y + 1) + " " + x;
//				for (int s = 0; s < 8; s++) {
//					if (s == 0) {
//						currNum = spotCheck(currNum, right);
//					} else if (s == 1) {
//						currNum = spotCheck(currNum, belowRight);
//					} else if (s == 2) {
//						currNum = spotCheck(currNum, aboveRight);
//					} else if (s == 3) {
//						currNum = spotCheck(currNum, left);
//					} else if (s == 4) {
//						currNum = spotCheck(currNum, belowLeft);
//					} else if (s == 5) {
//						currNum = spotCheck(currNum, aboveLeft);
//					} else if (s == 6) {
//						currNum = spotCheck(currNum, below);
//					} else {
//						currNum = spotCheck(currNum, above);
//					}
//				}
//				if (currNum > 0) {
//					this.setSpotMasterBoard(y, x, String.valueOf(currNum));
//				}
//			}
//		}
//	}

	private int spotCheck(String spot) {
		int y = Integer.parseInt(spot.split(" ")[0]);
		int x = Integer.parseInt(spot.split(" ")[1]);
		try {
			if (!this.getSpotMasterBoard(y, x).equals("X")) {
				return 0;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
		return 1;
	}

	void setMineMasterBoard(int y, int x) {
		this.masterBoard[y-1][x-1] = "X";
	}

	void createPlayerBoard() {
		this.playerBoard = Arrays.stream(this.masterBoard).map(String[]::clone).toArray(String[][]::new);
		for (int y = 1; y <= this.playerBoard.length; y++) {
			for (int x = 1; x <= this.playerBoard[0].length; x++) {
				if (this.getSpotPlayerBoard(y, x).equals("X")) {
					this.setSpotPlayerBoard(y, x, ".");
				}
			}
		}
	}

	String getSpotPlayerBoard(int y, int x) {
		return this.playerBoard[y-1][x-1];
	}

	void setSpotPlayerBoard(int y, int x, String newVal) {
		this.playerBoard[y-1][x-1] = newVal;
	}

	void printPlayerBoard() {
		StringBuilder printBoard = new StringBuilder();
		printBoard.append(" |");
		int num = 1;
		for (String ignored : this.playerBoard[0]) {
			printBoard.append(num++);
		}
		printBoard.append("|\n-|");
		for (String ignored : this.playerBoard[0]) {
			printBoard.append("-");
		}
		printBoard.append("|\n");
		int y = 1;
		for (String[] rows : this.playerBoard) {
			printBoard.append(y++).append("|");
			for (String spot : rows) {
				printBoard.append(spot);
			}
			printBoard.append("|\n");
		}
		printBoard.append("-|");
		for (String ignored : this.playerBoard[0]) {
			printBoard.append("-");
		}
		printBoard.append("|\n");
		System.out.println(printBoard);
	}

//	void printMasterBoard() {
//		for (String[] rows : this.masterBoard) {
//			for (String spot : rows) {
//				System.out.print(spot);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	String getSpotMasterBoard(int y, int x) {
		return this.masterBoard[y-1][x-1];
	}

	boolean checkFoundMines() {
		ArrayList<String> markedSpots = new ArrayList<>();
		for (int y = 1; y <= this.playerBoard.length; y++) {
			for (int x = 1; x <= this.playerBoard[0].length; x++) {
				if (this.getSpotPlayerBoard(y,x).equals("*")) {
					markedSpots.add(y + " " + x);
				}
			}
		}
		if (markedSpots.size() == 0) return false;
		if (markedSpots.size() < mineList.size()) return false;
		if (markedSpots.size() > mineList.size()) return false;
		for (String markedSpot : markedSpots) {
			if (!mineList.contains(markedSpot)) {
				return false;
			}
		}
		return true;
	}

	void explore(int y, int x) {
		if(y > this.playerBoard.length || x > this.playerBoard[0].length || y < 1 || x < 1) return;
		if(!(getSpotPlayerBoard(y,x).equals(".") || getSpotPlayerBoard(y,x).equals("*"))) return;
		if(getSpotMasterBoard(y, x).equals("X")) return;
		int currNum = 0;
		String right = y + " " + (x + 1);
		String belowRight = (y - 1) + " " + (x + 1);
		String aboveRight = (y + 1) + " " + (x + 1);
		String left = y + " " + (x - 1);
		String belowLeft = (y - 1) + " " + (x - 1);
		String aboveLeft = (y + 1) + " " + (x - 1);
		String below = (y - 1) + " " + x;
		String above = (y + 1) + " " + x;
		currNum = checkSurroundingSpotsForMines(currNum, right, belowRight, aboveRight, left, belowLeft, aboveLeft, below, above);
		if (currNum == 0) {
			this.setSpotPlayerBoard(y, x,"/");
			checkAndExplore(right);
			checkAndExplore(belowRight);
			checkAndExplore(aboveRight);
			checkAndExplore(left);
			checkAndExplore(belowLeft);
			checkAndExplore(aboveLeft);
			checkAndExplore(below);
			checkAndExplore(above);
		} else {
			this.setSpotPlayerBoard(y, x, String.valueOf(currNum));
		}
	}

	private int checkSurroundingSpotsForMines(int currNum, String right, String belowRight, String aboveRight, String left, String belowLeft, String aboveLeft, String below, String above) {
		currNum += spotCheck(right);
		currNum += spotCheck(belowRight);
		currNum += spotCheck(aboveRight);
		currNum += spotCheck(left);
		currNum += spotCheck(belowLeft);
		currNum += spotCheck(aboveLeft);
		currNum += spotCheck(below);
		currNum += spotCheck(above);
		return currNum;
	}

	private void checkAndExplore(String spot) {
		int spotY = Integer.parseInt(spot.split(" ")[0]);
		int spotX = Integer.parseInt(spot.split(" ")[1]);
		explore(spotY, spotX);
	}
}
