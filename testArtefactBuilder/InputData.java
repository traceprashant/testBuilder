package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;

public class InputData {
	
	ArrayList<File> listOfObjects = new ArrayList<>();
	ArrayList<File> listOfTrailBlocks = new ArrayList<>();
	
	public InputData() {
		File objFile1 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir1/obj1.txt");
		File objFile2 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir2/obj2.txt");
		File objFile3 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir3/obj3.txt");
		File objFile4 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir4/obj4.txt");
		File objFile5 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir5/obj5.txt");
		File objFile6 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir6/obj6.txt");
		
		listOfObjects.add(objFile1);
		listOfObjects.add(objFile2);
		listOfObjects.add(objFile3);
		listOfObjects.add(objFile4);
		listOfObjects.add(objFile5);
		listOfObjects.add(objFile6);
		
		
	}

	public ArrayList<File> getListOfObjects() {
		return listOfObjects;
	}

	public ArrayList<File> getListOfTrailBlocks() {
		return listOfTrailBlocks;
	}
	
	

}
