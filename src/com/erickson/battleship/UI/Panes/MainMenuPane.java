package com.erickson.battleship.UI.Panes;

import com.erickson.battleship.Game.GameControllerInterface;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class MainMenuPane extends GamePane {

    public MainMenuPane(GameControllerInterface controllerAccess) {
        super(controllerAccess);

        Button hostGameButton = new Button("Host Game");
        Button joinGameButton = new Button("Join Game");
        Button optionsButton = new Button("Options");
        Button statsButton = new Button("Stats");
        Label gameLabel = new Label("BATTLESHIP");
        /*
        gameLabel.setFont(new Font(30));

        Region fillerLeft = new Region();
        Region fillerRight = new Region();
        HBox.setHgrow(fillerLeft, Priority.ALWAYS);
        HBox.setHgrow(fillerRight, Priority.ALWAYS);

        VBox contents = new VBox(gameLabel, hostGameButton, joinGameButton, optionsButton, statsButton);
        contents.setAlignment(Pos.CENTER);
        contents.setSpacing(20);
        HBox.setHgrow(contents, Priority.ALWAYS);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(40);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(30);
        this.getColumnConstraints().addAll(col1, col2, col3);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(100);
        this.getRowConstraints().addAll(row1);
        */
    }

}
