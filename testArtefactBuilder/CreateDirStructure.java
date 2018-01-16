package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CreateDirStructure {
	
	public ArrayList<File> listOfRunDirs = new ArrayList<>();

	public ArrayList<File> getListOfRunDirs() {
		return listOfRunDirs;
	}

	public void setListOfRunDirs(ArrayList<File> listOfRunDirs) {
		this.listOfRunDirs = listOfRunDirs;
	}

	public CreateDirStructure(ArrayList<File> listOfObjects) {
		
		Environment myEnvironment = new Environment(); 
		//StringBuilder uniqueDirString = new StringBuilder(LocalDateTime.now().toString());
		StringBuilder dirName = new StringBuilder(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		for (int i = 0; i < listOfObjects.size(); i++) {
			StringBuilder tempDirName = dirName;
			File runDir = new File(myEnvironment.getRunDataRepoLocation(), tempDirName.append("_").append(i).toString());
			runDir.mkdir();
			listOfRunDirs.add(runDir);
		}
	}
	
	

}
