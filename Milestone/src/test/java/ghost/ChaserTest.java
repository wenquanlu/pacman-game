package ghost;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ChaserTest {
    @Test 
    public void nonScatterMove() {
        Setting s = new Setting();
        Chaser c = new Chaser(186,219,2);
        c.reverseMode();
        c.move(s.getCellMap(),26,171,false);
        assertEquals(184,c.getX());
    }
}