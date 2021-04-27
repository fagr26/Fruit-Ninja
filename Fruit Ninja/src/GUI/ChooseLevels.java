package GUI;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sun.swing.plaf.windows.ClassicSortArrowIcon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseLevels implements Initializable {


    Image im = new Image("background.jpg");
    Image classic = new Image("Classic.png");
    Image arcade = new Image("Arcade.png");
    Image zen = new Image("Zen.png");

    @FXML
    ImageView Classic;
    @FXML
    ImageView Arcade;
    @FXML
    ImageView Zen;
    @FXML
    ImageView background;


    @FXML
    public void moveToScene() throws IOException {
        System.out.println("hhhhhh");
        Parent gameScene = FXMLLoader.load(getClass().getResource("LevelScene.fxml"));
        //Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
        Main.window.setTitle("Hello World");

        Main.window.setScene(new Scene(gameScene, 660, 410));
        Main.window.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        background.setImage(im);
        Classic.setImage(classic);
        Arcade.setImage(arcade);
        Zen.setImage(zen);
        RotateTransition rotate= new RotateTransition(Duration.seconds(2),Classic);
        rotate.setByAngle(360);
        rotate.setCycleCount(15);
        rotate.play();
        RotateTransition rotateAr= new RotateTransition(Duration.seconds(2),Arcade);
        rotateAr.setByAngle(360);
        rotateAr.setCycleCount(15);
        rotateAr.play();
        RotateTransition rotateZe= new RotateTransition(Duration.seconds(2),Zen);
        rotateZe.setByAngle(360);
        rotateZe.setCycleCount(15);
        rotateZe.play();
    }
}
