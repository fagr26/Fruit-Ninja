package GUI;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOver implements Initializable {
    Image im = new Image("gameOver.jpg");

    @FXML
    ImageView GameOver;


public void chooseLevels() throws IOException {

    Parent gameScene = FXMLLoader.load(getClass().getResource("chooseLevels.fxml"));
    //Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
    Main.window.setTitle("Hello World");

    Main.window.setScene( new Scene(gameScene, 660, 410));
    Main.window.show();

}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameOver.setImage(im);
    }
}
