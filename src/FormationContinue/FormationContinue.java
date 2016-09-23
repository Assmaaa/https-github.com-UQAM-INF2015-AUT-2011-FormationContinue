/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormationContinue;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 *
 * @author wissem
 */
public class FormationContinue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String jsonTxt =null;
     try{
         jsonTxt = Utf8File.loadFileIntoString("declaration.json");
         
      }catch(IOException e)  {
          System.out.println("Erreur lors de la lecture du fichier JSON." + e.getLocalizedMessage());
          System.exit(1);
      }
      JSONObject racine = (JSONObject) JSONSerializer.toJSON(jsonTxt);
      JSONArray activites = racine.getJSONArray("activites");
      int TotalRedactionProfessionnelle =0;
      
       for (int i = 0; i < activites.size(); i++) {
                JSONObject item = activites.getJSONObject(i);
               
                if (item.getString("categorie").equals("rédaction professionnelle")){ 
                 TotalRedactionProfessionnelle = TotalRedactionProfessionnelle+ item.getInt("heures") ;   
                }
                
                        
                }
       if (TotalRedactionProfessionnelle >17){
          TotalRedactionProfessionnelle=17; 
           }
          System.out.println(TotalRedactionProfessionnelle);
           
       }
        // TODO code application logic here
    }
    

