import view.GUI;
import view.TextUI;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class PetRescue {
	static CommandLineParser parser = new BasicParser();
	static Options options = new Options();
	
	static void makeConfigFromCommandLineArgs(String[] args){
		options.addOption("t", "text", false, "Run the program in console");
		options.addOption("g", "graphical", false, "Run the program in a window");
		options.addOption("l", "level", true, "Choose the level you want to play");
		options.addOption("b", "bot", false, "Let's a bot play the game");
		options.addOption("h", "help", false, "Shows this help");
		
		try {
			CommandLine commandLine = parser.parse(options, args);
			if (commandLine.hasOption("l")) {
				if (validLevel(commandLine.getOptionValue("l"))) {
					if (commandLine.hasOption("t")) {
						System.out.println("t");
						/* Call the text user interface 
						 * and select the level
						 */
					} else if (commandLine.hasOption("g")) {
						System.out.println("g");
						/* Call the graphical user interface 
						 * and select the level
						 */
					} else if (commandLine.hasOption("b")) {
						//TODO : make the bot gameplay method
					} else if (commandLine.hasOption("h")) {
						displayHelpAndExit();
					}
				} else {
					System.err.println("1");
				}
			}	
		 else {
			System.err.println("Wrong command");
			displayHelpAndExit();
		 }
		} catch (ParseException e) {
			System.err.println("Wrong command");
			displayHelpAndExit();
		}
	
	}
	static boolean validLevel(String level) {
		try {
			switch(Integer.parseInt(level)) {
			case 0 :
				System.out.println(0);
				break;
			case 1 : 
				System.out.println(1);
				break;
			case 2 : 
				System.out.println(2);
				break;
			case 3 : 
				System.out.println(3);
				break;
			}
		} catch (Exception e) {
			System.err.println("You must declare an int between ...");	
			displayHelpAndExit();
		}
		return true;
		//TODO : check if the level is playable
	}
	static void displayHelpAndExit() {
		String header = "Make sure you add at least the -l argument (obligatory) with an int option";
		String footer ="";
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("CommandLineParameters", header, options, footer, true);
	}
	
    public static void main(String[] args) {
    	makeConfigFromCommandLineArgs(args);
    	
    	//GUI graphicalInterface = new GUI();
    	//UI textInterface = new UI();    	
    }
    
}
