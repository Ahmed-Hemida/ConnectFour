/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author kar
 */

public class music {
        static float v = 0.1f;
        

    

           static  Media music = new Media("file:///D://ahmed//ConnectFour/src/music/talt_dait.mp3");
       static  MediaPlayer mediaplayer = new MediaPlayer(music);
//      public music() {
//          mediaplayer.setAutoPlay(true);
//        mediaplayer.setCycleCount(1000);
//        mediaplayer.setVolume(volume);
//    }  
//        
    public static void run_music(){
     
        mediaplayer.setCycleCount(1000);
        mediaplayer.setVolume(v);
        mediaplayer.setAutoPlay(true);
        
    
    }
     public static void option(Stage primaryStage){
        mediaplayer.setVolume(v);
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();

        btn1.setText("+");
        btn2.setText("-");
        btn3.setText("Retrurn to the menu");
        ImageView mv=new ImageView("2.jpg");
    mv.setFitWidth(300);
    mv.setFitHeight(300);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(v<1){
                v=v+0.1f;
                mediaplayer.setVolume(v);
                }
                else{
                v=v;
                mediaplayer.setVolume(v);
                }
            }
        } );
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (v>0.1){
                v=v-0.1f;
                mediaplayer.setVolume(v);
                }
                else {
                        v=v;
                        mediaplayer.setVolume(v);
                        }
            
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               menu.men(primaryStage);
            }
        })
    ;


        Group root = new Group();
        root.getChildren().addAll(mv);
        btn1.setPadding(new Insets(5,7,5,7));
        btn2.setPadding(new Insets(5,9,5,9));
        btn1.setLayoutX(170);
        btn1.setLayoutY(50);
        btn2.setLayoutX(110);
        btn2.setLayoutY(50);
        btn3.setLayoutX(90);
        btn3.setLayoutY(10);


        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
        primaryStage.setTitle("Music Control");
    }
    
    
}
