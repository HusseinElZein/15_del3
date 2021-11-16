import gui_fields.GUI_Field;
import gui_main.GUI;

class GUI_controller {
    private static GUI board;
    private static Fields fields = new Fields();
    private static GUI GUI_instance = null;

    private GUI GUI_controller() {
        fields.CreateFields();
        board = new GUI(fields.getFields());
        return board;
    }

    public GUI getInstance() {
        if (GUI_instance == null) {
            GUI_controller k = new GUI_controller();
            GUI_instance = k.GUI_controller();
        }
        return GUI_instance;
    }

    public GUI_Field getSpecificField(int specificFields) {
        return fields.getSpecificField(specificFields);
    }

    public static void main(String[] args) {

        GUI_controller gui = new GUI_controller();
        System.out.println(gui.getSpecificField(0));

    }

}







