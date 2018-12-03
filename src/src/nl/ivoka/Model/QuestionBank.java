package nl.ivoka.Model;

import nl.ivoka.Main;

import java.util.LinkedHashMap;
import java.util.Map;

public class QuestionBank {
    public static Map<Main.VAR, Question> list = new LinkedHashMap<>();

    public QuestionBank() {

        list.put(Main.VAR.METHOD, new Question(
                "(E)ncrypt or (D)ecrypt ([e]/d): ",
                true,
                "Not a valid option. Default set to Encrypt",
                new char[] {'e','d'}
        ));
        list.put(Main.VAR.KEYWORD, new Question(
                "Keyword (will be lower case): ",
                "",
                "Error."
        ));
        list.put(Main.VAR.MESSAGE, new Question(
                "Message: ",
                "",
                "Error."
        ));
        list.put(Main.VAR.SPACES, new Question(
                "Remove spaces? ([y]/n): ",
                true,
                "Not a valid option. Default set to yes.",
                new char[] {'y', 'n'},
                true,
                Main.METHOD.ENCRYPT
        ));
        list.put(Main.VAR.UPPERCASE, new Question(
                "All uppercase? ([y]/n): ",
                true,
                "Not a valid option. Default set to yes.",
                new char[] {'y', 'n'},
                true,
                Main.METHOD.ENCRYPT
        ));
    }
}
