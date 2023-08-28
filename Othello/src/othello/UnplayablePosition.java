package othello;

public class UnplayablePosition extends Position{

	public static final char UNPLAYABLE = '*';
	
	public UnplayablePosition(char piece) {
		super(UNPLAYABLE);
	}

	@Override
	public boolean canPlay() {
		return (getPiece()==UNPLAYABLE);
	}

}
