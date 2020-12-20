package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;

public class AmbusherTest {
    @Test 
    public void testMoveRight() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),100,100,"right",false);
        assertEquals(164,a.getTargetX());
        assertEquals(100,a.getTargetY());
    }

    @Test
    public void testMoveRightEdge() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),384,100,"right",false);
        assertEquals(448,a.getTargetX());
        assertEquals(100,a.getTargetY());
    }

    @Test
    public void testMoveRightOut() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),420,100,"right",false);
        assertEquals(448,a.getTargetX());
        assertEquals(100,a.getTargetY());
    }

    @Test 
    public void testMoveLeft() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),120,100,"left",false);
        assertEquals(56,a.getTargetX());
        assertEquals(100,a.getTargetY());
    }

    @Test 
    public void testMoveLeftEdge() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),64,100,"left",false);
        assertEquals(0,a.getTargetX());
        assertEquals(100,a.getTargetY());
    }

    @Test 
    public void testMoveLeftOut() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),16,100,"left",false);
        assertEquals(0,a.getTargetX());
        assertEquals(100,a.getTargetY());
    }

    @Test
    public void testMoveUp() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),160,100,"up",false);
        assertEquals(160,a.getTargetX());
        assertEquals(36,a.getTargetY());
    }

    @Test
    public void testMoveUpEdge() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),160,64,"up",false);
        assertEquals(160,a.getTargetX());
        assertEquals(0,a.getTargetY());
    }

    @Test 
    public void testMoveUpOut() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),160,20,"up",false);
        assertEquals(160,a.getTargetX());
        assertEquals(0,a.getTargetY());
    }

    @Test
    public void testMoveDown() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),160,200,"down",false);
        assertEquals(160,a.getTargetX());
        assertEquals(264,a.getTargetY());
    }

    @Test
    public void testMoveDownEdge() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),160,512,"down",false);
        assertEquals(160,a.getTargetX());
        assertEquals(576,a.getTargetY());
    }

    @Test
    public void testMoveDownOut() {
        Setting set = new Setting();
        Ambusher a = new Ambusher(154,219,2);
        a.reverseMode();
        a.move(set.getCellMap(),160,550,"down",false);
        assertEquals(160,a.getTargetX());
        assertEquals(576,a.getTargetY());
    }
}