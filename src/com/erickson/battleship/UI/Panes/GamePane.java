package com.erickson.battleship.UI.Panes;

import com.erickson.battleship.Game.GameControllerInterface;
import com.erickson.battleship.UI.GameObserver;
import javafx.scene.layout.GridPane;

public abstract class GamePane extends GridPane implements GameObserver {
    private GameControllerInterface controllerAccess;

    GamePane(GameControllerInterface controllerAccess) {
        super();
        this.controllerAccess = controllerAccess;
    }

}
