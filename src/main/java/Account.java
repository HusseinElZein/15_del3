public class Account{
    private int money=15;

    public void setMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }

    public void transferMoney(int money, Player receiver, Player payer){
        receiver.setMoney(money);
        payer.setMoney(-money);
    }
}