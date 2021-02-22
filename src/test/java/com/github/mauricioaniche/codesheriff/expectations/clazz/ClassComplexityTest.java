package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassComplexityTest {

    @Test
    void fixture7ClassComplexity() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inPackage("fixture.f7")
                .have()
                .complexity(m -> m < 10);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .allMatch(s -> s.contains("Fixture7Class2"));
    }


}
