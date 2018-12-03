package nl.ivoka.Algorithms;

import nl.ivoka.Main;

import java.util.*;

public class Encrypt extends Library {

    public Encrypt(String keyWord, String message) {
        this.keyWord = keyWord;
        this.message = message;
    }

    public void encrypt() {
        keyWordLength = keyWord.length();

        message = addX(message);

        List<String> rows = createRows(message);
        List<Integer> placeInAlphabet = placeInAlphabet(keyWord);
        int[] orderOfKeyWord = orderOfKeyWord(placeInAlphabet, toIntArray(placeInAlphabet));
        Map<Integer, List<String>> msgToRows = msgToRows(toIntegerList(orderOfKeyWord), rows, message);
        output = getOutput(msgToRows);

        Main.println();
        Main.println("Encrypted message: "+output);
    }

    private String addX(String s) {
        while (s.length() % keyWordLength != 0) {
            s += "X";
        } if (Main.debug) { Main.println("Message: "+s); }
        return s;
    }

    private Map<Integer, List<String>> msgToRows(List<Integer> orderOfKeyWord, List<String> rows, String s) {
        Map<Integer, List<String>> _msgToRows = new LinkedHashMap<>();

        // Initialize _msgToRows
        for (int i = 1; i <= orderOfKeyWord.size(); i++) {
            List<String> _s = new ArrayList<>();
            _msgToRows.put(i, _s);
        }
        // End of initializing _msgToRows

        // Add all characters in good order in _msgToRows
        int cursor = 1;
        for (char _char : s.toCharArray()) {
            List<String> _tmp = _msgToRows.get(orderOfKeyWord.get(cursor-1));
            _tmp.add(String.valueOf(_char));
            _msgToRows.put(orderOfKeyWord.get(cursor-1), _tmp);

            if (++cursor > orderOfKeyWord.size())
                cursor = 1;
        } if (Main.debug) { Main.println("Message in rows: "+Arrays.toString(_msgToRows.entrySet().toArray())); }
        // Done

        return _msgToRows;
    }

    private String getOutput(Map<Integer, List<String>> msgToRows) {
        String s = "";
        for (List<String> _entry : msgToRows.values()) {
            for (String _s : _entry) {
                s += _s;
            }
        } if (Main.debug) { Main.println("Output: "+s); }
        return s;
    }
}
