package othello;

public class Driver {

	public static void main(String [] args) {
		Player p1 = new Player(null);
		Player p2 = new Player(null);
		Game g1 = new Game(p1, p2);
		
		g1.start();
	}
}
