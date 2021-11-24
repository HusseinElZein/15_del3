import gui_fields.*;

import java.awt.*;

public class GameBoard {
    private GUI_Controller gui = new GUI_Controller();
    private GUI_Field[] fields = new GUI_Field[24];
    private boolean[] isFieldOwned = new boolean[24];
    private Player owner[] = new Player[24];
    private GUI_Player ownerPlayers[] = new GUI_Player[24];
    private static int jackpotBundle;

    //This will create all the fields
    public void createFields() {
        for (int i = 0; i <= 23; i++) {
            fields[i] = new GUI_Street();
        }
        jailField();
        ownField();
        chance();
        startField();
        jackpot();
    }

    //This is what the teacher wanted; to make a to string method to write out
    //all our fields
    public String allFieldsToString(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<23; i++){
            builder.append("field: " + i + " " + fields[i].getTitle() + "\n");
        }
        return builder.toString();
    }

    //using all fields to string in a main
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.createFields();
        System.out.println(gameBoard.allFieldsToString());
    }

    public GUI_Field[] getFields(){
        return fields;
    }

    public GUI_Field getSpecificField(int specificField){
        return fields[specificField];
    }

    public void jackpot(){
        GUI_Street jackpot = new GUI_Street();
        jackpot.setSubText("Faa loese");
        jackpot.setTitle("JACKPOT");

        fields[12] = jackpot;
    }

    public void jailField(){
        GUI_Jail visitJail = new GUI_Jail();
        visitJail.setTitle("");
        visitJail.setSubText("Besoeg");

        GUI_Jail goToJail = new GUI_Jail();
        goToJail.setTitle("");
        goToJail.setSubText("Gaa i faengsel");

        fields[6] = visitJail;
        fields[18] = goToJail;
    }

    public void startField() {
        GUI_Start go = new GUI_Start();
        go.setTitle("Start");
        go.setSubText("Modtag 2₩ når du passerer her");
        fields[0] = go;
    }

    public void ownableFields(String name, String price, Color color, int fieldNumber){
        GUI_Street field = new GUI_Street();
        field.setTitle(name);
        field.setRent(price);
        field.setSubText("Pris: " + price + "₩");
        field.setBackGroundColor(color);
        fields[fieldNumber] = field;
    }

    public void ownField(){
        ownableFields("Noerrebro","1",Color.magenta,1);
        ownableFields("Holbaek","1",Color.magenta,2);
        ownableFields("Gladsaxe","1",Color.blue,4);
        ownableFields("Hvidovre","1",Color.blue,5);
        ownableFields("Nyborg","2",Color.red,7);
        ownableFields("Odense","2",Color.red,8);
        ownableFields("Aalborg","2",Color.yellow,10);
        ownableFields("Husum","2",Color.yellow,11);
        ownableFields("Thisted","3",Color.green,13);
        ownableFields("Frederikssund","3",Color.green,14);
        ownableFields("Helsingoer","3",Color.CYAN,16);
        ownableFields("Hilleroed","3",Color.CYAN,17);
        ownableFields("Valby","4",Color.WHITE,19);
        ownableFields("Frederiksberg","4",Color.WHITE,20);
        ownableFields("Gentofte","5",Color.DARK_GRAY.brighter(),22);
        ownableFields("Helleruo","5",Color.DARK_GRAY.brighter(),23);
    }

    public void chance(){
        GUI_Chance chance1 = new GUI_Chance();
        fields[3] = chance1;

        GUI_Chance chance2 = new GUI_Chance();
        fields[9] = chance2;

        GUI_Chance chance3 = new GUI_Chance();
        fields[15] = chance3;

        GUI_Chance chance4 = new GUI_Chance();
        fields[21] = chance4;
    }

    public GUI_Street getField(int fieldNumber){
        return (GUI_Street) fields[fieldNumber];
    }

    public int getFieldRent (int fieldNumber) {
        return Integer.parseInt(getField(fieldNumber).getRent());
    }

    public void buyField (Player player,GUI_Player players, GUI_Car car) {
        player.setMoney(-getFieldRent(player.getSquare()));
        getField(player.getSquare()).setOwnerName(players.getName());
        getField(player.getSquare()).setBorder(car.getPrimaryColor());
        isFieldOwned[player.getSquare()] = true;
        getField(player.getSquare()).setSubText(players.getName());
        setOwnerOfField(player.getSquare(),player, players);
    }

    public void payToOwner(GUI_Player guiPayer, GUI_Player guiReceiver, Player payer, Player receiver){
        payer.transferMoney((getFieldRent(payer.getSquare())),getOwnerOfField(payer.getSquare()) ,payer);
        guiPayer.setBalance(payer.getMoney());
        guiReceiver.setBalance(receiver.getMoney());
    }

    public void didLandOnChance(Player ourPlayers, GUI_Player players){

        int s = ourPlayers.getSquare();
        if(s == 3 || s == 9 || s == 15 || s == 21){
            gui.getInstance().getUserButtonPressed(ourPlayers.getName() + " er landet paa chance, traek et" +
                    " chancekort", "traek");

            int randomCard = (int) (Math.random()*8+1);

            switch(randomCard){
                case 1: card1(ourPlayers,players);
                    break;
                case 2: card2(ourPlayers,players);
                    break;
                case 3: card3(ourPlayers,players);
                    break;
                case 4: card2(ourPlayers,players);
                    break;
                case 5: card1(ourPlayers,players);
                    break;
                case 6: card3(ourPlayers,players);
                    break;
                case 7: card4(ourPlayers,players);
                    break;
                case 8: card5(ourPlayers,players);
                    break;
            }
        }
    }

    public void didLandOnJackpot(Player player, GUI_Player players){

        int s = player.getSquare();
        if(s==12) {
            receiveJackpot(player, players);
        }
    }

    public void setJackpotBundle(int plusJackpot){
        jackpotBundle += plusJackpot;
    }

    public void receiveJackpot(Player player, GUI_Player players){
        if(jackpotBundle>0) {
            gui.getInstance().showMessage(player.getName() + ", du er landet på jackpot! Du modtager " + jackpotBundle
                    + "₩");
            player.setMoney(jackpotBundle);
            players.setBalance(player.getMoney());
            jackpotBundle = 0;
        }
    }

    public void card1(Player ourPlayers, GUI_Player players){
        gui.getInstance().showMessage(" CHANCE KORT: Betal 1₩ til jackpot");
        ourPlayers.setMoney(-1);
        players.setBalance(ourPlayers.getMoney());
        setJackpotBundle(1);
    }

    public void card2(Player ourPlayers, GUI_Player players){
        gui.getInstance().showMessage("CHANCE KORT: Modtag 2₩ fra kassen");
        ourPlayers.setMoney(2);
        players.setBalance(ourPlayers.getMoney());
    }

    public void card3(Player ourPlayers, GUI_Player players){
        gui.getInstance().showMessage("CHANCE KORT: Ryk to felter frem");
        getSpecificField(ourPlayers.getSquare()).setCar(players,false);
        ourPlayers.moveToSquare(2,0);
        getSpecificField(ourPlayers.getSquare()).setCar(players,true);
    }

    public void card4(Player ourPlayer, GUI_Player players){
        gui.getInstance().showMessage("CHANCE KORT: Ryk frem til start og modtag 2₩");
        getSpecificField(ourPlayer.getSquare()).setCar(players,false);
        ourPlayer.moveToHere(0);
        getSpecificField(ourPlayer.getSquare()).setCar(players,true);
        ourPlayer.setMoney(2);
        players.setBalance(ourPlayer.getMoney());
    }

    public void card5(Player ourPlayers, GUI_Player players){
        gui.getInstance().showMessage(" CHANCE KORT: Betal 2₩ til jackpot");
        ourPlayers.setMoney(-2);
        players.setBalance(ourPlayers.getMoney());
        setJackpotBundle(2);
    }

    public void setOwnerOfField(int fieldNumber, Player player, GUI_Player players){
        owner[fieldNumber] = player;
        ownerPlayers[fieldNumber] = players;
    }

    public Player getOwnerOfField(int fieldNumber){
        return owner[fieldNumber];
    }

    public GUI_Player getGuiOwner(int fieldNumber){
        return ownerPlayers[fieldNumber];
    }

    public boolean isPlaceOwned(Player player) {
        return isFieldOwned[player.getSquare()];
    }
}