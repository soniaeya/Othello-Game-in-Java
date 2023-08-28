package othello;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	
	private Board board;
	private Scanner in;
	
	public Game(Player p1, Player p2) {
	}
	
	public void start() {
		in = new Scanner(System.in);
		int option =0;
		boolean validOption = false;
		System.out.print("Welcome To Othello Game\n"
				+ "\nPlease choose one of the following options"
				+ "\n1. Load a Game"
				+ "\n2. Quit"
				+ "\n3. Start a New Game "
				+ "\nChosen Option: ");
		
		do {
			try {
				option = in.nextInt();
				if(option == 1) {
					validOption = true;
					System.out.println("Please enter the name of the game file");
					String name = in.next();					
					Board.load(name);
				}
				
				if(option == 2) {
					validOption = true;
					System.out.println("Quitted the Game");
					System.exit(0);
				}
				
				if (option == 3) {
					validOption = true;
					System.out.print("\nNew Game Loaded \nPlease Enter both Player's names: ");
					String name1 = in.next();
					String name2 = in.next();
					System.out.println("Thank you " + name1 + ", you will have the Black Piece, therefore you will be playing the game with ASCII letter 'B' ");
					System.out.println("Thank you " + name2 + ", you will have the White Piece, therefore you will be playing the game with ASCII letter 'W' ");
					Player p1 = new Player(name1);
					Player p2 = new Player(name2);
					this.board = new Board(p1,p2,0);
					board.play();
				}	
				
				else {
					validOption = false;
					System.out.println("Incorrect option Please try again!");
				}
				
			}catch(InputMismatchException e) {
				in.next();
				System.out.println("Input must be an integer");
			}
			
		} while(!validOption);
	}
}
