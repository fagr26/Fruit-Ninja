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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LevelBombs implements Initializable,Observer{
    int cscore;
    int bestscore;
    int y;
    int index = 0;
    int indexApple = 0;
    int indexPine = 0;
    boolean sliced = false;
    boolean sliced1 = false;
    boolean sliced2 = false;
    private Manager manager=new Manager(); //for commandpattern
    public Save Savee; //for commandpattern

 int i;
 int g;
 int t;
   public int lifes=3;
    int count=0;
    TranslateTransition translate = new TranslateTransition();
    TranslateTransition translate2 = new TranslateTransition();
    TranslateTransition translate3 = new TranslateTransition();
    Controller control = Controller.getInstance();
    ArrayList<GameObject> list1 = control.addArray1();
    ArrayList<GameObject> list4 = control.addArray4();
    ArrayList<GameObject> list5 = control.addArray5();
    ArrayList<GameObject> loaded;
    GameObject o11;
    GameObject o22;
    GameObject o33;
    ArrayList<GameObject> slicedfruits = new ArrayList<>();

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
    @FXML
    Label label1;
    @FXML
    Button save;
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
    Label label;

    @FXML
    public void moveWatermelon() throws IOException {
        System.out.println("hhhhhh");
        System.out.println(index);
        sliced = true;
        if (list1.get(index) instanceof Apple) {
            watermelon.setImage(sliceTofaha);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list1.get(index) instanceof Orange) {
            watermelon.setImage(sliceMoza);
            y=update();
            System.out.println("Score:"+y);
        }
        y=update();
        System.out.println("Score:"+y);
        if (list1.get(index) instanceof Watermelon) {
            watermelon.setImage(slice);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list1.get(index) instanceof Dangerous) {
            watermelon.setImage(explode);
            sliced = false;
            y=update();
            System.out.println("Score:"+y);
        }
        if (list1.get(index) instanceof Fatal) {
            watermelon.setImage(explode);
            lifes = 0;
            endGame();

        }
        if (list1.get(index) instanceof BlueBanana) {
            y=update();
            System.out.println("Score:"+y);
            watermelon.setImage(bananasliced);
        }
        if (list1.get(index) instanceof Grapes) {
            y=update();
            System.out.println("Score:"+y);
            watermelon.setImage(slicedGrapes);
        }
    }
    @FXML
    public void moveApple() throws IOException {
        System.out.println("hhhhhh");
        System.out.println(index);
        sliced1 = true;
        if (list4.get(indexApple) instanceof Apple) {
            apple.setImage(sliceTofaha);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list4.get(indexApple) instanceof Orange) {
            apple.setImage(sliceMoza);
            y=update();
            System.out.println("Score:"+y);
        }

        if (list4.get(indexApple) instanceof Watermelon) {
            apple.setImage(slice);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list4.get(indexApple) instanceof Dangerous) {
            apple.setImage(explode);
            sliced1= false;
        }
        if (list4.get(indexApple) instanceof Fatal) {
            apple.setImage(explode);
            lifes = 0;
            endGame();

        }
        if (list4.get(indexApple) instanceof BlueBanana) {
            y=update();
            System.out.println("Score:"+y);
            apple.setImage(bananasliced);
        }
        if (list4.get(indexApple) instanceof Grapes) {
            y=update();
            System.out.println("Score:"+y);
            apple.setImage(slicedGrapes);
        }
    }
    @FXML
    public void movePine() throws IOException {

        sliced2 = true;
        if (list5.get(indexPine) instanceof Apple) {
            pineapple.setImage(sliceTofaha);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list5.get(indexPine) instanceof Orange) {
            pineapple.setImage(sliceMoza);
            y=update();
            System.out.println("Score:"+y);
        }

        if (list5.get(indexPine) instanceof Watermelon) {
            pineapple.setImage(slice);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list5.get(indexPine) instanceof Dangerous) {
            pineapple.setImage(explode);
            sliced2= false;
        }
        if (list5.get(indexPine) instanceof Fatal) {
            pineapple.setImage(explode);
            lifes = 0;
            endGame();

        }
        if (list5.get(indexPine) instanceof BlueBanana) {
            pineapple.setImage(bananasliced);
            y=update();
            System.out.println("Score:"+y);
        }
        if (list5.get(indexPine) instanceof Grapes) {
            pineapple.setImage(slicedGrapes);
            y=update();
            System.out.println("Score:"+y);
        }
    }
    public void setLife() throws IOException {


        if (sliced == false && count == 0) {
            count++;
            lifes--;
            endGame();
            heart1.setVisible(false);
        } else if (sliced == false && count == 1) {
            count++;
            lifes--;
            endGame();
            //System.out.println("ya wala");
            heart2.setVisible(false);

        } else if (sliced == false && count == 2) {
            count++;
            lifes--;
            endGame();
            //System.out.println("yarab");
            heart3.setVisible(false);

        }
        System.out.println(lifes);
    }

    public void setLife1() throws IOException {


        if (sliced1 == false && count == 0) {
            count++;
            lifes--;
            endGame();
            heart1.setVisible(false);
        } else if (sliced1 == false && count == 1) {
            count++;
            lifes--;
            endGame();
            //System.out.println("ya wala");
            heart2.setVisible(false);

        } else if (sliced1 == false && count == 2) {
            count++;
            lifes--;
            endGame();
            //System.out.println("yarab");
            heart3.setVisible(false);

        }
        System.out.println(lifes);
    }
    public void setLife2() throws IOException {


        if (sliced2 == false && count == 0) {
            count++;
            lifes--;
            endGame();
            heart1.setVisible(false);
        } else if (sliced2 == false && count == 1) {
            count++;
            lifes--;
            endGame();
            //System.out.println("ya wala");
            heart2.setVisible(false);

        } else if (sliced2 == false && count == 2) {
            count++;
            lifes--;
            endGame();
            //System.out.println("yarab");
            heart3.setVisible(false);

        }

    }

    public void translate() {
        translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
        translate2.setDuration(Duration.seconds(list1.get(index).getInitialVelocity()));
        translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
        translate.setNode(apple);
        translate.setToY(-350);
        translate2.setNode(watermelon);
        translate2.setToY(-350);
        translate3.setNode(pineapple);
        translate3.setToY(-350);
        translate.setCycleCount(2);
        translate.setAutoReverse(true);
        translate2.setCycleCount(2);
        translate2.setAutoReverse(true);
        translate3.setCycleCount(2);
        translate3.setAutoReverse(true);
        translate.play();
        translate2.play();
        translate3.play();

        translate2.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    setLife();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sliced = false;
                index++;
                if (index == list1.size())
                    index = 0;
                if (list1.get(index) instanceof Apple) {
                    watermelon.setImage(imApple);
                    translate2.setDuration(Duration.seconds(list1.get(index).getInitialVelocity()));
                }
                if (list1.get(index) instanceof Orange) {
                    watermelon.setImage(imPineApple);

                }

                if (list1.get(index) instanceof Watermelon) {
                    watermelon.setImage(imWater);
                }
                if (list1.get(index) instanceof Dangerous) {
                    sliced = true;
                    watermelon.setImage(bomb);
                    translate2.setDuration(Duration.seconds(list1.get(index).getInitialVelocity()));
                }
                if (list1.get(index) instanceof Fatal) {
                    sliced=true;
                    watermelon.setImage(fatal);
                    translate2.setDuration(Duration.seconds(list1.get(index).getInitialVelocity()));
                }
                if (list1.get(index) instanceof BlueBanana) {
                    watermelon.setImage(banana);
                    translate2.setDuration(Duration.seconds(list1.get(index).getInitialVelocity()));
                }
                if (list1.get(index) instanceof Grapes) {
                    watermelon.setImage(grapes);
                    translate2.setDuration(Duration.seconds(list1.get(index).getInitialVelocity()));
                }

                translate2.setNode(watermelon);
                translate2.play();
            }
        });

        translate.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    setLife1();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sliced1 = false;
                indexApple++;
                if (indexApple == list4.size())
                    indexApple = 0;
                if (list4.get(indexApple) instanceof Apple) {
                    apple.setImage(imApple);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }
                if (list4.get(indexApple) instanceof Orange) {
                    apple.setImage(imPineApple);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }

                if (list4.get(indexApple) instanceof Watermelon) {
                    apple.setImage(imWater);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }
                if (list4.get(indexApple) instanceof Dangerous) {
                    sliced1 = true;
                    apple.setImage(bomb);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }
                if (list4.get(indexApple) instanceof Fatal) {
                    sliced1=true;
                    apple.setImage(fatal);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }
                if (list4.get(indexApple) instanceof BlueBanana) {
                    apple.setImage(banana);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }
                if (list4.get(indexApple) instanceof Grapes) {
                    apple.setImage(grapes);
                    translate.setDuration(Duration.seconds(list4.get(indexApple).getInitialVelocity()));
                }

                translate.setNode(apple);
                translate.play();
            }
        });
        translate3.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    setLife2();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sliced2 = false;
                indexPine++;
                if (indexPine == list5.size())
                    indexPine = 0;
                if (list5.get(indexPine) instanceof Apple) {
                    pineapple.setImage(imApple);
                    translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }
                if (list5.get(indexPine) instanceof Orange) {
                    pineapple.setImage(imPineApple);
                    translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }

                if (list5.get(indexPine) instanceof Watermelon) {
                    pineapple.setImage(imWater);
                    translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }
                if (list5.get(indexPine) instanceof Dangerous) {
                    sliced2 = true;
                    pineapple.setImage(bomb);
                    translate.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }
                if (list5.get(indexPine) instanceof Fatal) {
                    sliced2=true;
                    pineapple.setImage(fatal);
                    translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }
                if (list5.get(indexPine) instanceof BlueBanana) {
                    pineapple.setImage(banana);
                    translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }
                if (list5.get(indexPine) instanceof Grapes) {
                    pineapple.setImage(grapes);
                    translate3.setDuration(Duration.seconds(list5.get(indexPine).getInitialVelocity()));
                }

                translate3.setNode(pineapple);
                translate3.play();
            }
        });
    }
    public void endGame() throws IOException {

        if (lifes == 0) {

            translate.pause();
            translate2.pause();
            translate3.pause();
            Parent gameScene = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            Main.window.setTitle("Hello World");
            Main.window.setScene(new Scene(gameScene, 660, 410));
            Main.window.show();


        }
    }
    @Override
    public int update() {
        cscore=score.addScore();
        System.out.println("SCORE"+cscore);
        return cscore;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        background2.setImage(im);
       // apple.setImage(imApple);
        if (list1.get(index) instanceof Apple) {
            watermelon.setImage(imApple);
        }
        if (list1.get(index) instanceof Orange) {
            watermelon.setImage(imPineApple);
        }

        if (list1.get(index) instanceof Watermelon) {
            watermelon.setImage(imWater);
        }
        if (list1.get(index) instanceof Dangerous) {
            watermelon.setImage(bomb);
        }
        if (list1.get(index) instanceof Fatal) {
            watermelon.setImage(fatal);
        }
        if (list1.get(index) instanceof BlueBanana) {
            watermelon.setImage(banana);
        }
        if (list1.get(index) instanceof Grapes) {
            watermelon.setImage(grapes);
        }

        if (list4.get(indexApple) instanceof Apple) {
            apple.setImage(imApple);
        }
        if (list4.get(indexApple) instanceof Orange) {
            apple.setImage(imPineApple);
        }

        if (list4.get(indexApple) instanceof Watermelon) {
            apple.setImage(imWater);
        }
        if (list4.get(index) instanceof Dangerous) {
            apple.setImage(bomb);
        }
        if (list4.get(indexApple) instanceof Fatal) {
            apple.setImage(fatal);
        }
        if (list4.get(indexApple) instanceof BlueBanana) {
            apple.setImage(banana);
        }
        if (list4.get(indexApple) instanceof Grapes) {
            apple.setImage(grapes);
        }

        if (list5.get(indexPine) instanceof Apple) {
            pineapple.setImage(imApple);
        }
        if (list5.get(indexPine) instanceof Orange) {
            pineapple.setImage(imPineApple);
        }

        if (list5.get(indexPine) instanceof Watermelon) {
            pineapple.setImage(imWater);
        }
        if (list5.get(indexPine) instanceof Dangerous) {
            pineapple.setImage(bomb);
        }
        if (list5.get(indexPine) instanceof Fatal) {
            pineapple.setImage(fatal);
        }
        if (list5.get(indexPine) instanceof BlueBanana) {
            pineapple.setImage(banana);
        }
        if (list5.get(indexPine) instanceof Grapes) {
            pineapple.setImage(grapes);
        }
        translate();
        //pineapple.setImage(imWater);
        heart1.setImage(life1);
        heart2.setImage(life2);
        heart3.setImage(life3);


    }
    public void Save() throws TransformerException, ParserConfigurationException, IOException, SAXException {


        GameObject object1=list1.get(index);
       GameObject object4=list4.get(indexApple);
       GameObject object5=list5.get(indexPine);
      control.saveGame(cscore,lifes,object1,object4,object5);



    }
    public void Load() throws TransformerException, ParserConfigurationException, IOException, SAXException {
   bestscore=control.Loadscore();
        lifes=control.Loadlives();
        if (lifes == 1) {
                heart1.setVisible(false);
                heart2.setVisible(false);
            } else if (lifes == 2)
                heart1.setVisible(false);
        loaded=control.loadGame();
        cscore=control.Loadcurrent();
        o11=loaded.get(0);
        System.out.println("o111" +o11);
        o22=loaded.get(1);
        System.out.println("o222" +o22);
        o33=loaded.get(2);
        System.out.println("o333" +o33);
        for(i=0;i<list1.size();i++) {
            if (o11 instanceof Apple && list1.get(i) instanceof Apple)
             {
                index = i;
                break;
            }
            System.out.println("index" + i);

        }
        for(g=0;g<list4.size();g++) {
            if (o22 == list4.get(g)) {
                indexApple=g;
                break;
            }
            System.out.println("indexapple" + g);
        }
        for(t=0;t<list5.size();t++) {
            if (o33 == list5.get(t)) {
                indexPine = t;
                break;
            }
            System.out.println("indexpine" + t);
        }

    }
}

