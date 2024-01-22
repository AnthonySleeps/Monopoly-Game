public class Space {
    private boolean owned; 
    private Player owner;
    private int price;
    private int rent;
    private SpaceType type;

    public Space(SpaceType t ,int p, int r, Player owner){
        switch(type) {
            case TAX:
                owned = true;
                price = 0;
                rent = r;
                break;
            case FREE_SPACE:
                owned = false;
                price = 0;
                rent = 0;
                break;
            case PROPERTY:
                if (owner == null) {
                    owned = false;
                    rent = 0;
                    price = p;
                } else {
                    owned = true;
                    rent = r;
                    price = 0;
                }
                break;
            case CHANCE:
                owned = false;
                price = 0;
                rent = 0;
                break;
            case INCOME: 
            	owned = false;
            	price = 0;
            	rent = r * -1;
            	
        }
    }


    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }
    
    public void setRent(int rent) {
        this.rent = rent;
    }

    public SpaceType getType() {
        return type;
    }

    public void setType(SpaceType type) {
        this.type = type;
    }


}
