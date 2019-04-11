package com.erickson.battleship.Battleship;

import com.erickson.battleship.Game.GameController;
import com.erickson.battleship.UI.UIMain;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GameController gameController = new GameController(stage);
        gameController.startGameController();
    }

    public static void main(String[] args) {
        System.out.println("Launching Application: Battleship");
        Application.launch(args);
    }
}
