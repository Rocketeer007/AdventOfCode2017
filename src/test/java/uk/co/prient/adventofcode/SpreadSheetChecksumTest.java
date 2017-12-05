package uk.co.prient.adventofcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SpreadSheetChecksumTest {
    private final SpreadSheetChecksum calculator = new SpreadSheetChecksum();

    @Test(expected = IllegalArgumentException.class)
    public void given_empty_string_calculateChecksum_throws_IllegalArgumentException() {
        assertThat(calculator.calculateChecksum(""), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_null_string_calculateChecksum_throws_IllegalArgumentException() {
        assertThat(calculator.calculateChecksum(""), is(0));
    }

    @Test
    public void given_single_cell_spreadsheet_calculateChecksum_returns_0() {
        assertThat(calculator.calculateChecksum("1234"), is(0));
    }

    @Test
    public void given_single_value_row_calculateChecksum_returns_0() {
        assertThat(calculator.calculateChecksum("1\t1"), is(0));
    }

    @Test
    public void given_multiple_single_value_rows_calculateChecksum_returns_0() {
        assertThat(calculator.calculateChecksum("1\t1\n2\t2"), is(0));
    }

    @Test
    public void given_two_value_row_calculateChecksum_returns_difference() {
        assertThat(calculator.calculateChecksum("1\t9"), is(8));
    }

    @Test
    public void given_multiple_two_value_rows_calculateChecksum_returns_sum_of_differences() {
        assertThat(calculator.calculateChecksum("1\t9\n0\t5"), is(13));
    }

    @Test
    public void given_trailing_newLine_calculateChecksum_returns_sum_of_differences() {
        assertThat(calculator.calculateChecksum("1\t9\n0\t5\n"), is(13));
    }

}
