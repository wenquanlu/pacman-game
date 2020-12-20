package ghost;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
public class Waka {
    private int x;
    private int y;
    private PImage sprite;
    private String direction;
    private PImage playerClosedImg;
    private PImage playerDownImg;
    private PImage playerRightImg;
    private PImage playerLeftImg;
    private PImage playerUpImg;
    private boolean open = false;
    private int speed;
    private int frame = 1;
    private boolean enableFrightenedMode = false;
    private boolean multipleFrightened = false;
    private boolean enableSodaMode = false;

    /**
     * Constructor for Waka
     * @param x: x coordinate in unit of pixels
     * @param y: y coordinate in unit of pixels
     * @param sprite: PImage of the waka
     * @param speed: Waka's speed
     */
    public Waka(int x, int y, PImage sprite,int speed) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.speed = speed;
    }

    /**
     * Getter method for waka's y coordinate in unit of pixels
     * @return int y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter method for waka's x coordinate in unit of pixels
     * @return int x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Draw waka in app.
     * @param app: game app
     * @param direction: "up" or "down" or "left" or "right"
     */
    public void draw(PApplet app, String direction) {
        if (!open) {
            app.image(this.playerClosedImg,this.x,this.y);
        } else {
            if (direction == "up") {
                app.image(this.playerUpImg,this.x,this.y);
            } else if (direction == "down") {
                app.image(this.playerDownImg,this.x,this.y);
            } else if (direction == "left") {
                app.image(this.playerLeftImg,this.x,this.y);
            } else if (direction == "right") {
                app.image(this.playerRightImg,this.x,this.y);
            } 
        }
        if (frame == 8) {
            reverseStatus();
            frame = 1;
        } else {
            frame += 1;
        }
    }

    /**
     * The method processes the raw direction input from the user, then
     * return the correct, adjusted input
     * @param inputKey: waka's direction at the moment.
     * @param temp_input: user's raw input.
     * @param cellMap: list of list of Cells.
     * @return final input.
     */
    public String wakaMove(String inputKey,String temp_input, ArrayList<ArrayList<Cell>> cellMap) {
        if (this.move(temp_input,cellMap)) {
            return temp_input;
        } else {
            this.move(inputKey,cellMap);
            return inputKey;
        }
    }

    /**
     * Through careful mathematical calculation, this method uses 4 points in the
     * direction of input to determine if the space ahead of waka is walkable, and whether
     * waka should follow the input direction.
     * @return true: Waka can move in the direction of input./false: Waka
     * Can't move in the direction of input.
     */
    public boolean move(String inputKey, ArrayList<ArrayList<Cell>> cellMap) {
        if (inputKey == null)
        {
            return false; 
        } else if (inputKey.equals("right")) {
            if ((cellMap.get((y+4)/16+1).get((x+4)/16+1).getMoveOn() 
            && cellMap.get((y-11)/16+1).get((x+4)/16+1).getMoveOn()) 
            || (cellMap.get((y+4)/16+1).get((x+19)/16+1).getMoveOn()
            && cellMap.get((y-11)/16+1).get((x+19)/16+1).getMoveOn())) {      
                this.x +=speed;
                Cell thisCell = cellMap.get((y+5+13)/16).get((x+1+4+12)/16);
                thisCell.update(cellMap);
                if (thisCell.getCode() == 's') {
                    enableSodaMode = true;
                }
                if (thisCell.getCode() == '8') {
                    if (enableFrightenedMode) {
                        enableFrightenedMode = true;
                        multipleFrightened = true;
                    } else {
                        enableFrightenedMode = true;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (inputKey.equals("left")) {
            if (x<=12) {
                    return false;
                }
            if ((cellMap.get((y+4)/16+1).get((x-13)/16+1).getMoveOn()
            && cellMap.get((y-11)/16+1).get((x-13)/16+1).getMoveOn())
            || (cellMap.get((y+4)/16+1).get((x-28)/16+1).getMoveOn()
            && cellMap.get((y-11)/16+1).get((x-28)/16+1).getMoveOn())) {
                this.x -=speed;
                Cell thisCell = cellMap.get((y+5+13)/16).get((x-1+4+6)/16);
                thisCell.update(cellMap);
                if (thisCell.getCode() == 's') {
                    enableSodaMode = true;
                }
                if (thisCell.getCode() == '8') {
                    if (enableFrightenedMode) {
                        enableFrightenedMode = true;
                        multipleFrightened = true;
                    } else {
                        enableFrightenedMode = true;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (inputKey.equals("up")) {
            if ((cellMap.get((y-27)/16+1).get((x+3)/16+1).getMoveOn()
            && cellMap.get((y-27)/16+1).get((x-12)/16+1).getMoveOn())
            || (cellMap.get((y-12)/16+1).get((x+3)/16+1).getMoveOn()
            && cellMap.get((y-12)/16+1).get((x-12)/16+1).getMoveOn())) {
                this.y -=speed;
                Cell thisCell = cellMap.get((y-1+5)/16).get((x+4+12)/16);
                thisCell.update(cellMap);
                if (thisCell.getCode() == 's') {
                    enableSodaMode = true;
                }
                if (thisCell.getCode() == '8') {
                    if (enableFrightenedMode) {
                        enableFrightenedMode = true;
                        multipleFrightened = true;
                    } else {
                        enableFrightenedMode = true;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if (inputKey.equals("down")) {
            if ((cellMap.get((y+5)/16+1).get((x+3)/16+1).getMoveOn()
            && cellMap.get((y+5)/16+1).get((x-12)/16+1).getMoveOn())
            || (cellMap.get((y+20)/16+1).get((x+3)/16+1).getMoveOn()
            && cellMap.get((y+20)/16+1).get((x-12)/16+1).getMoveOn())) {
                this.y +=speed;
                Cell thisCell = cellMap.get((y+1+5+13)/16).get((x+4+12)/16);
                thisCell.update(cellMap);
                if (thisCell.getCode() == 's') {
                    enableSodaMode = true;
                }
                if (thisCell.getCode() == '8') {
                    if (enableFrightenedMode) {
                        enableFrightenedMode = true;
                        multipleFrightened = true;
                    } else {
                        enableFrightenedMode = true;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * set Waka's PImage in different orientations.
     */
    public void setImgs(PImage playerClosedImg,PImage playerDownImg,PImage playerUpImg,
    PImage playerRightImg,PImage playerLeftImg) {
        this.playerClosedImg = playerClosedImg;
        this.playerDownImg = playerDownImg;
        this.playerUpImg = playerUpImg;
        this.playerRightImg = playerRightImg;
        this.playerLeftImg = playerLeftImg;
    }

    /**
     * reverse Waka's mouth opening status(close to open, open to close)
     */
    public void reverseStatus() {
        this.open = !open;
    }

    /**
     * Gatter method for frightened mode
     * @return enableFrightenedMode, true if the frightened mode is enabled.
     */
    public boolean getEnableFrightenedMode() {
        return enableFrightenedMode;
    }

    /**
     * Setter method for frightened mode.
     */
    public void setEnableFrightenedMode(boolean enableFrightenedMode) {
        this.enableFrightenedMode = enableFrightenedMode;
    }

    /**
     * this method controls the length of frightened mode from Waka's perspective,
     * Ghosts use this method, like listener, listening for the event happen in 
     * Waka's world, e.g. eating a superfruit. 
     * @param length: configured length of frightened mode.
     * @param frightenedModePointer: frightened mode pointer in Ghost
     * @return waka-updated frightened mode pointer.
     */
    public int timeFrightened(int length, int frightenedModePointer) {
        if (multipleFrightened) {
            multipleFrightened = false;
            return 0;
        }
        if (frightenedModePointer == length*60 && enableFrightenedMode) {
            this.setEnableFrightenedMode(false);
            return 0;
        }
        if (enableFrightenedMode) {
            frightenedModePointer++;
            return frightenedModePointer;
        } else {
            return 0;
        }
    }

    /**
     * Setter method for sodaMode.
     */
    public void setSodaMode(boolean mode) {
        enableSodaMode = mode;
    }
    /**
     * Getter method for sodaMode.
     */
    public boolean getEnableSodaMode() {
        return enableSodaMode;
    }

}