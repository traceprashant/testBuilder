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

public class InputData {
	
	ArrayList<File> listOfObjects = new ArrayList<>();
	ArrayList<File> listOfTrailBlocks = new ArrayList<>();
	
	public InputData() {
		File objFile1 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir1/obj1.prt");
		File objFile2 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir2/obj2.prt");
		File objFile3 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir3/obj3.prt");
		File objFile4 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir4/obj4.prt");
		File objFile5 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir5/obj5.prt");
		File objFile6 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir6/obj6.prt");
		
		listOfObjects.add(objFile1);
		listOfObjects.add(objFile2);
		listOfObjects.add(objFile3);
		listOfObjects.add(objFile4);
		listOfObjects.add(objFile5);
		listOfObjects.add(objFile6);
		
		
	}
	
	public InputData(Environment myEnv) {
		
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
			
			for (int i = 0; i < objects.size(); i++) {
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

	public ArrayList<File> getListOfObjects() {
		return listOfObjects;
	}

	public ArrayList<File> getListOfTrailBlocks() {
		return listOfTrailBlocks;
	}
	
	

}
