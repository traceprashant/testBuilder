package testArtefactBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ParseInputJson {
	
	public void parseJson() {
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/input.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println(jsonObject);
			
			JSONArray msg = (JSONArray) jsonObject.get("objects");
			for (int i = 0; i < msg.size(); i++) {
				String temp = msg.get(i).toString();
				System.out.println(temp);
			}
			Iterator<String> iterator = msg.iterator();
			while (iterator.hasNext()) {
				//System.out.println(iterator.next());
			}
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		ParseInputJson parseInputJson = new ParseInputJson();
		parseInputJson.parseJson();
	}
	
}
