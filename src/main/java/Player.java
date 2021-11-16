public class Player {
    private Account account = new Account();
    private int square = 0;
    private boolean overGo;

    public void setMoney(int money) {
        account.setMoney(money);
    }

    public int getMoney() {
        return account.getMoney();
    }

    public void transferMoney(int money, Player reciever, Player payer) {
        account.transferMoney(money, reciever, payer);
    }

    public int moveToSquare(int dice1, int dice2) {
        this.square += dice1 + dice2;

        if (square > 23) {
            this.overGo = true;
        }

        square %= 24;
        return square;
    }

    public boolean checkOverGo() {
        return this.overGo;
    }

    public int getSquare() {
        return square;
    }


    //This test is to check if the player turns over the go field to
    //recieve money
    /* public static void main(String[] args) {
     Player player = new Player();

        player.moveToSquare(13,12);
        System.out.println("Player has overgone Go Field: " + player.checkOverGo());
        System.out.println("Player's money right now: " + player.getMoney());

        if(player.checkOverGo()==true)

     */

}


