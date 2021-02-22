package com.github.mauricioaniche.codesheriff.filters.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassNameStartsWithTest {

    @ParameterizedTest
    @CsvSource({
            "a.b.Abc, Ab, true",
            "Abc, Ab, true",
            "a.b.Abc, A, true",
            "a.b.Abc, Abc, true",
            "a.b.Abc, b, false",
            "b.Abc, b, false",
            "a.b.Abc, c, false",
            "a.b.Abc, d, false"
    })
    void filter(String className, String start, boolean expectedResult) {
        CKClassResult clazz = mock(CKClassResult.class);
        when(clazz.getClassName()).thenReturn(className);

        assertThat(new ClassNameStartsWith(start).accept(clazz))
                .isEqualTo(expectedResult);
    }

    @Test
    void fixture6ClassNameStartsWith() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inPackage("fixture.f6")
                .withNamesStartingWith("Ab")
                .have()
                .linesOfCode(m -> m < 2);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(2)
                .anyMatch(s -> s.contains("Abc"))
                .anyMatch(s -> s.contains("Abd"));
    }
}
