/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
/**
 *
 * @author kar
 */
public class piece  extends Circle{
     
      final  int row=7;
      final  int colum=6;
      
    piece(int radius,String color){
    super(radius, Color.web(color,1));
    this.setCenterX(0);
    this.setCenterY(0);
   
    }
}
