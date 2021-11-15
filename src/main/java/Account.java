public class Account{
    private int money=35;

    public void setMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }

    public void transferMoney(int money, Player reciever, Player payer){
        reciever.setMoney(money);
        payer.setMoney(-money);
    }

}
