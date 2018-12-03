package nl.ivoka.Model;

import java.util.ArrayList;
import java.util.List;

public class Messages {
    static List<String> messages = new ArrayList<>();

    public static void load() {
        messages.add("This is a tool to encrypt and decrypt using the columntransformation method.");
        messages.add("*** WARNING: If message is not a good length, there will be added (multiple) X's (X) ***");
        messages.add("*** WARNING: Keyword cannot contain 2 the same letters ***");
        messages.add("");
        messages.add("This tool is created by iVoKa (jorisvos).");
        messages.add("");
    }

    public static String[] get() { return messages.toArray(new String[messages.size()]); }
}
