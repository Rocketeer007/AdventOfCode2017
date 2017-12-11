package uk.co.prient.adventofcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PassphraseValidatorTest {
    private final PassphraseValidator passphraseValidator = new PassphraseValidator();

    @Test
    public void given_null_string_then_verifyUniqueWords_returns_false() {
        assertThat(passphraseValidator.verifyUniqueWords(null), is(false));
    }

    @Test
    public void given_empty_string_then_verifyUniqueWords_returns_false() {
        assertThat(passphraseValidator.verifyUniqueWords(""), is(false));
    }

    @Test
    public void given_repeated_words_only_then_verifyUniqueWords_returns_false() {
        assertThat(passphraseValidator.verifyUniqueWords("word1 word1"), is(false));
    }

    @Test
    public void given_some_repeated_words_then_verifyUniqueWords_returns_false() {
        assertThat(passphraseValidator.verifyUniqueWords("word1 word2 word1"), is(false));
    }

    @Test
    public void given_unique_words_only_then_verifyUniqueWords_returns_false() {
        assertThat(passphraseValidator.verifyUniqueWords("word1 word2 word3"), is(true));
    }
}
