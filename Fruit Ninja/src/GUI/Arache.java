package GUI;

import Control.Controller;
import Logic.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Arache implements Initializable, Observer {
    ArrayList<GameObject> arrayList= new ArrayList<GameObject>();
   //static Thread thread=new Thread();
    int tm;
int seconds=60;
Timer timer=new Timer();
TimerTask task;

    Apple app = new Apple();
    Watermelon waterObject=new Watermelon();
    Orange or = new Orange();
    int index=0;
    boolean sliced=false;
    boolean yes;
    int y;
    int ze;
    Score s=new Score();
    TranslateTransition translate= new TranslateTransition();
    TranslateTransition translate2= new TranslateTransition();
    TranslateTransition translate3= new TranslateTransition();
    Controller control= Controller.getInstance();
    Score score=new Score();
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

    int lifes=3;
    int count=0;
    boolean x;


    @FXML
    ImageView background2;

    @FXML
    ImageView apple;
    @FXML
    ImageView watermelon;
    @FXML
    ImageView pineapple;
    @FXML ImageView fruitSlice;
@FXML
Label maisoon;


    @FXML
    public void moveWatermelon() throws InterruptedException {
      //  Label label=new Label();
        System.out.println("hhhhhh");
        System.out.println(index);
        sliced=true;
        if(arrayList.get(index) instanceof Apple){
            watermelon.setImage(sliceTofaha);
         y=update();
            System.out.println("Score:"+y);
            //label.setText(String.valueOf(y));

        }

        if(arrayList.get(index) instanceof Orange) {
            watermelon.setImage(sliceMoza);
           y = update();
            System.out.println("Score:" + y);
        }

        if(arrayList.get(index) instanceof Watermelon){
            watermelon.setImage(slice);
           y=update();
            System.out.println("Score:"+y);

        }


    }

    public void Timerrr() {
        task = new TimerTask() {
            @Override
            public void run(){
                seconds--;
               // if(seconds==0)
                //    endOver();
                System.out.println("TimerDown" + seconds);

            }
        };}
  /*  public void endOver()throws IOException
    {



            Parent gameScene = FXMLLoader.load(getClass().getResource("chooseLevels.fxml"));
            //Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
            Main.window.setTitle("Hello World");

            Main.window.setScene( new Scene(gameScene, 660, 410));
            Main.window.show();
        }
*/
        public void start ()
        {
            timer.scheduleAtFixedRate(task, 1000, 1000);
        }

    public void translate() throws InterruptedException {

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
      //  maisoon.setText(String.valueOf(seconds));
        translate2.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                sliced=false;
                index++;
                if(index==arrayList.size())
                    index=0;
                if(arrayList.get(index) instanceof Apple){
                    watermelon.setImage(imApple);
                }
                if(arrayList.get(index) instanceof Orange){
                    watermelon.setImage(imPineApple);
                }

                if(arrayList.get(index) instanceof Watermelon){
                    watermelon.setImage(imWater);
                }

                translate2.setNode(watermelon);
                translate2.play();

            }

        });
    }

    public void addingArray(){
        arrayList.add(app);
        arrayList.add(or);
        arrayList.add(waterObject);


    }


    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        addingArray();
        background2.setImage(im);

   Timerrr();
      start();


        apple.setImage(imApple);
        if(arrayList.get(index) instanceof Apple){
            watermelon.setImage(imApple);
        }
        if(arrayList.get(index) instanceof Orange){
            watermelon.setImage(imPineApple);
        }

        if(arrayList.get(index) instanceof Watermelon){
            watermelon.setImage(imWater);
        }
        pineapple.setImage(imPineApple);
        fruitSlice.setImage(slice);
        //label.setText(String.valueOf(y));
        fruitSlice.setVisible(false);

        try {
            translate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


   @Override
    public int update() {
        ze=score.addScore();
        System.out.println("SCORE"+ze);
        return ze;
    }
}
