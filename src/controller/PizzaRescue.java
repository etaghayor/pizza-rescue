package controller;

import java.io.File;

import javax.swing.SwingUtilities;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import model.Player;
import model.TUI;
import view.GUI;


public class PizzaRescue {
    //Create the command line parser and the differents option
    static CommandLineParser parser = new DefaultParser();
    static Options options = new Options();
    GUI gui;
    TUI textUI;
    
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

    public PizzaRescue() {
    }

    public PizzaRescue(boolean b) {
        if (b) {
            SwingUtilities.invokeLater(() -> {
                gui = new GUI();
                gui.setVisible(true);
            });
        } else {
            textUI = new TUI();
        }
    }

    //Check if the level exists
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
                ("java -cp " + "Libraries/commons-cli-1.4.jar " + " src/" +
                                new PizzaRescue().getClass().getName() + ".java -l is mandatory",

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
                    new PizzaRescue(false);
                    if (new File("user/player_data").exists()) {
                    	System.out.println("player data exists");
                    	System.out.println(Player.deserialize().getLastLevel());
                    	System.out.println(Integer.parseInt(commandLine.getOptionValue("l")));
                    	if (Player.deserialize().getLastLevel() >= Integer.parseInt(commandLine.getOptionValue("l"))) {
                    	System.out.println("ok");
                    	}
                    }
                    //Call the text user interface and select the good level
                }
                if (commandLine.hasOption("g")) {
                    System.out.println("graphical method");
                    new PizzaRescue(true);
                    if (new File("user/player_data").exists()) {
//                    	System.out.println(Player.deserialize().getLastLevel());
//                    	System.out.println(Integer.parseInt(commandLine.getOptionValue("l")));
//                    	if (Player.deserialize().getLastLevel() >= Integer.parseInt(commandLine.getOptionValue("l"))) {
//                    	
//                    	}
                    }
                }
                if (args.length == 2) {
                    new PizzaRescue(false);
                }
            } else {
                System.err.println("You must declare an int between 1 and 10");
            }
        } catch (ParseException e) {
            System.err.println("Wrong command");
            displayHelpAndExit();
        }
    }
}
