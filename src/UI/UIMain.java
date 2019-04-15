package UI;

import Game.GameControllerInterface;
import UI.Panes.MainMenuPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIMain implements SceneDisplayerInterface {
    private Stage mainStage;

    private Scene mainMenuScene;
    private Scene hostGameScene;
    private Scene joinGameScene;
    private Scene optionsScene;
    private Scene statsScene;
    private Scene currentScene;

    private GameControllerInterface gameControl;

    public UIMain(Stage stage, GameControllerInterface gameControl) {
        this.gameControl = gameControl;
        this.mainStage = stage;

        this.mainMenuScene = new Scene(new MainMenuPane(gameControl));
    }

    public void startUIMain() {
        System.out.println("Showing UI elements for the first time");
        this.mainStage.setTitle("Battleship");
        this.displayMainScene();
    }

    /* ===========================================
       Interface Methods
       =========================================== */

    @Override
    public void displayMainScene() {
        this.currentScene = this.mainMenuScene;
        this.mainStage.setScene(this.currentScene);
        this.mainStage.show();
        //System.out.println("Showing Main Menu Scene");
    }

    @Override
    public void displayHostGameScene() {
        this.currentScene = this.hostGameScene;
        this.mainStage.setScene(this.hostGameScene);
        this.mainStage.show();
    }

    @Override
    public void displayJoinGameScene() {
        this.currentScene = this.joinGameScene;
        this.mainStage.setScene(this.joinGameScene);
        this.mainStage.show();
    }

    @Override
    public void displayOptionsScene() {
        this.currentScene = this.optionsScene;
        this.mainStage.setScene(this.optionsScene);
        this.mainStage.show();
    }

    @Override
    public void displayStatsScene() {
        this.currentScene = this.statsScene;
        this.mainStage.setScene(this.statsScene);
        this.mainStage.show();
    }
}
