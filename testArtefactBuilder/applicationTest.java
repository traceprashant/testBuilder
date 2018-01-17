package testArtefactBuilder;

import java.util.ArrayList;

public class applicationTest {

	public static void main(String[] args) {
		
		Environment currentEnvironment = new Environment();
		InputData currentInputData = new InputData(currentEnvironment);
		ArrayList<RegressionTest> allRegressionTests = new ArrayList<>();
		GenerateTestArtefacts generateTestArtefacts = new GenerateTestArtefacts();
		
		//Create RegressionTest objects and add them to allRegressionTests array list
		for (int i = 0; i < currentInputData.getListOfObjects().size(); i++) {
			RegressionTest tempRegressionTest = new RegressionTest();
			allRegressionTests.add(tempRegressionTest);
		}
		
		//Create Run Directories and assign them to each RegressionTest object
		generateTestArtefacts.createAssignRunDir(currentEnvironment, allRegressionTests, currentInputData);
		
		//Assign input objects to RegressionTestObject
		for (int i = 0; i < allRegressionTests.size(); i++) {
			allRegressionTests.get(i).setDatasetFile(currentInputData.getListOfObjects().get(i));
			allRegressionTests.get(i).setDataSetFileName(currentInputData.getListOfObjects().get(i).getName());
		}
		
		//Copy Dataset object files to each runDir
		generateTestArtefacts.copyObjectFiles(allRegressionTests);
		
		//Generate Trail File and Copy to each run dir
		
		//provide output object array
		
		// Generate toString for all RegressionTest Object for testing
		for (RegressionTest regTest : allRegressionTests) {
			System.out.println(regTest.toString());
			System.out.println("");
		}
		
	}

}
