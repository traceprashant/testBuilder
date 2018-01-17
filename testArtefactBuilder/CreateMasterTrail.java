package testArtefactBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author kpatel
 *
 */

public class CreateMasterTrail {

	File trailSource = new File("D:\\Training\\eclipse_workspaces\\test_artefact_builder\\trail_files");
	File masterTrailDest = new File("D:\\Training\\eclipse_workspaces\\test_artefact_builder\\test_run_dir\\RunDataRepo\\run1\\master_trail.txt");
	File initialTrail = new File("D:\\Training\\eclipse_workspaces\\test_artefact_builder\\startEndTrails");
	
	static int count=0;
	
	ArrayList<String> arrlistObj = new ArrayList<>();
	FileInputStream fileInputObj;

	//trailrepoloc path picked up from .properties file

	
	public void createMasterTrailFile() throws Exception {
		
		if(!masterTrailDest.exists())
			masterTrailDest.createNewFile();
		
		
		File[] listOfFiles = trailSource.listFiles();
		
		for (File file : listOfFiles)
		{
			arrlistObj.add(file.getName());
		
			while(count < arrlistObj.size())
			{
		
				fileInputObj = new FileInputStream(file.getAbsolutePath());
				BufferedReader buffReaderObj = new BufferedReader(new InputStreamReader(fileInputObj));
			
			
				FileWriter fileWriterObj = new FileWriter(masterTrailDest, true);
				BufferedWriter buffWriterObj = new BufferedWriter(fileWriterObj);
			
				String line = null;
			
				while ((line = buffReaderObj.readLine()) != null) {
					buffWriterObj.write(line);
					buffWriterObj.newLine();
				}// inner while
			
				
				buffReaderObj.close();
				buffWriterObj.close();
		
				count++;
			}//outer while
		
		}// for
		
		System.out.println("Done");
	}//method
		
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		CreateMasterTrail cm = new CreateMasterTrail();
		cm.createMasterTrailFile();

	}

}
