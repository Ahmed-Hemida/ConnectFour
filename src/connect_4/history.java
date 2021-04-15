/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;



import static connect_4.game.scren_hight;
import static connect_4.game.scren_width;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kar
 */
public class history {
    
      public static void record_history(JSONObject game_history){ 
         
         JSONObject json=new JSONObject();
          LocalDate date = LocalDate.now(); // Create a date object
        
         try {
             json.put("frist_player",game_history.getString("frist_player"));
             json.put("frist_player_color",game_history.getString("frist_player_color"));
             json.put("second_player",game_history.getString("second_player"));
             json.put("second_player_color",game_history.getString("second_player_color"));
             json.put("status",game_history.getString("status"));
             json.put("date",date);
         } catch (JSONException ex) {
             System.err.println(ex);
         }
            
         try{
             
      FileWriter inPutFile=new FileWriter("historyData.txt",true);
       inPutFile.write(json.toString().concat("\r\n"));
      inPutFile.close();
            
     }catch (IOException ex){
             System.err.println(ex);
        }
     }
      
      public static JSONArray read_history(){
     File outPutFile=new File("historyData.txt");
     String read="";
      JSONArray jsonObjectArray=new JSONArray();
         try {
             // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
             Scanner scanner = new Scanner( outPutFile); 
             
              while (scanner.hasNextLine()) {
                  read= scanner.nextLine();
                  JSONObject json=new JSONObject(read);
               jsonObjectArray.put(json);
            } 
              scanner.close();
         } catch (FileNotFoundException ex) {
             System.err.println(ex);
         } catch (JSONException ex) {
             System.err.println(ex);
         }
     return jsonObjectArray ;
     }
    
        public static void history_view(Stage primarystatge) {
            JSONArray jsonObjectArray= read_history();
             Group root = new Group();
             root.setId("h_root");
             ScrollPane sp = new ScrollPane();
              Button back = new Button();
                        back.setText("BAck");
                        back.setId("back");
                        back.setLayoutX(700);
                        back.setLayoutY(20);
                         back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               menu.men(primarystatge);
            }
        }) ;
              
                 ImageView mv=new ImageView("img/bg/bg-menu-5.jpg");
                mv.setFitWidth(scren_width );
                mv.setFitHeight(scren_hight*5);
                root.getChildren().addAll(mv,back);
                 sp.setContent(root);
                 
              
             Scene history_scene = new Scene(sp, scren_width, scren_hight, Color.BLACK);
           Label frist,frist_color,second,second_color,stat,dat;
           
           frist= new Label("player_1");
                         frist_color=new Label("1_color");
                           second=new Label("player_2");
                           second_color=new Label("2_color");
                           stat=new Label("winner");
                          dat=new Label("date");
                     frist.setLayoutX(40); frist.setLayoutY(60);
                     frist.setTextFill(Color.RED); 
                     frist.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                      frist_color.setLayoutX(160); frist_color.setLayoutY(60);
                     frist_color.setTextFill(Color.RED); 
                     frist_color.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                     
                       second.setLayoutX(250); second.setLayoutY(60);
                     second.setTextFill(Color.RED); 
                     second.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                      second_color.setLayoutX(400); second_color.setLayoutY(60);
                     second_color.setTextFill(Color.RED); 
                    second_color.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                    
                    stat.setLayoutX(550); stat.setLayoutY(60);
                     stat.setTextFill(Color.RED); 
                     stat.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                      dat.setLayoutX(700); dat.setLayoutY(60);
                    dat.setTextFill(Color.RED); 
                    dat.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                     root.getChildren().addAll(frist,frist_color,second
                    ,second_color,stat,dat);
          
            for(int i=0; i<jsonObjectArray.length(); i++){

                try {
                    JSONObject jsonObject= jsonObjectArray.getJSONObject(i);
                    Label frist_player,frist_player_color,second_player,second_player_color,status,date;
                   frist_player= new Label(jsonObject.getString("frist_player"));
                         frist_player_color=new Label(jsonObject.getString("frist_player_color"));
                           second_player=new Label(jsonObject.getString("second_player"));
                           second_player_color=new Label(jsonObject.getString("second_player_color"));
                           status=new Label(jsonObject.getString("status"));
                          date=new Label(jsonObject.getString("date"));
                     frist_player.setLayoutX(40); frist_player.setLayoutY(110+(50*i));
                     frist_player.setTextFill(Color.WHITE); 
                     frist_player.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                      frist_player_color.setLayoutX(160); frist_player_color.setLayoutY(110+(50*i));
                     frist_player_color.setTextFill(Color.WHITE); 
                     frist_player_color.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                     
                       second_player.setLayoutX(240); second_player.setLayoutY(110+(50*i));
                     second_player.setTextFill(Color.WHITE); 
                     second_player.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                      second_player_color.setLayoutX(400); second_player_color.setLayoutY(110+(50*i));
                     second_player_color.setTextFill(Color.WHITE); 
                    second_player_color.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                    
                    status.setLayoutX(520); status.setLayoutY(110+(50*i));
                     status.setTextFill(Color.WHITE); 
                     status.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                      date.setLayoutX(650); date.setLayoutY(110+(50*i));
                    date.setTextFill(Color.WHITE); 
                    date.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
                     root.getChildren().addAll(frist_player,frist_player_color,second_player
                    ,second_player_color,status,date);
                } catch (JSONException ex) {
                    Logger.getLogger(history.class.getName()).log(Level.SEVERE, null, ex);
                }
           
            }
            if(jsonObjectArray.length()>=40){
                detete_history_file();
            }
            root.getStylesheets().add("connect_4/CSS.css");
        history_scene.getStylesheets().add("connect_4/CSS.css");
        primarystatge.setScene(history_scene);
        primarystatge.setTitle("connect_4");
        primarystatge.show();
          }
      public static void detete_history_file(){
     
     File File=new File("historyData.txt");
     File.deleteOnExit();
     }
    
}
