package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class GenerateTestArtefacts {
	
	public void createAssignRunDir (Environment myEnv, ArrayList<RegressionTest> allRegressionTests, InputData currentInputData) {
		StringBuilder dirName = new StringBuilder(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		
		for (int i = 0; i < allRegressionTests.size(); i++) {
			StringBuilder tempDirName = new StringBuilder(dirName.toString());
			File runDir = new File(myEnv.getRunDataRepoLocation(), tempDirName.append("_").append(i).toString());
			runDir.mkdir();
			allRegressionTests.get(i).setRundir(runDir);
		}
	}
	
	public void copyObjectFiles (ArrayList<RegressionTest> allRegressionTests) {
		
		for (int i = 0; i < allRegressionTests.size(); i++) {
			File source = allRegressionTests.get(i).getDatasetFile().getParentFile();
			File dest = allRegressionTests.get(i).getRundir();
			
			File[] listOfFiles = source.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile()) {
			    	try {
						FileUtils.copyFileToDirectory(file,dest);
						allRegressionTests.get(i).setDataCopied(true);
					} catch (IOException e) {
						System.out.println("Failed to copy object file: " + file.getName());
						e.printStackTrace();
					}	
			    }
			}
		}
	}
	
	public boolean buildTrail(ArrayList<File> trailBlocks, ArrayList<RegressionTest> allRegressionTests) {
		 File assembledTrail = new File(allRegressionTests.get(0).getRundir(), "generated_trail.txt");
		 try {
			assembledTrail.createNewFile();
			
			for (int i = 0; i < trailBlocks.size(); i++) {
				FileInputStream fileInputObj = new FileInputStream(trailBlocks.get(i));
				BufferedReader buffReaderObj = new BufferedReader(new InputStreamReader(fileInputObj));
				
				FileWriter fileWriterObj = new FileWriter(assembledTrail, true);
				BufferedWriter buffWriterObj = new BufferedWriter(fileWriterObj);
				
				String line = null;
				
				while ((line = buffReaderObj.readLine()) != null) {
					buffWriterObj.write(line);
					buffWriterObj.newLine();
				}
				
				buffReaderObj.close();
				buffWriterObj.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		if (assembledTrail.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void copyTrailToAllRundirs (ArrayList<RegressionTest> allRegressionTests) {
		File generatedTrail = new File(allRegressionTests.get(0).getRundir(),"generated_trail.txt");
		for (int i = 0; i < allRegressionTests.size(); i++) {
			try {
				if (i != 0) {
					FileUtils.copyFileToDirectory(generatedTrail, allRegressionTests.get(i).getRundir());
				}
				allRegressionTests.get(i).setTrailCopied(true);
				allRegressionTests.get(i).setTrailFile(new File(allRegressionTests.get(i).getRundir(),"generated_trail.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
