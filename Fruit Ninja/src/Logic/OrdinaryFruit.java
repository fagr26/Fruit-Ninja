/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.awt.image.BufferedImage;

/**
 *
 * @author mayar abu zeid
 */
public class OrdinaryFruit implements GameObject{
    private int points=5;
    private boolean done;
    
    public int getPoints() {
        return points;
    }

    @Override
    public int getXlocation() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYlocation() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxHeight() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getInitialVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFallingVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isSliced() {
         done=true;
//To change body of generated methods, choose Tools | Templates.
return done;
    }

    @Override
    public Boolean hasMovedOffScreen() {
      done=false;
      //To change body of generated methods, choose Tools | Templates.
      return done;
    }

    @Override
    public void slice() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(double time) {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BufferedImage[] getBufferedImages() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
    
}
