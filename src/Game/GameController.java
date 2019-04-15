package Game;

import UI.UIMain;
import com.google.gson.JsonObject;
import javafx.stage.Stage;

public class GameController implements GameControllerInterface {

    private RequestHandler requestHandler;
    private UIMain uiMain;

    public GameController(Stage stage) {
        this.uiMain = new UIMain(stage, this);
        this.requestHandler = new RequestHandler();
    }

    public void startGameController() {
        System.out.println("Game controller launched");
        this.uiMain.startUIMain();
    }

    /* ===========================================
       Interface Methods
       =========================================== */

    @Override
    public boolean hostNewGame(JsonObject newGameDetails) {
        return false;
    }

    @Override
    public boolean joinGame(JsonObject joinGameDetails) {
        return false;
    }
}
