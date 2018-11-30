package nl.ivoka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static boolean debug = false;
    static boolean advancedOptions = false;
    static BufferedReader reader = null;

    public static void main(String[] args) {
        checkForArguments(args);

        reader = new BufferedReader(new InputStreamReader(System.in));

        Messages.load();
        for (String message : Messages.get()) {
            println(message);
        }
    }

    public static void checkForArguments(String[] args) {
        if (args.length > 0) {
            if (args.length > 2) {
                println("usage: java -jar columntransformation.jar [-d(ebug)] [-a(dvanced options)]");
                System.exit(0);
            } else {
                if (args.length == 1) {
                    if (args[0].equals("-help") || args[0].equals("-h") || args[0].equals("--help") || args[0].equals("--h")) {
                        println("usage: java -jar columntransformation.jar [-d(ebug)] [-a(dvanced options)]");
                        System.exit(0);
                    } else if (args[0].equals("-d")) {
                        println("Debug mode has been activated."); println();
                        debug = true;
                    } else if (args[0].equals("-a")) {
                        println("Advanced options have been activated."); println();
                        advancedOptions = true;
                    } else {
                        println("That is not a valid argument!");
                        println("usage: java -jar columntransformation.jar [-d(ebug)] [-a(dvanced options)]");
                        System.exit(0);
                    }
                } else {
                    if ((args[0].equals("-d") || args[0].equals("-a")) && (args[1].equals("-d") || args[1].equals("-a")) && !args[0].equals(args[1])) {
                        println("Debug mode and Advanced options have been activated."); println();
                        debug = true;
                        advancedOptions = true;
                    } else {
                        println("That is not a valid argument!");
                        println("usage: java -jar columntransformation.jar [-d(ebug)] [-a(dvanced options)]");
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static String readLine() throws IOException { return reader.readLine(); }

    public static void print(String message) { System.out.print(message); }
    public static void print(int message) { System.out.print(message); }
    public static void println(String message) { System.out.println(message); }
    public static void println(int message) { System.out.println(message); }
    public static void println() { System.out.println(""); }
}
