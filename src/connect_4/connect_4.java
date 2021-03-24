package connect_4;

import javafx.application.Application;

import javafx.stage.Stage;

public class connect_4 extends Application {


    @Override
    public void start(Stage primaryStage) {
//        menu men=new menu();
//        men.display(primaryStage);
          menu.display(primaryStage);
//        display(primaryStage);
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
