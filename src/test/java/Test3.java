import gui_fields.*;
import gui_main.GUI;
import java.awt.*;

public class Test3 {

    //This TDD test is showing us how we can initialize one player, and move on a board
    public void myFields(){
        GUI_Field[] fields = new GUI_Field[24];
        GUI board;

        for(int i=0; i<=23; i++) {
            fields[i] = new GUI_Street();
        }
        board = new GUI(fields);

        GUI_Car car = new GUI_Car(Color.red,Color.white, GUI_Car.Type.RACECAR, GUI_Car.Pattern.CHECKERED);
        GUI_Player player = new GUI_Player("Yusuf", 1000, car);
        board.addPlayer(player);
        Dice dice = new  Dice();
        Player playerOurs = new Player();


        while(true) {
            board.getUserButtonPressed("tryk for at kaste", "kast");
            fields[playerOurs.getSquare()].setCar(player, false);
            dice.throwDice();
            board.setDice(dice.getDie1(), dice.getDie2());
            fields[playerOurs.moveToSquare(dice.getDie1(), dice.getDie2())].setCar(player, true);
        }
    }

    public static void main(String[] args) {
        Test3 intoGuiTest = new Test3();
        intoGuiTest.myFields();
    }

}
