package com.github.mauricioaniche.codesheriff.filters.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
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

public class MethodNameStartsWithTest {

    private CKClassResult any = null; // it does not matter

    @ParameterizedTest
    @CsvSource({
            "m1/0, n, false",
            "m1/0, m, true",
            "nm1/0, m, false",
            "abcd/1, ab, true"
    })
    void filter(String methodName, String start, boolean expectedResult) {
        CKMethodResult method = mock(CKMethodResult.class);
        when(method.getMethodName()).thenReturn(methodName);

        assertThat(new MethodNameStartsWith(start).accept(method, any))
                .isEqualTo(expectedResult);
    }

    @Test
    void fixture5MethodNameStartsWith() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f5")
                .withNamesStartingWith("abc")
                .have()
                .linesOfCode(m -> m < 2);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(2)
                .anyMatch(s -> s.contains("abc/0"))
                .anyMatch(s -> s.contains("abc/1"));
    }
}
