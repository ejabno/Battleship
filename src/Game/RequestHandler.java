package Game;

import Game.Client.GameClient;
import Game.Client.GameClientInterface;
import Game.Server.GameServer;
import Game.Server.GameServerInterface;
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
