import java.util.Scanner;

//This is a TDD test, in which I (Hussein) want to figure out how to
//prevent players from naming themselves the same name.

public class Test11 {
    private static Player[] players = new Player[4];
    private int numberOfPlayers = 4;
    private boolean same;

    private boolean playerNamesAreSame(String name, int playerNumberYet) {

        for (int i = 0; i < playerNumberYet; i++) {
            if (!name.equals(players[i].getName())){
                same = false;
            }
        }
        for (int i = 0; i < playerNumberYet; i++) {
            if (name.equals(players[i].getName())) {
                same = true;
            }
        }
        return same;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Test11 test = new Test11();

        for (int i = 0; i < 4; i++) {
            System.out.print("Navn til spiller " + (i + 1) + ": ");
            String nameOfPlayer = sc.next();

            players[i] = new Player();
            players[i].setName(nameOfPlayer);

            if (i > 0) {

                while(test.playerNamesAreSame(nameOfPlayer, i) == true) {
                    System.out.print("Spiller " + (i+1) + ", navnet er allerede taget, skriv et nyt: ");
                    nameOfPlayer = sc.next();
                }
                players[i].setName(nameOfPlayer);
            }
        }

            for (int i = 0; i < 4; i++) {
                System.out.println("Spiller " + (i + 1) + ": " + players[i].getName());
            }
    }
}

