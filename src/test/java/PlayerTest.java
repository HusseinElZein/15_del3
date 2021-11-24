import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void transferMoney() {
        Player player1 = new Player();
        Player player2 = new Player();

        player1.transferMoney(10,player2,player1);
        assertEquals(5,player1.getMoney());
        assertEquals(25,player2.getMoney());

    }
}