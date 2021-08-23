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

public class IgnoreMethodTest {

    private CKClassResult any = null; // it does not matter

    @ParameterizedTest
    @CsvSource({
            "m1/0, m1, false",
            "m1/1, m1, false",
            "m2/0, m1, true",
            "m2/1, m1, true",
    })
    void filter(String methodName, String methodToIgnore, boolean expectedResult) {
        CKMethodResult method = mock(CKMethodResult.class);
        when(method.getMethodName()).thenReturn(methodName);

        assertThat(new IgnoreMethod(methodToIgnore).accept(method, any))
                .isEqualTo(expectedResult);
    }

    @Test
    void fixture1IgnoreMethod() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .withExceptionOfMethod("m2")
                .have()
                .linesOfCode(m -> m < 2);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .anyMatch(s -> s.contains("m1/0"));
    }
}
