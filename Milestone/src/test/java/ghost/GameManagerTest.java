package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import processing.data.JSONArray;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONArray;
import processing.core.PFont;

public class GameManagerTest {

    @Test
    public void testKeyPressedNormal() {
        assertEquals("right",GameManager.keyPressed(39));
        assertEquals("left",GameManager.keyPressed(37));
        assertEquals("up",GameManager.keyPressed(38));
        assertEquals("down",GameManager.keyPressed(40));
    }

    @Test
    public void testKeyPressedEdge() {
        assertEquals("",GameManager.keyPressed(32));

    }

    @Test
    public void testKeyPressedNegative() {
        assertEquals("",GameManager.keyPressed(29));
    }

    @Test
    public void testDebugPositive() {
        assertEquals(false, GameManager.debug(32, true));
        assertEquals(true, GameManager.debug(32, false));
    }

    @Test
    public void testDebugNegative() {
        assertEquals(false, GameManager.debug(30, false));
        assertEquals(true, GameManager.debug(39, true));
    }

    @Test
    public void simpleClass() {
        assertNotNull(new GameManager());
    }
}