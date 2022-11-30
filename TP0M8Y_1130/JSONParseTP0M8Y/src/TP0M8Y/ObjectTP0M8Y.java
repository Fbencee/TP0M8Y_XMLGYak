package TP0M8Y;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ObjectTP0M8Y {

	public static void main(String[] args) {

		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("src/TP0M8Y/JSONTP0M8Y.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray students = (JSONArray) obj;
            System.out.println(students);
             
            //Iterate over employee array
            students.forEach( student -> parseStudentObject( (JSONObject) student ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	private static void parseStudentObject(JSONObject student) 
    {
        JSONObject studentObject = (JSONObject) student.get("student");
         
        String nev = (String) studentObject.get("nev");    
        System.out.println(nev);
         
        String neptunkod = (String) studentObject.get("neptunkod");  
        System.out.println(neptunkod);
         
        String szak = (String) studentObject.get("szak");    
        System.out.println(szak);
    }

}
