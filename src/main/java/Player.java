public class Player {
    private Account account = new Account();
    private int square = 0;
    private boolean overGo;
    private boolean inJail;
    private String name;
    private boolean waitATurn;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        account.setMoney(money);
    }

    public int getMoney() {
        return account.getMoney();
    }

    public void transferMoney(int money, Player receiver, Player payer) {
        account.transferMoney(money, receiver, payer);
    }

    public boolean setWait(boolean trueOrFalse){
        return waitATurn = trueOrFalse;
    }

    public boolean getWait(){
        return waitATurn;
    }

    public int moveToSquare(int die1, int die2) {
        this.square += die1 + die2;

        if (square > 23) {
            this.overGo = true;
        }

        square %= 24;
        return square;
    }

    public int moveToHere(int where){
        this.square = where;
        return square;
    }

    public int getSquare() {
        return square;
    }

    public boolean checkOverGo() {
        return this.overGo;
    }

    public boolean setOverGoFalse(){
        return this.overGo = false;
    }

    public boolean setInJail(boolean falseOrTrue){
        return inJail = falseOrTrue;
    }

    public boolean getIsInJail() {
        return inJail;
    }
}
