package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodComplexityTest {

    @Test
    void fixture1Complexity() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .complexity(m -> m < 2);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .allMatch(s -> s.contains("m2/2[int,int]"));
    }


}
