import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {

    //testing number of players with an array
    //This is not a productive test, we just tried to see how
    //the given GUI works.. to get a taste for it
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many players are you? (2-4)");

        int numberOfPlayers = sc.nextInt();

        if(numberOfPlayers>=2 && numberOfPlayers<=4){
            ArrayList<Player>[] players = new ArrayList[numberOfPlayers-1];


            int i=0;

            while(i<numberOfPlayers){

                System.out.print("Write in player "+ (1+ i++) +"'s name: ");
                String name = sc.nextLine();


            }

        }




    }

}