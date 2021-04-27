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
public interface GameActions {
    public GameObject createGameObject();
/*
* update moving objects locations

*/
public void updateObjectsLocations();
/*
* it is used to slice fruits located in your swiping region
This method can take your swiping region as parameters (they
depend on how you calculate it).
*/
public void sliceObjects();
/*
*saves the current state of the game
*/
public void saveGame();
/*
*loads the last saved state of the game
*/
public void loadGame();
/*
*resets the game to its initial state
*/
public void ResetGame();

}
