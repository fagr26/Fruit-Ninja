/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author mayar abu zeid
 */
public class Bombsfactory {
    public Bombs getBombs(String cname) {
        if (cname.equals("Fatal")) {
            return new Fatal();
        }
        if (cname.equals("Dangerous")) {
            return new Dangerous();
        }
       
         return null;
    }
}
