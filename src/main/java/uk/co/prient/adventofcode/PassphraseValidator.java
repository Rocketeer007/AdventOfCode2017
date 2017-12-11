package uk.co.prient.adventofcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PassphraseValidator {
    public boolean verifyUniqueWords(String passphrase) {
        if (passphrase == null || passphrase.isEmpty()) {
            return false;
        }

        Set<String> words = new HashSet<>();

        for (String word : passphrase.split(" ")) {
            if (words.contains(word)) {
                return false;
            }
            words.add(word);
        }
        return true;
    }

    public boolean verifyAnagramUniqueWords(String passphrase) {
        if (passphrase == null || passphrase.isEmpty()) {
            return false;
        }

        Set<String> words = new HashSet<>();

        for (String word : passphrase.split(" ")) {
            String sortedWord = sortWord(word);
            if (words.contains(sortedWord)) {
                return false;
            }
            words.add(sortedWord);
        }
        return true;
    }

    public String sortWord(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return String.valueOf(letters);
    }
}
