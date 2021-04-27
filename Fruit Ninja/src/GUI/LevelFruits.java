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
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static GUI.Main.audioBack;

public class LevelFruits implements Initializable,Observer{
    int index = 0;
    int indexApple = 0;
    int indexPine = 0;
    boolean sliced = false;
    boolean sliced1 = false;
    boolean sliced2 = false;
    boolean sliced3 = false;
    int y;
    int ze;
    int i;
    int g;
    int t;
    Score score=new Score();
    TranslateTransition translate = new TranslateTransition();
    TranslateTransition translate2 = new TranslateTransition();
    TranslateTransition translate3 = new TranslateTransition();
    TranslateTransition translate4 = new TranslateTransition();
    Controller control = Controller.getInstance();
    ArrayList<GameObject> arrayList = control.addArray1();
    ArrayList<GameObject> object2 = control.addArray2();
    ArrayList<GameObject> object3 = control.addArray3();
    ArrayList<GameObject> object4 = control.addArray4();
    ArrayList<GameObject> list1 = control.addArray1();
    ArrayList<GameObject> list4 = control.addArray2();
    ArrayList<GameObject> list5 = control.addArray3();
    ArrayList<String> loaded;
    String o11;
    String o22;
    String o33;
    int bestscore;
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
    Image scoreIm = new Image("score.png");
    int lifes = 3;
    int count = 0;
    int indexfruit=0;
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
    Label scorelabel;
    @FXML
    ImageView scoreimage;
    @FXML
    ImageView fruit;
    @FXML
    Button save;
    @FXML
    Button load;
    @FXML
    Button reset;
    @FXML
    Label scoree;
    @FXML
    public void moveWatermelon() throws IOException, TransformerException, ParserConfigurationException, SAXException {
        System.out.println("hhhhhh");
        System.out.println(index);
        sliced = true;
        if (arrayList.get(index) instanceof Apple) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            watermelon.setImage(sliceTofaha);
            y=update(new Apple());
            //System.out.println("Score:"+y);
            scorelabel.setText(String.valueOf(ze));
        }
        if (arrayList.get(index) instanceof Orange) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            watermelon.setImage(sliceMoza);
            y=update(new Orange());
            scorelabel.setText(String.valueOf(ze));
        }

        if (arrayList.get(index) instanceof Watermelon) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            watermelon.setImage(slice);
            y=update(new Watermelon());
            scorelabel.setText(String.valueOf(ze));
        }
        if (arrayList.get(index) instanceof Dangerous) {
            AudioClip audio = new AudioClip(getClass().getResource("bomb.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            watermelon.setImage(explode);
            sliced = false;
            y=update(new Dangerous());
            scorelabel.setText(String.valueOf(ze));
        }
        if (arrayList.get(index) instanceof Fatal) {
            AudioClip audio = new AudioClip(getClass().getResource("evilLaugh.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);

            audio.play();

            watermelon.setImage(explode);
            lifes = 0;
            endGame();
            audioBack.stop();

        }
        if (arrayList.get(index) instanceof BlueBanana) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            y=update(new BlueBanana());
            scorelabel.setText(String.valueOf(ze));
            watermelon.setImage(bananasliced);
        }
        if (arrayList.get(index) instanceof Grapes) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            y=update(new Grapes());
            scorelabel.setText(String.valueOf(ze));
            watermelon.setImage(slicedGrapes);
        }
    }

    @FXML
    public void moveApple() throws IOException, TransformerException, SAXException, ParserConfigurationException {
        System.out.println("hhhhhh");
        System.out.println(index);
        sliced1 = true;
        if (object2.get(indexApple) instanceof Apple) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            apple.setImage(sliceTofaha);
            y=update(new Apple());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object2.get(indexApple) instanceof Orange) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            apple.setImage(sliceMoza);
            y=update(new Orange());
            scorelabel.setText(String.valueOf(ze));
        }

        if (object2.get(indexApple) instanceof Watermelon) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            apple.setImage(slice);
            y=update(new Watermelon());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object2.get(indexApple) instanceof Dangerous) {
            AudioClip audio = new AudioClip(getClass().getResource("bomb.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            apple.setImage(explode);
            sliced1= false;
        }
        if (object2.get(indexApple) instanceof Fatal) {
            AudioClip audio = new AudioClip(getClass().getResource("evilLaugh.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            apple.setImage(explode);
            lifes = 0;
            try {
                endGame();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            audioBack.stop();

        }
        if (object2.get(indexApple) instanceof BlueBanana) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            y=update(new BlueBanana());
            scorelabel.setText(String.valueOf(ze));
            apple.setImage(bananasliced);
        }
        if (object2.get(indexApple) instanceof Grapes) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            y=update(new Grapes());
            scorelabel.setText(String.valueOf(ze));
            apple.setImage(slicedGrapes);
        }
    }
    @FXML
    public void movePine() throws IOException, TransformerException, ParserConfigurationException, SAXException {

        sliced2 = true;
        if (object3.get(indexPine) instanceof Apple) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(sliceTofaha);
            y=update(new Apple());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object3.get(indexPine) instanceof Orange) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(sliceMoza);
            y=update(new Orange());
            scorelabel.setText(String.valueOf(ze));
        }

        if (object3.get(indexPine) instanceof Watermelon) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(slice);
            y=update(new Watermelon());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object3.get(indexPine) instanceof Dangerous) {
            AudioClip audio = new AudioClip(getClass().getResource("bomb.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(explode);
            sliced2= false;
        }
        if (object3.get(indexPine) instanceof Fatal) {
            AudioClip audio = new AudioClip(getClass().getResource("evilLaugh.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(explode);
            lifes = 0;
            endGame();
            audioBack.stop();

        }
        if (object3.get(indexPine) instanceof BlueBanana) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(bananasliced);
            y=update(new BlueBanana());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object3.get(indexPine) instanceof Grapes) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            pineapple.setImage(slicedGrapes);
            y=update(new Grapes());
            scorelabel.setText(String.valueOf(ze));
        }
    }
    @FXML
    public void moveFruit() throws IOException, TransformerException, ParserConfigurationException, SAXException {

        sliced3 = true;
        if (object4.get(indexfruit) instanceof Apple) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(sliceTofaha);
            y=update(new Apple());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object4.get(indexfruit) instanceof Orange) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(sliceMoza);
            y=update(new Orange());
            scorelabel.setText(String.valueOf(ze));
        }

        if (object4.get(indexfruit) instanceof Watermelon) {
            AudioClip audio = new AudioClip(getClass().getResource("slicingSound.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(slice);
            y=update(new Watermelon());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object4.get(indexfruit) instanceof Dangerous) {
            AudioClip audio = new AudioClip(getClass().getResource("bomb.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(explode);
            sliced2= false;
        }
        if (object4.get(indexfruit) instanceof Fatal) {
            AudioClip audio = new AudioClip(getClass().getResource("evilLaugh.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(explode);
            lifes = 0;
            endGame();
            audioBack.stop();

        }
        if (object4.get(indexfruit) instanceof BlueBanana) {
            AudioClip audio = new AudioClip(getClass().getResource("Tada.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(bananasliced);
            y=update(new BlueBanana());
            scorelabel.setText(String.valueOf(ze));
        }
        if (object4.get(indexfruit) instanceof Grapes) {
            AudioClip audio = new AudioClip(getClass().getResource("Tada.mp3").toString());
            //audio.setVolume(0.5f);
            audio.setCycleCount(1);
            audio.play();
            fruit.setImage(slicedGrapes);
            y=update(new Grapes());
            scorelabel.setText(String.valueOf(ze));
        }
    }



    public void setLife() throws IOException, TransformerException, ParserConfigurationException, SAXException {


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

    public void setLife1() throws IOException, TransformerException, ParserConfigurationException, SAXException {


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
    public void setLife2() throws IOException, TransformerException, ParserConfigurationException, SAXException {


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
    public void setLife3() throws IOException, TransformerException, ParserConfigurationException, SAXException {


        if (sliced3 == false && count == 0) {
            count++;
            lifes--;
            endGame();
            heart1.setVisible(false);
        } else if (sliced3 == false && count == 1) {
            count++;
            lifes--;
            endGame();
            //System.out.println("ya wala");
            heart2.setVisible(false);

        } else if (sliced3 == false && count == 2) {
            count++;
            lifes--;
            endGame();
            //System.out.println("yarab");
            heart3.setVisible(false);

        }
    }
    public void translate() {
        translate.setDuration(Duration.seconds(arrayList.get(index).getInitialVelocity()));
        translate2.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
        translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
        translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
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
        translate4.setNode(fruit);
        translate4.setToY(-350);
        translate4.setCycleCount(2);
        translate4.setAutoReverse(true);
        translate.play();
        translate2.play();
        translate3.play();
        translate4.play();
        translate2.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    setLife();
                } catch (IOException | TransformerException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
                sliced = false;
                index++;
                if (index == arrayList.size())
                    index = 0;
                if (arrayList.get(index) instanceof Apple) {
                    watermelon.setImage(imApple);
                    translate2.setDuration(Duration.seconds(arrayList.get(index).getInitialVelocity()));
                }
                if (arrayList.get(index) instanceof Orange) {
                    watermelon.setImage(imPineApple);

                }

                if (arrayList.get(index) instanceof Watermelon) {
                    watermelon.setImage(imWater);
                }
                if (arrayList.get(index) instanceof Dangerous) {
                    sliced = true;
                    watermelon.setImage(bomb);
                    translate2.setDuration(Duration.seconds(arrayList.get(index).getInitialVelocity()));
                }
                if (arrayList.get(index) instanceof Fatal) {
                    sliced=true;
                    watermelon.setImage(fatal);
                    translate2.setDuration(Duration.seconds(arrayList.get(index).getInitialVelocity()));
                }
                if (arrayList.get(index) instanceof BlueBanana) {
                    watermelon.setImage(banana);
                    translate2.setDuration(Duration.seconds(arrayList.get(index).getInitialVelocity()));
                }
                if (arrayList.get(index) instanceof Grapes) {
                    watermelon.setImage(grapes);
                    translate2.setDuration(Duration.seconds(arrayList.get(index).getInitialVelocity()));
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
                } catch (IOException | TransformerException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
                sliced1 = false;
                indexApple++;
                if (indexApple == object2.size())
                    indexApple = 0;
                if (object2.get(indexApple) instanceof Apple) {
                    apple.setImage(imApple);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
                }
                if (object2.get(indexApple) instanceof Orange) {
                    apple.setImage(imPineApple);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
                }

                if (object2.get(indexApple) instanceof Watermelon) {
                    apple.setImage(imWater);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
                }
                if (object2.get(indexApple) instanceof Dangerous) {
                    sliced1 = true;
                    apple.setImage(bomb);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
                }
                if (object2.get(indexApple) instanceof Fatal) {
                    sliced1=true;
                    apple.setImage(fatal);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
                }
                if (object2.get(indexApple) instanceof BlueBanana) {
                    apple.setImage(banana);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
                }
                if (object2.get(indexApple) instanceof Grapes) {
                    apple.setImage(grapes);
                    translate.setDuration(Duration.seconds(object2.get(indexApple).getInitialVelocity()));
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
                } catch (IOException | TransformerException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
                sliced2 = false;
                indexPine++;
                if (indexPine == object3.size())
                    indexPine = 0;
                if (object3.get(indexPine) instanceof Apple) {
                    pineapple.setImage(imApple);
                    translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }
                if (object3.get(indexPine) instanceof Orange) {
                    pineapple.setImage(imPineApple);
                    translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }

                if (object3.get(indexPine) instanceof Watermelon) {
                    pineapple.setImage(imWater);
                    translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }
                if (object3.get(indexPine) instanceof Dangerous) {
                    sliced2 = true;
                    pineapple.setImage(bomb);
                    translate.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }
                if (object3.get(indexPine) instanceof Fatal) {
                    sliced2=true;
                    pineapple.setImage(fatal);
                    translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }
                if (object3.get(indexPine) instanceof BlueBanana) {
                    pineapple.setImage(banana);
                    translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }
                if (object3.get(indexPine) instanceof Grapes) {
                    pineapple.setImage(grapes);
                    translate3.setDuration(Duration.seconds(object3.get(indexPine).getInitialVelocity()));
                }

                translate3.setNode(pineapple);
                translate3.play();
            }
        });
        translate4.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    setLife3();
                } catch (IOException | TransformerException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
                sliced3 = false;
                indexfruit++;
                if (indexfruit == object4.size())
                    indexfruit = 0;
                if (object4.get(indexfruit) instanceof Apple) {
                    fruit.setImage(imApple);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                    System.out.println("hiiiiiii");
                }
                if (object4.get(indexfruit) instanceof Orange) {
                    fruit.setImage(imPineApple);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                }

                if (object4.get(indexfruit) instanceof Watermelon) {
                    fruit.setImage(imWater);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                }
                if (object4.get(indexfruit) instanceof Dangerous) {
                    sliced3 = true;
                    fruit.setImage(bomb);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                }
                if (object4.get(indexfruit) instanceof Fatal) {
                    sliced3=true;
                    fruit.setImage(fatal);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                }
                if (object4.get(indexfruit) instanceof BlueBanana) {
                    fruit.setImage(banana);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                }
                if (object4.get(indexfruit) instanceof Grapes) {
                    fruit.setImage(grapes);
                    translate4.setDuration(Duration.seconds(object4.get(indexfruit).getInitialVelocity()));
                }

                translate4.setNode(fruit);
                translate4.play();
            }
        });
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            int bs=control.Loadscore();
            String e=Integer.toString(bs);
            System.out.println("e=" +e);
            scoree.setText(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        background2.setImage(im);
        scoreimage.setImage(scoreIm);
        if (arrayList.get(index) instanceof Apple) {
            watermelon.setImage(imApple);
        }
        if (arrayList.get(index) instanceof Orange) {
            watermelon.setImage(imPineApple);
        }

        if (arrayList.get(index) instanceof Watermelon) {
            watermelon.setImage(imWater);
        }
        if (arrayList.get(index) instanceof Dangerous) {
            watermelon.setImage(bomb);
        }
        if (arrayList.get(index) instanceof Fatal) {
            watermelon.setImage(fatal);
        }
        if (arrayList.get(index) instanceof BlueBanana) {
            watermelon.setImage(banana);
        }
        if (arrayList.get(index) instanceof Grapes) {
            watermelon.setImage(grapes);
        }

        if (object2.get(indexApple) instanceof Apple) {
            apple.setImage(imApple);
        }
        if (object2.get(indexApple) instanceof Orange) {
            apple.setImage(imPineApple);
        }

        if (object2.get(indexApple) instanceof Watermelon) {
            apple.setImage(imWater);
        }
        if (object2.get(index) instanceof Dangerous) {
            apple.setImage(bomb);
        }
        if (object2.get(indexApple) instanceof Fatal) {
            apple.setImage(fatal);
        }
        if (object2.get(indexApple) instanceof BlueBanana) {
            apple.setImage(banana);
        }
        if (object2.get(indexApple) instanceof Grapes) {
            apple.setImage(grapes);
        }

        if (object3.get(indexPine) instanceof Apple) {
            pineapple.setImage(imApple);
        }
        if (object3.get(indexPine) instanceof Orange) {
            pineapple.setImage(imPineApple);
        }

        if (object3.get(indexPine) instanceof Watermelon) {
            pineapple.setImage(imWater);
        }
        if (object3.get(indexPine) instanceof Dangerous) {
            pineapple.setImage(bomb);
        }
        if (object3.get(indexPine) instanceof Fatal) {
            pineapple.setImage(fatal);
        }
        if (object3.get(indexPine) instanceof BlueBanana) {
            pineapple.setImage(banana);
        }
        if (object3.get(indexPine) instanceof Grapes) {
            pineapple.setImage(grapes);
        }
        if (object4.get(indexfruit) instanceof Apple) {
            fruit.setImage(imApple);
        }
        if (object4.get(indexfruit) instanceof Orange) {
            fruit.setImage(imPineApple);
        }

        if (object4.get(indexfruit) instanceof Watermelon) {
            fruit.setImage(imWater);
        }
        if (object4.get(indexfruit) instanceof Dangerous) {
            fruit.setImage(bomb);
        }
        if (object4.get(indexfruit) instanceof Fatal) {
            fruit.setImage(fatal);
        }
        if (object4.get(indexfruit) instanceof BlueBanana) {
            fruit.setImage(banana);
        }
        if (object4.get(indexfruit) instanceof Grapes) {
            fruit.setImage(grapes);
        }
        translate();
        pineapple.setImage(imPineApple);
        fruitSlice.setImage(slice);
        fruitSlice.setVisible(false);
        heart1.setImage(life1);
        heart2.setImage(life2);
        heart3.setImage(life3);
    }
    public int update(GameObject fruit) throws SAXException, TransformerException, ParserConfigurationException, IOException {
        ze=score.addScore(fruit);
        int bs=control.Loadscore();
        if(ze>bs)
            scoree.setText(String.valueOf(ze));
        System.out.println("bestt in updat" +bs);
        scorelabel.setText(String.valueOf(ze));
        System.out.println("SCORE"+ze);
        return ze;
    }
    public void Save() throws TransformerException, ParserConfigurationException, IOException, SAXException {
        GameObject object1=list1.get(index);
        GameObject object4=list4.get(indexApple);
        GameObject object5=list5.get(indexPine);
        control.saveGame(ze,lifes,object1,object4,object5);


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
        ze=control.Loadcurrent();
        o11=loaded.get(0);
        o22=loaded.get(1);
        o33=loaded.get(2);
        if (o11.equals("apple"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof Apple)
                {index=i;
                    watermelon.setImage(imApple);
                }
            }
        }
        else if (o11.equals("orange"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof Orange)
                {index=i;
                    watermelon.setImage(imPineApple);
                }

            }
        }
        else if (o11.equals("watermelon"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof Watermelon)
                {index=i;
                    watermelon.setImage(imWater);
                }

            }
        }
        else if (o11.equals("banana"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof BlueBanana)
                {index=i;
                    watermelon.setImage(banana);
                }

            }
        }
        else if (o11.equals("grapes"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof Grapes)
                {index=i;
                    watermelon.setImage(grapes);
                }

            }
        }
        else if (o11.equals("fatal"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof Fatal)
                {index=i;
                    watermelon.setImage(fatal);
                }
            }
        }
        else if (o11.equals("dangerous"))
        {
            for(i=0;i<list1.size();i++) {
                if (list1.get(i) instanceof Dangerous)
                {index=i;
                    watermelon.setImage(bomb);
                }

            }
        }
        System.out.println("indnex= " +index);
        if (o22.equals("apple"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof Apple)
                {indexApple=g;
                    apple.setImage(imApple);
                }

            }
        }
        else if (o22.equals("orange"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof Orange)
                {indexApple=g;
                    apple.setImage(imPineApple);
                }

            }
        }
        else if (o22.equals("watermelon"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof Watermelon)
                {indexApple=g;
                    apple.setImage(imWater);
                }

            }
        }
        else if (o22.equals("fatal"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof Fatal)
                {indexApple=g;
                    apple.setImage(fatal);
                }

            }
        }
        else if (o22.equals("banana"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof BlueBanana)
                {indexApple=g;
                    apple.setImage(banana);
                }

            }
        }
        else if (o22.equals("grapes"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof Grapes)
                {indexApple=g;
                    apple.setImage(grapes);
                }


            }
        }
        else if (o22.equals("dangerous"))
        {
            for(g=0;g<list4.size();g++) {
                if (list4.get(g) instanceof Dangerous)
                {indexApple=g;
                    apple.setImage(bomb);
                }
            }
        }
        System.out.println("indexApple= " +indexApple);
        if (o33.equals("apple"))
        {
            for(t=0;t<list5.size();t++) {
                if (list5.get(t) instanceof Apple)
                {indexPine=t;
                    pineapple.setImage(imApple);
                }
            }
        }
        else if (o33.equals("orange"))
        {
            for(t=0;t<list5.size();t++) {
                if (list5.get(t) instanceof Orange)
                {indexPine=t;
                    pineapple.setImage(imPineApple);
                }
            }
        }
        else if (o33.equals("watermelon"))
        {
            for(t=0;g<list5.size();t++) {
                if (list5.get(t) instanceof Watermelon)
                {indexPine=t;
                    pineapple.setImage(imWater);
                }
            }
        }
        else if (o33.equals("fatal"))
        {
            for(t=0;t<list5.size();t++) {
                if (list5.get(t) instanceof Fatal)
                {indexPine=t;
                    pineapple.setImage(fatal);
                }
            }
        }
        else if (o33.equals("banana"))
        {
            for(t=0;t<list5.size();t++) {
                if (list5.get(t) instanceof BlueBanana)
                {indexPine=t;
                    pineapple.setImage(banana);
                }

            }
        }
        else if (o33.equals("grapes"))
        {
            for(t=0;t<list5.size();t++) {
                if (list5.get(t) instanceof Grapes)
                {indexPine=t;
                    pineapple.setImage(grapes);
                }
            }
        }
        else if (o33.equals("dangerous"))
        {
            for(t=0;t<list5.size();t++) {
                if (list5.get(t) instanceof Dangerous)
                {indexPine=t;
                    pineapple.setImage(bomb);
                }
            }
        }

        System.out.println("indexP= " +indexPine);
        translate();
    }
    public int resett(){
        ze=score.reset();
        return ze;
    }
    public void reset() throws IOException {
        indexPine=0;
        index=0;
        indexApple=0;
        ze=resett();
       scorelabel.setText(Integer.toString(ze));
        lifes=3;
        heart1.setVisible(true);
        heart2.setVisible(true);
        heart3.setVisible(true);
        count=0;
        watermelon.setImage(imApple);
        apple.setImage(grapes);
        pineapple.setImage(imWater);


    }
    public void endGame() throws IOException, TransformerException, ParserConfigurationException, SAXException {

        if (lifes == 0) {

            audioBack.stop();
            translate.pause();
            translate2.pause();
            translate3.pause();
            Save();

            Parent gameScene = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            Main.window.setTitle("Hello World");
            Main.window.setScene(new Scene(gameScene, 660, 410));
            Main.window.show();


        }
    }


}
