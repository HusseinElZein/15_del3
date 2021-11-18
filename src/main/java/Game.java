import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import java.awt.*;

public class Game {
    GUI_controller gui = new GUI_controller();
    private Player[] ourPlayers;
    private GUI_Player[] players;
    private Dice dice = new Dice();
    private int numberOfPlayers;

    public void createPlayers(){
        String option = gui.getInstance().getUserSelection("Hvor mange spillere?", "2", "3", "4");
        int chosenOption = Integer.parseInt(option);
        this.numberOfPlayers = chosenOption;

        ourPlayers = new Player[numberOfPlayers];
        players = new GUI_Player[numberOfPlayers];

        GUI_Car[] cars = new GUI_Car[4];
        cars[0] = new GUI_Car();
        cars[0].setPrimaryColor(Color.green);
        cars[1] = new GUI_Car();
        cars[1].setPrimaryColor(Color.black);
        cars[2] = new GUI_Car();
        cars[2].setPrimaryColor(Color.blue);
        cars[3] = new GUI_Car();
        cars[3].setPrimaryColor(Color.red);

        for(int i=0; i<numberOfPlayers; i++){
            String spillernavn = gui.getInstance().getUserString("Spiller " + (i+1) +", Indtast et navn");
            ourPlayers[i] = new Player();
            players[i] = new GUI_Player(spillernavn,ourPlayers[i].getMoney(),cars[i]);
            gui.getInstance().addPlayer(players[i]);
            //gui.getSpecificField(0).setCar(players[i],true);
            gui.getSpecificField(0).setCar(players[i],true);
        }
    }

    public void round() {
        int i = 0;
        while(true) {
            gui.getInstance().getUserButtonPressed(players[i].getName() + ", tryk for at kaste", "kast");
            gui.getSpecificField(ourPlayers[i].getSquare()).setCar(players[i], false);
            dice.throwDice();
            gui.getInstance().setDice(dice.getDie1(), dice.getDie2());


            if (dice.getDie1() == dice.getDie2()) {
                gui.getSpecificField(ourPlayers[i].moveToSquare(dice.getDie1(), dice.getDie2())).setCar(players[i], true);

                gui.getInstance().getUserButtonPressed(players[i].getName() + ", har slået to éns! Kast igen", "kast");
                gui.getSpecificField(ourPlayers[i].getSquare()).setCar(players[i], false);
                dice.throwDice();

                gui.getInstance().setDice(dice.getDie1(), dice.getDie2());
                gui.getSpecificField(ourPlayers[i].moveToSquare(dice.getDie1(), dice.getDie2())).setCar(players[i], true);
            } else {
                gui.getSpecificField(ourPlayers[i].moveToSquare(dice.getDie1(), dice.getDie2())).setCar(players[i], true);
            }



            i++;
            i %= numberOfPlayers;
        }

    }

/*
    public boolean checkWinning(){
        for(int i=0; i<Game.numberOfPlayers; i++){
            if(players[i].getBalance()==0){
                break;
            }
        }
        return players[i]
    }
 */

    public void overGo(Player player, GUI_Player players){
        if(player.checkOverGo() == true){
            gui.getInstance().showMessage(players.getName() + ", du har passeret startfeltet, du får 5$");
            player.setMoney(5);
            players.setBalance(player.getMoney());
        }
    }


}