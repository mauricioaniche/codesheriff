package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MethodExpectationTest {

    final CKClassResult classResult = mock(CKClassResult.class);
    final CKMethodResult methodResult = mock(CKMethodResult.class);
    final SheriffReport report = new SheriffReport();

    class TestMethodExpectation extends DefaultMethodExpectation {
        public TestMethodExpectation(ComparisonOperator operator) {
            super(operator);
        }

        @Override
        protected int value(CKMethodResult method, CKClassResult clazz) {
            return 10;
        }

        @Override
        protected String message() {
            return "method %s class %s message %d";
        }
    }

    @Test
    void comparisonReturnsFalseAndRaisesAViolation() {
        ComparisonOperator comparison = mock(ComparisonOperator.class);
        when(comparison.compare(anyInt())).thenReturn(false);

        when(classResult.getClassName()).thenReturn("abc");
        when(methodResult.getMethodName()).thenReturn("m1/0");

        TestMethodExpectation expectation = new TestMethodExpectation(comparison);
        expectation.match(methodResult, classResult, report);

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .containsExactly("method m1/0 class abc message 10");
    }

    @Test
    void comparisonReturnsTrueAndNoViolationIsRaised() {
        ComparisonOperator comparison = mock(ComparisonOperator.class);
        when(comparison.compare(anyInt())).thenReturn(true);

        TestMethodExpectation expectation = new TestMethodExpectation(comparison);
        expectation.match(methodResult, classResult, report);

        assertThat(report.containsViolations()).isFalse();
        assertThat(report.getViolations()).isEmpty();
    }
}
