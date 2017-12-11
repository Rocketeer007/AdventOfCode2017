package uk.co.prient.adventofcode;

import java.util.HashSet;
import java.util.Set;

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
}
