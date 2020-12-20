package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;

class SettingTest {
    Setting set = new Setting();
    @Test 
    public void existTest() {
        assertNotNull(set);
    }
    @Test
    public void testSpeed() {
        assertEquals(2, set.getSpeed());
    }
    @Test
    public void testLives() {
        assertEquals(5, set.getLives());
    }

    @Test
    public void testInitialiseGhost() {
        ArrayList<Ghost> ghosts = set.initialiseGhost(null,null,null,null,null,null,null, set.getfrightenedLength());
        assertTrue(ghosts.get(0) instanceof Ambusher);
        assertTrue(ghosts.get(1) instanceof Chaser);
        assertTrue(ghosts.get(2) instanceof Ignorant);
        assertTrue(ghosts.get(3) instanceof Whim);
    }

    @Test
    public void testGetFrightenedLength() {
        assertEquals(4,set.getfrightenedLength());
    }

    @Test
    public void testParseCells() {
        set.parseSetting();
        ArrayList<ArrayList<Cell>> map = set.getCellMap();
        assertTrue(map.get(0).get(0) instanceof Empty);
        assertTrue(map.get(1).get(1) instanceof Empty);
        assertTrue(map.get(3).get(0) instanceof DownRight);
        assertTrue(map.get(4).get(2) instanceof Fruit);
        assertTrue(map.get(6).get(7) instanceof Vertical);
        assertTrue(map.get(9).get(5) instanceof DownLeft);
        assertTrue(map.get(18).get(0) instanceof UpRight);
        assertTrue(map.get(20).get(13) instanceof WakaStart);
        assertTrue(map.get(23).get(6) instanceof SuperFruit);
        assertTrue(map.get(26).get(14) instanceof SodaCan);
    }

    @Test
    public void testNotWin() {
        assertEquals(false, set.checkWin());
    }

    @Test
    public void testGetWakaStart() {
        int[] start = set.getWakaStart();
        assertEquals(13*16-4, start[0]);
        assertEquals(20*16-5, start[1]);
    }

    @Test
    public void testGetModeLengths() {
        JSONArray a = set.getModeLengths();
        assertEquals(10,a.getInt(0));
        assertEquals(5,a.getInt(1));
        assertEquals(2,a.getInt(2));
        assertEquals(10,a.getInt(3));
        //assertEquals(10,a.getInt(4));
    }
/*
    @Test
    public void testDrawCall() {
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.delay(1); // Wait for assets to be loaded in
        app.noLoop(); 
        int count = set.draw(app, set.getCellMap(), null, null, null, null
        ,null, null, null, null, null, null, 2);
        assertEquals(10,count);
    }
*/



}

