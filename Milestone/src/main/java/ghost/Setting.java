package ghost;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.data.JSONObject;
public class Setting extends JSONObject {
    private String map = "";
    private int lives;
    private int speed;
    private JSONArray modeLengths;
    private ArrayList<ArrayList<Cell>> cellMap = new ArrayList<>();
    private int wakaStartX;
    private int wakaStartY;
    private int frightenedLength;
    private ArrayList<ArrayList<Integer>> ghostPositions = new ArrayList<>();
    /**
     * Constructor of Setting,
     * which calls two sub methods "parseSetting()" and "parseCell()" 
     * to parse game configuration and set up the game.
     */
    public Setting() {
        this.parseSetting();
        this.parseCells();
    }
    
    /**
     * This method parses lives, speed, map name, frightenedLength, modeLengths
     * from configuration file named "config.json"
     */
    public void parseSetting() {
        File f = new File("config.json");
        try {
            Scanner input = new Scanner(f);
            String s = "";
            while (input.hasNextLine()) {
                s += input.nextLine();
            }
            JSONObject jasonData = parse(s);
            this.lives = jasonData.getInt("lives");
            this.speed = jasonData.getInt("speed");
            this.map = jasonData.getString("map");
            this.frightenedLength = jasonData.getInt("frightenedLength");
            this.modeLengths = jasonData.getJSONArray("modeLengths");
        } catch (FileNotFoundException e) {
        }
    }

    /**
     * parse each grid on the map to a Cell object on a 2-D ArrayList 
     * "CellMap".
     * Note: Waka and Ghosts are not parsed as Cells, but their initial
     * positions will be registered in some Cells/Setting.
     */
    public void parseCells() {
        String path = map;
        File f = new File(path);
        int line = 0;
        try {
            Scanner input = new Scanner(f);
            int ghostcount = 0;
            int y = 0;
            while (input.hasNextLine())
            {
                ArrayList<Cell> temp = new ArrayList<>();
                char[] lineChar = input.nextLine().toCharArray();
                for (int i = 0; i < lineChar.length; i++) {
                    char thisCell = lineChar[i];
                    if (thisCell == '0') {
                        temp.add(new Empty(i,y));
                    } else if (thisCell == '1') {
                        temp.add(new Horizontal(i,y));
                    } else if (thisCell == '2') {
                        temp.add(new Vertical(i,y));
                    } else if (thisCell == '3') {
                        temp.add(new UpLeft(i,y));
                    } else if (thisCell == '4') {
                        temp.add(new UpRight(i,y));
                    } else if (thisCell == '5') {
                        temp.add(new DownLeft(i,y));
                    } else if (thisCell == '6') {
                        temp.add(new DownRight(i,y));
                    } else if (thisCell == '7') {
                        temp.add(new Fruit(i,y));
                    } else if (thisCell == '8') {
                        temp.add(new SuperFruit(i,y));
                    } else if (thisCell == 's') {
                        temp.add(new SodaCan(i,y));
                    } else if (thisCell == 'p') {
                        temp.add(new WakaStart(i,y));
                        wakaStartX = i*16-4;
                        wakaStartY = y*16-5;
                    } else if (thisCell == 'a'||thisCell == 'c' ||thisCell == 'i'||thisCell == 'w') {
                        temp.add(new GhostStart(i,y,thisCell));
                        ArrayList<Integer> coord = new ArrayList<>();
                        coord.add(i);
                        coord.add(y);
                        ghostPositions.add(coord);
                        ghostcount++;
                    }
                }
                cellMap.add(temp);
                y++;
            }
        
        } catch (FileNotFoundException e) { 
        }

    }
    /**
     * The method returns the start coordinate position of waka
     * as a array of size 2. (in unit of pixels)
     * @return int[] {x coordinate, y coordinate}
     */
    public int[] getWakaStart() {
        return new int[] {wakaStartX,wakaStartY};
    }

    /**
     * The method returns a 2-D ArrayList of parsed Cells.
     * @return list of list of Cells.
     */
    public ArrayList<ArrayList<Cell>> getCellMap() {
        return cellMap;
    }

    /**
     * @return configured speed of both Waka and Ghosts
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @return configured waka's number of lives
     */
    public int getLives() {
        return lives;
    }
    
    /**
     * @return A 2-D arrayList stores the x,y coordinates of Ghosts.
     * (in units of Cells)
     */
    public ArrayList<ArrayList<Integer>> getGhostPositions() {
        return ghostPositions;
    }

