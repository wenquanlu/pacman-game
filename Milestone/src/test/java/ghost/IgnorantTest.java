package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;

public class IgnorantTest {
    @Test
    public void testMoveAttracted() {
        Setting set = new Setting();
        Ignorant i = new Ignorant(234,219,2);
        i.reverseMode();
        i.move(set.getCellMap(), 236, 315,false);
        assertEquals(236,i.getX());
    }

    @Test
    public void testMoveNotAttracted() {
        Setting set = new Setting();
        Ignorant i = new Ignorant(234,219,2);
        i.reverseMode();
        i.move(set.getCellMap(), 400, 500,false);
        assertEquals(232,i.getX());
    }
/*
    @Test
    public void partialTestDraw() {
        Waka waka = new Waka(350, 507, null, 2);
        Ghost g = new Ignorant(10,59,2);
        Setting set = new Setting();
        assertEquals(false, g.getFrightened());
        ArrayList<Ghost> ghosts = new ArrayList<>();
        ghosts.add(g);
        waka.setEnableFrightenedMode(true);
        Ghost.ghostsMove(ghosts,set.getCellMap(),waka,"right");

        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        //Waka waka = new Waka(350, 507, null, 2);
        Ignorant i = new Ignorant(234, 219, 2);
        i.draw(app,app.getWaka());
        assertEquals(0,i.getSodaModePointer());
        app.delay(2000);
        app.noLoop();
    }
*/
}