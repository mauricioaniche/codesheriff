package com.github.mauricioaniche.codesheriff.dsl.comparisons;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OfExactlyTest {

    @ParameterizedTest
    @CsvSource({"9,false", "10, true", "11, false"})
    void compare(int number, boolean expectedResult) {
        OfExactly ofExactly = new OfExactly(10);
        assertThat(ofExactly.compare(number)).isEqualTo(expectedResult);
    }
}
