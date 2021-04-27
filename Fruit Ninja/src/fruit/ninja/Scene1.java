package fruit.ninja;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Scene1 {
    Scene scene1;
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        primaryStage.setTitle("hi");
        primaryStage.setScene(scene1);
        scene1=new Scene(root,400,400);
        primaryStage.show();
    }
    public static void main(String[] args)
    {launch(args);}
}