package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Logic.GameObject;
import Logic.Load;
import Logic.ManagerSave;
import Logic.Save;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


/**
 *
 * @author mayar abu zeid
 */
public class Controller implements GameActions{
    
private static Controller instance=null;
public static Controller getInstance(){
if(instance==null)
{instance =new Controller();
}
    return instance;
}
ManagerSave manager=new ManagerSave();
Save save=new Save();
Load load=new Load();
public void start(){
 
}
    @Override
    public GameObject createGameObject() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateObjectsLocations() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sliceObjects() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveGame() throws TransformerException, ParserConfigurationException {
       manager.Command(save);
    }

    @Override
    public void loadGame() throws TransformerException, ParserConfigurationException {
manager.Command(load);
    }

    @Override
    public void ResetGame() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
    
}
