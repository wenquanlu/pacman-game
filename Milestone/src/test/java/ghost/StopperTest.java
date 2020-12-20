package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;

public class StopperTest extends PApplet{

    @Test
    public void testNotLose() {
        Stopper s = new Stopper();
        Setting set = new Setting();
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        assertEquals(0, s.stopLose(set, app, app.getFonts()));
        app.delay(2000); // Wait for assets to be loaded in
        app.noLoop();
    }

    @Test
    public void testStopLose() {
        Stopper s = new Stopper();
        s.setStopCounter(600);
        Setting set = new Setting();
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        assertEquals(5, s.stopLose(set, app, app.getFonts()));
        app.delay(1000); // Wait for assets to be loaded in
        app.noLoop();
    }

    @Test
    public void testNotWin() {
        Stopper s = new Stopper();
        Setting set = new Setting();
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        assertEquals(false, s.stopWin(app, app.getFonts()));
        app.delay(1000); // Wait for assets to be loaded in
        app.noLoop();
    }


    @Test
    public void testStopWin() {
        Stopper s = new Stopper();
        s.setStopCounter(600);
        Setting set = new Setting();
        App app = new App();
        PApplet.runSketch(new String[] {""}, app);
        app.setup();
        assertEquals(true, s.stopWin(app, app.getFonts()));
        app.delay(1000); // Wait for assets to be loaded in
        app.noLoop();
    }

}