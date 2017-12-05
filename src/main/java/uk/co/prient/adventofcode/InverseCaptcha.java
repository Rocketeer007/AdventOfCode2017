package uk.co.prient.adventofcode;

import java.util.regex.Pattern;

public class InverseCaptcha {

    public int calculateCaptcha(String input) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException("Input should be digits only");
        }

        int total = 0;
        Character previousChar = input.charAt(input.length()-1);
        for (Character character : input.toCharArray()) {
            if (character.equals(previousChar)) {
                total += Integer.valueOf(String.valueOf(character));
            }
            previousChar = character;
        }

        return total;
    }

    private boolean validateInput(String input) {
        return Pattern.matches("\\d+", input);
    }
}
