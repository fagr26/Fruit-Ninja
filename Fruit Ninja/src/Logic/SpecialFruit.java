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
public class SpecialFruit implements GameObject{
private int points=15;
boolean done;

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
        return done;
        
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean hasMovedOffScreen() {
       done=false;
       return done;
        
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void slice() {
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
