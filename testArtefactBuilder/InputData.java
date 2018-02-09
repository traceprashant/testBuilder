package testArtefactBuilder;

import java.util.ArrayList;
import java.util.Properties;

import javax.naming.CommunicationException;

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
	ArrayList<String> datasetIdList = new ArrayList<>();
	String creoVersion;
	
	InputData(Environment myEnv) {
		
		File jsonFile = new File(myEnv.getInputJsonDirLocation(), "input.json");
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jsonFile));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			creoVersion = jsonObject.get("creoversion").toString();
			JSONArray datasets = (JSONArray) jsonObject.get("datasets");
			JSONArray trailBlocks = (JSONArray) jsonObject.get("trailblocks");
			
			//System.out.println("Creo Version: "+ creoVersion);
			
			// reading dataset.properties file 
			File workDir = new File(System.getProperty("user.dir"));
			FileReader readDataset = new FileReader(new File(workDir,"dataset.properties"));
			Properties propDataset = new Properties();
			propDataset.load(readDataset);
			
			
			// populating dataset
			for (int i = 0; i < datasets.size(); i++) {
			
				String datapropValue = propDataset.getProperty(datasets.get(i).toString());
				File tempObject = new File(myEnv.getObjectRepoLocation(), datapropValue);
				listOfObjects.add(tempObject);
				datasetIdList.add(datasets.get(i).toString());
			}
			
			//populating trail blocks
			for (int i = 0; i < trailBlocks.size(); i++) {
				File tempTrailBlock = new File(myEnv.getTrailRepoLocation(),   trailBlocks.get(i).toString().concat(".txt"));
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

	public String getCreoVersion() {
		return creoVersion;
	}

	public ArrayList<String> getDatasetIdList() {
		return datasetIdList;
	}
	
	

}
