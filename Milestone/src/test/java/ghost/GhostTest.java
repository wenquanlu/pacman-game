package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;
import java.lang.Math;
public class GhostTest {
    @Test
    public void testIdenity() {
        Ghost x = new Ghost(1,2,3);
        assertNull(x.getIdentity());
    }
    @Test
    public void testGenerateClosest() {
        Ghost x = new Ghost(250, 219, 2);
        assertEquals(0, x.generateClosest(1,1));
        assertEquals(1, x.generateClosest(500,1));
        assertEquals(2, x.generateClosest(1,300));
        assertEquals(3, x.generateClosest(400,300));
        assertEquals(4, x.generateClosest(250,1));
        assertEquals(5, x.generateClosest(250,300));
        assertEquals(6, x.generateClosest(1,219));
        assertEquals(7, x.generateClosest(300,219));
        assertEquals(8, x.generateClosest(250,219));
        assertEquals(9, x.generateClosest(220,1));
        assertEquals(10, x.generateClosest(260,1));
        assertEquals(11, x.generateClosest(230,300));
        assertEquals(12, x.generateClosest(260,300));

    }

    @Test
    public void testMoveAccordingToClosest() {
        Setting set = new Setting();
        Ghost g = new Ghost(12,59,2);
        g.moveAccordingToClosest(set.getCellMap(),9);
        assertEquals(59,g.getY());
        assertEquals(10,g.getX());
        g.moveAccordingToClosest(set.getCellMap(),9);
        assertEquals(61,g.getY());
        assertEquals(10,g.getX());

        g = new Ghost(10,59,2);
        g.moveAccordingToClosest(set.getCellMap(),9);
        assertEquals(59,g.getY());
        assertEquals(12,g.getX());

        g = new Ghost(26 ,123, 2);
        g.moveAccordingToClosest(set.getCellMap(),9);
        assertEquals(24, g.getX());
        assertEquals(123,g.getY());

        g = new Ghost(410,59,2);
        g.moveAccordingToClosest(set.getCellMap(),0);
        assertEquals(408,g.getX());
        assertEquals(59,g.getY());

        g = new Ghost(410,75,2);
        g.moveAccordingToClosest(set.getCellMap(),0);
        assertEquals(410,g.getX());
        assertEquals(73,g.getY());


        g = new Ghost(234, 59,2);
        g.moveAccordingToClosest(set.getCellMap(),0);
        assertEquals(234,g.getX());
        assertEquals(61,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        assertEquals(410,g.getX());
        assertEquals(107,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),0);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),11);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),11);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());

        g = new Ghost(410,233,2);
        g.moveAccordingToClosest(set.getCellMap(),12);
        g.moveAccordingToClosest(set.getCellMap(),12);
        g.moveAccordingToClosest(set.getCellMap(),12);
        assertEquals(410,g.getX());
        assertEquals(231,g.getY());

        g = new Ghost(10,75,2);
        for (int i = 0; i < 8; i++) {
            g.moveAccordingToClosest(set.getCellMap(),1);
        }
        assertEquals(10,g.getX());
        assertEquals(59,g.getY());
        for (int i = 0; i < 96; i++) {
            g.moveAccordingToClosest(set.getCellMap(),1);
        }
        assertEquals(75,g.getY());
        assertEquals(186,g.getX());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),1);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),1);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());
        

        g = new Ghost(410,233,2);
        g.moveAccordingToClosest(set.getCellMap(),3);
        g.moveAccordingToClosest(set.getCellMap(),3);
        g.moveAccordingToClosest(set.getCellMap(),3);
        assertEquals(410,g.getX());
        assertEquals(231,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),10);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),10);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),9);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),9);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());

        g = new Ghost(44,507,2);
        g.moveAccordingToClosest(set.getCellMap(),2);
        assertEquals(42,g.getX());
        assertEquals(507,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),2);
        assertEquals(44,g.getX());
        assertEquals(507,g.getY());

        g = new Ghost(138,427,2);
        for (int i = 0; i < 48; i++) {
            g.moveAccordingToClosest(set.getCellMap(),2);
        }
        assertEquals(475,g.getY());
        assertEquals(186,g.getX());

        g = new Ghost(10,235,2);
        g.moveAccordingToClosest(set.getCellMap(),4);
        assertEquals(10,g.getX());
        assertEquals(233,g.getY());

        g = new Ghost(90,91,2);
        for (int i = 0; i < 16; i++) {
            g.moveAccordingToClosest(set.getCellMap(),4);
        }
        assertEquals(59,g.getY());
        assertEquals(90,g.getX());
        for (int i = 0; i < 8; i++) {
            g.moveAccordingToClosest(set.getCellMap(),4);
        }
        assertEquals(74,g.getX());
        assertEquals(59,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),4);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),4);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());


        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),5);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),5);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());

        g = new Ghost(44,507,2);
        g.moveAccordingToClosest(set.getCellMap(),6);
        assertEquals(42,g.getX());
        assertEquals(507,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),6);
        assertEquals(44,g.getX());
        assertEquals(507,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),7);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),7);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());

        g = new Ghost(44,507,2);
        g.moveAccordingToClosest(set.getCellMap(),5);
        assertEquals(42,g.getX());
        assertEquals(507,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),5);
        assertEquals(44,g.getX());
        assertEquals(507,g.getY());


        g = new Ghost(10,75,2);
        for (int i = 0; i < 8; i++) {
            g.moveAccordingToClosest(set.getCellMap(),7);
        }
        assertEquals(10,g.getX());
        assertEquals(59,g.getY());
        for (int i = 0; i < 96; i++) {
            g.moveAccordingToClosest(set.getCellMap(),7);
        }
        assertEquals(75,g.getY());
        assertEquals(186,g.getX());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        g.moveAccordingToClosest(set.getCellMap(),7);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),7);
        assertEquals(410,g.getX());
        assertEquals(111,g.getY());

        g = new Ghost(410,59,2);
        g.moveAccordingToClosest(set.getCellMap(),6);
        assertEquals(408,g.getX());
        assertEquals(59,g.getY());

        g = new Ghost(410,75,2);
        g.moveAccordingToClosest(set.getCellMap(),6);
        assertEquals(410,g.getX());
        assertEquals(73,g.getY());


        g = new Ghost(234, 59,2);
        g.moveAccordingToClosest(set.getCellMap(),6);
        assertEquals(234,g.getX());
        assertEquals(61,g.getY());

        g = new Ghost(410, 109, 2);
        g.toUp(set.getCellMap());
        assertEquals(410,g.getX());
        assertEquals(107,g.getY());
        g.moveAccordingToClosest(set.getCellMap(),6);
        assertEquals(410,g.getX());
        assertEquals(109,g.getY());
    }

    @Test
    public void testGetFrightened() {
        Ghost g = new Ambusher(10,59,2);
        Setting set = new Setting();
        assertEquals(false, g.getFrightened());
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(g);
        ghosts.add(new Whim(10,75,2));
        ghosts.add(new Chaser(10,91,2));
        ghosts.add(new Ignorant(10,107,2));
        Waka waka = new Waka(204, 315, null, 2);
        waka.setEnableFrightenedMode(true);
        Ghost.ghostsMove(ghosts,set.getCellMap(),waka,"right");
        assertEquals(true, g.getFrightened());
    }

    @Test
    public void testWhimWithOutChaser() {
        Waka waka = new Waka(204, 315, null, 2);
        Ghost g = new Whim(10,75,2);
        Setting set = new Setting();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ignorant(10,107,2));
        ghosts.add(g);
        waka.setEnableFrightenedMode(true);
        Ghost.ghostsMove(ghosts,set.getCellMap(),waka,"right");
        assertTrue(g.getX()== 12||g.getX() == 10 || g.getX() == 8);
        assertTrue(g.getY()== 75|| g.getY() == 77 || g.getY() == 73);

    }

    @Test
    public void testWhimWithOutChaserNoFrightened() {
        Waka waka = new Waka(204, 315, null, 2);
        Ghost g = new Whim(10,75,2);
        Setting set = new Setting();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ignorant(10,107,2));
        ghosts.add(g);
        waka.setEnableFrightenedMode(false);
        Ghost.ghostsMove(ghosts,set.getCellMap(),waka,"right");
        assertTrue(g.getX() == 10);
        assertTrue(g.getY() == 77);
    }

    @Test
    public void testGoBack() {
        Ghost ambusher = new Ambusher(90,123,2);
        Setting set = new Setting();
        ambusher.toUp(set.getCellMap());
        ambusher.goBack();
        assertEquals(90,ambusher.getX());
        assertEquals(123,ambusher.getY());
        ambusher.toDown(set.getCellMap());
        ambusher.goBack();
        assertEquals(90,ambusher.getX());
        assertEquals(123,ambusher.getY());
        ambusher.toLeft(set.getCellMap());
        ambusher.goBack();
        assertEquals(90,ambusher.getX());
        assertEquals(123,ambusher.getY());
        ambusher.toRight(set.getCellMap());
        ambusher.goBack();
        assertEquals(90,ambusher.getX());
        assertEquals(123,ambusher.getY());

    }

    @Test
    public void testRandomMove() {
        Ghost ambusher = new Ambusher(90,123,2);
        Setting set = new Setting();
        ambusher.move(set.getCellMap());
        assertTrue((ambusher.getX()==92 || ambusher.getX() == 88 || ambusher.getX() == 90)
                && (ambusher.getY() == 125 || ambusher.getY() == 121 || ambusher.getY() == 123));
        
        for (int i = 0; i < 50; i++) {
            ambusher = new Ambusher(90,123,2);
            ambusher.move(set.getCellMap());
            assertTrue((ambusher.getX()==92 || ambusher.getX() == 88 || ambusher.getX() == 90)
                    && (ambusher.getY() == 125 || ambusher.getY() == 121 || ambusher.getY() == 123));
        }

        for (int i = 0; i<20; i++) {
            ambusher = new Ambusher(394,75,2);
            ambusher.move(set.getCellMap());
            assertTrue((ambusher.getX() == 394 || ambusher.getX() == 396 || ambusher.getX() == 394)
                    && (ambusher.getY() == 75 || ambusher.getY() == 77 || ambusher.getY() == 73));
        }

        for (int i = 0; i < 20; i++) {
            ambusher = new Ambusher(410,75,2);
            ambusher.move(set.getCellMap());
            assertTrue((ambusher.getX()==410 || ambusher.getX() == 408 || ambusher.getX() == 412)
                    && (ambusher.getY() == 75 || ambusher.getY() == 73 || ambusher.getY() == 77));
        }

        for (int i = 0; i < 30; i++) {
            ambusher = new Ambusher(410,75,2);
            ambusher.move(set.getCellMap());
            ambusher.move(set.getCellMap());
            ambusher.move(set.getCellMap());
            assertTrue((ambusher.getX() <= 416 && ambusher.getX() >= 404)
            && (ambusher.getY() <= 81 && ambusher.getY() >= 69));
        }
            
    }

    @Test
    public void testSodaGetter() {
        Ghost x = new Ghost(1,1,2);
        assertEquals(0,x.getSodaModePointer());
    }

    @Test
    public void testGhostEat() {
        Ghost ambusher = new Ambusher(410,75,2);
        ambusher.setFrightened(true);
        Ghost whim = new Whim(234, 59,2);
        whim.setFrightened(true);
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(whim);
        ghosts.add(ambusher);
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        Waka waka = new Waka(410,75,null,2);
        assertEquals(0, Ghost.ghostEat(ghosts,waka,app,3));
        app.delay(1000);
        app.noLoop();
    }

    @Test
    public void testGhostEatLiveOne() {
        Ghost ambusher = new Ambusher(410,75,2);
        Ghost whim = new Whim(234, 59,2);
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(whim);
        ghosts.add(ambusher);
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        Waka waka = new Waka(410,75,null,2);
        assertEquals(1, Ghost.ghostEat(ghosts,waka,app,1));
        app.delay(1000);
        app.noLoop();
    }

    
    @Test
    public void testCheckReverse() {
        Setting set = new Setting();
        Ghost ambusher = new Ambusher(100,100,2);
        Ghost whim = new Whim(20,20,2);
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(ambusher);
        ghosts.add(whim);
        Ghost.setIJPointers(0,0);
        Ghost.checkReverse(ghosts,set.getModeLengths(),false);
        Ghost.checkReverse(ghosts,set.getModeLengths(),false);
        assertEquals(2,Ghost.getIJPointers()[0]);
        assertEquals(0,Ghost.getIJPointers()[1]);
        Ghost.checkReverse(ghosts,set.getModeLengths(),true);
        assertEquals(0,Ghost.getIJPointers()[1]);
        assertEquals(2,Ghost.getIJPointers()[0]);
        for (int i = 0; i < 598; i++) {
            Ghost.checkReverse(ghosts,set.getModeLengths(),false);
        }
        assertEquals(0,Ghost.getIJPointers()[0]);
        assertEquals(1,Ghost.getIJPointers()[1]);
        for (int i = 0; i < 1020; i++) {
            Ghost.checkReverse(ghosts,set.getModeLengths(),false);
        }
        assertEquals(0,Ghost.getIJPointers()[0]);
        assertEquals(0,Ghost.getIJPointers()[1]);
    }

    @Test 
    public void checkUnimplementedSuperClassMethod() {
        Ghost g = new Ghost(1,2,2);
        Setting set = new Setting();
        int xi = g.getX();
        int yi = g.getY();
        g.move(set.getCellMap(),1,2,"right",true);
        g.move(set.getCellMap(),1,2,"right",true);
        g.move(set.getCellMap(),1,2,"right",true);
        g.move(set.getCellMap(),1,2,"right",true);
        g.move(set.getCellMap(),1,2,"right",true);
        assertEquals(xi,g.getX());
        assertEquals(yi,g.getY());
        g.move(set.getCellMap(),3,4,false);
        g.move(set.getCellMap(),3,4,false);
        g.move(set.getCellMap(),5,6,false);
        assertEquals(xi,g.getX());
        assertEquals(yi,g.getY());
        g.move(set.getCellMap(),2,3,"right",4,5,false);
        g.move(set.getCellMap(),2,3,"right",4,5,false);
        g.move(set.getCellMap(),2,3,"right",4,5,false);
        assertEquals(xi,g.getX());
        assertEquals(yi,g.getY());

    }

}