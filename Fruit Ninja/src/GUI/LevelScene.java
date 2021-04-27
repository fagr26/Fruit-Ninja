package GUI;

import Control.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ResourceBundle;
public class LevelScene implements Initializable {
Controller control=Controller.getInstance();
    Image im = new Image("fruitninja1.jpg");
    @FXML
    ImageView background2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        background2.setImage(im);
    }
}
