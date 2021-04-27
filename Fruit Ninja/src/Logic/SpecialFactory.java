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
public class SpecialFactory {
    public SpecialFruit getFruit(String cname) {
        if (cname.equals("Grapes")) {
            return new Grapes();
        }
        if (cname.equals("BlueBanana")) {
            return new BlueBanana();
        }
        
         return null;
    }
}
