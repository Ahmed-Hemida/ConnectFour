
package connect_4;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
public class connect_4 extends Application {
        
      final  int radius=40;
      final  int row=7;
      final  int colum=6;
      final int scren_width=row*radius*2;
      final int scren_hight=colum*radius*2;
       int ycolum[]=new int[row];
       static boolean switch_pleyer= true ;
        player player_1=new player("ahmed","red");
         player player_2=new player("eslam","yellow");
   @Override
    public void start(Stage primaryStage) {
      play(primaryStage);
      
    }
    public void play(Stage primaryStage){
        player_1=new player("ahmed","yellow");
         player_2=new player("eslam","red");
                Group root = new Group();
        Group circles = new Group();
     Scene scene = new Scene(root, scren_width, scren_hight, Color.BLUE);
        Circle[][] circle = new  Circle[row][ colum];
      for (int z = 0; z <row; z++) {
        for (int i = 0; i < colum ; i++) {
           circle[z][i] =new  Circle(radius, Color.web("white"));
           circle[z][i].setStrokeType(StrokeType.OUTSIDE);
           circle[z][i].setCenterX(radius);
           circle[z][i].setCenterY(radius);
           circle[z][i].setTranslateX(radius*2*z);
           circle[z][i].setTranslateY(radius*2*i );
           Light.Distant light =new Light.Distant();
         light.setAzimuth(45);  
         light.setElevation(50);
        light.setColor(Color.WHITE); 
        Lighting lighting = new Lighting();   
        lighting.setLight(light);  
        lighting.setSurfaceScale(5);
        circle[z][i].setEffect(lighting);
        circles.getChildren().add(circle[z][i]);
         }
       
        ycolum[z]=colum-1;
        }
      root.getChildren().add(circles);
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            piece c = setcircle((int)event.getSceneX());
            root.getChildren().add(c);
            
            player_1.cel();
            if(player_1.win()||player_2.win()){
                if(player_1.win())
                alert(player_1.name);
                else
                    alert(player_2.name);
                boolean  playAgain=playAgain();
                if(playAgain){
                    play(primaryStage);
                }else
                    Platform.exit();
            }
            if(player_1.stock==0&&player_2.stock==0){
                alert("symmetry");
                 boolean  playAgain=playAgain();
                if(playAgain){
                    play(primaryStage);
                }else
                    Platform.exit();
                
            }
        }});
        
        
       primaryStage.setScene(scene);
        primaryStage.show();
    }
                
    public void alert(String name){
      Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("win");
                alert.setHeaderText("Look, "+name);
                alert.setContentText("you have a great win!");
                alert.showAndWait();
                System.out.println(name+" is win");
    }
    public boolean playAgain(){
      Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("connect 4");
                alert.setHeaderText("Look Dear");
                alert.setContentText("Do you play  ?");
//                alert.showAndWait();
                Optional<ButtonType> result = alert.showAndWait();
                  return result.get() == ButtonType.OK ;  
                  
    }
    public piece setcircle( int x){
    // final  int h_radius= radius/2;
        int xcolum =(int) x/(radius*2);
        int xposition =xcolum*(radius*2);
        int yposition =(radius*2*(ycolum[xcolum]));
        piece cir;
          if( switch_pleyer&&ycolum[xcolum]>=0)
              cir=player_1.playPiece(xposition, ycolum[xcolum]);
          else
              cir=player_2.playPiece(xposition, ycolum[xcolum]);
           TranslateTransition  gravity =new  TranslateTransition(Duration.millis(3000), cir);
            gravity.setToY((yposition));
            ycolum[xcolum]--;
            gravity.play();
         if(ycolum[xcolum]>=-1){
            switch_pleyer=!switch_pleyer;
        }
        return  cir;
    }
         
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
