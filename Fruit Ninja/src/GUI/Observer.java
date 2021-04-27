package GUI;

import Logic.Score;

public interface Observer {
    Score score = new Score();
   public int update();


}
