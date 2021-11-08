import java.util.Scanner;

public class Game {
	Board board;
	boolean steppedOnMine = false;
	boolean won = false;

	Game(Board board) {
		this.board = board;
	}

	void turn(){
		Scanner scnr = new Scanner(System.in);
		int xChoice = 0;
		int yChoice = 0;
		String type = "";
		while (true){
			System.out.println("Set/unset mines marks or claim a cell as free: ");
				try{
					String choices = scnr.nextLine();
					choices = choices.trim();
					if(choices.split(" ").length == 3){
						xChoice = Integer.parseInt(choices.split(" ")[0]);
						yChoice = Integer.parseInt(choices.split(" ")[1]);
						type = choices.split(" ")[2];
						if(xChoice > board.playerBoard[0].length){
							System.out.println("X value out of range try again");
							continue;
						}else if(yChoice > board.playerBoard.length){
							System.out.println("Y value out of range try again");
							continue;
						}else if(!(type.equals("free") || type.equals("mine"))){
							System.out.println("For the third value please enter free or mine.  Try again");
							continue;
						}
					}
				}catch(Exception e){
					System.out.println("Enter two numbers with a space between them, try again.");
					continue;
				}
			if(type.equals("free")){
				if(board.getSpotMasterBoard(yChoice, xChoice).equals("X")){
					this.steppedOnMine = true;
				}
				board.explore(yChoice, xChoice);
				return;
			}else if (type.equals("mine")){
				if(!board.getSpotPlayerBoard(yChoice, xChoice).equals(".")){
					if(board.getSpotPlayerBoard(yChoice, xChoice).equals("*")){
						board.setSpotPlayerBoard(yChoice, xChoice, ".");
						return;
					}
					System.out.println("This spot is already explored");
					continue;
				}

				board.setSpotPlayerBoard(yChoice, xChoice, "*");
				if(board.checkFoundMines()){
					this.won = true;
					return;
				}
				return;
			}
		}
	}

	void play(){
		while (!steppedOnMine && !won){
			board.printPlayerBoard();
			turn();
		}
		if(steppedOnMine){
			System.out.println("You stepped on a mine and failed!");
		}else {
			System.out.println("Congratulations! You found all the mines!");
		}
		board.printPlayerBoard();
	}
}

