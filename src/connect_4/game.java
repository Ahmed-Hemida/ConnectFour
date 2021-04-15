/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;


import java.util.Optional;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author kar
 */
public class game {
    static final int radius = 40;
    static final int row = 7;
    static final int colum = 6;
    static final int scren_width = row * radius * 2 + 250;
    static final int scren_hight = colum * radius * 2;
    static int ycolum[] = new int[row];
    static boolean switch_pleyer = true;
    static Circle current_player ;
    
    static player player_1;
    static player player_2;
    static Group Signin = new Group();
    static Scene Sign = new Scene(Signin, 300, 400, Color.WHITESMOKE);
    static Label label, label1, label2, label3, label4,last_play;
    static TextField text1, text2;
    static ImageView image1;
    static Button btn;
    Rectangle rect;
   static Group root = new Group();
   static Scene scene = new Scene(root, scren_width, scren_hight, Color.BLACK);
   
    static String player_name1,player_name2;
   
     public static void display_form(Stage primaryStage){            
//        image1 = new ImageView("img/form_img/connect4.PNG");
//        image1.setFitWidth(scren_width-500);
//        image1.setFitHeight(scren_hight-50);
//        Signin.getChildren().add(image1);
            ImageView mv=new ImageView("2.jpg");
            mv.setFitWidth(300);
            mv.setFitHeight(500);
        label = new Label("Welcome !");
        label.setLayoutX(100);
        label.setLayoutY(10);
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        label1 = new Label("player 1 : ");
        label1.setLayoutX(80);
        label1.setLayoutY(60);
        label1.setTextFill(Color.RED);
        label1.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        text1 = new TextField();
        text1.setLayoutX(80);
        text1.setLayoutY(90);
        text1.setPrefSize(160, 30);
        label2 = new Label("player 2 : ");
        label2.setLayoutX(80);
        label2.setLayoutY(140);
        label2.setTextFill(Color.YELLOW);
        label2.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        text2 = new TextField();
        text2.setLayoutX(80);
        text2.setLayoutY(170);
        text2.setPrefSize(160, 30);
        label3 = new Label();
        label3.setLayoutX(scren_width-195);
        label3.setLayoutY(35);
        label3.setTextFill(Color.LIGHTSKYBLUE);
        label3.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        label4 = new Label();
        label4.setLayoutX(scren_width-195);
        label4.setLayoutY(140);
        label4.setTextFill(Color.RED);
        label4.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        
        current_player = new Circle(15,Color.web("white"));
         last_play = new Label("last player :");
        last_play.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        last_play.setLayoutX((radius * 2*7)+40);
       last_play.setLayoutY(240);
        last_play.setTextFill(Color.VIOLET);
        last_play.setTranslateX(10);
        last_play.setTranslateY(10);
        current_player.setTranslateX((radius * 2*9)+45);
        current_player.setTranslateY(260);
       
        Button back = new Button();
                        back.setText("Back");
                        back.setId("back");
                        back.setLayoutX(130);
                        back.setLayoutY(280);
                        root.getChildren().add(back);
//                         menu.men(primaryStage);
               back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
             menu.men(primaryStage);
            }
        }) ;
        
        btn = new Button("Start Game");
        btn.setLayoutX(110);
        btn.setLayoutY(220);
        btn.setPrefSize(100, 40);
        btn.setTextFill(Color.BLUE);
