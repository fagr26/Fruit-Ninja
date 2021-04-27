package GUI;

import Control.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  public static Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
      window=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        window.setTitle("Hello World");
        window.setScene( new Scene(root, 660, 410));

        window.show();

        Controller control = null ;
        control=control.getInstance();
        control.start();
    }
}
