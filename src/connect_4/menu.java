

package connect_4;

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
     

    static Button option,form,about,exit;
   static Label l1,l2,l3,l4,l5,l6,l7;
   public static void info(Stage primaryStage){
               Button back = new Button();
               back.setText("return to the menu");
               back.setLayoutX(500);
               back.setLayoutY(500);
       ImageView mv=new ImageView("3.jpg");
            mv.setFitWidth(1000);
            mv.setFitHeight(1000);
            back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               menu.men(primaryStage);
            }
        });
       
   l1=new Label("Name: Eslam Khaled Eid "+"\n"+"ID: 20191700105" );
         l2=new Label("Name: Mohamed Sameh Ahmed "+"\n"+"ID: 20191700533" );
          l3=new Label("Name: Asmaa Khaled Rashad "+"\n"+"ID: 20191700115" );
           l4=new Label("Name: Ahmed Hemada "+"\n"+"ID: 20191700028" );
           l5=new Label("Name: Eslam Mohamed "+"\n"+"ID: 20191700111" );
           l6=new Label("Name: Ahmed Hamada "+"\n"+"ID: 20191700026" );
            l7=new Label("G084");
            l1.setFont(new Font("Arial", 25));
        l1.setTranslateX(85);
        l1.setTranslateY(95);
        l1.setTextFill(Color.WHEAT);
        
        l2.setFont(new Font("Arial", 20));
        l2.setTranslateX(85);
        l2.setTranslateY(170);
        l2.setTextFill(Color.WHEAT);
         
        l3.setFont(new Font("Arial", 25));
        l3.setTranslateX(85);
        l3.setTranslateY(230);
        l3.setTextFill(Color.WHEAT);
        
        l4.setFont(new Font("Arial", 20));
        l4.setTranslateX(85);
        l4.setTranslateY(300);
        l4.setTextFill(Color.WHEAT);
        
        l5.setFont(new Font("Arial", 25));
        l5.setTranslateX(85);
        l5.setTranslateY(360);
        l5.setTextFill(Color.WHEAT);
        
        l6.setFont(new Font("Arial", 20));
        l6.setTranslateX(85);
        l6.setTranslateY(430);
        l6.setTextFill(Color.WHEAT);
        
        l7.setFont(new Font("Arial", 35));
        l7.setTranslateX(70);
        l7.setTranslateY(20);
        l7.setTextFill(Color.AQUA);
        
         l1.setOnMouseEntered((MouseEvent e) -> {
            l1.setTextFill(Color.RED);
            l1.setScaleX(1.2);
            l1.setScaleY(1.2);
            
        });
         
         l1.setOnMouseExited((MouseEvent e) -> {
            l1.setTextFill(Color.WHEAT);
            l1.setScaleX(1);
            l1.setScaleY(1);
        });
 
         l2.setOnMouseEntered((MouseEvent e) -> {
            l2.setTextFill(Color.RED);
            l2.setScaleX(1.2);
            l2.setScaleY(1.2);
        });
         
         l2.setOnMouseExited((MouseEvent e) -> {
            l2.setTextFill(Color.WHEAT);
            l2.setScaleX(1);
            l2.setScaleY(1);
        });
         
         l3.setOnMouseEntered((MouseEvent e) -> {
            l3.setTextFill(Color.RED);
            l3.setScaleX(1.2);
            l3.setScaleY(1.2);
        });
         
         l3.setOnMouseExited((MouseEvent e) -> {
            l3.setTextFill(Color.WHEAT);
            l3.setScaleX(1);
            l3.setScaleY(1);
        });
         
         l4.setOnMouseEntered((MouseEvent e) -> {
            l4.setTextFill(Color.RED);
            l4.setScaleX(1.2);
            l4.setScaleY(1.2);
        });
         
         l4.setOnMouseExited((MouseEvent e) -> {
            l4.setTextFill(Color.WHEAT);
            l4.setScaleX(1);
            l4.setScaleY(1);
        });
 
         l5.setOnMouseEntered((MouseEvent e) -> {
            l5.setTextFill(Color.RED);
            l5.setScaleX(1.2);
            l5.setScaleY(1.2);
        });
         
         l5.setOnMouseExited((MouseEvent e) -> {
            l5.setTextFill(Color.WHEAT);
            l5.setScaleX(1);
            l5.setScaleY(1);
        });
         
         l6.setOnMouseEntered((MouseEvent e) -> {
            l6.setTextFill(Color.RED);
            l6.setScaleX(1.2);
            l6.setScaleY(1.2);
        });
         
         l6.setOnMouseExited((MouseEvent e) -> {
            l6.setTextFill(Color.WHEAT);
            l6.setScaleX(1);
            l6.setScaleY(1);
        });
 
         l7.setOnMouseEntered((MouseEvent e) -> {
            l7.setTextFill(Color.RED);
            l7.setScaleX(1.5);
            l7.setScaleY(1.5);
        });
         
         l7.setOnMouseExited((MouseEvent e) -> {
            l7.setTextFill(Color.AQUA);
            l7.setScaleX(1.1);
            l7.setScaleY(1.1);
        });
         Group root = new Group();
root.getChildren().addAll(mv);
                   root.getChildren().addAll(l1,l2,l3,l4,l5,l6,l7);
                     primaryStage.setScene(new Scene(root, 1000,1000));
        primaryStage.show();
        root.getChildren().addAll(back);
                


   
   }
    public static void men(Stage primaryStage){
        
          primaryStage.setTitle("connect four");
        Button option = new Button();
        option.setText("Settings");
        option.setLayoutX(235);
        option.setLayoutY(10);

    ImageView mv=new ImageView("2.jpg");
    mv.setFitWidth(300);
    mv.setFitHeight(300);
   
    

        option.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//               music.option(primaryStage);
//                music.option(primaryStage);
            }
        });
                about = new Button();
                about.setText("about us");
                about.setLayoutX(235);
                about.setLayoutY(195);
                exit = new Button();
                exit.setText("exit");
                exit.setLayoutX(10);
                exit.setLayoutY(200);
    

       form = new Button();
        form.setText("Start");
        form.setLayoutX(10);
    form.setLayoutY(10);
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
         about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               menu.info(primaryStage);
            }
            
        });
        Group root = new Group();

        root.getChildren().addAll(mv);
        root.getChildren().addAll(option,form,about,exit);
//        root.getChildren().add(mv);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
       
        
    }
   
}
