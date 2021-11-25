import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test1 {

    @Test
    void moveToSquare() {
        Player player = new Player();
        assertEquals(12,player.moveToSquare(12,0));
        assertEquals(0,player.moveToSquare(12,0));
    }
}