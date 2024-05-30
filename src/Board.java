import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;

public class Board extends ArrayList<Space> {
    private int spaceCount;
    private int vertSpace;
    private int horizontalSpace;
    private String title;
    
    public Board() {
    	this("regular");
    	//finish adding all the regular monopoly board spaces
    }
    
    public Board(String s) {
    	super(40);
    	this.add(0, new Space(SpaceType.FREE_SPACE, "GO",0,0,Color.WHITE));
    	this.add(1, new Space(SpaceType.PROPERTY, "Mediterrainean Ave",250,60,new Color(244,70,70)));
    	this.add(2, new Space(SpaceType.CHANCE, "Community Chest",0,0,Color.WHITE));
    	this.add(3, new Space(SpaceType.PROPERTY, "Baltic Ave",450,60,new Color(244,70,70)));
    	this.add(4, new Space(SpaceType.TAX, "Income tax", 200, 0, Color.WHITE));
    	this.add(5, new Space(SpaceType.PROPERTY, "Reading Railroad", 50, 200,Color.WHITE));
    	this.add(6, new Space(SpaceType.PROPERTY, "Oriental Ave", 550, 100,new Color(0,70,244)));
    	this.add(7, new Space(SpaceType.CHANCE, "Chance", 0, 0, Color.WHITE));
    	this.add(8, new Space(SpaceType.PROPERTY, "Vermont Ave", 550, 100, new Color(0,70,244)));
    	this.add(9, new Space(SpaceType.PROPERTY, "Connecticut Ave", 550, 100,new Color(0,70,244)));
    	this.add(10, new Space(SpaceType.FREE_SPACE, "Jail", 0, 0, Color.WHITE));
    	this.add(11, new Space(SpaceType.PROPERTY, "St. Charles Place", 600, 140,Color.PINK));
    	this.add(12, new Space(SpaceType.PROPERTY, "Electric Company", 150, 150, Color.WHITE));
    	this.add(13, new Space(SpaceType.PROPERTY, "States Ave", 600, 140,Color.PINK));
    	this.add(14, new Space(SpaceType.PROPERTY, "Virginia Ave", 650, 160, Color.PINK));
    	this.add(15, new Space(SpaceType.PROPERTY, "Pennsylvania Railroad", 50, 200, Color.WHITE));
    	this.add(16, new Space(SpaceType.PROPERTY, "St. James Place", 700, 180, Color.ORANGE));
    	this.add(17, new Space(SpaceType.CHANCE, "Community Chest", 0, 0,Color.WHITE));
    	this.add(18, new Space(SpaceType.PROPERTY, "Tennessee Ave", 750, 180,Color.ORANGE));
    	this.add(19, new Space(SpaceType.PROPERTY, "New York Ave", 800, 200,Color.ORANGE));
    	this.add(20, new Space(SpaceType.FREE_SPACE, "Free Parking", 0, 0,Color.WHITE));
    	this.add(21, new Space(SpaceType.PROPERTY, "Kentucky Ave", 850, 220,Color.RED));
    	this.add(22, new Space(SpaceType.CHANCE, "Chance", 0, 0,Color.WHITE));
    	this.add(23, new Space(SpaceType.PROPERTY, "Indiana Ave", 850, 220,Color.RED));
    	this.add(24, new Space(SpaceType.PROPERTY, "Illinois Ave", 900, 240, Color.RED));
    	this.add(25, new Space(SpaceType.PROPERTY, "B. & O. Railroad", 50, 200, Color.WHITE));
    	this.add(26, new Space(SpaceType.PROPERTY, "Atlantic Ave", 950, 260,Color.YELLOW));
    	this.add(27, new Space(SpaceType.PROPERTY, "Ventnor Ave", 950, 260,Color.YELLOW));
    	this.add(28, new Space(SpaceType.PROPERTY, "Water Works", 150, 150,Color.WHITE));
    	this.add(29, new Space(SpaceType.PROPERTY, "Marvin Gardens", 1000, 280,Color.YELLOW));
    	this.add(30, new Space(SpaceType.FREE_SPACE, "Go to Jail", 0, 0,Color.WHITE));
    	this.add(31, new Space(SpaceType.PROPERTY, "Pacific Ave", 1050, 300,Color.GREEN));
    	this.add(32, new Space(SpaceType.PROPERTY, "North Carolina Ave", 1050, 300, Color.GREEN));
    	this.add(33, new Space(SpaceType.CHANCE, "Community Chest", 0, 0, Color.WHITE));
    	this.add(34, new Space(SpaceType.PROPERTY, "Pennsylvania Ave", 1100, 320, Color.GREEN));
    	this.add(35, new Space(SpaceType.PROPERTY, "Short Line", 50, 200, Color.WHITE));
    	this.add(36, new Space(SpaceType.CHANCE, "Chance", 0, 0, Color.WHITE));
    	this.add(37, new Space(SpaceType.TAX, "Luxury Tax", 75, 0, Color.WHITE));
    	this.add(38, new Space(SpaceType.PROPERTY, "Park Place", 1200, 350,Color.BLUE));
    	this.add(39, new Space(SpaceType.PROPERTY, "Boardwalk", 1400, 400, Color.BLUE));
    	if (s.equals("regular")) {
    		spaceCount = 40;
    		
    		
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
    				//editing = false;
    				break;
    			}
    			System.out.println("Which space (enter a number)"); 
    			editSpace( input.nextInt(), input);

    		}
    		input.close();
    		
    	}
    }
    
    
    public void editSpace(int spaceNumber, Scanner input) {
    	
		System.out.println("Please add the Space information for space (Please enter  space type in all caps)");
		System.out.println("What is the name of the " + spaceNumber + "nd space");
		String spaceName = input.next();
		System.out.println("What type of space will it be (TAX, FREE_SPACE, PROPERTY, CHANCE, INCOME");
		String spaceType = input.next();
		
		switch (spaceType) {
		case "TAX": 
			System.out.println("How much should it charge");
			int r = input.nextInt();
			this.set(spaceNumber, new Space( SpaceType.TAX , spaceName, r, 0, Color.WHITE));
			break;
		case "FREE_SPACE":
			System.out.println("ok");
			break;
		case "PROPERTY":
			System.out.println("How much should it charge");
			int rent = input.nextInt();
			System.out.println("How much should it cost to buy");
			int p = input.nextInt();
			//add way to change color later
			this.set(spaceNumber, new Space( SpaceType.TAX , spaceName, rent, p, Color.WHITE));
			break;
		case "CHANCE":
			System.out.println("ok");
			break;
		case "INCOME":
			System.out.println("How much should it give you");
			int reward = input.nextInt();
			this.set(spaceNumber, new Space( SpaceType.TAX , spaceName, reward, 0, Color.WHITE));
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
    
    public void createBoard() {
    	
    	JFrame frame = new JFrame("Monopoly Board");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(1000, 5000);       
    	
    	frame.add(new MonopolyBoard(this));
    	frame.setVisible(true);
    }
    
}

class MonopolyBoard extends JPanel {
    private Board spaces;

    public MonopolyBoard(Board b) {
       spaces=b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        this.setBackground(Color.LIGHT_GRAY);
        
    }

    public void drawBoard(Graphics g) {
        int spaceWidth = 200; 
        int horizontalSpace = 50; 

        for (Space s : spaces) {
        	g.setColor(s.getColor());
            int x = 0; 
            int y = ((spaces.size()/4)*50)- (spaces.indexOf(s) * horizontalSpace);
            
            if (spaces.indexOf(s) > spaces.size()/4 && spaces.indexOf(s) <= spaces.size()/2) {
            	x = (((spaces.size()/2 - spaces.size()/4)*100) - ((spaces.indexOf(s)- spaces.size()/4)*200));
            	y = ((spaces.size()/4)*50)-(spaces.size()/4*horizontalSpace);	
            }
            
            if (spaces.indexOf(s) > spaces.size()/2 && spaces.indexOf(s) < (spaces.size()/4) *3) {
            	x = (spaces.size()/2 - spaces.size()/4) * spaceWidth;
            	y = spaces.indexOf(s) * spaceWidth;
            	
            }
            
            if (spaces.indexOf(s) > (spaces.size()/4) *3) {
            	x = 1000 - (spaces.indexOf(s) - (spaces.size()/4) *3);
            }
            
            
            // Draw the rectangle for each space
            g.drawRect(x, y, spaceWidth, horizontalSpace);

            // Draw the name of the space
            g.drawString(s.getName(), x + 10, y + 20);
        }
    }
}
