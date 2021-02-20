package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SheriffRunnerTest {

    @Test
    void t1() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .complexityOfLessThan(2);

        SheriffReport report = new SheriffRunner("/Users/mauricioaniche/workspace/codesheriff/src/test/java/")
                .run(Arrays.asList(sheriff));

        System.out.println(report.getViolations());
    }
}
