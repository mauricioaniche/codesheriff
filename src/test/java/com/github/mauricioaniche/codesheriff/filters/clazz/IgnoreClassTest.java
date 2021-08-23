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

public class IgnoreClassTest {

    @ParameterizedTest
    @CsvSource({
            "a.b.Abc, Ab, true",
            "Abc, Ab, true",
            "a.b.Abc, A, true",
            "a.b.Abc, Abc, false",
            "a.b.Abc, b, true",
            "b.Abc, b, true",
            "a.b.Abc, c, true",
            "a.b.Abc, d, true"
    })
    void filter(String className, String classToIgnore, boolean expectedResult) {
        CKClassResult clazz = mock(CKClassResult.class);
        when(clazz.getClassName()).thenReturn(className);

        assertThat(new IgnoreClass(classToIgnore).accept(clazz))
                .isEqualTo(expectedResult);
    }

    @Test
    void fixture6IgnoreClass() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inPackage("fixture.f6")
                .withExceptionOfClass("Abc")
                .withExceptionOfClass("Other")
                .have()
                .linesOfCode(m -> m < 2);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .anyMatch(s -> s.contains("Abd"));
    }
}
