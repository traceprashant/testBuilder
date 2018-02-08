package testArtefactBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
     
public class RunMultiTest {

	    public void executeBatFile(String batFileName,String Working_Dir) throws IOException, InterruptedException
	    {

	        String command="cmd /c start " + batFileName + Working_Dir;     
	       // String command="cmd /c start " + batFileName + " currentTestDeck.getRegressionTestSet().get(0).getRundir().toString()";   
	        Runtime rt = Runtime.getRuntime(); rt.exec(command); 

	    }
   
	    public static void main(String args[]) throws IOException, InterruptedException
	    {
	    	RunMultiTest obj = new RunMultiTest();   	
	    }    
	}

