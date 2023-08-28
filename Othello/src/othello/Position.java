package othello;

public abstract class Position {
	
private char piece;
	
	public static final char EMPTY = ' ';
	public static final char BLACK = 'B';
	public static final char WHITE = 'W';
	
	public abstract boolean canPlay();
	
	public Position(char piece) {
		this.piece = piece;
	}
	
	public char getPiece() {
		return piece;
	}

	public void setPiece(char piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		return piece + "";
	}
	
	public void flip(int x, int y, char oppPiece, char myPiece) {
		if(getPiece() == oppPiece) {
			setPiece(myPiece);
		}
	}
	
}

