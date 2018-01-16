package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

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

}
