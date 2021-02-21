package com.github.mauricioaniche.codesheriff.dsl.comparisons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InBetweenTest {

    @ParameterizedTest
    @CsvSource({"9,false", "10, true", "11, true", "19, true", "20, true", "21, false"})
    void compare(int number, boolean expectedResult) {
        InBetween ofExactly = new InBetween(10, 20);
        assertThat(ofExactly.compare(number)).isEqualTo(expectedResult);
    }
}
