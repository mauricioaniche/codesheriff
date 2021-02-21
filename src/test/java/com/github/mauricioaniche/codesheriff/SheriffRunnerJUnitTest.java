package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.junit.CodeSheriffJUnit;
import org.junit.jupiter.api.Disabled;

import static com.github.mauricioaniche.codesheriff.dsl.comparisons.Comparisons.ofLessThan;

@Disabled
public class SheriffRunnerJUnitTest extends CodeSheriffJUnit {

    CodeSheriff complexity() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .complexity(ofLessThan(2));

        return sheriff;
    }

    CodeSheriff coupling() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("fixture.f1")
                .have()
                .coupling(ofLessThan(2));

        return sheriff;
    }

    CodeSheriff totalMethodsInAClass() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inClassesOfPackage("fixture.f1")
                .have()
                .numberOfMethods(ofLessThan(10));

        return sheriff;
    }
}
