package testArtefactBuilder;

import java.io.*;
import java.util.*;

class Environment {
	
	File workDir, runDataRepoLocation, trailRepoLocation, objectRepoLocation;

	Environment() {
		workDir = new File(System.getProperty("user.dir"));
		try {
			FileReader reader = new FileReader(new File(workDir,"environment.properties"));
			Properties prop = new Properties();
			prop.load(reader);
			
			runDataRepoLocation = new File(prop.getProperty("runDataRepoLocation"));
			trailRepoLocation = new File(prop.getProperty("trailRepoLocation"));
			objectRepoLocation = new File(prop.getProperty("objectRepoLocation"));
			
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

}
