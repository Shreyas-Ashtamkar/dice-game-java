package bits.h20240192.java.dicegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader homeScreen = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));

        Scene homeScene = new Scene(homeScreen.load());

        stage.setTitle("Dice Game!");
        stage.setScene(homeScene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}