package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.github.mauricioaniche.codesheriff.dsl.comparisons.Comparisons.ofLessThan;
import static org.assertj.core.api.Assertions.assertThat;

public class CodeSheriffE2ETest {
    @Test
    void fixture1Complexity() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .complexity(ofLessThan(2));

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .allMatch(s -> s.contains("m2/2[int,int]"));
    }

    @Test
    void fixture2NumberOfMethodsInAClass() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inClassesOfPackage("fixture.f2")
                .have()
                .numberOfMethods(ofLessThan(10));

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .allMatch(s -> s.contains("Fixture2Class1"));
    }
}
