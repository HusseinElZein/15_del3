public class Player {
    private Account account = new Account();
    private int square = 0;

    public void setMoney(int money){
        account.setMoney(money);
    }

    public int getMoney() {
        return account.getMoney();
    }

    public void transferMoney(int money, Player reciever, Player payer){
        account.transferMoney(money, reciever, payer);
    }

    public int moveToSquare(int dice1, int dice2) {
        this.square += dice1+dice2;

        square %= 24;
        return square;
    }

    public int getSquare() {
        return square;
    }

}


