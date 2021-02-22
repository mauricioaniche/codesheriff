package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassExpectationTest {

    final CKClassResult classResult = mock(CKClassResult.class);
    final SheriffReport report = new SheriffReport();

    class TestClassExpectation extends DefaultClassExpectation {
        public TestClassExpectation(ComparisonOperator operator) {
            super(operator);
        }

        @Override
        protected int value(CKClassResult clazz) {
            return 10;
        }

        @Override
        protected String message() {
            return "class %s message %d";
        }
    }

    @Test
    void comparisonReturnsFalseAndRaisesAViolation() {
        ComparisonOperator comparison = mock(ComparisonOperator.class);
        when(comparison.compare(anyInt())).thenReturn(false);

        when(classResult.getClassName()).thenReturn("abc");

        TestClassExpectation expectation = new TestClassExpectation(comparison);
        expectation.match(classResult, report);

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .containsExactly("class abc message 10");
    }

    @Test
    void comparisonReturnsTrueAndNoViolationIsRaised() {
        ComparisonOperator comparison = mock(ComparisonOperator.class);
        when(comparison.compare(anyInt())).thenReturn(true);

        TestClassExpectation expectation = new TestClassExpectation(comparison);
        expectation.match(classResult, report);

        assertThat(report.containsViolations()).isFalse();
        assertThat(report.getViolations()).isEmpty();
    }
}
