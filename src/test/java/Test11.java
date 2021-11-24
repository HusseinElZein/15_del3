public class Test11 {

    //This unit test is to ensure that the player
    //moves to the inserted field if using the moveToHere method in Player

    public static void main(String[] args) {
        Player player = new Player();

        System.out.println("Player field before moveToHere: " + player.getSquare());

        player.moveToHere(8);

        System.out.println("Player field after moveToHere: " + player.getSquare());
    }
}