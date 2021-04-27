package GUI;
import Control.Controller;
import Logic.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class LevelBombsScene implements Initializable {
    Apple app = new Apple();
    Watermelon waterObject = new Watermelon();
    Orange or = new Orange();
    Controller control = Controller.getInstance();
    ArrayList<GameObject> list1 = control.addArray1();
    ArrayList<GameObject> list4 = control.addArray2();
    ArrayList<GameObject> list5 = control.addArray3();
    Image life1 = new Image("life.png");
    Image life2 = new Image("life.png");
    Image life3 = new Image("life.png");
    Image sliceTofaha = new Image("sliceTofaha.png");
    Image sliceMoza = new Image("sliceorange.png");
    Image im = new Image("hoh.jpg");
    Image imApple = new Image("apple.png");
    Image imPineApple = new Image("orange.png");
    Image imWater = new Image("watermelon.png");
    Image slice = new Image("fruit-slice.png");
    Image bomb = new Image("bomb.png");
    Image explode = new Image("Explosion-PNG-Image-Background.png");
    Image fatal = new Image("fatal.png");
    Image banana = new Image("blue banana.png");
    Image bananasliced = new Image("sliced banana.png");
    Image grapes = new Image("grapes.png");
    Image slicedGrapes = new Image("slice grapes.png");
    int lifes = 3;
    @FXML
    ImageView background2;
    @FXML
    ImageView apple;
    @FXML
    ImageView watermelon;
    @FXML
    ImageView pineapple;
    @FXML
    ImageView fruitSlice;
    @FXML
    ImageView heart1;
    @FXML
    ImageView heart2;
    @FXML
    ImageView heart3;
    @FXML
    TranslateTransition translate = new TranslateTransition();
    TranslateTransition translate2 = new TranslateTransition();
    TranslateTransition translate3 = new TranslateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void translate() {
        translate.setDuration(Duration.seconds(0.5));
        translate2.setDuration(Duration.seconds(2));
        translate3.setDuration(Duration.seconds(2));
        translate.setNode(apple);
        translate.setToY(-200);
        translate2.setNode(watermelon);
        translate2.setToY(-200);
        translate3.setNode(pineapple);
        translate3.setToY(-200);
        translate.setCycleCount(2);
        translate.setAutoReverse(true);
        translate2.setCycleCount(2);
        translate2.setAutoReverse(true);
        translate3.setCycleCount(2);
        translate3.setAutoReverse(true);
        translate.play();
        translate2.play();
        translate3.play();

    }
}
