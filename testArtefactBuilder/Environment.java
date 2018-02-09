package testArtefactBuilder;

import java.io.*;
import java.util.*;

class Environment {
	
	File workDir, runDataRepoLocation, trailRepoLocation, objectRepoLocation, inputJsonDirLocation;

	
	Environment() {
		
		try {
			workDir = new File(System.getProperty("user.dir") + "\\src\\workingDir");
			
			FileReader reader = new FileReader(new File(workDir,"environment.properties"));
			Properties propEnv = new Properties();
			propEnv.load(reader);
			
			runDataRepoLocation = new File(propEnv.getProperty("runDataRepoLocation"));
			trailRepoLocation = new File(propEnv.getProperty("trailRepoLocation"));
			objectRepoLocation = new File(propEnv.getProperty("objectRepoLocation"));
			inputJsonDirLocation = new File(propEnv.getProperty("inputJsonDirLocation"));
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Failed to load file environment.properties");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed to read properties from environment.properties");
			e.printStackTrace();
		}
		
	}
	
	

	File getWorkDir() {
		return workDir;
	}

	File getRunDataRepoLocation() {
		return runDataRepoLocation;
	}

	File getTrailRepoLocation() {
		return trailRepoLocation;
	}

	File getObjectRepoLocation() {
		return objectRepoLocation;
	}	
	
	File getInputJsonDirLocation()
	{
		return inputJsonDirLocation;
	}

}
