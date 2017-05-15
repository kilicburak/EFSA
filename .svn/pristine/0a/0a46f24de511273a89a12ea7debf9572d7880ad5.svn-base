package eu.everis.efsa.config;

import java.util.Arrays;

/**
 * Management of the arguments of the main class.
 * @author mfontsan
 *
 */
public class Arguments {
	String xmlFilePath;

	public String getXmlFilePath() {
		return xmlFilePath;
	}

	public void setXmlFilePath(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
	}

	/**
	 * Parse all the arguments send via parameter.
	 * @param args
	 */
	public void parseArguments(String[] args) {
		String str1 = Arrays.toString(args);
		checkArguments(str1.substring(1, str1.length()-1));

		for (int i = 0; i < args.length; i++) {
			String arg = args[i].trim();

			if (arg.equalsIgnoreCase("-url")) {
				this.xmlFilePath = args[++i];
			}
		}
	}

	/**
	 * Whether it contains the expected arguments, if not, exit.
	 * @param stringArgs
	 */
	private void checkArguments(String stringArgs) {
		if (!stringArgs.toLowerCase().contains("-url")) {
			exit();
		}
	}

	/**
	 * Exit information if not correct arguments.
	 */
	private void exit() {
		String outputInformation = "";

		outputInformation += "\nNo valid options have been provided.\n";
		outputInformation += "Usage: -url [xpath1] \n";
		outputInformation += "The arguments are:\n";
		outputInformation += "-url .......................[Dossier path to be validated]\n";

		System.out.println(outputInformation);
		System.exit(1);
	}
}
