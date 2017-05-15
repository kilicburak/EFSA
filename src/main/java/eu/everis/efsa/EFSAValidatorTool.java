package eu.everis.efsa;

import java.net.URL;

import eu.everis.efsa.config.Arguments;
import eu.everis.efsa.config.PropertiesManager;

/**
 * @author mfontsan
 * Main class
 */
public class EFSAValidatorTool {
	private static final String CONFIG_FILE = "local.config.properties";
	
	private static PropertiesManager properties;
	private static String filePathName;
	private static String filePath;

	/**
	 * Constructor
	 */
	public EFSAValidatorTool() {
		super();
	}

	/**
	 * Main function of the project
	 * @param args
	 */
	public static void main(String[] args) {

		init(args);
		
		ValidationProcess vp = new ValidationProcess(filePathName, filePath, properties);
	}
	
	@SuppressWarnings("static-access")
	private static void init(String[] args) {

		Arguments argClass = new Arguments();
		argClass.parseArguments(args);
		filePathName = argClass.getXmlFilePath();

		URL localPath = EFSAValidatorTool.class.getProtectionDomain().getCodeSource().getLocation();
		filePath = localPath.getFile();

		System.out.println("--- File path: " + filePath);

		properties = new PropertiesManager();
		properties.initProperties(EFSAValidatorTool.class.getClassLoader().getSystemResourceAsStream(CONFIG_FILE));
	}

}
