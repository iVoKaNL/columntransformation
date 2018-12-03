package nl.ivoka.Algorithms;

import nl.ivoka.Main;

import java.util.*;

public class Decrypt extends Library {

    public Decrypt(String keyWord, String message) {
        this.keyWord = keyWord;
        this.message = message;
    }

    public void decrypt() {
        keyWordLength = keyWord.length();

        List<String> rows = createRows(message);
        List<Integer> placeInAlphabet = placeInAlphabet(keyWord);
        int[] orderOfKeyWord = orderOfKeyWord(placeInAlphabet, toIntArray(placeInAlphabet));
        Map<Integer, List<String>> msgToRows = msgToRows(toIntegerList(orderOfKeyWord), rows, message);
        output = getOutput(msgToRows, toIntegerList(orderOfKeyWord));

        Main.println();
        Main.println("Decrypted message: "+output);
    }

    private Map<Integer, List<String>> msgToRows(List<Integer> orderOfKeyWord, List<String> rows, String s) {
        Map<Integer, List<String>> _msgToRows = new LinkedHashMap<>();

        // Initialize _msgToRows
        for (int i = 1; i <= orderOfKeyWord.size(); i++) {
            List<String> _s = new ArrayList<>();
            _msgToRows.put(i, _s);
        }
        // End of initializing _msgToRows

        int msgCluster = message.length() / keyWordLength;
        standardClusterSize = message.length() / keyWordLength;

        // Add all characters in good order in _msgToRows
        int cursor = 1;
        for (char _char : s.toCharArray()) {
            List<String> _tmp = _msgToRows.get(cursor);
            _tmp.add(String.valueOf(_char));
            _msgToRows.put(cursor, _tmp);

            if (--msgCluster < 1) {
                msgCluster = standardClusterSize;
                cursor++;
            }
        } if (Main.debug) { Main.println("Message in rows: "+ Arrays.toString(_msgToRows.entrySet().toArray())); }
        // Done

        return _msgToRows;
    }

    private String getOutput(Map<Integer, List<String>> msgToRows, List<Integer> orderOfKeyWord) {
        String s = "";

        // Initialize necessary variables
        int columnCursor = 0;
        int rowCursor = 0;
        int columnResetAt = keyWordLength;
        // Done

        while (true) {

            if (rowCursor >= msgToRows.get(1).size())
                break;

            s += msgToRows.get(orderOfKeyWord.get(columnCursor++)).get(rowCursor);

            if (columnCursor >= columnResetAt) {
                columnCursor = 0;
                rowCursor++;
            }
        } if (Main.debug) { Main.println("Output: "+s); }
        return s;
    }
}
