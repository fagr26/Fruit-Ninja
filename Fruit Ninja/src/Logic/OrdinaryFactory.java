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
public class OrdinaryFactory {
    public OrdinaryFruit getFruit(String cname) {
        if (cname.equals("Apple")) {
            return new Apple();
        }
        if (cname.equals("Watermelon")) {
            return new Watermelon();
        }
         if (cname.equals("Orange")) {
            return new Orange();
        }
         return null;
    }
}
