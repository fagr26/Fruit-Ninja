package Logic;


import GUI.LevelScene;
import GUI.Observer;

public class Score {


    GameObject obj=new SpecialFruit();
    GameObject objs=new OrdinaryFruit();
Observer observer;



    public int score=0;
    public int addScore()
    {
        if(objs.isSliced()==true){
        score+=objs.getPoints();
        }
        else if(obj.isSliced())
        {
         score+=obj.getPoints();
        }

        return score;

    }


    public void notifyObservers() {
 observer.update();
    }
}

