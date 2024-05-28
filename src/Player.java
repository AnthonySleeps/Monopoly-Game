import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int order;
    int cash;
    private ArrayList<Space> ownedSpaces;
    private Space currentSpace;

    
    public Player(String n, int o){
        name = n;
        order = o;
        cash = 2500;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getOrder() {
        return order;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }
    
    public boolean buySpace() {
    	if (currentSpace.isOwned()) {
    		return false;
    	} else if(cash >= currentSpace.getPrice() && wantsToBuy()) {
    		cash -= currentSpace.getPrice();
    		currentSpace.setOwner(this);
    		return true;
    	}
    	return false;
    }
    
    public boolean wantsToBuy() {
    	Scanner askBuy = new Scanner(System.in);
    	System.out.println("do you want to purchase " + currentSpace + " ?" );
    	String answer = askBuy.next();
    	if (answer.equals("yes"))
    		return true;
    	
    	return false;
    }
}
