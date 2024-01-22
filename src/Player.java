import java.util.ArrayList;

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
    	if (currentSpace)
    }
}
