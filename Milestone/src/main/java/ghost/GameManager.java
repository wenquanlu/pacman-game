package ghost;
import java.util.ArrayList;
import processing.core.PApplet;

/**
 * GameManager is a small helper (wrapper) class that does not have its own
 * instance method/attributes. 
 * Its whole functionality is processing key events, keycodes into 
 * understandable instruction.
 */
public class GameManager {

    /**
     * @param keyCode: int keyCode passed by the keyPressed method in App.
     * @return temp_input: stands for temporary/raw input in the form of
     * a String, "right","left","up","down".This temp_input will not be 
     * directly used by Waka.
     */
    public static String keyPressed(int keyCode) {
        String temp_input = "";
        if (keyCode == 39) { 
            temp_input = "right";
        } else if (keyCode == 37) { 
            temp_input = "left"; 
        } else if (keyCode == 38) { 
            temp_input = "up"; 
        } else if (keyCode == 40) { 
            temp_input = "down";
        }
        return temp_input;
    }

    /**
     * The method detects if the space bar is pressed.
     * @return true: the space bar is pressed, signalling starting the debug mode. 
     *  false: the space bar is not pressed.
     */
    public static boolean debug(int keyCode, boolean debug) {
        if (keyCode == 32) { 
            return !debug;
        } else {
            return debug;
        }

    }
}