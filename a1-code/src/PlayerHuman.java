import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Add Javadoc comments for this class and all its methods. (Task 3)
/**
 * A class to build a player, human can control the player's move through input
 * and Determine if the move is valid and put the pieces to this position to 
 * make the Move.
 * @author Junmin Fang
 *
 */
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;
	/**
	 * Initialize the game othello and player
	 * @param othello the game othello
	 * @param player P1 or P2
	 */
	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}
	/**
	 * according getMove()'s output to get a Move and move pieces to that position
	 * @return a move of P1 or P2 according person input in getMove() method
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}
	/**
	 * Return -1 if move is invalid and print error message by what exception happened
	 * return a integer that player input as a move (e.g: col or row that human input) if input is valid
	 * @param message
	 * @return a integer that player input as a move (e.g: col or row that human input) if input is valid
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
