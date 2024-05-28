import java.util.ArrayList;
import java.util.Scanner;

public class Board extends ArrayList<Space> {
    private int spaceCount;
    private int vertSpace;
    private int horizontalSpace;
    private String title;
    
    public Board() {
    	super(40);
    	this.set(0, new Space(SpaceType.FREE_SPACE, "GO",0,0));
    	//finish adding all the regular monopoly board spaces
    }
    public Board(String s) {
    	if (s.equals("regular")) {
    		spaceCount = 40;
    		//figure out how to call super here 
    		
    	} else if (s.equals("new")) {
    		Scanner input = new Scanner(System.in);
    		System.out.println("How many spaces do you want in the board? If it is invalid this primpt will appear again");
    		int sc = input.nextInt();
    		while (!((sc - 4)%4 == 0)) {
    			System.out.println("How many spaces do you want in the board? If it is invalid this primpt will appear again");
        		sc = input.nextInt();
    		} 
    		spaceCount = sc;
    		
    		if (spaceCount > 40) {
    			for (int i = 41; i <= spaceCount; i++) {
    				editSpace(i,input);
    			}
    		}
    		
    		boolean editing = true;
    		while(editing) {
    			System.out.println("Do you want to change one of the default boards");
    			String choice = input.next();
    			if (choice.equals("no")) {
    				editing = false;
    				break;
    			}
    			System.out.println("Which space (enter a number)"); 
    			editSpace( input.nextInt(), input);

    		}
    		
    	}
    }
    
    
    public void editSpace(int spaceNumber, Scanner input) {
    	
		System.out.println("Please add the Space information for space (Please enter  space type in all caps)");
		System.out.println("What is the name of the " + spaceNumber + " st space");
		String spaceName = input.next();
		System.out.println("What type of space will it be (TAX, FREE_SPACE, PROPERTY, CHANCE, INCOME");
		String spaceType = input.next();
		
		switch (spaceType) {
		case "TAX": 
			System.out.println("How much should it charge");
			int r = input.nextInt();
			this.set(spaceNumber, new Space( SpaceType.TAX , spaceName, r, 0));
			break;
		case "FREE_SPACE":
			System.out.println("ok");
			break;
		case "PROPERTY":
			System.out.println("How much should it charge");
			int rent = input.nextInt();
			System.out.println("How much should it cost to buy");
			int p = input.nextInt();
			this.set(spaceNumber, new Space( SpaceType.TAX , spaceName, rent, p));
			break;
		case "CHANCE":
			System.out.println("ok");
			break;
		case "INCOME":
			System.out.println("How much should it give you");
			int reward = input.nextInt();
			this.set(spaceNumber, new Space( SpaceType.TAX , spaceName, reward, 0));
			break;
		}
    }
    
    
    public int getSpaceCount() {
        return spaceCount;
    }
    
    public Board(int x, int y, int c){
        horizontalSpace = x;
        vertSpace = y;
        spaceCount = c;
    }

    public void setSpaceCount(int spaceCount) {
        this.spaceCount = spaceCount;
    }

    public int getVertSpace() {
        return vertSpace;
    }

    public void setVertSpace(int vertSpace) {
        this.vertSpace = vertSpace;
    }

    public int getHorizontalSpace() {
        return horizontalSpace;
    }

    public void setHorizontalSpace(int horizontalSpace) {
        this.horizontalSpace = horizontalSpace;
    }
    
}
