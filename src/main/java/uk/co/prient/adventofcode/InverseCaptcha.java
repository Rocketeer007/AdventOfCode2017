package uk.co.prient.adventofcode;

import java.util.regex.Pattern;

public class InverseCaptcha {

    public int calculateCaptcha(String input) {
        return calculateCaptcha(input, 1);
    }

    public int calculateCaptcha(String input, int offset) {
        if (!validateInput(input)) {
            throw new IllegalArgumentException("Input should be digits only");
        }

        String offsetString = createOffsetString(input, offset);
        assert offsetString.length() == input.length() : "Offset string should have same length as original";

        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == offsetString.charAt(i)) {
                total += Integer.valueOf(String.valueOf(input.charAt(i)));
            }
        }

        return total;
    }

    private String createOffsetString(String input, int offset) {
        return (input.substring(offset) + input).substring(0, input.length());
    }

    private boolean validateInput(String input) {
        return Pattern.matches("\\d+", input);
    }
}
