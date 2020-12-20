package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;

public class WakaTest {
    @Test
    public void testInitialise() {
        Waka waka = new Waka(1,2,null,2);
        assertNotNull(waka);
    }

    @Test
    public void testGetY() {
        Waka waka = new Waka(1,2,null,2);
        assertEquals(1,waka.getX());
    }

    @Test
    public void testGetX() {
        Waka waka = new Waka(1,2,null,2);
        assertEquals(2,waka.getY());
    }

    /*
    @Test 
    public void testDirection() {
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.delay(1000); // Wait for assets to be loaded in
        app.noLoop(); 
        Waka waka = app.getWaka();
    }
*/
    @Test
    public void testMove() {
        boolean movable = false;
        Setting set = new Setting();
        Waka waka = new Waka(204, 315, null, 2);
        movable = waka.move("right",set.getCellMap());
        assertEquals(true, movable);
        assertEquals(206, waka.getX());
        assertEquals(315, waka.getY());
        waka.move("right",set.getCellMap());
        waka.move("right",set.getCellMap());
        assertEquals(210,waka.getX());
        assertEquals(315,waka.getY());
        waka.move("left",set.getCellMap());
        waka.move("left",set.getCellMap());
        waka.move("left",set.getCellMap());
        assertEquals(204, waka.getX());
        assertEquals(315, waka.getY());
        movable = waka.move("up",set.getCellMap());
        assertEquals(204, waka.getX());
        assertEquals(315, waka.getY());
        assertEquals(false, movable);
        movable = waka.move("down",set.getCellMap());
        assertEquals(204, waka.getX());
        assertEquals(315, waka.getY());
        assertEquals(false, movable);
        for (int i = 0; i < 32; i++) {
            waka.move("left",set.getCellMap());
        }
        assertEquals(140, waka.getX());
        assertEquals(315,waka.getY());
        movable = waka.move("left",set.getCellMap());
        assertEquals(140,waka.getX());
        assertEquals(315,waka.getY());
        assertEquals(false, movable);
        movable = waka.move("up", set.getCellMap());
        assertEquals(true, movable);
        assertEquals(140,waka.getX());
        assertEquals(313,waka.getY());
        movable = waka.move("down", set.getCellMap());
        assertEquals(true, movable);
        assertEquals(140,waka.getX());
        assertEquals(315,waka.getY());
        waka.move("up",set.getCellMap());
        movable = waka.move("left",set.getCellMap());
        assertEquals(140,waka.getX());
        assertEquals(313,waka.getY());
        assertEquals(false,movable);
        movable = waka.move("right",set.getCellMap());
        assertEquals(140,waka.getX());
        assertEquals(313,waka.getY());
        assertEquals(false,movable);
        movable = waka.move(null, set.getCellMap());
        assertEquals(false, movable);
    }

    @Test
    public void MoveOnSuperFruitRight() {
        boolean movable = false;
        Setting set = new Setting();
        Waka waka = new Waka(76, 363, null, 2);
        movable = waka.move("right",set.getCellMap());
        assertEquals(78,waka.getX());
        assertEquals(363,waka.getY());
        for (int i = 0; i < 6; i++) {
            movable = waka.move("right",set.getCellMap());
        }
        assertEquals(90,waka.getX());
        assertEquals(363,waka.getY());
    }

    @Test
    public void MoveOnSuperFruitLeft() {
        boolean movable = false;
        Setting set = new Setting();
        Waka waka = new Waka(90, 363, null, 2);
        for (int i = 0; i < 6; i++) {
            movable = waka.move("left",set.getCellMap());
        }
        assertEquals(78,waka.getX());
        assertEquals(363,waka.getY());
    }

    @Test
    public void MoveOnSuperFruitDown() {
        boolean movable = false;
        Setting set = new Setting();
        Waka waka = new Waka(92, 353, null, 2);   
        for (int i = 0; i < 6; i++) {
            waka.move("down",set.getCellMap());
        }
        assertEquals(92,waka.getX());
        assertEquals(365,waka.getY());
        assertEquals(true, waka.getEnableFrightenedMode());
    }

    @Test
    public void MoveOnSuperFruitUp() {
        Setting set = new Setting();
        Waka waka = new Waka(92, 375, null, 2);   
        for (int i = 0; i < 6; i++) {
            waka.move("up",set.getCellMap());
        }
        assertEquals(92,waka.getX());
        assertEquals(363,waka.getY());
        assertEquals(true, waka.getEnableFrightenedMode());
    }

    @Test
    public void MoveOnSodaLeft() {
        Setting set = new Setting();
        Waka waka = new Waka(230, 411, null, 2);  
        for (int i = 0; i < 6; i++) {
            waka.move("left",set.getCellMap());
        }
        assertEquals(218,waka.getX());
        assertEquals(411,waka.getY());
        assertEquals(true, waka.getEnableSodaMode());
    }

    @Test
    public void MoveOnSodaRight() {
        Setting set = new Setting();
        Waka waka = new Waka(210, 411, null, 2);
        for (int i = 0; i < 6; i++) {
            waka.move("right",set.getCellMap());
        }  
        assertEquals(222,waka.getX());
        assertEquals(411,waka.getY());
        assertEquals(true, waka.getEnableSodaMode());
    }

