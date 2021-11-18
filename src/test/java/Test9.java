public class Test9 {

    public static void main(String[] args) {
        Fields fields = new Fields();
        fields.CreateFields();
        fields.getField(1).setOwnerName("Hejse");
        System.out.println(fields.getField(1).getOwnerName());
    }

}
