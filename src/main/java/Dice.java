public class Dice {
    private int die1, die2;

    public void throwDice(){
        this.die1 = (int) (Math.random()*6+1);
        this.die2 = (int) (Math.random()*6+1);
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

}
