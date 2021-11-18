import gui_fields.*;

import java.awt.*;

public class Fields {
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
        GUI_Street firstField = new GUI_Street();
        firstField.setTitle("Noerrebro");
        firstField.setSubText("Pris: 1₩");
        firstField.setBackGroundColor(Color.magenta);
        firstField.setRent("-1");
        firstField.setDescription("");
        fields[1] = firstField;

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


    }
    public void chance(){
        GUI_Chance chance1 = new GUI_Chance();
        fields[3] = chance1;

        GUI_Chance chance2 = new GUI_Chance();
        fields[9] = chance2;

    }

}