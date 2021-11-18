import gui_fields.*;

public class Fields {
    GUI_Field[] fields = new GUI_Field[24];

    public void CreateFields() {
        for (int i = 0; i <= 23; i++) {
            fields[i] = new GUI_Street();
        }
        jailField();
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

    public void ownField(){



    }
}