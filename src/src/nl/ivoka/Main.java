package nl.ivoka;

import nl.ivoka.Algorithms.Decrypt;
import nl.ivoka.Algorithms.Encrypt;
import nl.ivoka.Model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean debug = false;
    public static boolean advancedOptions = false;
    static BufferedReader reader = null;
    public static QuestionBank allQuestions = new QuestionBank();

    public enum METHOD {
        ENCRYPT,
        DECRYPT
    }

    public enum VAR {
        METHOD,
        KEYWORD,
        MESSAGE,
        SPACES,
        UPPERCASE
    }

    public static void main(String[] args) throws IOException {
        checkForArguments(args);

        reader = new BufferedReader(new InputStreamReader(System.in));

        Messages.load();
        for (String message : Messages.get()) {
            println(message);
        }

        Input.userInput();

        if (advancedOptions) {
            if (allQuestions.list.get(VAR.SPACES).answer)
                allQuestions.list.get(VAR.MESSAGE).answerText = removeSpaces(allQuestions.list.get(VAR.MESSAGE).answerText);
            if (allQuestions.list.get(VAR.UPPERCASE).answer)
                allQuestions.list.get(VAR.MESSAGE).answerText = toUpperCase(allQuestions.list.get(VAR.MESSAGE).answerText);
        } else {
            allQuestions.list.get(VAR.MESSAGE).answerText = removeSpaces(allQuestions.list.get(VAR.MESSAGE).answerText);
            allQuestions.list.get(VAR.MESSAGE).answerText = toUpperCase(allQuestions.list.get(VAR.MESSAGE).answerText);
        }
        allQuestions.list.get(VAR.KEYWORD).answerText = toLowerCase(allQuestions.list.get(VAR.KEYWORD).answerText);

        if (debug) println();

        if (allQuestions.list.get(VAR.METHOD).method == METHOD.ENCRYPT) {
            Encrypt toEncrypt = new Encrypt(allQuestions.list.get(VAR.KEYWORD).answerText, allQuestions.list.get(VAR.MESSAGE).answerText);
            toEncrypt.encrypt();
        } else {
            Decrypt toDecrypt = new Decrypt(allQuestions.list.get(VAR.KEYWORD).answerText, allQuestions.list.get(VAR.MESSAGE).answerText);
            toDecrypt.decrypt();
        }
    }

    static String removeSpaces(String s) {
        String withoutspaces = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                withoutspaces += s.charAt(i);

        }
        return withoutspaces;
    }
    static String toUpperCase(String s) { return s.toUpperCase(); }
    static String toLowerCase(String s) { return s.toLowerCase(); }

    static void checkForArguments(String[] args) {
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
