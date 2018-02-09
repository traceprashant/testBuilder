package testArtefactBuilder;

import java.util.ArrayList;

public class RegressionTestSet {
	
	ArrayList<RegressionTest> regressionTestSet;

	public RegressionTestSet() {
		
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
			allRegressionTests.get(i).setDatasetId(currentInputData.getDatasetIdList().get(i));
		}
		
		//Copy Dataset object files to each runDir
		generateTestArtefacts.copyObjectFiles(allRegressionTests);
		
		//Generate Trail File in first rundir and copy it to others if generated
		if (generateTestArtefacts.buildTrail(currentInputData.getListOfTrailBlocks(), allRegressionTests) == true) {
			generateTestArtefacts.copyTrailToAllRundirs(allRegressionTests);
		};
				
		regressionTestSet = allRegressionTests;
		
		
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (RegressionTest regTest : regressionTestSet) {
			output.append(regTest.toString());
			output.append(System.getProperty("line.separator"));
		}
		return output.toString();
	}

	public ArrayList<RegressionTest> getRegressionTestSet() {
		return regressionTestSet;
	}
	
	

}
