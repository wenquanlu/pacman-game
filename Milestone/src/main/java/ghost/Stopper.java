package ghost;
import processing.core.PFont;
/**
 * Stopper class handles the continuation, visual representation of the game
 * when the game stops due to win or lose. It has an internal clock: a counter that
 * increments everytime stopLose or stopWin is called.
 */
public class Stopper {
    private int stopCounter = 0;

    /**
     * Setter method for the stopCounter
     * @param counter: sets the clock counter.
     * this method mainly serves for testing purpose.
     */
    public void setStopCounter(int counter) { stopCounter = counter; }

    /**
     * stopLose is called when the game is stopped due to lose.
     * It return lives to be 0 and draws "GAME OVER" screen
     * until the end of 10 seconds is reached.
     * @param set, a Setting object, used to provide initial number of 
     * lives for waka
     * @param app, the game app.
     * @param fonts, type of font used to display "GAME OVER"
     * @return lives of Waka
     */
    public int stopLose(Setting set, App app, PFont fonts) {
        if (stopCounter == 600) {
            set = new Setting();
            app.setup();
            stopCounter = 0;
            return set.getLives();
        }
            app.rect(-1, -1, app.WIDTH+2, app.HEIGHT+2);
            app.background(0);
            app.textFont(fonts,29);
            app.text("GAME OVER",96,200);
            stopCounter ++;
            return 0;
    }


        /**
     * stopWin is called when the game is stopped due to Win.
     * It draws "YOU WIN" screen and return false
     * until the end of 10 seconds is reached.
     * @param app, the game app.
     * @param fonts, type of font used to display "You win"
     * @return whether it reaches the end of 10 seconds
     */
    public boolean stopWin(App app, PFont fonts) {
        if (stopCounter == 600) {
            stopCounter = 0;
            return true;
        }
        app.rect(-1, -1, app.WIDTH+2, app.HEIGHT+2);
        app.background(0);
        app.textFont(fonts,29);
        app.text("YOU WIN",126,200);
        stopCounter ++;
        return false;

    }
}