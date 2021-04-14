/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;

import javafx.scene.control.TextField;


/**
 *
 * @author kar
 */
public class player {
     final  int radius=40;
      final  int row=7;
      final  int colum=7;
      final int pieces_num = row*(colum-1)/2;
      int stock=pieces_num;
      private final char[][] cell =  new char[colum][row]; 
      piece[] pie=new piece[pieces_num];
      String name;
      String color;
    char var;
     int piece_id=0;
    public player(String name,String color) {
        
        this.name=name;
        this.color=color;
        var =color.charAt(0); 
        for (int i = 0; i <colum; i++)
        for (int j = 0; j <row  ; j++)
        cell[i][j] = '-';
        
    }

    
    public piece playPiece(int xposition ,int ycolum){
        int xcolum = xposition/(radius*2);
        piece cir=new piece(radius-10,color);
        cir.setTranslateX(xposition);
        cir.setTranslateY(0);
//        pie[piece_id]=cir;
        if(ycolum>=0){
        cell[ycolum][xcolum] = var;
        stock--;
        }
        
      return cir;
//System.out.println(piece_id);
//    return pie[piece_id];
    }
    public boolean win(){
//         return vertical(var)||horizontal(var)||diagonal(var);
           return rightHorizontalDiagonal(var)||rightVerticalDiagonal(var);
    } 
     public boolean horizontal(char var){
        for (int c = 0; c < colum; ++c){
            int count = 0;
        for (int r = 0; r < row; ++r) {
          if (cell[c][r] == var) {
             ++count;
            if (count == 4) 
                return true;
            }
            else 
             count = 0; // reset and count again if not consecutive
            }
              // win
            }
            return false;
     }
     public boolean vertical(char var){
     for (int r = 0; r < row; ++r){
            int count = 0;
          for (int c = 0; c < colum; ++c) {
            
          if (cell[c][r] == var) {
             ++count;
          if (count == 4) 
                return true; 
          } // win
          else
             count = 0; // reset and count again if not consecutive
            }
            
        }
        return false;
    } 
      public boolean diagonal(char var){
         return leftHorizontalDiagonal(var)|| leftVerticalDiagonal(var);
      }
      public boolean leftHorizontalDiagonal(char var){
            // top left frist 4 vertical diagonal 
           for (int c = 0; c < colum; ++c){
            int count = 0;
              for (int r = 0; r < row-c-1; ++r){
                 // System.out.println("cout :" +count);   //r<row-c -1 becouse if r<7 and nuber of colume = 6 in this case it out garbage 
                   if (cell[r+c][r] == var){ //R+C TO check all diagonal in vertical
                       ++count;
                       if (count == 4) 
                       return true;  // win  
                         
                   }
                   else
                       count = 0; // reset and count again if not consecutive
                    } 
                     
                      }
                return false;
            }
      
                public boolean leftVerticalDiagonal(char var){
            // top right frist 4 vertical diagonal 
           for (int r = 0; r < row; ++r){
            int count = 0;
              for (int c = 0; c < colum-r; ++c){   //c<colum-r -1 becouse if r<7 and nuber of colume = 6 in this case it out garbage 
                   if (cell[c][c+r] == var){ //R+C TO check all diagonal in vertical
                       ++count;
                      
                      if (count == 4) 
                       return true;  // win 
                   }
                   else 
                       count = 0; // reset and count again if not consecutive
                    } 
                      
                      }
                return false;
            }
      
                
              public boolean rightHorizontalDiagonal(char var){
            // top left frist 4 vertical diagonal 
           for (int c = colum-1; c >0; --c){
            int count = 0;
              for (int r = 0; r <= row+c-1&&c-r>=0; ++r){
//                  System.out.println("h:c= "+(c-r)+" r="+r+"/t count = "+count);
                 // System.out.println("cout :" +count);   //r<row-c -1 becouse if r<7 and nuber of colume = 6 in this case it out garbage 
                   if (cell[c-r][r] == var){ //R+C TO check all diagonal in vertical
                       ++count;
                        
                       if (count == 4) 
                       return true;  // win
                   }
                   else
                       count = 0; // reset and count again if not consecutive
                    } 
                     
                      }
                return false;
            }
              
                public boolean rightVerticalDiagonal(char var){
            // top right frist 4 vertical diagonal 
           for (int r = 0; r < row; ++r){
            int count = 0;
              for (int c = colum-1,d=0; c >= 0&&r+d<7; --c,++d){   //c<colum-r -1 becouse if r<7 and nuber of colume = 6 in this case it out garbage 
//                      System.out.println("v"+var+":c= "+c+"/ r"+(d+r)+"/t count = "+count);
                  if (cell[c][d+r] == var){ //R+C TO check all diagonal in vertical
                       ++count;
                   
                      if (count == 4) 
                       return true;  // win 
                   }
                   else 
                       count = 0; // reset and count again if not consecutive
                    } 
                      
                      }
                return false;
            }
   public void cel(){
       
      for (int i = 0; i < colum ; i++){
      for (int j = 0; j <row; j++)
       System.out.print(" | "+ cell[i][j] +" | ");
      System.out.println("\n");
        }
     System.out.println("\n *************************");
        
   }
    
}
