/**
 * @Author Anthony Amedome
 * this class reads the rules from a file
 */

import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class RuleProcess {

	private Queue<Player> playerList;
	private Dice dice;
	private Board board;
	
	public RuleProcess( Board b) {
		Scanner s = new Scanner(System.in);
		playerList = new LinkedList<Player>();
		joinPlayers(s);
		System.out.println("Do you want to create a new Dice? ");
		String die = s.next();
		if (die.equals("yes"))
			createDice(s);
		
		board = b;
		board.createBoard();
		
		
		s.close();
		
	}
	
	public void joinPlayers(Scanner ppl) {
		
		System.out.println("Add a new player?");
		String ans = ppl.next();
		while (ans.equals("yes")) {
			System.out.println("Enter Player name: ");
			playerList.add(new Player(ppl.next()));
			System.out.println("Add a new player?");
			ans = ppl.next();
			
		}
		
	}
	
	public void createDice(Scanner die) {

		System.out.println("You are now creating your dice \nPut in thte six nubers ou want on the dice \nNumber One: ");
		int d1 = die.nextInt();
		System.out.println("Number Two: ");
		int d2 = die.nextInt();
		System.out.println("Number Three: ");
		int d3 = die.nextInt();
		System.out.println("Number Four: ");
		int d4 = die.nextInt();
		System.out.println("Number Five: ");
		int d5 = die.nextInt();
		System.out.println("Number Six: ");
		int d6 = die.nextInt();
		
		dice = new Dice(d1,d2,d3,d4,d5,d6);
	}
	
	public static void main( String[] args ){
		RuleProcess game1 = new RuleProcess(new Board());
	}
	
	
	
}
