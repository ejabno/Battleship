package Battleship;

import Game.GameController;
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
