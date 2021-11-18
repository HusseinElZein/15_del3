public class Test2 {

    public static void main(String[] args) {
        Player yusuf = new Player();
        Player hussein = new Player();

        System.out.println("Husseins penge: " + hussein.getMoney());
        System.out.println("Yusufs penge: " + yusuf.getMoney());

        yusuf.transferMoney(1000,yusuf,hussein);
        System.out.println("Husseins penge: " +hussein.getMoney());
        System.out.println("Yusufs penge: " + yusuf.getMoney());
        yusuf.transferMoney(1000,yusuf,hussein);
        System.out.println("Husseins penge: " + hussein.getMoney());
        System.out.println("Yusufs penge: "  +yusuf.getMoney());

    }

}