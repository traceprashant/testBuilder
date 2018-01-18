package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class InputData {
	
	ArrayList<File> listOfObjects = new ArrayList<>();
	ArrayList<File> listOfTrailBlocks = new ArrayList<>();
	
	InputData(Environment myEnv) {
		
		File jsonFile = new File(myEnv.getWorkDir(), "input.json");
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jsonFile));
			
			JSONObject jsonObject = (JSONObject) obj;
			//System.out.println(jsonObject);
			
			JSONArray objects = (JSONArray) jsonObject.get("objects");
			JSONArray trailBlocks = (JSONArray) jsonObject.get("trailblocks");
			
			for (int i = 0; i < objects.size(); i++) {
				File tempObject = new File(myEnv.getObjectRepoLocation(), objects.get(i).toString());
				listOfObjects.add(tempObject);
			}
			
			for (int i = 0; i < trailBlocks.size(); i++) {
				File tempTrailBlock = new File(myEnv.getTrailRepoLocation(), trailBlocks.get(i).toString());
				listOfTrailBlocks.add(tempTrailBlock);
			}
			
			
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
	}

	ArrayList<File> getListOfObjects() {
		return listOfObjects;
	}

	ArrayList<File> getListOfTrailBlocks() {
		return listOfTrailBlocks;
	}
	
	

}
