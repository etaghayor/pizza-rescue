package controller;


import javax.swing.SwingUtilities;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

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

        options.addOptionGroup(interfaceGroup);
    }

    public PizzaRescue() {
    }

    public PizzaRescue(boolean b) {
        if (b) {
//            Time.deserializeLastTime();
            SwingUtilities.invokeLater(() -> {
                gui = new GUI();
                gui.setVisible(true);
            });
        } else {
            textUI = new TUI();
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
            if (commandLine.hasOption("t")) {
                new PizzaRescue(false);

            }
            if (commandLine.hasOption("g")) {
                System.out.println("graphical method");
                new PizzaRescue(true);
            }
            if (args.length == 2) {
                new PizzaRescue(false);
            }

        } catch (ParseException e) {
            System.err.println("Wrong command");
            displayHelpAndExit();
        }


    }

}
