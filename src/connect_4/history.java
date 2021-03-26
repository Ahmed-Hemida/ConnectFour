/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
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
      
      public JSONArray read_history(){
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
      
      public void detete_history_file(){
     
     File File=new File("historyData.txt");
     File.deleteOnExit();
     }
    
}
