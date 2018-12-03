package nl.ivoka.Algorithms;

import nl.ivoka.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Library {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String keyWord;
    String message;
    String output;
    int standardClusterSize;
    int keyWordLength;

    List<String> createRows(String s) {
        List<String> _s = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            _s.add(s.substring(i, Math.min(i + keyWordLength, s.length())));
            i+=keyWordLength;
        } if (Main.debug) { Main.println("Rows: "+Arrays.toString(_s.toArray())); }
        return _s;
    }

    List<Integer> placeInAlphabet(String s) {
        List<Integer> _i = new ArrayList<>();
        for (int i = 0; i < keyWordLength; i++) {
            _i.add(alphabet.indexOf(s.charAt(i))+1);
        } if (Main.debug) { Main.println("Place in alphabet: "+Arrays.toString(_i.toArray())); }
        return _i;
    }

    // !!! HAS TO BE 'int[]' BECAUSE OF 'Collections.min()'
    int[] orderOfKeyWord(List<Integer> i_1, int[] i_2) {
        int[] _i = new int[keyWordLength];
        int i = 1;
        while (i_1.size() > 0) {
            _i[indexOf(i_2, Collections.min(i_1))] = i++;
            i_1.remove(i_1.indexOf(Collections.min(i_1)));
        } if (Main.debug) { Main.println("Order: "+Arrays.toString(_i)); }
        return _i;
    }

    int indexOf(int[] array, int valueToFind) {
        if (array == null) {
            return -1;
        }
        return IntStream.range(0, array.length)
                .filter(i -> valueToFind == array[i])
                .findFirst()
                .orElse(-1);
    }
    int[] toIntArray(List<Integer> i) { return i.stream().mapToInt(Integer::intValue).toArray(); }
    List<Integer> toIntegerList(int[] i) { return Arrays.stream(i).boxed().collect(Collectors.toList()); }
}