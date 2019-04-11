package com.erickson.battleship.Game;

import com.erickson.battleship.Networking.Client.GameClient;
import com.erickson.battleship.Networking.Client.GameClientInterface;
import com.erickson.battleship.Networking.Server.GameServer;
import com.erickson.battleship.Networking.Server.GameServerInterface;
import com.google.gson.JsonObject;

class RequestHandler {
    private GameServerInterface serverInterface;
    private GameClientInterface clientInterface;

    RequestHandler() {
        this.serverInterface = new GameServer();
        this.clientInterface = new GameClient();
    }

    private boolean isValidJson(JsonObject jsonObject) {
        return true;
    }
}
