package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodNumberOfVariablesTest {

    @Test
    void fixture9NumberOfVariables() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f9")
                .have()
                .numberOfDeclaredVariables(m -> m < 4);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .allMatch(s -> s.contains("m2/0"));
    }


}
