import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class Game {
    private GUI_Controller gui = new GUI_Controller();
    private Dice dice = new Dice();
    private int numberOfPlayers;
    private Player[] ourPlayers = new Player[numberOfPlayers];
    private GUI_Player[] players = new GUI_Player[numberOfPlayers];
    private boolean gameEnded;
    private boolean draw;
    private Player winner2;
    private boolean sameName;

    //If the players want a long game, then the money will start at 35, if short; 15
    public void longOrShortGame(){
        String longOrShort = gui.getInstance().getUserButtonPressed("Oensker I et langt eller kort spil?", "Kort","Langt");

        if(longOrShort == "Kort"){
            for(int i=0; i<numberOfPlayers; i++){
                players[i].setBalance(ourPlayers[i].getMoney());
            }
        }
        if(longOrShort == "Langt"){
            for(int i=0; i<numberOfPlayers; i++){
                ourPlayers[i].setMoney(20);
                players[i].setBalance(ourPlayers[i].getMoney());
            }
        }
    }

    public boolean playerNamesAreSame(String name, int playerNumberYet){
        for (int i = 0; i < playerNumberYet; i++) {
            if (!name.equals(players[i].getName())){
                sameName = false;
            }
        }
        for (int i = 0; i < playerNumberYet; i++) {
            if (name.equals(players[i].getName())) {
                sameName = true;
            }
        }
        return sameName;
    }

    //This will create all wanted players
    public void createPlayers(){
        String option = gui.getInstance().getUserSelection("Hvor mange spillere?", "2", "3", "4");
        this.numberOfPlayers = Integer.parseInt(option);

        ourPlayers = new Player[numberOfPlayers];
        players = new GUI_Player[numberOfPlayers];

        GUI_Car[] cars = new GUI_Car[4];
        cars[0] = new GUI_Car(); cars[0].setPrimaryColor(Color.green);
        cars[1] = new GUI_Car(); cars[1].setPrimaryColor(Color.black);
        cars[2] = new GUI_Car(); cars[2].setPrimaryColor(Color.blue);
        cars[3] = new GUI_Car(); cars[3].setPrimaryColor(Color.red);


        for(int i=0; i<numberOfPlayers; i++){

            String nameOfPlayer = gui.getInstance().getUserString("Spiller " + (i+1) + ", Indtast et navn");
            ourPlayers[i] = new Player();

            if(i > 0){
                while(playerNamesAreSame(nameOfPlayer, i) == true) {
                    gui.getInstance().showMessage("Spiller " + (i+1) + ", navnet er allerede taget, skriv et nyt");
                    nameOfPlayer = gui.getInstance().getUserString("Spiller " + (i+1) + ", Indtast et navn");
                }
                ourPlayers[i].setName(nameOfPlayer);
            }

            ourPlayers[i].setName(nameOfPlayer);
            players[i] = new GUI_Player(nameOfPlayer,ourPlayers[i].getMoney(),cars[i]);
            gui.getInstance().addPlayer(players[i]);
            gui.getSpecificField(0).setCar(players[i],true);
        }
        longOrShortGame();
    }

    public void checkForLoser(Player ourPlayer){
        if(ourPlayer.getMoney() <= 0) {
            gui.getInstance().showMessage(ourPlayer.getName() + " er gaaet bankerot");
            gameEnded = true;
        }
    }

    public void checkForWinner(Player player){
        Player winner = player;

        for(int i=0; i<ourPlayers.length; i++){
            if(ourPlayers[i].getMoney() > winner.getMoney()){
                winner = ourPlayers[i];
            }
        }
        checkIfDraw(winner);
        if(draw != true) {
            gui.getInstance().showMessage(winner.getName() + " har vundet spillet! Hurra!");

        }else if (draw){
            System.out.println("Spillet er uafgjort mellem " + winner.getName() + " og " + winner2.getName());
            gui.getInstance().showMessage("Spillet er uafgjort mellem " + winner.getName() + " og " + winner2.getName());
        }
    }


    public Player checkIfDraw(Player winner){

        for(int i=0; i<ourPlayers.length; i++){

            if(winner.getMoney() == ourPlayers[i].getMoney()){
                if(winner != ourPlayers[i]) {
                    winner2 = ourPlayers[i];
                    draw = true;
                }
            }
        }
        return winner2;
    }

    public void findWinnerIfLoser(Player player) {
        checkForLoser(player);
        if (gameEnded == true) {
            checkForWinner(player);
        }
    }

    public void buyOrRent(Player ourPlayers, GUI_Player players, GUI_Car car){

        int f = ourPlayers.getSquare();
        if((f==1||f==2||f==2||f==4||f==5||f==7||f==8||f==10||f==11||f==13||f==14||f==16||f==17||f==19
                ||f==20||f==22||f==23)
                && gui.getJustFields().isPlaceOwned(ourPlayers) != true
                && ourPlayers.getMoney()>(1+gui.getJustFields().getFieldRent(ourPlayers.getSquare()))){

            String option = gui.getInstance().getUserSelection(players.getName() + ", vil du købe "
                            + gui.getSpecificField(ourPlayers.getSquare()).getTitle() +
                            " for " + gui.getJustFields().getFieldRent(ourPlayers.getSquare()) + "₩",
                    "Ja", "Nej");

            if(option == "Ja"){
                gui.getJustFields().buyField(ourPlayers,players, car);
                players.setBalance(ourPlayers.getMoney());
                gui.getJustFields().getField(ourPlayers.getSquare()).setOwnerName(players.getName());
            }
        }
        else if(gui.getJustFields().isPlaceOwned(ourPlayers) == true
                && gui.getJustFields().getOwnerOfField(ourPlayers.getSquare()) != ourPlayers){
            gui.getInstance().showMessage("Oh oh.. " +
                    gui.getSpecificField(ourPlayers.getSquare()).getTitle() +
                    " er ejet af " + gui.getJustFields().getField(ourPlayers.getSquare()).getOwnerName()
                    + ". " + ourPlayers.getName() + " skal betale " + gui.getJustFields().getFieldRent(ourPlayers.getSquare()) + "₩");

            gui.getJustFields().payToOwner(players,gui.getJustFields().getGuiOwner(ourPlayers.getSquare()),ourPlayers,
                    gui.getJustFields().getOwnerOfField(ourPlayers.getSquare()));

            findWinnerIfLoser(ourPlayers);
        }
    }

    public void start() {

        createPlayers();

        int i = 0;
        while(true) {

            round(ourPlayers[i],players[i],players[i].getCar());
            i++;
            i %= numberOfPlayers;
        }
    }

    public void setPlayerInJail(Player ourPlayers, GUI_Player players) {

        if(ourPlayers.getSquare() == 18){
            if (ourPlayers.getMoney() > 3) {
                gui.getInstance().showMessage(players.getName() + " skal i faengsel, du skal betale 3₩ " +
                        "ved naeste tur for at komme ud, eller slaa to éns terninger");
            } else {
                gui.getInstance().showMessage(players.getName() + " skal i faengsel, du skal" +
                        " slaa to éns terninger ved naeste tur for at komme ud");
            }

            gui.getSpecificField(18).setCar(players, false);
            gui.getSpecificField(6).setCar(players, true);
            ourPlayers.moveToHere(8);

            ourPlayers.setInJail(true);
            ourPlayers.setWait(true);
        }
    }


    public void setPlayerOutJail(Player ourPlayers, GUI_Player players){

        ourPlayers.setWait(false);
        if (ourPlayers.getMoney() > 3) {
            String option = gui.getInstance().getUserButtonPressed(players.getName() +
                            ", du er i faengsel, vil du betale 3 for at komme ud eller slaa to éns?",
                    "slaa", "betal 3₩");

            if (option == "slaa") {
                gui.getInstance().getUserButtonPressed(players.getName() + ", tryk for at kaste", "kast");
                dice.throwDice();
                gui.getInstance().setDice(dice.getDie1(), dice.getDie2());

                if (dice.getDie1() == dice.getDie2()) {
                    gui.getInstance().showMessage("Du fik to éns! Der var du heldig, nu faar du lov " +
                            "til at rykke dit kast");
                    ourPlayers.setInJail(false);
                    ourPlayers.moveToSquare(dice.getDie1(), dice.getDie2());
                    gui.getSpecificField(6).setCar(players, false);
                    gui.getSpecificField(ourPlayers.getSquare()).setCar(players, true);

                    anyFieldLand(ourPlayers,players);

                } else {
                    gui.getInstance().showMessage("Bedre held naeste gang");
                }
            }

            if (option == "betal 3₩") {
                ourPlayers.setMoney(-3);
                players.setBalance(ourPlayers.getMoney());

                ourPlayers.setInJail(false);

                gui.getInstance().showMessage("Nu er du fri igen");

                gui.getInstance().getUserButtonPressed(players.getName() + ", tryk for at kaste", "kast");
                dice.throwDice();
                gui.getInstance().setDice(dice.getDie1(), dice.getDie2());

                gui.getSpecificField(6).setCar(players,false);
                ourPlayers.moveToSquare(dice.getDie1(),dice.getDie2());
                gui.getSpecificField(ourPlayers.getSquare()).setCar(players,true);

                anyFieldLand(ourPlayers,players);

                if ((dice.getDie1() == dice.getDie2()) && gameEnded == false && ourPlayers.getIsInJail() == false) {
                    gui.getInstance().showMessage("Du slog to éns, slå igen");
                    gui.getInstance().getUserButtonPressed(players.getName() + ", tryk for at kaste", "kast");

                    gui.getSpecificField(ourPlayers.getSquare()).setCar(players, false);
                    ourPlayers.moveToSquare(dice.getDie1(), dice.getDie2());
                    gui.getSpecificField(ourPlayers.getSquare()).setCar(players, true);

                    anyFieldLand(ourPlayers,players);
                }
            }
        }
    }

    public void anyFieldLand(Player ourPlayers, GUI_Player players){
        ifPassingGo(ourPlayers,players);
        gui.getJustFields().didLandOnChance(ourPlayers,players);
        gui.getJustFields().didLandOnJackpot(ourPlayers,players);
        buyOrRent(ourPlayers,players, players.getCar());
        setPlayerInJail(ourPlayers,players);
    }

    public void round(Player ourPlayers, GUI_Player players, GUI_Car car){

        if(ourPlayers.getIsInJail() == false && gameEnded == false){
            gui.getInstance().getUserButtonPressed(players.getName() + ", tryk for at kaste", "kast");
            gui.getSpecificField(ourPlayers.getSquare()).setCar(players, false);
            dice.throwDice();
            gui.getInstance().setDice(dice.getDie1(), dice.getDie2());
            gui.getSpecificField(ourPlayers.moveToSquare(dice.getDie1(), dice.getDie2())).setCar(players, true);

            anyFieldLand(ourPlayers,players);

            if (dice.getDie1() == dice.getDie2() && ourPlayers.getIsInJail() == false && gameEnded ==false) {

                gui.getInstance().getUserButtonPressed(players.getName() + " har slået to éns! Kast igen", "kast");
                dice.throwDice();
                gui.getSpecificField(ourPlayers.getSquare()).setCar(players, false);

                gui.getInstance().setDice(dice.getDie1(), dice.getDie2());
                gui.getSpecificField(ourPlayers.moveToSquare(dice.getDie1(), dice.getDie2())).setCar(players, true);

                anyFieldLand(ourPlayers,players);
            }
        }

        if(ourPlayers.getIsInJail() == true && ourPlayers.getWait() == false){
            setPlayerOutJail(ourPlayers,players);
        }
        ourPlayers.setWait(false);
    }

    public void ifPassingGo(Player ourPlayers, GUI_Player players){
        if(ourPlayers.checkOverGo()==true){

            ourPlayers.setOverGoFalse();

            gui.getInstance().showMessage(players.getName() + " har passeret start, du tjener 2₩");
            ourPlayers.setMoney(2);
            players.setBalance(ourPlayers.getMoney());
        }
    }
}