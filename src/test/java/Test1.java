public class Test1 {

    public static void main(String[] args) {
        Dice dice = new Dice();
        Player player1 = new Player();
        Player player2 = new Player();
        Player test = new Player();


        System.out.println("TEST:" + test.moveToSquare(12,0));
        System.out.println("TEST:" + test.moveToSquare(12,0));
        System.out.println("TEST:" + test.moveToSquare(12,0));
        System.out.println();

        for(int i=0; i<10; i++){

            dice.throwDice();
            System.out.print("Player 1: ");
            System.out.println("First die: " + dice.getDie1() + " Second die: " + dice.getDie2() +
                    " Field: " + player1.moveToSquare(dice.getDie2(), dice.getDie1()));

            System.out.println();

            System.out.print("Player 2: ");
            dice.throwDice();
            System.out.println("First die: " + dice.getDie1() + " Second die: " + dice.getDie2() +
                    " Field: " + player2.moveToSquare(dice.getDie2(), dice.getDie1()));

            System.out.println();
        }

    }
}
