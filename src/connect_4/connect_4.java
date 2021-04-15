package connect_4;

//import static java.awt.SystemColor.menu;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import menu;

public class connect_4 extends Application {


    @Override
    public void start(Stage primaryStage) {
        
//        music mus=new music();
       music.run_music();
       menu.men(primaryStage);
      primaryStage.resizableProperty().setValue(Boolean.FALSE);
//          primaryStage.setMaximized(false);
//        display(primaryStage);
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
