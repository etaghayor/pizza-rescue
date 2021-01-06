package controller;

import javax.swing.SwingUtilities;

import model.TUI;
import serialize.SerializeLevels;
import view.GUI;

public class PizzaRescue {
    // Create the command line parser and the differents option
    GUI gui;
    TUI textUI;

    public PizzaRescue() {
    }

    public PizzaRescue(boolean b) {
        if (b) {
            // Time.deserializeLastTime();

            // SwingUtilities.invokeLater(() -> {
            gui = new GUI();
            gui.setVisible(true);
            // });
        } else {
            textUI = new TUI();
        }
        while (true) {

        }
    }

    static void displayHelpAndExit() {
        System.out.println("Wrong command!");
        System.out.println("Available commands:\n" + "-t or -text for TUI mode on terminal" + "\n"
                + "-g or -graphic for GUI mode");
        System.exit(0);
    }

    public static void main(String[] args) {
        new SerializeLevels();
        if (args.length == 0)
            displayHelpAndExit();
        if (args[0].equals("-t") || args[0].equals("-text"))
            new PizzaRescue(false);
        else if (args[0].equals("-g") || args[0].equals("-graphic"))
            new PizzaRescue(true);
        else {
            displayHelpAndExit();
        }

    }

}
