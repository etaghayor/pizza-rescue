package main;
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
		options.addOption("b", "bot", false, "Let's a bot play the game on graphical interface");
		options.addOption("h", "help", false, "Shows this help");
		
		try {
			CommandLine commandLine = parser.parse(options, args);
			if(args.length != 0) {
				if (commandLine.hasOption("l")) {
					if (validLevel(commandLine.getOptionValue("l"))) {
						if (commandLine.hasOption("t")) {
							System.out.println("text method");
							/* Call the text user interface 
							 * and select the level
							 */
						} else if (commandLine.hasOption("g")) {
							System.out.println("graphical method");
							/* Call the graphical user interface 
							 * and select the level
							 */
							GUI view = new GUI();
						} else if (commandLine.hasOption("b")) {
							System.out.println("bot method");
							//TODO : make the bot gameplay method
						} else if (commandLine.hasOption("h")) {
							displayHelpAndExit();
						} else {
							System.out.println("text method by default");
							/* Call the text user interface 
							 * and select the level
							 * by default
							 */
						}
					} else {
						displayHelpAndExit();
					}
				} else if (commandLine.hasOption("h")){
					displayHelpAndExit();
				} else {
					System.err.println("You must use the -l argument with an int option and then -b, -g, or -t");
					displayHelpAndExit();
				}
			} else {
				System.out.println("Text method by default");
				//TODO : call the first level
			}
		} catch (ParseException e) {
			System.err.println("Wrong command");
			displayHelpAndExit();
		}
	
	}
	static boolean validLevel(String level) {
		try {
			int levelInt = Integer.parseInt(level);
			if (levelInt > 0 && levelInt < 10) {
				return true;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			System.err.println("You must declare the -l argument with an int behind between ...");	
			return false;
		}		
	}
	static void displayHelpAndExit() {
		String header = "Make sure you add at least the -l argument (obligatory) with an int option";
		String footer ="";
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("CommandLineParameters", header, options, footer, true);
		System.exit(1);
	}
	
    public static void main(String[] args) {
    	makeConfigFromCommandLineArgs(args);
    	
    	//GUI graphicalInterface = new GUI();
    	//UI textInterface = new UI();    	
    }
    
}
