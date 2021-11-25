//this unit (TDD) test is testing a method inside Game. It is to ensure that
//the system checks for the richest player in order to win.
//Also in this test I'm (Hussein) trying to figure out how to make it work,
//so that afterwards I can implement it.
//And also the dilemma: What if there are two richest players?
//That will mean that it is a draw between those two,
//I know it is a stupid rule, but it is a junior, and juniors don't
//like to stay out after going bankrupt for too long

public class Test9 {

    private static Player[] ourPlayers = new Player[4];
    private boolean gameEnded;
    private boolean draw;
    private Player winner2;

    public void checkForLoser(Player ourPlayer){

        ourPlayer.setMoney(-5);


        if(ourPlayer.getMoney() <= 0) {
            System.out.println(ourPlayer.getName() + " er gaaet bankerot");
            gameEnded = true;
        }
    }

    public void checkForWinner(Player player){

        Player winner = player;

        for(int i=0; i<ourPlayers.length; i++){

            if(ourPlayers[i].getMoney() > winner.getMoney()){
                winner = ourPlayers[i];
            }
        }
        checkIfDraw(winner);
        if(draw != true) {
            System.out.println(winner.getName() + " har vundet spillet! Hurra!");
        }else if (draw == true){
            System.out.println("Spillet er uafgjort mellem " + winner.getName() + " og " + winner2.getName());
        }
    }


    public Player checkIfDraw(Player winner){

        for(int i=0; i<ourPlayers.length; i++){

            if(winner.getMoney() == ourPlayers[i].getMoney()){
                if(winner != ourPlayers[i]) {
                    winner2 = ourPlayers[i];
                    draw = true;
                }
            }
        }
        return winner2;
    }

    public void findWinnerIfLoser(Player player) {
        checkForLoser(player);
        if (gameEnded == true) {
            checkForWinner(player);
        }
    }

    public static void main(String[] args) {
        Test9 test12 = new Test9();

        //ourPlayers = new Player[2];
        ourPlayers[0] = new Player();
        ourPlayers[1] = new Player();
        ourPlayers[2] = new Player();
        ourPlayers[3] = new Player();

        ourPlayers[0].setName("player0");
        ourPlayers[1].setName("player1");
        ourPlayers[2].setName("player2");
        ourPlayers[3].setName("player3");

        ourPlayers[1].setMoney(-3);
        ourPlayers[2].setMoney(-3);
        ourPlayers[3].setMoney(-2);

        test12.findWinnerIfLoser(ourPlayers[0]);
    }
}