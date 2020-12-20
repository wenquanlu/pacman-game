package ghost;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Class type that represents relatively static objects in the game. 
 * (Wall,Fruit...)
 */
public class Cell {
    protected char code;
    protected boolean canMoveOn; 
    protected int x = 0;
    protected int y = 0;

    /**
     * @param x: x coordinate of the Cell (in unit of Cells)
     * @param y: y coordinate of the Cell (in unit of Cells)
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draw the image of the Cell to the app.
     * @param app: the game app.
     * @param sprite: the PImage of the Cell.
     */
    public void draw(PApplet app, PImage sprite) {

    }

    /**
     * Getter method for the code of the Cell in map.txt
     * @return char code: 
     * '0' for Empty cell
     * '1' for horizontal wall
     * '2' for vertical wall
     * '3' for up left corner
     * '4' for up right corner
     * '5' for down left corner
     * '6' for down right corner
     * '7' for Fruit
     * '8' for superFruit
     * 'p' for Waka starting position
     * 'a','c','i','w' for ambusher,chaser,ignorant,
     * whim starting positions.
     * 's' for soda can.
     */
    public char getCode() {
        return code;
    }

    /**
     * The method returns if the cell can be steped upon,
     * fruit, superfruit, soda can can be stepped upon/eaten.
     * The walls can't be.
     * @return boolean true if the cell can be eaten/steped, false
     * otherwise.
     */
    public boolean getMoveOn() {
        return canMoveOn;
    }

    /**
     * Some cells, like fruit, superfruit or soda can will be 
     * consumed as Waka going by. Calling update() modifies and
     * updates the cellMap 
     * @param cellMap, list of list of Cells
     */
    public void update(ArrayList<ArrayList<Cell>> cellMap) {

    }

    /**
     * @return x coordinate of the Cell in unit of pixel.
     */
    public int getX() {
        return x*16;
    }

    /**
     * @return y coordinate of the Cell in unit of pixel.
     */
    public int getY() {
        return y*16;
    }
}

    /*
        Non-public subclass Empty.
    */
class Empty extends Cell {
    char code ='0';
     
    //Empty Cells can be steped upon.    
    boolean canMoveOn = true;

    public Empty(int x, int y) {
        super(x,y);
    }
    @Override
    public void draw(PApplet app, PImage sprite) {
        return;
    }
    
    @Override
    public char getCode() {
        return code;
    }
    
    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
}

    /*
        Non-public subclass DownLeft
    */
class DownLeft extends Cell {
    char code = '5';
    
    //Wall can't be steped upon.
    boolean canMoveOn = false;

    public DownLeft(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
    

}

    /*
        Non-public subclass DownRight
    */
class DownRight extends Cell {
    char code = '6';

    //Wall can't be stepped upon.
    boolean canMoveOn = false;

    public DownRight(int x, int y) {
        super(x,y);
    }
    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }
    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
    
}

    /*
        Non-public subclass Fruit
    */
class Fruit extends Cell {
    char code = '7';

    //Fruit can be stepped on and eaten
    boolean canMoveOn = true;

    public Fruit(int x, int y) {
        super(x,y);
    }
    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }
    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }

    //Once eaten, update the fruit Cell to an empty cell.
    @Override
    public void update(ArrayList<ArrayList<Cell>> cellMap) {
        cellMap.get(this.y).set(x, new Empty(x,y));
    }
}

    /*
        Non-public subclass Horizontal
    */
class Horizontal extends Cell {
    char code = '1';

    //Wall can't be stepped upon.
    boolean canMoveOn = false;

    public Horizontal(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
    
}

    /*
        Non-public subclass UpLeft
    */
class UpLeft extends Cell {
    char code = '3';

    //Wall can't be stepped upon.
    boolean canMoveOn = false;
    public UpLeft(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
}

    /*
        Non-public subclass UpRight
    */
class UpRight extends Cell {
    char code = '4';

    //Wall can't be stepped upon.
    boolean canMoveOn = false;

    public UpRight(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
}

    /*
        Non-public subclass WakaStart
        It is not Waka, but a start position for Waka
    */
class WakaStart extends Cell {
    char code = 'p';

    //A position can be moved on.
    boolean canMoveOn = true;

    public WakaStart(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        return;
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
}

    /*
        Non-public subclass WakaStart
        It is not a Ghost, but a start position for Ghost
    */
class GhostStart extends Cell {
    char code = 'g';
    //A position can be moved on.
    boolean canMoveOn = true;
    
    public GhostStart(int x, int y,char type) { 
        super(x,y);
        this.code = type;
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        return;
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
}

    /*
        Non-public subclass Vertical
    */
class Vertical extends Cell {
    char code = '2';
    //Wall can't be stepped upon.
    boolean canMoveOn = false;
    public Vertical(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }
    
    @Override
    public char getCode() {
        return code;
    }

    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
}

    /*
        Non-public subclass SuperFruit
    */
class SuperFruit extends Cell {
    char code = '8';
    //SuperFruit can be stepped upon/eaten.
    boolean canMoveOn = true;
    public SuperFruit(int x, int y) {
        super(x,y);
    }
    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }
    @Override
    public char getCode() {
        return code;
    }
    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }
    //Once eaten, update the superfruit Cell to an empty cell.
    @Override
    public void update(ArrayList<ArrayList<Cell>> cellMap) {
        cellMap.get(this.y).set(x, new Empty(x,y));
    }
}

    /*
        Non-public subclass SodaCan
    */
class SodaCan extends Cell {
    char code = 's';
    //SodaCan can be stepped upon/eaten.
    boolean canMoveOn = true;
    public SodaCan(int x, int y) {
        super(x,y);
    }
    @Override
    public char getCode() {
        return code;
    }
    @Override
    public void draw(PApplet app, PImage sprite) {
        app.image(sprite,x*16,y*16);
    }
    
    @Override
    public boolean getMoveOn() {
        return canMoveOn;
    }

    //Once eaten, update the SodaCan to an empty cell.
    @Override
    public void update(ArrayList<ArrayList<Cell>> cellMap) {
        cellMap.get(this.y).set(x, new Empty(x,y));
    }

}