package com.github.mauricioaniche.codesheriff.dsl.comparisons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OfLessThanTest {

    @ParameterizedTest
    @CsvSource({"9,true", "10, false", "11, false"})
    void compare(int number, boolean expectedResult) {
        OfLessThan lessThan = new OfLessThan(10);
        assertThat(lessThan.compare(number)).isEqualTo(expectedResult);
    }
}
