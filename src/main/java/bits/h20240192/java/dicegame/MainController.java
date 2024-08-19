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
import java.util.Random;

public class MainController {
    @FXML
    private Label diceFaceValue1;
    @FXML
    private Label diceFaceValue2;
    @FXML
    private Label diceFaceValueSum;

    Random dice = new Random();

    int diceValue1;
    int diceValue2;

    protected void changeScene(Stage stage, String scene_name) throws IOException {
//        "win-.fxml"
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource(scene_name)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void onRollButtonClick(ActionEvent event) throws IOException {
        PauseTransition pause = new PauseTransition(
            Duration.seconds(1.8)
        );

        diceValue1 = dice.nextInt(1, 7);
        diceValue2 = dice.nextInt(1, 7);

        diceFaceValue1.setText(diceValue1+"");
        diceFaceValue2.setText(diceValue2+"");

        diceFaceValueSum.setText(diceValue1+diceValue2+"");

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

        if ((diceValue1+diceValue2) == 7){
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