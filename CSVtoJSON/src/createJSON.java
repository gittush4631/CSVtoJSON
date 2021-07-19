import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class createJSON {  

    public static void main(String[] args) throws FileNotFoundException, IOException {  

    	
    	String country="";
    	String population="";
    	String fileName = "/home/tushar/work/csvtojson/country.csv";
    	String jsonfile="/home/tushar/work/csvtojson/final.json";
    	 Scanner scanner = new Scanner(new File(fileName));
    	 File jfile=new File(jsonfile);  
    	 jfile.createNewFile();  

         FileWriter fileWriter = new FileWriter(jfile,true); 
         fileWriter.write("{ \"countries\":[");
         //Set the delimiter used in file
         scanner.useDelimiter(",");
          
         //Get all tokens and store them in some data structure
         //I am just printing them
         while (scanner.hasNext()) 
         {
        	 country=scanner.next();
        	 population=scanner.next();
        	
             //System.out.println("Country | Population = "+country+"|"+population);
            country=country.replaceAll("\\n", "");
            population=population.replaceAll("\\n", "");
            System.out.println("country :"+country);
            System.out.println("population: "+population); 
            JSONObject countryObj = new JSONObject();  
             countryObj.put("Name", country);  
             countryObj.put("Population", population);  
             JSONArray listOfStates = new JSONArray();  
             listOfStates.add("Madhya Pradesh");  
             listOfStates.add("Maharastra");  
             listOfStates.add("Rajasthan");  

             countryObj.put("States", listOfStates);  
             System.out.println("json obj"+countryObj);
             
             
            // System.out.println("Writing JSON object to file");  
             //System.out.println("-----------------------");  
             //System.out.print(countryObj);  
            
             fileWriter.write(countryObj.toJSONString());  
            
            fileWriter.write(",");

         }
         fileWriter.write("]}");
         fileWriter.close();
         //Do not forget to close the scanner  
         scanner.close();  

    }  
} 

