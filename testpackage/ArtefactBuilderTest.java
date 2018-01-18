package testpackage;

import testArtefactBuilder.*;

public class ArtefactBuilderTest {

	public static void main(String[] args) {
		// Generate Regression Test Set with all artefacts
		RegressionTestSet currentTestDeck = new RegressionTestSet();
		
		// Find Number of Regression Tests
		System.out.println("Number of Tests: " + currentTestDeck.getRegressionTestSet().size());
		System.out.println();
		
		// Print Information about entire Regression Set
		System.out.println("ToString for Set of Regression tests ro show all attributes:");
		System.out.println(currentTestDeck);
				
		
		
		//////Fetch Parameters of single Regression Test
		System.out.println("Examples for getting parametes of very first Regression Test");
		//Get run directory
		System.out.println("Run Dir Location: " + currentTestDeck.getRegressionTestSet().get(0).getRundir());
		//Get source location of objects
		System.out.println("Source Object Location: " + currentTestDeck.getRegressionTestSet().get(0).getDatasetFile());
		//Get Trail File
		System.out.println("Trail File Location: " + currentTestDeck.getRegressionTestSet().get(0).getTrailFile());
		//Check if Trail File is copied
		System.out.println("Is Trail Copied: " + currentTestDeck.getRegressionTestSet().get(0).isTrailCopied());
		//Check if config.pro File is Updated
		System.out.println("Is Config.pro Updated: " + currentTestDeck.getRegressionTestSet().get(0).isConfigUpdated());
		//Check if Dataset is copied to run directory
		System.out.println("Is Dataset Copied: " + currentTestDeck.getRegressionTestSet().get(0).isDataCopied());
		//Check Dataset File name
		System.out.println("Seed Object File Name: " + currentTestDeck.getRegressionTestSet().get(0).getDataSetFileName());
		
	}

}
