public class Test5 {

    //This test is to check if the player turns over the go field to
    //recieve money
    public static void main(String[] args) {
        Player player = new Player();

        player.moveToSquare(13, 12);
        System.out.println("Player's money right now: " + player.getMoney());
        System.out.println("Player has overgone Go Field: " + player.checkOverGo());

        if(player.checkOverGo()==true){
            player.setMoney(2);
            player.setOverGoFalse();
        }
        System.out.println("Player's money right now: " + player.getMoney());


        if(player.checkOverGo()==true){
            player.setMoney(2);
            player.setOverGoFalse();
        }
        System.out.println("Player has overgone Go Field: " + player.checkOverGo());
        System.out.println("Player's money right now: " + player.getMoney());
    }
}
