import java.util.Random;
public class Dice{
	private int d1, d2, d3, d4, d5, d6;
	Random rand = new Random();
	public Dice(int n1, int n2, int n3, int n4, int n5, int n6) {
		d1 = n1;
		d2 = n2;
		d3 = n3;
		d4 = n4;
		d5 = n5;
		d6 = n6;
		}
	public int roll(){
		int rollInt = (rand.nextInt(6))+1;
		switch (rollInt) {
		case 1:return d1;
		case 2:return d2;
		case 3:return d3;
		case 4:return d4;
		case 5:return d5;
		case 6:return d6;
		}
		return 1;}
	}