

package connect_4;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author kar
 */
public class menu {
    static Button option,form;
    public static void men(Stage primaryStage){
          primaryStage.setTitle("connect four");
        Button option = new Button();
        option.setText("option");
        option.setLayoutX(100);
    option.setLayoutY(100);

        option.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//               game.display_form(primaryStage);
            }
        });
       form = new Button();
        form.setText("form");
        form.setLayoutX(100);
    form.setLayoutY(150);
        form.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               game.display_form(primaryStage);
            }
        });
        Group root = new Group();
        root.getChildren().addAll(option,form);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
}
