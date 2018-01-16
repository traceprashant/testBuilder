package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;

public class applicationTest {

	public static void main(String[] args) {
		
		Environment currentEnvironment = new Environment();
		InputData currentInputData = new InputData();
		ArrayList<RegressionTest> allRegressionTests = new ArrayList<>();
		GenerateTestArtefacts generateTestArtefacts = new GenerateTestArtefacts();
		
		//Create RegressionTest objects and add them to allRegressionTests array list
		for (int i = 0; i < currentInputData.getListOfObjects().size(); i++) {
			RegressionTest tempRegressionTest = new RegressionTest();
			allRegressionTests.add(tempRegressionTest);
		}
		
		//Create Run Directories and assign them to each RegressionTest object
		generateTestArtefacts.createAssignRunDir(currentEnvironment, allRegressionTests, currentInputData);
		
		//Copy Dataset object files to each runDir
		
		//Generate Trail File and Copy to each run dir
		
		//provide output object array
		
		
		CreateDirStructure thisDirStructure = new CreateDirStructure(currentInputData.getListOfObjects());
		ArrayList<File> createdDirList = thisDirStructure.getListOfRunDirs();
		
		for (int i = 0; i < createdDirList.size(); i++) {
			System.out.println(createdDirList.get(i));
		}
	}

}
