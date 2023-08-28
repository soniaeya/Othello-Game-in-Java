package othello;

public class PlayablePosition extends Position{
	
	public PlayablePosition(char piece) {
		super(piece);
	}

	@Override
	public boolean canPlay() {
		return (getPiece()==Position.EMPTY);
	}
	
}
