/**
 * @Author Anthony Amedome
 * this class reads the rules from a file
 */

import java.io.File;
import java.util.Scanner;
import java.util.PriorityQueue;

public class RuleProcess {

	private PriorityQueue playerList;
	
	public RuleProcess(int numPlayers, Dice dice, Board board) {
		playerList = new PriorityQueue<Player>(numPlayers);
		
	}
	
	
	
}
