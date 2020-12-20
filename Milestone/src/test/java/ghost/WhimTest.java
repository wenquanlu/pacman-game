package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;
public class WhimTest {
    @Test 
    public void testIdentity() {
        Setting set = new Setting();
        Whim w = new Whim(252, 219, 2);
        assertEquals("Whim",w.getIdentity());   
    }

    @Test 
    public void testMoveScatter() {
        Setting set = new Setting();
        Whim w = new Whim(250, 219, 2);
        w.move(set.getCellMap(),204,315,false);
        assertEquals(252,w.getX());
        assertEquals(219,w.getY());
        for (int i = 0; i < 15; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(282,w.getX());
        assertEquals(219,w.getY());
        for (int i = 0; i < 72; i ++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(282,w.getX());
        assertEquals(363,w.getY());
        //assertEquals(299,w.getY());
        /*
        for (int i = 0; i < 16; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(267,w.getY());
        for (int i = 0; i < 24; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(282,w.getX());
        assertEquals(315,w.getY());
        for (int i = 0; i < 48; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(true,w.getX()>282);
        assertEquals(411,w.getY());
        */

        /*
        assertEquals(267,w.getY());
        assertEquals(410,w.getX());
        for (int i = 0; i < 48; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(410, w.getX());
        assertEquals(171,w.getY());
        for (int i = 0; i < 40; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(330, w.getX());
        assertEquals(171,w.getY());
        for (int i = 0; i < 32; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(330, w.getX());
        assertEquals(235, w.getY());
        */
    }
    @Test 
    public void testMoveScatterSecond() {
        Setting set = new Setting();
        Whim w = new Whim(410, 507, 2);
        
        for (int i = 0 ; i < 88; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(507,w.getY());
        assertEquals(234,w.getX());
        for (int i = 0; i < 24; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(234,w.getX());
        assertEquals(459,w.getY());
    }
    @Test
    public void testScatterMove() {
        Setting set = new Setting();
        Whim w = new Whim(410, 507, 2);
        w.reverseMode();
        for (int i = 0 ; i < 88; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(507,w.getY());
        assertEquals(234,w.getX());
        for (int i = 0; i < 24; i++) {
            w.move(set.getCellMap(),204,315,false);
        }
        assertEquals(234,w.getX());
        assertEquals(459,w.getY());
    }

    @Test
    public void testNoScatterNoChaserMove() {
        Setting set = new Setting();
        Whim w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),448,576,false);
        assertEquals(252,w.getX());
        assertEquals(219,w.getY());
        for (int i = 0; i < 15; i++) {
            w.move(set.getCellMap(),448,576,false);
        }
        assertEquals(282,w.getX());
        assertEquals(219,w.getY());
        for (int i = 0; i < 72; i ++) {
            w.move(set.getCellMap(),448,576,false);
        }
        assertEquals(282,w.getX());
        assertEquals(363,w.getY());
    }

    @Test
    public void testVectorMoveScatter() {
        Setting set = new Setting();
        Whim w = new Whim(250, 219, 2);
        Waka waka = new Waka(204, 315, null, 2);
        w.move(set.getCellMap(),w.getX(),w.getY(),"left", 218, 219, false);
        assertEquals(252, w.getX());
    }

    @Test
    public void testVectorMoveNoScatter() {
        Setting set = new Setting();
        Whim w = new Whim(250, 219, 2);
        w.reverseMode();
        Waka waka = new Waka(204, 315, null, 2);
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left", 218, 219, false);
        assertEquals(248, w.getX());
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left",0,0,false);
        assertEquals(252, w.getX());
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left",448,500,false);
        assertEquals(248, w.getX());
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left",448,0,false);
        assertEquals(248, w.getX());
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left",0,576,false);
        assertEquals(252, w.getX());
        waka = new Waka(300, 315, null, 2);
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left",0,315,false);
        assertEquals(252, w.getX());

        waka = new Waka(300, 10, null, 2);
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),waka.getX(),waka.getY(),"left",300,500,false);
        assertEquals(248, w.getX());
      
        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),100,100,"up",100,100,false);
        assertEquals(248, w.getX());

        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),100,100,"down",100,100,false);
        assertEquals(248,w.getX());

        w = new Whim(250, 219, 2);
        w.reverseMode();
        w.move(set.getCellMap(),100,100,"right",100,100,false);
        assertEquals(248, w.getX());
        
    }
    
}