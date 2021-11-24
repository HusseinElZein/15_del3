import gui_fields.GUI_Field;
import gui_main.GUI;
import java.awt.*;

//This is a singleton class that we use in classes GameBoard
//and Game. Whenever these two classes or others use this GUI_Controller,
// then they refer to the same GUI.

class GUI_Controller {
    private static GUI board;
    private static GUI GUI_instance = null;
    private static GameBoard fields = new GameBoard();

    private GUI GUI_controller() {
        fields.createFields();
        board = new GUI(this.fields.getFields(), Color.lightGray);
        return board;
    }

    public GUI getInstance() {
        if (GUI_instance == null) {
            GUI_Controller k = new GUI_Controller();
            GUI_instance = k.GUI_controller();
        }
        return GUI_instance;
    }

    public GameBoard getJustFields(){
        return fields;
    }

    public GUI_Field getSpecificField(int specificField) {
        return this.fields.getSpecificField(specificField);
    }


}
