/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;

import static connect_4.game.scren_hight;
import static connect_4.game.scren_width;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author kar
 */

public class music {
        static float v = 0.1f;
        

    
        static    String path = music.class.getResource("../music/talt_dait.mp3").toString();
            static  Media music = new Media(path);
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
        Button back = new Button();
        
        Button change_song = new Button();
         change_song.setText("stop");
         
        btn1.setText("+");
        btn2.setText("-");
        back.setText("Back");
        ImageView mv=new ImageView("img/bg/bg-menu.jpg");
        mv.setFitWidth(scren_width );
        mv.setFitHeight(scren_hight);;

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
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               menu.men(primaryStage);
            }
        }) ;
       change_song.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
//              change_song();
            stop();
            }
        }) ;


        Group root = new Group();
        root.getChildren().addAll(mv);
        btn1.setPadding(new Insets(5,7,5,7));
        btn2.setPadding(new Insets(5,9,5,9));
        btn1.setLayoutX(530);
        btn1.setLayoutY(250);
        btn2.setLayoutX(250);
        btn2.setLayoutY(250);
        //back
        back.setLayoutX(380);
        back.setLayoutY(120);
        
        change_song.setLayoutX(380);
       change_song.setLayoutY(220);


        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().addAll(back,change_song);
        Scene scene = new Scene(root, scren_width, scren_hight, Color.BLACK);
        scene.getStylesheets().add("connect_4/CSS.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Music Control");
    }
    
     public static void stop(){
       
         if(!mediaplayer.isAutoPlay()){
      mediaplayer.setAutoPlay(true);
     mediaplayer.pause();
     }else{
     mediaplayer.setAutoPlay(false);
     mediaplayer.stop();
                }
        }
}
