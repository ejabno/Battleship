package com.erickson.battleship.Game;

import com.google.gson.JsonObject;

public interface GameControllerInterface {
    boolean hostNewGame(JsonObject newGameDetails);

    boolean joinGame(JsonObject joinGameDetails);
}
