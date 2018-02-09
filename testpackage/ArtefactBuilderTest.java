package testpackage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import testArtefactBuilder.*;

public class ArtefactBuilderTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Generate Regression Test Set with all artefacts
		RegressionTestSet currentTestDeck = new RegressionTestSet();
		
		//ArrayList<RegressionTest> allRegressionTests = new ArrayList<>();
		RegressionTest regressionTest= new RegressionTest();
		
		for (int i=0;i<currentTestDeck.getRegressionTestSet().size();i++)
		{
		//Get run directory
		System.out.println("Run Dir Location: " + currentTestDeck.getRegressionTestSet().get(i).getRundir());
		
		//Get source location of objects
		System.out.println("Source Object Location: " + currentTestDeck.getRegressionTestSet().get(i).getDatasetFile());
		//Get Trail File
		System.out.println("Trail File Location: " + currentTestDeck.getRegressionTestSet().get(i).getTrailFile());
		//Check if Trail File is copied
		System.out.println("Is Trail Copied: " + currentTestDeck.getRegressionTestSet().get(i).isTrailCopied());
		//Check if config.pro File is Updated
		System.out.println("Is Config.pro Updated: " + currentTestDeck.getRegressionTestSet().get(i).isConfigUpdated());
		//Check if Dataset is copied to run directory
		System.out.println("Is Dataset Copied: " + currentTestDeck.getRegressionTestSet().get(i).isDataCopied());
		//Check Dataset File name
		System.out.println("Seed Object File Name: " + currentTestDeck.getRegressionTestSet().get(i).getDataSetFileName());		
				
		/*String WORKING_DIR="";
		WORKING_DIR=currentTestDeck.getRegressionTestSet().get(i).getRundir().toString();
		WORKING_DIR=WORKING_DIR.replace("\\","/");
		System.out.println("WORKING_DIR: " + WORKING_DIR);
		RunMultiTest runMultitest=new RunMultiTest();
		runMultitest.executeBatFile("D:/Hackathon/testBuilder/testArtefactBuilder/jscb.bat ", WORKING_DIR);
		
		Thread.sleep(60000);
		System.out.println();

		Scanner file = new Scanner(new File(WORKING_DIR + "/" + "trail.txt.1"));
		String pass_case="Finished processing input trail";
		
		int val=0;
		              
		
		while(file.hasNextLine())           
        {
            String line = file.nextLine();
            if(line.indexOf(pass_case) != -1)
            {
                val = 1;
                break;
            }
            else
            {
                val = 0;
                continue;
            }
        }
        if(val == 1)
        {
        	regressionTest.setResult(true);
            System.out.println("TEST PASSED..!!!");
        }
        else
        {
        	regressionTest.setResult(false);       
        	System.out.println("TEST FAILED..!!!");
        }
        
        System.out.println("############################################################################");*/
                	
		}	
 		/*System.out.println("Total Number of Tests: " + currentTestDeck.getRegressionTestSet().size());
 		System.out.println();
 		
 		// Print Information about entire Regression Set
 		System.out.println(currentTestDeck);*/	
 
  }
}
