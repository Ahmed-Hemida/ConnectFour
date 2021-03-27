/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author kar
 */
public class music {

    
    static float volume =.5f;
           static  Media music = new Media("file:///E://Music/Alarab_Um_Kalthom_Amal_Hayate.mp3");
       static  MediaPlayer mediaplayer = new MediaPlayer(music);
//      public music() {
//          mediaplayer.setAutoPlay(true);
//        mediaplayer.setCycleCount(1000);
//        mediaplayer.setVolume(volume);
//    }  
//        
    public static void run_music(){
     
        mediaplayer.setCycleCount(1000);
        mediaplayer.setVolume(volume);
        mediaplayer.setAutoPlay(true);
    
    }
    
}
