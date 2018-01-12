package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;

public class applicationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File objFile1 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir1/obj1.txt");
		File objFile2 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir2/obj2.txt");
		File objFile3 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir3/obj3.txt");
		File objFile4 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir4/obj4.txt");
		File objFile5 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir5/obj5.txt");
		File objFile6 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir6/obj6.txt");
		//File objFile7 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir7/obj7.txt");
		//File objFile8 = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/ObjFileDir/dir8/obj8.txt");
		
		ArrayList<File> listOfObjects = new ArrayList<>();
		
		listOfObjects.add(objFile1);
		listOfObjects.add(objFile2);
		listOfObjects.add(objFile3);
		listOfObjects.add(objFile4);
		listOfObjects.add(objFile5);
		listOfObjects.add(objFile6);
		
		CreateDirStructure thisDirStructure = new CreateDirStructure(listOfObjects);
		ArrayList<File> createdDirList = thisDirStructure.getListOfRunDirs();
		
		for (int i = 0; i < createdDirList.size(); i++) {
			System.out.println(createdDirList.get(i));
		}
	}

}
