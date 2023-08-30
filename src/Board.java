import java.util.ArrayList;


public class Board extends ArrayList<Space> {
    private int spaceCount;
    private int vertSpace;
    private int horizontalSpace;
    
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
