package bits.h20240192.java.dicegame;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    private Label diceFaceValue1;
    @FXML
    private Label diceFaceValue2;
    @FXML
    private Label diceFaceValueSum;

    private static final GameBoard game = new GameBoard(2);

    protected void changeScene(Stage stage, String scene_name) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource(scene_name)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void onRollButtonClick(ActionEvent event) {
        PauseTransition pause = new PauseTransition(
            Duration.seconds(1.8)
        );

        game.rollDice();

        diceFaceValue1.setText(game.dices[0].getFaceValue()+"");
        diceFaceValue2.setText(game.dices[1].getFaceValue()+"");

        diceFaceValueSum.setText(game.getDiceValueSum()+"");

        Button rollButton = (Button) event.getSource();

        pause.setOnFinished(
                _ -> {
                    try {
                        changeScene((Stage) rollButton.getScene().getWindow(), "win-view.fxml");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );

        if ((game.getDiceValueSum()) == 7){
            diceFaceValueSum.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            diceFaceValueSum.setTextFill(Color.WHITE);
            pause.play();
            rollButton.setDisable(true);
        }

    }

    @FXML
    protected void onResetButtonClick(ActionEvent event) throws IOException {
        changeScene((Stage) ((Node)event.getSource()).getScene().getWindow(), "home-view.fxml");
    }
}