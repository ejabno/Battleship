package Game.Data.Entities;

import java.util.Hashtable;

public class GameBoard {
    private int size;

    GameBoard(int size) {
        if (size > 0) {
            this.size = size;
        }
        else throw new RuntimeException("Game board cannot have size <= 0");
    }

}