    /**
     * @return A JSONArray configuring the lengths of time for each game mode.
     */
    public JSONArray getModeLengths() {
        return modeLengths;
    }

    /**
     * The static method draws a static game board, where Waka and Ghosts travel in.
     */
    public static void draw(App app,ArrayList<ArrayList<Cell>> cellMap, PImage horizontalImg, PImage verticalImg,
    PImage upLeftImg, PImage upRightImg, PImage downLeftImg, PImage downRightImg, PImage fruitImg, 
    PImage playerRightImg,PImage superFruitImg,PImage sodaImg,int lives) {
        int count = 0;
        for (ArrayList<Cell> line : cellMap) {
            for (Cell eachCell: line) {
                if (eachCell.getCode() == '1') {
                    eachCell.draw(app,horizontalImg);
                } else if (eachCell.getCode() == '2') {
                    eachCell.draw(app,verticalImg);
                } else if (eachCell.getCode() == '3') {
                    eachCell.draw(app,upLeftImg);
                } else if (eachCell.getCode() == '4') {
                    eachCell.draw(app,upRightImg);
                } else if (eachCell.getCode() == '5') {
                    eachCell.draw(app,downLeftImg);
                } else if (eachCell.getCode() == '6') {
                    eachCell.draw(app,downRightImg);
                } else if (eachCell.getCode() == '7') {
                    eachCell.draw(app,fruitImg);
                } else if (eachCell.getCode() == '8') {
                    eachCell.draw(app,superFruitImg);
                } else if (eachCell.getCode() == 's') {
                    eachCell.draw(app,sodaImg);
                }
            }
        }
        int livePointer = 0;
        while (livePointer < lives) {
            app.image(playerRightImg,7+livePointer*26,545);
            livePointer+=1;
        }
    }

    /**
     * @param ambusherImg: PImage of the Ambusher Ghost.
     * @param chaserImg: PImage of the Chaser Ghost.
     * @param ignorantImg: PImage of the Ignorant Ghost.
     * @param whimImg: PImage of the Whim Ghost.
     * @param frightenedImg: PImage of frightened mode Ghost.
     * @param wavy1Img: PImage of invisible wavy state Ghost.
     * @param wavy2Img: PImage of invisible wavy state Ghost.
     * @param frightenedLength: length of specified frightened mode.
     * @return An ArrayList of all Ghosts in the game.
     * All Ghosts has their own pixel coordinates start position parsed in.
     */
    public ArrayList<Ghost> initialiseGhost(PImage ambusherImg,
    PImage chaserImg, PImage ignorantImg, PImage whimImg, PImage frightenedImg,PImage wavy1Img, PImage wavy2Img, int frightenedLength) {
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Ghost.setIJPointers(0,0);
        Ghost.setFrightenedModeLength(frightenedLength);
        for (int i = 0; i < this.getGhostPositions().size(); i++) {
            int x = this.getGhostPositions().get(i).get(0);
            int y = this.getGhostPositions().get(i).get(1);
            char code = cellMap.get(y).get(x).getCode();
            if (code == 'a') {
                ghosts.add(new Ambusher(x*16-6, y*16-5,ambusherImg, frightenedImg, wavy1Img, wavy2Img, this.getSpeed(), frightenedLength));
            } else if (code == 'c') {
                ghosts.add(new Chaser(x*16-6, y*16-5,chaserImg,frightenedImg,wavy1Img, wavy2Img, this.getSpeed(), frightenedLength));
            } else if (code == 'i') {
                ghosts.add(new Ignorant(x*16-6, y*16-5,ignorantImg,frightenedImg, wavy1Img, wavy2Img,this.getSpeed(), frightenedLength));
            } else if (code == 'w') {
                ghosts.add(new Whim(x*16-6, y*16-5,whimImg,frightenedImg,wavy1Img, wavy2Img, this.getSpeed(), frightenedLength));
            }
        }
        return ghosts;
    }

    /**
     * Getter method for frightenedLength
     * @return int length of frightened mode specified in configuration file.
     */
    public int getfrightenedLength() {
        return frightenedLength;
    }

    /**
     * The method scans for any presence of fruit or superfruit,
     * if Waka ate all the fruits and superfruits, it wins.
     * @return true if won, false if haven't won.
     */
    public boolean checkWin() {
        boolean win = true;
        for (ArrayList<Cell> line : cellMap) {
            for (Cell eachCell: line) {
                if (eachCell.getCode() == '7' || eachCell.getCode() == '8') {
                    win = false;
                    break;
                }
            }
            if (!win) {
                break;
            }
        }
        return win;
    }

}