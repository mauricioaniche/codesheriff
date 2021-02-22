package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassNumberOfMethodsTest {

    @Test
    void fixture2NumberOfMethodsInAClass() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inPackage("fixture.f2")
                .have()
                .numberOfMethods(m -> m < 10);

        SheriffReport report = new SheriffRunner()
                .run(Arrays.asList(sheriff));

        assertThat(report.containsViolations()).isTrue();
        assertThat(report.getViolations())
                .hasSize(1)
                .allMatch(s -> s.contains("Fixture2Class1"));
    }


}
