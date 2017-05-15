package eu.everis.efsa.validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Validation of the dossier's folder structure
 * @author mfontsan
 *
 */
public class FolderValidation {
	String dossierStrPath;
	boolean status = false;

	/**
	 * Constructor
	 * @param dossierPath
	 */
	public FolderValidation(String dossierPath) {
		this.dossierStrPath = dossierPath;
		
		if(dossierExists()){
			if(checkSubmissionNumber()){
				status = true;
			}
		}
	}

	private boolean dossierExists(){
		File dossier = new File(dossierStrPath);
		
		if(dossier.exists()){
			return true;
		}
		
		return false;
	}

	private boolean checkSubmissionNumber(){
		Path dossierPath = Paths.get(this.dossierStrPath);
		
			DirectoryStream<Path> stream;
			try {
				stream = Files.newDirectoryStream(dossierPath);
				ArrayList<String> submissionNumbers = new ArrayList<String>();
				
			    for (Path file: stream) {
			    	submissionNumbers.add(file.getFileName().toString());
			    }
			    
			    Collections.sort(submissionNumbers);
		    	int i = 1;
		    	
			    for(String num: submissionNumbers){
			    	String value = "";
			    	
			    	if(i<10){
			    		value = "0" + String.valueOf(i);
			    	}else{
			    		value = String.valueOf(i);
			    	}
			    	
			    	if(!num.equalsIgnoreCase(value)){
			    		return false;
			    	}
			    	i++;
			    }
			    
			} catch (IOException e) {
				return false;
			}
			
			return true;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
