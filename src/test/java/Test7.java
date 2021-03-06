import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

import java.awt.*;

public class Test7 {

    //This test is to ensure that the transfer works
    //between an owner of a field and the player who lands on it

    public static void main(String[] args) {

        Player receiver = new Player();
        Player payer = new Player();
        GameBoard fields = new GameBoard();
        fields.createFields();

        GUI_Car car = new GUI_Car();
        car.setPrimaryColor(Color.black);

        GUI_Player players = new GUI_Player("Name",receiver.getMoney(),car);

        receiver.moveToHere(1);

        System.out.println("Ejers penge før: " + receiver.getMoney());
        System.out.println("spiller der lander's penge før: " + payer.getMoney());

        fields.setOwnerOfField(receiver.getSquare(),receiver, players);

        payer.moveToHere(1);

        payer.transferMoney((fields.getFieldRent(payer.getSquare())),
                fields.getOwnerOfField(payer.getSquare()), payer);



        System.out.println("betal: " + fields.getField(payer.getSquare()).getRent());

        System.out.println("ejerens penge: " + receiver.getMoney());

        System.out.println("Betalerens penge: " + payer.getMoney());



        fields.getOwnerOfField(1).getMoney();

        fields.buyField(receiver,players,car);
    }
}
