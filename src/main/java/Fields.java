import gui_fields.*;

import java.awt.*;
import java.lang.reflect.Field;

public class Fields {
    GUI_Street field1, field2;
    GUI_Field[] fields = new GUI_Field[24];

    public void CreateFields() {
        for (int i = 0; i <= 23; i++) {
            fields[i] = new GUI_Street();
        }
        jailField();
        ownField();
        chance();
        startField();
    }

    public GUI_Field[] getFields(){
        return fields;
    }

    public GUI_Field getSpecificField(int specificField){
        return fields[specificField];
    }

    public void jailField(){
        fields[6] = new GUI_Jail();
        fields[18] = new GUI_Jail();
    }

    public void startField() {
        GUI_Start go = new GUI_Start();
        go.setTitle("Start");
        go.setSubText("Modtag 2₩ når du passerer her");
        fields[0] = go;

    }

    public void ownField(){
        this.field1 = new GUI_Street();
        field1.setTitle("Noerrebro");
        field1.setSubText("Pris: 1₩");
        field1.setBackGroundColor(Color.magenta);
        field1.setRent("-1");
        field1.setDescription("");
        fields[1] = field1;

        GUI_Street secondField = new GUI_Street();
        secondField.setTitle("Holbaek");
        secondField.setSubText("Pris: 1₩");
        secondField.setBackGroundColor(Color.magenta);
        secondField.setRent("-1");
        secondField.setDescription("");
        fields[2] = secondField;

        GUI_Street fourthField = new GUI_Street();
        fourthField.setTitle("Gladsaxe");
        fourthField.setSubText("Pris: 1₩");
        fourthField.setBackGroundColor(Color.blue);
        fourthField.setRent("-1");
        fourthField.setDescription("");
        fields[4] = fourthField;

        GUI_Street fifthField = new GUI_Street();
        fifthField.setTitle("Hvidovre");
        fifthField.setSubText("Pris: 1₩");
        fifthField.setBackGroundColor(Color.blue);
        fifthField.setRent("-1");
        fifthField.setDescription("");
        fields[5] = fifthField;

        GUI_Street seventhField = new GUI_Street();
        seventhField.setTitle("Nyborg");
        seventhField.setSubText("Pris: 2₩");
        seventhField.setBackGroundColor(Color.red);
        seventhField.setRent("-2");
        seventhField.setDescription("");
        fields[7] = seventhField;

        GUI_Street eigthField = new GUI_Street();
        eigthField.setTitle("Odense");
        eigthField.setSubText("Pris: 2₩");
        eigthField.setBackGroundColor(Color.red);
        eigthField.setRent("-2");
        eigthField.setDescription("");
        fields[8] = eigthField;

        GUI_Street tenthField = new GUI_Street();
        tenthField.setTitle("Aalborg");
        tenthField.setSubText("Pris: 2₩");
        tenthField.setBackGroundColor(Color.yellow);
        tenthField.setRent("-2");
        tenthField.setDescription("");
        fields[10] = tenthField;

        GUI_Street eleventhField = new GUI_Street();
        eleventhField.setTitle("Husum");
        eleventhField.setSubText("Pris: 2₩");
        eleventhField.setBackGroundColor(Color.yellow);
        eleventhField.setRent("-2");
        fields[11] = eleventhField;

        GUI_Street thirteenthField = new GUI_Street();
        thirteenthField.setTitle("Thisted");
        thirteenthField.setSubText("Pris: 3₩");
        thirteenthField.setBackGroundColor(Color.green);
        thirteenthField.setRent("-3");
        fields[13] = thirteenthField;

        GUI_Street fourteenthField = new GUI_Street();
        fourteenthField.setTitle("Frederikssund");
        fourteenthField.setSubText("Pris: 3₩");
        fourteenthField.setBackGroundColor(Color.green);
        fourteenthField.setRent("-3");
        fields[14] = fourteenthField;

        GUI_Street fifteenthField = new GUI_Street();
        fifteenthField.setTitle("Helsingoer");
        fifteenthField.setSubText("Pris: 3₩");
        fifteenthField.setBackGroundColor(Color.CYAN);
        fifteenthField.setRent("-3");
        fields[16] = fifteenthField;

        GUI_Street field17 = new GUI_Street();
        field17.setTitle("Hillerød");
        field17.setSubText("Pris: 3₩");
        field17.setBackGroundColor(Color.CYAN);
        field17.setRent("-3");
        fields[17] = field17;

        GUI_Street field19 = new GUI_Street();
        field19.setTitle("Valby");
        field19.setSubText("Pris: 4₩");
        field19.setBackGroundColor(Color.WHITE);
        field19.setRent("-4");
        fields[19] = field19;

        GUI_Street field20 = new GUI_Street();
        field20.setTitle("Frederiksberg");
        field20.setSubText("Pris: 4₩");
        field20.setBackGroundColor(Color.WHITE);
        field20.setRent("-4");
        fields[20] = field20;

        GUI_Street field22 = new GUI_Street();
        field22.setTitle("Gentofte");
        field22.setSubText("Pris: 5₩");
        field22.setBackGroundColor(Color.DARK_GRAY);
        field22.setRent("-5");
        fields[22] = field22;

        GUI_Street field23 = new GUI_Street();
        field23.setTitle("Hellerup");
        field23.setSubText("Pris: 5₩");
        field23.setBackGroundColor(Color.DARK_GRAY);
        field23.setRent("-5");
        fields[23] = field23;

    }
    public void chance(){
        GUI_Chance chance1 = new GUI_Chance();
        fields[3] = chance1;

        GUI_Chance chance2 = new GUI_Chance();
        fields[9] = chance2;

        GUI_Chance chance3 = new GUI_Chance();
        fields[15] = chance3;

        GUI_Chance chance4 = new GUI_Chance();
        fields[21] = chance4;

    }

    public GUI_Street getField(int fieldNumber){
        return (GUI_Street) fields[fieldNumber];
    }

    public int getFieldRent (int fieldNumber) {
        return Integer.parseInt(getField(fieldNumber).getRent());
    }

    public void buyField (Player player,GUI_Player players) {

        player.setMoney(getFieldRent(player.getSquare()));
        getField(player.getSquare()).setOwnerName(players.getName());

        getField(GUI_Ownable[2]);

        boolean owned = false;
        getField(player.getSquare());
        getField().

    }

    public void getOwner () {

    }

    public GUI_Street isOwned () {

        boolean owned = true;

    }

    public static void main(String[] args) {

        Fields field = new Fields();
        field.CreateFields();
        Player player = new Player();
        GUI_Car car = new GUI_Car();
        car.setPrimaryColor(Color.black);

        GUI_Player players = new GUI_Player("Hussein",player.getMoney(),car);
        player.moveToSquare(1,0);
        field.buyField(player,players);

        System.out.println(field.getField(player.getSquare()).getOwnerName());

    }

}
