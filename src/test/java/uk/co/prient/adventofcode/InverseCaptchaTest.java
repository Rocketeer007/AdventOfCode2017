package uk.co.prient.adventofcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class InverseCaptchaTest {
    private final InverseCaptcha inverseCaptcha = new InverseCaptcha();

    @Test(expected = IllegalArgumentException.class)
    public void given_empty_string_inverse_captcha_throws_IllegalArgumentException() {
        assertThat(inverseCaptcha.calculateCaptcha(""), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_null_string_inverse_captcha_throws_IllegalArugmentException() {
        assertThat(inverseCaptcha.calculateCaptcha(""), is(0));
    }

    @Test
    public void given_single_digit_string_inverse_captcha_is_digit() {
        assertThat(inverseCaptcha.calculateCaptcha("0"), is(0));
        assertThat(inverseCaptcha.calculateCaptcha("1"), is(1));
        assertThat(inverseCaptcha.calculateCaptcha("2"), is(2));
        assertThat(inverseCaptcha.calculateCaptcha("3"), is(3));
        assertThat(inverseCaptcha.calculateCaptcha("4"), is(4));
        assertThat(inverseCaptcha.calculateCaptcha("5"), is(5));
        assertThat(inverseCaptcha.calculateCaptcha("6"), is(6));
        assertThat(inverseCaptcha.calculateCaptcha("7"), is(7));
        assertThat(inverseCaptcha.calculateCaptcha("8"), is(8));
        assertThat(inverseCaptcha.calculateCaptcha("9"), is(9));
    }

    @Test
    public void given_double_digit_string_inverse_captcha_is_sum() {
        assertThat(inverseCaptcha.calculateCaptcha("00"), is(0));
        assertThat(inverseCaptcha.calculateCaptcha("11"), is(2));
        assertThat(inverseCaptcha.calculateCaptcha("22"), is(4));
        assertThat(inverseCaptcha.calculateCaptcha("33"), is(6));
        assertThat(inverseCaptcha.calculateCaptcha("44"), is(8));
        assertThat(inverseCaptcha.calculateCaptcha("55"), is(10));
        assertThat(inverseCaptcha.calculateCaptcha("66"), is(12));
        assertThat(inverseCaptcha.calculateCaptcha("77"), is(14));
        assertThat(inverseCaptcha.calculateCaptcha("88"), is(16));
        assertThat(inverseCaptcha.calculateCaptcha("99"), is(18));
    }

    @Test
    public void given_non_repeating_string_inverse_captcha_is_zero() {
        assertThat(inverseCaptcha.calculateCaptcha("1234"), is(0));
    }

    @Test
    public void given_paired_string_inverse_captcha_is_sum_of_single_digits() {
        assertThat(inverseCaptcha.calculateCaptcha("1122"), is(3));
    }

    @Test
    public void given_match_at_ends_inverse_captcha_is_end_digit() {
        assertThat(inverseCaptcha.calculateCaptcha("91212129"), is(9));
    }
}
