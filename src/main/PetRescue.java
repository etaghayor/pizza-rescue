package main;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import view.GUI;

public class PetRescue {
	static CommandLineParser parser = new DefaultParser();
	static Options options = new Options();
	static {		
		OptionGroup interfaceGroup = new OptionGroup();
		interfaceGroup.addOption(
				Option.builder("t")
				.longOpt("text")
				.desc("Display a text interface")
				.build());
		interfaceGroup.addOption(
				Option.builder("g")
				.longOpt("graphical")
				.desc("Display a graphical interface")
				.build());
		interfaceGroup.addOption(
				Option.builder("b")
				.longOpt("bot")
				.desc("Let's a bot play the game on graphical interface")
				.build());
		OptionGroup chooseLevel = new OptionGroup();
		chooseLevel.addOption(
				Option.builder("l")
				.longOpt("level")
				.hasArg()
				.desc("Select a level between 1 and 10")
				.build());
		chooseLevel.addOption(
				Option.builder("h")
				.longOpt("help")
				.desc("Show this help")
				.build());
		chooseLevel.setRequired(true);
		options.addOptionGroup(chooseLevel);
		options.addOptionGroup(interfaceGroup);
	}

	static boolean isValidLevel(String level) {
		try {
			int levelInt = Integer.parseInt(level);
			if (levelInt > 0 && levelInt < 10) 
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			displayHelpAndExit();
			return false;
		}
	}

	static void displayHelpAndExit() {
		new HelpFormatter().printHelp
		("java -cp "+"Libraries/commons-cli-1.4.jar "+" src/"+
		new PetRescue().getClass().getName()+".java",
		options);
		System.exit(1);
	}

	public static void main(String[] args) {
			try {
				CommandLine commandLine = parser.parse(options, args);
				if (commandLine.hasOption("h"))
					displayHelpAndExit();
				if (isValidLevel(commandLine.getOptionValue("l"))) {
					if (commandLine.hasOption("t")) {
						System.out.println("text method");
						//Call the text user interface and select the good level
					}
					if (commandLine.hasOption("g")) {
						System.out.println("graphical method");
						new GUI();
						/*
						 * Call the graphical user interface and select the level
						 */
					}
					if (commandLine.hasOption("b")) {
						System.out.println("bot method");
						//Let's create the bot method
					}
					if (args.length == 2) {
						System.out.println("text method by default");
						//Call the text user by default
					}
				}
				else {
					System.err.println("You must declare an int between 1 and 10");
				}
			} catch (ParseException e) {
				System.err.println("Wrong command");
				e.printStackTrace();
				displayHelpAndExit();
			}
	}

}
