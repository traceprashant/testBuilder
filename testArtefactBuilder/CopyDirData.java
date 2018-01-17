/**
 * 
 */
package testArtefactBuilder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author kpatel
 *
 */
public class CopyDirData
{
	
	//specify source and destination of files
	static File source = new File("D:\\Training\\eclipse_workspaces\\test_artefact_builder\\test_run_dir\\ObjFileDir\\dir1");
	static File dest = new File("D:\\Training\\eclipse_workspaces\\test_artefact_builder\\test_run_dir\\RunDataRepo\\run1");

	public boolean copyDataInRunDir(File source, File dest) throws IOException
	{
		// read the files present in the directory one by one and copy them to destination
		
		File[] listOfFiles = source.listFiles();

		for (File file : listOfFiles)
		{
		    if (file.isFile()) 
		    {
		    	
		    	File srcFile = new File(file.getAbsolutePath());
		    	//System.out.println(srcFile.getName());
		    	FileUtils.copyFileToDirectory(srcFile,dest);	
		    }
		}
		System.out.println("\nAbove files are copied to destination!");
		return true;
	}
	
	public static void main(String args[]) throws IOException {
		
		CopyDirData cpyDataObj = new CopyDirData();
		cpyDataObj.copyDataInRunDir(source,dest);
		
	}
	
}