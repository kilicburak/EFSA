package eu.everis.efsa;

import eu.everis.efsa.config.PropertiesManager;
import eu.everis.efsa.validation.FolderValidation;

/**
 * Main class with the validation steps
 * @author mfontsan
 *
 */
public class ValidationProcess {
	String dossierPath;
	String localPath;
	private PropertiesManager properties;

	/**
	 * Constructor
	 * @param dossierPath: path of the dossier
	 * @param localPath: path to the local location
	 * @param properties: file properties manager
	 */
	public ValidationProcess(String dossierPath, String localPath, PropertiesManager properties) {
		this.dossierPath = dossierPath;
		this.localPath = localPath;
		this.properties = properties;
		
		startProcess();
	}
	
	private void startProcess(){
		FolderValidation fv = new FolderValidation(dossierPath);
		
		System.out.println(fv.isStatus());
	}

}