    @Test
    public void MoveOnSodaUp() {
        Setting set = new Setting();
        Waka waka = new Waka(92, 305, null, 2);
        for (int i = 0; i < 6; i++) {
            waka.move("down",set.getCellMap());
        }  
        assertEquals(92,waka.getX());
        assertEquals(317,waka.getY());
        assertEquals(true, waka.getEnableSodaMode());
    }

    @Test 
    public void MoveOnSodaDown() {
        Setting set = new Setting();
        Waka waka = new Waka(92, 325, null, 2);
        for (int i = 0; i < 6; i++) {
            waka.move("up",set.getCellMap());
        }  
        assertEquals(92,waka.getX());
        assertEquals(313,waka.getY());
        assertEquals(true, waka.getEnableSodaMode());

    }

    @Test
    public void testMultipleFrightenedUp() {
        Setting set = new Setting();
        Waka waka = new Waka(12, 190, null, 2);
        for (int i = 0 ; i < 18; i++) {
            waka.move("up",set.getCellMap());
        }
        assertEquals(12,waka.getX());
        assertEquals(154,waka.getY());
        assertEquals(true, waka.getEnableFrightenedMode());
    }

    @Test
    public void testMultipleFrightenedDown() {
        Setting set = new Setting();
        Waka waka = new Waka(12, 154, null, 2);
        for (int i = 0 ; i < 18; i++) {
            waka.move("down",set.getCellMap());
        }
        assertEquals(12,waka.getX());
        assertEquals(190,waka.getY());
        assertEquals(true, waka.getEnableFrightenedMode());
    }

    @Test 
    public void testMultipleFrightenedRight() {
        Setting set = new Setting();
        Waka waka = new Waka(234, 507, null, 2);
        for (int i = 0 ; i < 58; i++) {
            waka.move("right",set.getCellMap());
        }
        assertEquals(350,waka.getX());
        assertEquals(507,waka.getY());
        assertEquals(true, waka.getEnableFrightenedMode());
    }

    @Test 
    public void testMultipleFrightenedLeft() {
        Setting set = new Setting();
        Waka waka = new Waka(350, 507, null, 2);
        for (int i = 0 ; i < 58; i++) {
            waka.move("left",set.getCellMap());
        }
        assertEquals(234,waka.getX());
        assertEquals(507,waka.getY());
        assertEquals(true, waka.getEnableFrightenedMode());
    }

    @Test
    public void leftEdgeCase() {
        Setting set = new Setting();
        Waka waka = new Waka(14, 363, null, 2); 
        boolean move = waka.move("left",set.getCellMap());
        assertEquals(true,move);
        move = waka.move("left",set.getCellMap());
        assertEquals(12,waka.getX());
        assertEquals(363,waka.getY());
    }

    @Test
    public void testSetGetSodaMode() {
        Waka waka = new Waka(92, 375, null, 2);   
        waka.setSodaMode(true);
        assertEquals(true, waka.getEnableSodaMode());
        waka.setSodaMode(false);
        assertEquals(false, waka.getEnableSodaMode());
    }

    @Test
    public void testSetGetFrightenedMode() {
        Waka waka = new Waka(92, 375, null, 2);   
        waka.setEnableFrightenedMode(true);
        assertEquals(true, waka.getEnableFrightenedMode());
        waka.setEnableFrightenedMode(false);
        assertEquals(false, waka.getEnableFrightenedMode());
    }

    @Test 
    public void testTimeFrightenedMultipleFrightened() {
        Setting set = new Setting();
        Waka waka = new Waka(350, 507, null, 2);
        for (int i = 0 ; i < 58; i++) {
            waka.move("left",set.getCellMap());
        }
        assertEquals(0, waka.timeFrightened(100, 50));
    }

    @Test
    public void testTimeFrightenedEnd() {
        boolean movable = false;
        Setting set = new Setting();
        Waka waka = new Waka(92, 353, null, 2);   
        for (int i = 0; i < 6; i++) {
            waka.move("down",set.getCellMap());
        }
        assertEquals(0, waka.timeFrightened(10,600));
    }

    @Test
    public void testTimeFrightenedOnceFrightened() {
        boolean movable = false;
        Setting set = new Setting();
        Waka waka = new Waka(92, 353, null, 2);   
        for (int i = 0; i < 6; i++) {
            waka.move("down",set.getCellMap());
        }
        assertEquals(61, waka.timeFrightened(10,60));
    }

    @Test
    public void testTimeFrightenedNotFrightened() {
        Setting set = new Setting();
        Waka waka = new Waka(204, 315, null, 2);
        waka.move("right",set.getCellMap());
        assertEquals(0, waka.timeFrightened(10,60));
    }

    @Test
    public void testWakaMoveCanMove() {
        Setting set = new Setting();
        Waka waka = new Waka(204, 315, null, 2);
        String result = waka.wakaMove("right","left",set.getCellMap()); 
        assertEquals("left",result);
    }

    @Test
    public void testWakaMoveCannotMove() {
        Setting set = new Setting();
        Waka waka = new Waka(204, 315, null, 2);
        String result = waka.wakaMove("right","up",set.getCellMap()); 
        assertEquals("right",result);
    }
}