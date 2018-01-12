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
		//int noOfDirs = listOfObjects.size();
		Environment myEnvironment = new Environment(); 
		myEnvironment.setRunDataRepoLocation();
		//StringBuilder uniqueDirString = new StringBuilder(LocalDateTime.now().toString());
		for (int i = 0; i < listOfObjects.size(); i++) {
			StringBuilder dirName = new StringBuilder(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			File runDir = new File(myEnvironment.getRunDataRepoLocation(), dirName.append("_").append(i).toString());
			runDir.mkdir();
			listOfRunDirs.add(runDir);
		}
	}
	
	

}
