import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class createJSON {  

    public static void main(String[] args) throws FileNotFoundException, IOException {  

    	
    	String country="";
    	String population="";
    	String line="";
    	String gdp="";
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String fileName = "/home/tushar/work/csvtojson/country.csv";
    	String jsonfile="/home/tushar/work/csvtojson/final.json";
    	  Scanner scanner = new Scanner(new File(fileName));
    	    File jfile=new File(jsonfile);
    	    jfile.delete();
    	    jfile.createNewFile();

    	    FileWriter fileWriter = new FileWriter(jfile,true);
    	    fileWriter.write("{ \"countries\":[");
    	    //Set the delimiter used in file
    	    while( scanner.hasNextLine())
    	    {
    	        line=scanner.nextLine();
    	        Scanner linesc=new Scanner(line);
    	        linesc.useDelimiter(",");

    	       while (linesc.hasNext())
    	        {
    	            country=linesc.next();
    	            population=linesc.next();
    	            gdp = linesc.next();

    	            System.out.println("Country | Population | GDP = "+country+"|"+population+"|"+gdp);
    	            country=country.replaceAll("\\n", "");
    	            population=population.replaceAll("\\n", "");
    	            gdp=gdp.replaceAll("\\n", "");

    	            JsonObject countryObj = new JsonObject();
    	            countryObj.addProperty("Country", country);
    	            
    	            countryObj.addProperty("Population", population);
    	            countryObj.addProperty("GDP", gdp);

    	            final JsonArray countryObjs = new JsonArray();
    	            countryObjs.add(countryObj);

    	            final String jsonline=gson.toJson(countryObjs);
    	           // System.out.println("Print ready:" +countryObj.toJSONString());
    	            System.out.println("Final print : "+jsonline);
    	            fileWriter.write(jsonline);

    	            if(scanner.hasNext()) {
    	                fileWriter.write(",");
    	            }
    	        }
    	    }

    	    fileWriter.write("]}");
    	    fileWriter.close();
    	    //Do not forget to close the scanner

    	    scanner.close();

    	}
    }