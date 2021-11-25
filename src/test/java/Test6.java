public class Test6 {

    public static void main(String[] args) {
        GameBoard fields = new GameBoard();
        fields.createFields();
        fields.getField(1).setOwnerName("Hejse");
        System.out.println(fields.getField(1).getOwnerName());
    }

}
