package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.junit.CodeSheriffJUnit;

public class SheriffRunnerJUnitTest extends CodeSheriffJUnit {

    CodeSheriff complexity() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .complexityOfLessThan(2);

        return sheriff;
    }

    CodeSheriff coupling() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .couplingOfLessThan(2);

        return sheriff;
    }
}
