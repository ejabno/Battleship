package Game.Data.Entities;

import java.util.Hashtable;

public class Player {
    private String playerName;
    private int seatNum;
    private Hashtable<String, Ship> fleet;

    Player (String playerName, int seatNum) {
        this.playerName = playerName;
        this.seatNum = seatNum;
        this.fleet = new Hashtable<>();
        // Initialize fleet
        Ship carrier = new Ship("Carrier", 5);
        Ship battleship = new Ship("Battleship", 4);
        Ship cruiser = new Ship("Cruiser", 3);
        Ship submarine = new Ship("Submarine", 3);
        Ship destroyer = new Ship("Destroyer", 2);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
}