//        btn.setStyle(STYLESHEET_MODENA(
//
//        ));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource()== btn){
                    player_name1 = ((text1.getText().equals(""))?"player_1":text1.getText());
                    player_name2 = ((text2.getText().equals(""))?"player_2":text2.getText());;
                    
                    label3.setText("player1 : " + player_name1);
                    label4.setText("player2 : " + player_name2);
                    text1.setText(" "); text2.setText(" ");
                    play_game(primaryStage);
                }
            }
        });
        Signin.getChildren().addAll(mv,back);
        Signin.getStylesheets().add("connect_4/CSS.css");
        Signin.getChildren().addAll(label,label1,label2,text1,text2,btn);
        primaryStage.setTitle("Form");
        primaryStage.setScene(Sign);
        primaryStage.show();
    }
    

    public static void play_game(Stage primarystage) {
        ImageView mv=new ImageView("1.jpg");
    mv.setFitWidth(800);
    mv.setFitHeight(500);
             root.getChildren().addAll(mv);

        root.getChildren().add(label3);
        root.getChildren().add(label4);
        root.getChildren().add(last_play);
        root.getChildren().add(current_player);
        player_1 = new player(player_name1, "red");
        player_2 = new player(player_name2, "Yellow");
        Group circles = new Group();
        Circle[][] circle = new Circle[row][colum];
        for (int z = 0; z < row; z++) {
            for (int i = 0; i < colum; i++) {
                circle[z][i] = new Circle(radius-10, Color.web("white"));
                circle[z][i].setStrokeType(StrokeType.OUTSIDE);
                circle[z][i].setCenterX(radius);
                circle[z][i].setCenterY(radius);
                circle[z][i].setTranslateX(radius * 2 * z);
                circle[z][i].setTranslateY(radius * 2 * i);
                circles.getChildren().add(circle[z][i]);
            }

            ycolum[z] = colum - 1;
        }
        root.getChildren().add(circles);
       
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                
                if(switch_pleyer){
                current_player.setFill(Color.web("red"));
                
                }else{
                    current_player.setFill(Color.web("Yellow"));
                }
                piece c = setcircle((int) event.getSceneX());
                if(c!=null)
                root.getChildren().add(c);

//                player_1.cel();
                if (player_1.win() || player_2.win()) {
                    if (player_1.win()) {
                        win(player_1.name,player_1,player_2);
                    } else {
                        win(player_2.name,player_1,player_2);
                    }
                    boolean playAgain = playAgain();
                    if (playAgain) {
//                        play(primarystatge1);
                         display_form(primarystage);
                    } else {
                        Platform.exit();
                    }
                }
                if (player_1.stock == 0 && player_2.stock == 0) {
                    win("symmetry",player_1,player_2);
                    boolean playAgain = playAgain();
                    if (playAgain) {
                         display_form(primarystage);
//                        play(primarystatge1);
                    } else {
                        Platform.exit();
                    }

                }
            }
        });
         Button back = new Button();
                        back.setText("BAck");
                        back.setId("back");
                        back.setLayoutX(scren_width-100);
                        back.setLayoutY(scren_hight-100);
                        root.getChildren().add(back);
//                         menu.men(primaryStage);
               back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
             game.display_form(primarystage);
            }
        }) ;
         scene.getStylesheets().add("connect_4/CSS.css");
        primarystage.setScene(scene);
        primarystage.setTitle("connect_4");
        primarystage.show();
    }

    public static void win(String name,player frist_player,player second_player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("win");
        alert.setHeaderText("Look, " + name);
        alert.setContentText("you have a great win!");
        alert.showAndWait();
        
          JSONObject json=new JSONObject();
          
         try {
             json.put("frist_player",frist_player.name);
             json.put("frist_player_color",frist_player.color);
             json.put("second_player",second_player.name);
             json.put("second_player_color",second_player.color);
             json.put("status",name);
             history.record_history(json);
            
         } catch (JSONException ex) {
             System.err.println(ex);
         }
        
         
//        System.out.println(name + " is win");
    }

    public static boolean playAgain() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("connect 4");
        alert.setHeaderText("Look Dear");
        alert.setContentText("Do you play  ?");
//      alert.showAndWait();
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;

    }

    public static piece setcircle(int x) {
        // final  int h_radius= radius/2;
        int xcolum = (int) x / (radius * 2);
        if(xcolum<row){ 
            int xposition = xcolum * (radius * 2);
        int yposition = (radius * 2 * (ycolum[xcolum]));
        piece cir;
      
        if (switch_pleyer && ycolum[xcolum] >= 0) {
            cir = player_1.playPiece(xposition, ycolum[xcolum]);
        } else {
            cir = player_2.playPiece(xposition, ycolum[xcolum]);
        }
           
        TranslateTransition gravity = new TranslateTransition(Duration.millis(3000), cir);
        gravity.setToY((yposition));
        ycolum[xcolum]--;
        gravity.play();
        if (ycolum[xcolum] >= -1) {
            switch_pleyer = !switch_pleyer;
        }
        return cir; 
        }
        return null;
    }
    
}
