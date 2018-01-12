package testArtefactBuilder;

import java.util.ArrayList;
import java.io.File;
import java.nio.file.Files;

public class CopyFile {
	
	public void copyFile(File sourceFile, File targetFile) {
		Files.copy(sourceFile, targetFile);
	}

}
