package UI.Panes;

import Game.GameControllerInterface;
import UI.GameObserver;
import javafx.scene.layout.GridPane;

abstract class GamePane extends GridPane implements GameObserver {
    protected GameControllerInterface controllerAccess;

    GamePane(GameControllerInterface controllerAccess) {
        super();
        this.controllerAccess = controllerAccess;
    }

}
