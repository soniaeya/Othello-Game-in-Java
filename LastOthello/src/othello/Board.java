package othello;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Board implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Player first;
	private Player second;
	private Player current;
	public Position [][] boardTile;
	private final int DIM = 8;
	private Scanner in;
	private boolean beenSet;
	

	public Board(Player p1, Player p2, int start) {
		this.current = p1;
		this.first = p1;
		this.second = p2;
		this.boardTile = new Position[8][8];
		initBoard();
		start = offsetBoard();
	}
	
	public Board(String save_file) {	
		
	}
	
	public void initBoard() {
		for (int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				boardTile[row][col] = new PlayablePosition(Position.EMPTY);
			}
		}
		boardTile[3][7].setPiece(UnplayablePosition.UNPLAYABLE);
		boardTile[4][7].setPiece(UnplayablePosition.UNPLAYABLE);
	}
	
	public void displayOffset() {
		char [][] offboard = new char[8][8];
		System.out.println("\nOption 1:\n");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int row = 0; row < 8; row++) {
			System.out.print(row + " ");
			for(int col = 0; col <8; col++) {
				offboard[row][col] = ' ';
				offboard[3][7] = '*';
				offboard[4][7] = '*';
				offboard[2][2] = 'W';
				offboard[2][3] = 'B';
				offboard[3][2] = 'B';
				offboard[3][3] = 'W';
				System.out.print(offboard[row][col] +" ");
			}
			System.out.println();
		}
		System.out.println("\nOption 2:\n");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int row = 0; row < 8; row++) {
			System.out.print(row + " ");
			for(int col = 0; col <8; col++) {
				offboard[row][col] = ' ';
				offboard[3][7] = '*';
				offboard[4][7] = '*';
				offboard[4][2] = 'W';
				offboard[4][3] = 'B';
				offboard[5][2] = 'B';
				offboard[5][3] = 'W';
				System.out.print(offboard[row][col] +" ");
			}
			System.out.println();
		}
		System.out.println("\nOption 3:\n");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int row = 0; row < 8; row++) {
			System.out.print(row + " ");
			for(int col = 0; col <8; col++) {
				offboard[row][col] = ' ';
				offboard[3][7] = '*';
				offboard[4][7] = '*';
				offboard[2][4] = 'W';
				offboard[2][5] = 'B';
				offboard[3][4] = 'B';
				offboard[3][5] = 'W';
				System.out.print(offboard[row][col] +" ");
			}
			System.out.println();
		}
		System.out.println("\nOption 4:\n");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int row = 0; row < 8; row++) {
			System.out.print(row + " ");
			for(int col = 0; col <8; col++) {
				offboard[row][col] = ' ';
				offboard[3][7] = '*';
				offboard[4][7] = '*';
				offboard[4][4] = 'W';
				offboard[4][5] = 'B';
				offboard[5][4] = 'B';
				offboard[5][5] = 'W';
				System.out.print(offboard[row][col] +" ");
			}
			System.out.println();
		}
		System.out.println("\nOption 5:\n");
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int row = 0; row < 8; row++) {
			System.out.print(row + " ");
			for(int col = 0; col <8; col++) {
				offboard[row][col] = ' ';
				offboard[3][7] = '*';
				offboard[4][7] = '*';
				offboard[3][3] = 'W';
				offboard[3][4] = 'B';
				offboard[4][3] = 'B';
				offboard[4][4] = 'W';
				System.out.print(offboard[row][col] +" ");
			}
			System.out.println();
		}
	}
	
	public int offsetBoard() {
		int value =0;
		in = new Scanner(System.in);
		boolean input = false;
		displayOffset();
		System.out.println("\nPlease Collectively Choose an Offset on the Board from 1-5");
		
		do {
			try {
				value = in.nextInt();
				
				switch(value) {
				case 1: 
					input = true;
					boardTile[2][2].setPiece(Position.WHITE);
					boardTile[2][3].setPiece(Position.BLACK);
					boardTile[3][2].setPiece(Position.BLACK);
					boardTile[3][3].setPiece(Position.WHITE);
					break;
					
				case 2:
					input = true;
					boardTile[4][2].setPiece(Position.WHITE);
					boardTile[4][3].setPiece(Position.BLACK);
					boardTile[5][2].setPiece(Position.BLACK);
					boardTile[5][3].setPiece(Position.WHITE);
					break;
					
				case 3: 
					input = true;
					boardTile[2][4].setPiece(Position.WHITE);
					boardTile[2][5].setPiece(Position.BLACK);
					boardTile[3][4].setPiece(Position.BLACK);
					boardTile[3][5].setPiece(Position.WHITE);
					break;
					
				case 4:
					input = true;
					boardTile[4][4].setPiece(Position.WHITE);
					boardTile[4][5].setPiece(Position.BLACK);
					boardTile[5][4].setPiece(Position.BLACK);
					boardTile[5][5].setPiece(Position.WHITE);
					break;
					
				case 5:
					input = true;
					boardTile[3][3].setPiece(Position.WHITE);
					boardTile[3][4].setPiece(Position.BLACK);
					boardTile[4][3].setPiece(Position.BLACK);
					boardTile[4][4].setPiece(Position.WHITE);
					break;
					
				default:
					input = false;
					System.out.println("Entered value is not an option. Try Again!");
					break;
				}
			}catch(InputMismatchException e) {
				in.next();
				System.out.println("Input must be an integer");
			}
		}while(!input);
		return value;
	}
	
	public void drawBoard() {
		System.out.println("  0 1 2 3 4 5 6 7");
		for(int row = 0; row < 8; row++) {
			System.out.print(row + " ");
			for(int col = 0; col <8; col++) {
				System.out.print(boardTile[row][col] +" ");
			}
			System.out.println();
		}
	}
	
	public void getScore() {
		int scoreB = 0;
		int scoreW = 0;
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col <8; col++) {
				if(boardTile[row][col].getPiece() == Position.BLACK) {
					scoreB++;
				}
				
				if(boardTile[row][col].getPiece() == Position.WHITE) {
					scoreW++;
				}
			}
		}
		System.out.println("\n" + this.first + "'s Points [BLACK]: " + scoreB + "\n" + this.second + "'s Points [WHITE]: " + scoreW);
		
		if(scoreB + scoreW == 62) {
			if(scoreB > scoreW) {
				System.out.println("Congrats " + this.first + " you are the Winner!");
			}
			else {
				System.out.println("Congrats " + this.second + " you are the Winner!");
			}
		}
	}
	
	public void play() {
		int option = 0;
		boolean validOption = false;
		for(int i =0; i <100; i++) {
			System.out.print("\n" +current +" it is now your turn. Please choose one of the following options"
					+ "\n1. Save the Game"
					+ "\n2. Concede"
					+ "\n3. Make a Move"
					+ "\nChosen Option: ");
			
			do {
				try {
					option = in.nextInt();
					if(option == 1) {
					save();
					validOption = true;
					System.exit(0);
					}
					
					else if(option == 2) {
						concede();
						validOption = true;
					}
					
					else if (option == 3) {
						drawBoard();
						getScore();
						takeTurn();
						drawBoard();
						validOption = true;
					}	
					
					else {
						System.out.println("Incorrect option Please try again!");
						validOption = false;
					}
					
				}catch(InputMismatchException e) {
					in.next();
					System.out.println("Input must be an Integer");
				}
					
			}while(!validOption);
		}
	}
		
	public static void load(String saved_file){
		Board b = null;
		
		try{
			FileReader fr = new FileReader(saved_file + ".txt");
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine() != null) {
				System.out.println(br.readLine());
			}
         br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
        Board load_board = new Board(saved_file);
       
	}
	
	private void save(){
		System.out.println("enter a filename to be saved as");
		String boardFile = in.next();
		Board b;
		
			File f = new File(boardFile + ".txt");
			if(f.exists()) {
				System.out.println("Do you want to delete the previously saved file to replace with this one Enter yes or no");
				String opt = in.next();
				if(opt.equals("yes")) {
					f.delete(); // deletes in order to save the current 
				}
				else {
					System.out.println("File already exists, Overriding as been Cancelled.");
				}
			}
			try{
				f.createNewFile(); 
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				System.out.println("File Created!");
				FileWriter fw = new FileWriter(f, true);
				BufferedWriter writer = new BufferedWriter(fw);
				writer.write("\nFirst Player: " +first.getName());
				writer.write("\n\nSecond Player: " + second.getName());
				writer.write("\n\nCurrent Player: " + current.getName());
				writer.close();
				System.out.println("File Saved");
			}catch(IOException e) {
				e.printStackTrace();
			}
	}

	private void concede() {
		System.out.println("\n" + current +" has decided to concede the game");
		if(current == first) {
			System.out.println(second + " has won the Game!");
		}
		else {
			System.out.println(first + " has won the Game!");
		}
		System.exit(0);
	}
	
	private void takeTurn() {
		in = new Scanner(System.in);
		boolean possibleTurn = false;
		
		do {
			System.out.println("\nPlease make a move for " + current + " [0-7], [0-7]");
			int x = in.nextInt();
			int y = in.nextInt();
			
			if((x < 0 || x >= 8) || (y < 0 || y >= 8)) {
				System.out.println("Please make a move between 0 and 7");
				possibleTurn = false;
			}
			else {
				if(boardTile[x][y].canPlay()) {
					boolean validPos = false;
					do {
					if(current == first) {
						if(checkDir(x, y, Position.WHITE)) {
							checkFlip(x,y,Position.WHITE, Position.BLACK);
							if(beenSet) {
								current = second;
								beenSet = false;
							}
						}
						
						else {
							System.out.println("Position is unplayable Try again");
						}
					}
					else {
						if(checkDir(x, y, Position.BLACK)) {
							checkFlip(x,y,Position.BLACK, Position.WHITE);
							if(beenSet) {
								current = first;	
								beenSet = false;
							}
						}
						
						else {
							System.out.println("Position is unplayable Try again");
						}
					}
					validPos = true;
					}while(!validPos);
				}
				
				else if(boardTile[x][y].getPiece() == Position.BLACK || boardTile[x][y].getPiece() == Position.WHITE) {
					System.out.println("This tile is unplayable because it has a piece on it");
					possibleTurn = false;
				}
				
				else {
					System.out.println("This tile is unplayable");
					possibleTurn = false;
				}
			}
			possibleTurn = true;
		}while (!possibleTurn);
	}
	
	// checks for if its a valid move
	public boolean checkDir(int x, int y, char oppPiece) {
		boolean check = false;
		  // checks down of the piece
		  if (x+1<8 && boardTile[x+1][y].getPiece()==oppPiece){ 
			  check=true;
		  }
		  // checks up of the piece
		  else if (x-1>-1 && boardTile[x-1][y].getPiece()==oppPiece) { 
			  check=true;
		    }
		  // checks right of the piece
		  else if (y+1<8 && boardTile[x][y+1].getPiece()==oppPiece){ 
			  check=true;
		    }
		  // checks left of the piece
		  else if (y-1>-1 && boardTile[x][y-1].getPiece()==oppPiece){ 
			  check=true;
		    }
		  // checks diagonal left up side of the piece
		  else if (x-1>-1 && y-1>-1 && boardTile[x-1][y-1].getPiece()==oppPiece){ 
			  check=true;
		    }
		  // checks diagonal right up side of the piece
		  else if (x+1<8 && y-1>-1 && boardTile[x+1][y-1].getPiece()==oppPiece){ 
			  check=true;
		    }
		  // checks diagonal left down side of the piece
		  else if (x-1>-1 && y+1<8 && boardTile[x-1][y+1].getPiece()==oppPiece){ 
			  check=true;
		    }
		  // checks diagonal right down side of the piece
		  else if (x+1<8 && y+1<8 && boardTile[x+1][y+1].getPiece()==oppPiece){ 
			  check = true;
		  }
	    
		  else {
	    	check = false;
		  }
		  return check;
		}
	
	public void checkForPieceLeft(int x, int y, char oppPiece, char myPiece) {
		boolean validFlip = false;
		
		for(int i = y-1; i > -1; i--) {
			// confirms that there is an empty position  
			if(boardTile[x][i].getPiece() == Position.EMPTY) {	
				break;
			}
			// confirms that there is our piece  
			if(boardTile[x][i].getPiece() == myPiece) {
				validFlip = true;
				break;
			}
		}
		// confirms that there is our piece and then switches  
		if(validFlip) {
			for(int i = y-1; i > -1; i--) {
				if(boardTile[x][i].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[x][i].flip(x,y,oppPiece, myPiece);
			}
		}
	}
	
	public void checkForPieceRight(int x, int y, char oppPiece, char myPiece){
		boolean validFlip = false;
		
		for(int i = y+1; i < DIM ; i++) {
			// confirms that there is an empty position  
			if(boardTile[x][i].getPiece() == Position.EMPTY) {	
				break;
			}
			// confirms that there is our piece  
			if(boardTile[x][i].getPiece() == myPiece) {
				validFlip = true;
				break;
			}
		}
		// confirms that there is our piece and then switches  
		if(validFlip) {
			for(int i = y+1; i < DIM ; i++) {
				if(boardTile[x][i].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[x][i].flip(x,y,oppPiece, myPiece);
			}
		}
	}

	public void checkForPieceUp(int x, int y, char oppPiece, char myPiece){
		boolean validFlip = false;
		
		for(int i = x-1; i >-1; i--) {
			// confirms that there is an empty position  
			if(boardTile[i][y].getPiece() == Position.EMPTY) {	
				break;
			}
			// confirms that there is our piece  
			if(boardTile[i][y].getPiece() == myPiece) {
				validFlip = true;
				break;
			}
		}
		// confirms that there is our piece and then switches  
		if(validFlip) {
			for(int i = x-1; i >-1; i--) {
				if(boardTile[i][y].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[i][y].flip(x,y,oppPiece, myPiece);
			}
		}
	}

	public void checkForPieceDown(int x, int y, char oppPiece, char myPiece){
		boolean validFlip = false;
		
		for(int i = x+1; i < DIM; i++) {
			// confirms that there is an empty position  
			if(boardTile[i][y].getPiece() == Position.EMPTY) {	
				break;
			}
			// confirms that there is our piece  
			if(boardTile[i][y].getPiece() == myPiece) {
				validFlip = true;
				break;
			}
		}
		// confirms that there is our piece and then switches  
		if(validFlip) {
			for(int i = x+1; i < DIM; i++) {
				if(boardTile[i][y].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[i][y].flip(x,y,oppPiece, myPiece);
			}
		}
	}
	
	public void checkLeftTopDiagonal(int x, int y, char oppPiece, char myPiece) {
		boolean validFlip = false;
		for(int i = x - 1, j = y - 1; i>-1 && j>-1; i--, j--) {
				if(boardTile[i][j].getPiece() == Position.EMPTY) {	
					break;
				}
				// confirms that there is our piece  
				if(boardTile[i][j].getPiece() == myPiece) {
					validFlip = true;
					break;
			}
		}
		if(validFlip) {
			for(int i = x - 1, j = y - 1; i>-1 && j>-1; i--, j--) {
				if(boardTile[i][j].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[i][j].flip(x,y,oppPiece, myPiece);
			}
		}
	}

	public void checkRightTopDiagonal(int x, int y, char oppPiece, char myPiece) {
		boolean validFlip = false;
		for(int i = x - 1, j = y + 1; i>-1 && j<8; i--, j++) {
				if(boardTile[i][j].getPiece() == Position.EMPTY) {	
					break;
				}
				// confirms that there is our piece  
				if(boardTile[i][j].getPiece() == myPiece) {
					validFlip = true;
					break;
			}
		}
		if(validFlip) {
			for(int i = x - 1, j = y + 1; i>-1 && j<8; i--, j++) {
				if(boardTile[i][j].getPiece() == myPiece) {
						break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[i][j].flip(x,y,oppPiece, myPiece);
			}
		}
	}
	
	public void checkRightBottomDiagonal(int x, int y, char oppPiece, char myPiece) {
		boolean validFlip = false;
		for(int i = x + 1, j = y + 1; i<DIM && j<DIM; i++, j++) {
			if(boardTile[i][j].getPiece() == Position.EMPTY) {	
				break;
				}
				// confirms that there is our piece  
			if(boardTile[i][j].getPiece() == myPiece) {
				validFlip = true;
				break;
			}
		}
		if(validFlip) {
			for(int i = x + 1, j = y + 1; i<DIM && j<DIM; i++, j++) {
				if(boardTile[i][j].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[i][j].flip(x,y,oppPiece, myPiece);
			}
		}
	}

	public void checkLeftBottomDiagonal(int x, int y, char oppPiece, char myPiece) {
		boolean validFlip = false;
		for(int i = x + 1, j = y - 1; i<DIM && j>-1; i++, j--) {
			if(boardTile[i][j].getPiece() == Position.EMPTY) {	
					break;
			}
			// confirms that there is our piece  
			if(boardTile[i][j].getPiece() == myPiece) {
				validFlip = true;
				break;
			}
		}
		if(validFlip) {
			for(int i = x + 1, j = y - 1; i<DIM && j>-1; i++, j--) {
				if(boardTile[i][j].getPiece() == myPiece) {
					break;
				}
				boardTile[x][y].setPiece(myPiece);
				beenSet = true;
				boardTile[i][j].flip(x,y,oppPiece, myPiece);
				}
			}
	}

	public void checkFlip(int x, int y, char oppPiece, char myPiece) {
		checkForPieceLeft(x, y, oppPiece, myPiece);
		checkForPieceRight(x, y, oppPiece, myPiece);
		checkForPieceUp(x, y, oppPiece, myPiece);
		checkForPieceDown(x, y, oppPiece, myPiece);
		checkLeftTopDiagonal(x, y, oppPiece, myPiece);
		checkRightTopDiagonal(x, y, oppPiece, myPiece);
		checkRightBottomDiagonal(x, y, oppPiece, myPiece);
		checkLeftBottomDiagonal(x, y, oppPiece, myPiece);
		
	}
	
}
