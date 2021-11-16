import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class Test4 {

    public static void main(String[] args) {
        GUI_Field[] fields = new GUI_Field[24];
        GUI board;
        Dice dice = new Dice();

        for(int i=0; i<=23; i++) {
            fields[i] = new GUI_Street();
        }

        GUI_Street testStreet = new GUI_Street();
        testStreet.setTitle("høje gladsaxe");
        testStreet.setSubText("Pris: 3");
        testStreet.setBackGroundColor(Color.green);
        testStreet.setRent("-3");
        fields[1] = testStreet;

        System.out.println();

        board = new GUI(fields);

        String option = board.getUserSelection("Hvor mange spillere?", "2", "3", "4");
        int chosenOption = Integer.parseInt(option);

        Player[] ourPlayers = new Player[chosenOption];

        GUI_Car[] cars = new GUI_Car[4];
        cars[0] = new GUI_Car();
        cars[0].setPrimaryColor(Color.green);
        cars[1] = new GUI_Car();
        cars[1].setPrimaryColor(Color.black);
        cars[2] = new GUI_Car();
        cars[2].setPrimaryColor(Color.blue);
        cars[3] = new GUI_Car();
        cars[3].setPrimaryColor(Color.red);

        //creating number of players of what is chosen by the user from the GUI
        GUI_Player[] players = new GUI_Player[chosenOption];

        for(int i=0; i<chosenOption; i++){
            String spillernavn = board.getUserString("Spiller " + (i+1) +", Indtast et navn");
            ourPlayers[i] = new Player();
            players[i] = new GUI_Player(spillernavn,ourPlayers[i].getMoney(),cars[i]);
            board.addPlayer(players[i]);
            fields[0].setCar(players[i], true);
        }

        int i = 0;
        while(true){
            board.getUserButtonPressed(players[i].getName() +", tryk for at kaste", "kast");
            fields[ourPlayers[i].getSquare()].setCar(players[i], false);
            dice.throwDice();
            board.setDice(dice.getDie1(), dice.getDie2());
            
            ourPlayers[i].moveToSquare(dice.getDie1(), dice.getDie2());
            
            fields[ourPlayers[i].getSquare()].setCar(players[i], true);
            
            i++;
            i %= chosenOption;
        }
    }


}
