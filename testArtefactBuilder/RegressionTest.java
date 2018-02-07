package testArtefactBuilder;

import java.io.File;

public class RegressionTest {
	
	File rundir, datasetFile, trailFile;
	boolean isTrailCopied, isConfigUpdated, isDataCopied,result;
	String dataSetFileName;
		
	public String getDataSetFileName() {
		return dataSetFileName;
	}
	public void setDataSetFileName(String dataSetFileName) {
		this.dataSetFileName = dataSetFileName;
	}
	public File getTrailFile() {
		return trailFile;
	}
	public void setTrailFile(File trailFile) {
		this.trailFile = trailFile;
	}
	public File getRundir() {
		return rundir;
	}
	public void setRundir(File rundir) {
		this.rundir = rundir;
	}
	public File getDatasetFile() {
		return datasetFile;
	}
	public void setDatasetFile(File datasetFile) {
		this.datasetFile = datasetFile;
	}
	public boolean isTrailCopied() {
		return isTrailCopied;
	}
	public void setTrailCopied(boolean isTrailCopied) {
		this.isTrailCopied = isTrailCopied;
	}
	public boolean isConfigUpdated() {
		return isConfigUpdated;
	}
	public void setConfigUpdated(boolean isConfigUpdated) {
		this.isConfigUpdated = isConfigUpdated;
	}
	public boolean isDataCopied() {
		return isDataCopied;
	}
	public void setDataCopied(boolean isDataCopied) {
		this.isDataCopied = isDataCopied;
	}
	public void setResult(Boolean result) {
		this.result = result;
			
	}
	public RegressionTest() {
		this.rundir = null;
		this.datasetFile = null;
		this.trailFile = null;
		this.isTrailCopied = false;
		this.isConfigUpdated = false;
		this.isDataCopied = false;
		this.dataSetFileName = null;
		this.result=true;
	}
	
	@Override
	public String toString() {
		return "RegressionTest [result=" + result + ",rundir=" + rundir + ", datasetFile=" + datasetFile + ", trailFile=" + trailFile
				+ ", isTrailCopied=" + isTrailCopied + ", isConfigUpdated=" + isConfigUpdated + ", isDataCopied="
				+ isDataCopied + ", dataSetFileName=" + dataSetFileName + "]";
	}
	
	
}
