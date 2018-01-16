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
			StringBuilder tempDirName = dirName;
			File runDir = new File(myEnv.getRunDataRepoLocation(), tempDirName.append("_").append(i).toString());
			runDir.mkdir();
			allRegressionTests.get(i).setRundir(runDir);
		}
	}
	
	public void copyObjectFiles (File source, File dest) {
		File[] listOfFiles = source.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
		    	String fileLoc = source.toString()+"\\"+file.getName();
		    	File srcFile = new File(fileLoc);
		    	//System.out.println(srcFile.getName());
		    	try {
					FileUtils.copyFileToDirectory(srcFile,dest);
				} catch (IOException e) {
					System.out.println("Failed to copy object file.");
					e.printStackTrace();
				}	
		    }
		}
		
	}

}
