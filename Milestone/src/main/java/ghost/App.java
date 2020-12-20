package ghost;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;
/**
 * The surface, packaging of the game, also the centre for communication between 
 * classes and objects.
 */
public class App extends PApplet {

    /**
     * The width of the game display. (in unit of pixels)
     */
    public static final int WIDTH = 448;

    /**
     * The height of the game display. (in unit of pixels)
     */
    public static final int HEIGHT = 576;
    private String inputKey,temp_input;
    private Waka waka; 
    private ArrayList<ArrayList<Cell>> cellMap;
    private JSONArray modelengths;
    private int lives;
    private ArrayList<Ghost> ghosts;
    private boolean debug = false;
    private PFont fonts;
    private Stopper stp = new Stopper();
    private Setting set;
    private PImage downLeftImg, downRightImg, fruitImg, horizontalImg, upLeftImg, upRightImg, sodaImg;
    private PImage verticalImg, playerClosedImg, playerDownImg, playerRightImg, playerLeftImg, wavy1Img, wavy2Img;
    private PImage playerUpImg, ambusherImg, chaserImg, ignorantImg, whimImg, superFruitImg, frightenedImg;
    /**
     * Class constructor.
     */
    public App() {
        set = new Setting();
        lives = set.getLives();
    }
    /**
     * Set up the game environment, including loading images, fonts, game objects and 
     * seting the frame rate.
     */
    public void setup() {
        this.stroke(255);
        frameRate(60);
        inputKey = "left";
        temp_input = "";
        modelengths = set.getModeLengths();
        waka = new Waka(set.getWakaStart()[0],set.getWakaStart()[1],this.loadImage("src/main/resources/playerClosed.png")
        ,set.getSpeed());
        cellMap = set.getCellMap();
        downLeftImg = this.loadImage("src/main/resources/downLeft.png");
        downRightImg = this.loadImage("src/main/resources/downRight.png");
        fruitImg = this.loadImage("src/main/resources/fruit.png");
        horizontalImg = this.loadImage("src/main/resources/horizontal.png");
        upLeftImg = this.loadImage("src/main/resources/upLeft.png");
        upRightImg = this.loadImage("src/main/resources/upRight.png");
        verticalImg = this.loadImage("src/main/resources/vertical.png");
        playerClosedImg = this.loadImage("src/main/resources/playerClosed.png");
        playerUpImg = this.loadImage("src/main/resources/playerUp.png");
        playerDownImg = this.loadImage("src/main/resources/playerDown.png");
        playerLeftImg = this.loadImage("src/main/resources/playerLeft.png");
        playerRightImg = this.loadImage("src/main/resources/playerRight.png");
        ambusherImg = this.loadImage("src/main/resources/ambusher.png");
        chaserImg = this.loadImage("src/main/resources/chaser.png");
        ignorantImg = this.loadImage("src/main/resources/ignorant.png");
        whimImg = this.loadImage("src/main/resources/whim.png");
        superFruitImg = this.loadImage("src/main/resources/superfruit.png");
        frightenedImg = this.loadImage("src/main/resources/frightened.png");
        wavy1Img = this.loadImage("src/main/resources/wavy1.png");
        wavy2Img = this.loadImage("src/main/resources/wavy2.png");
        sodaImg = this.loadImage("src/main/resources/soda.png");
        fonts = this.createFont("src/main/resources/PressStart2P-Regular.ttf",20);
        ghosts = set.initialiseGhost(ambusherImg,chaserImg,ignorantImg,whimImg,frightenedImg,wavy1Img,wavy2Img, set.getfrightenedLength());
        waka.setImgs(playerClosedImg,playerDownImg,playerUpImg,playerRightImg,playerLeftImg);
    }
    /**
     * Overriden method to call size().
     */
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    /**
     * This method draws the visual representation of the game, with most of the logic
     * processed by the other classes.
     */
    public void draw() { 
        if (lives != 0) {
            if (!set.checkWin()) {
                inputKey = waka.wakaMove(inputKey,temp_input,cellMap);
                Ghost.checkReverse(ghosts, modelengths,waka.getEnableFrightenedMode());
                Ghost.ghostsMove(ghosts,cellMap,waka,inputKey);
                this.rect(-1, -1, WIDTH+2, HEIGHT+2);
                background(0,0,0);
                Setting.draw(this, cellMap,horizontalImg,verticalImg,upLeftImg,upRightImg,
                downLeftImg,downRightImg,fruitImg,playerRightImg,superFruitImg,sodaImg,lives);
                this.waka.draw(this, inputKey);
                Ghost.ghostsDraw(this, ghosts,waka, debug);
                lives -= Ghost.ghostEat(ghosts,waka,this,lives);
            } else {
                if (stp.stopWin(this,fonts)) {
                    set = new Setting();
                    this.setup();
                }
            }
        } else {
            lives = stp.stopLose(set,this,fonts);
            if (lives != 0) {
                set = new Setting();
                this.setup();
            }
        }
    }
    /**
     * The keyPressed() method is called once every time a key is pressed. 
     * The key that was pressed is stored in the key variable: keyCode.
     * The keyCode is then passed on to GameManager class.
     */
    public void keyPressed() {
        temp_input = GameManager.keyPressed(keyCode);
        debug = GameManager.debug(keyCode,debug);
    }
    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }
    /**
     * This method is created merely for the purpose of testing,
     * so the testing program can acquire the font without loading them again.
     * @return PFont: font.
     */
    public PFont getFonts() {return fonts;} //for testing

    /**
     * This method is created merely for the purpose of testing,
     * so the testing program can take it as a stub for any place that requiares a
     * PImage.
     * @return PImage: a stub image.
     */
    public PImage getImageTestStub() {return fruitImg;} //for testing
}