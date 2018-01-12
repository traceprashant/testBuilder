package testArtefactBuilder;

import java.io.File;

public class Environment {
	
	public File workDir;
	public File runDataRepoLocation;
	
	public File getWorkDir() {
		return workDir;
	}
	public void setWorkDir() {
		workDir = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir");
	}
	public File getRunDataRepoLocation() {
		return runDataRepoLocation;
	}
	public void setRunDataRepoLocation() {
		runDataRepoLocation = new File("D:/Training/eclipse_workspaces/test_artefact_builder/test_run_dir/RunDataRepo");
	}
	
	

}
