

package connect_4;


import static connect_4.game.scren_hight;
import static connect_4.game.scren_width;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author kar
 */
public class menu{
     

    static Button option,form,aboutn,log,exit;
   static Label l1,l2,l3,l4,l5,l6,l7;

    public static void men(Stage primaryStage){
           form = new Button();
        form.setText("Start");
        form.setId("btn-start");
        form.setLayoutX(380);
        form.setLayoutY(121);
        
        option = new Button();
        option.setText("Settings");
        option.setId("btn-option");
        option.setLayoutX(366);
        option.setLayoutY(220);
        
        log = new Button();
        log.setText("log");
        log.setId("btn-history");
        log.setLayoutX(380);
        log.setLayoutY(280);
        
        exit = new Button();
        exit.setText("exit");
         exit.setId("btn-exit");
        exit.setLayoutX(380);
        exit.setLayoutY(360);
        primaryStage.setTitle("connect four");
        Group root = new Group();
        Scene scene = new Scene(root, scren_width, scren_hight, Color.BLACK);;
              scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println(" x"+event.getSceneX()+"\t"+"y"+event.getSceneY());
               
            }
        });
        

        ImageView mv=new ImageView("img/bg/bg-menu.jpg");
        mv.setFitWidth(scren_width );
        mv.setFitHeight(scren_hight);
   
    

        log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//               music.option(primaryStage);
//                music.option(primaryStage);
                history.history_view(primaryStage);
            }
        });
         option.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//               music.option(primaryStage);
                music.option(primaryStage);
              
            }
        });
               
               
    

      
        form.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               game.display_form(primaryStage);
            }
            
        });
         exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Platform.exit();
            }
            
        });
       
      

        root.getChildren().addAll(mv);
        root.getChildren().addAll(option,form,log,exit);
//        root.getChildren().add(mv);
        
        scene.getStylesheets().add("connect_4/CSS.css");
        primaryStage.setScene(scene);
        primaryStage.show();
       
        
    }
   
}
