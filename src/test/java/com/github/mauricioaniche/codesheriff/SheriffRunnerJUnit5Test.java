package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.junit.CodeSheriffJUnit5;

// two random sheriffs just to ensure the integration works
public class SheriffRunnerJUnit5Test extends CodeSheriffJUnit5 {

    CodeSheriff fixture4ClassLoc() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inPackage("fixture.f4")
                .have()
                .linesOfCode(m -> m < 200);

        return sheriff;

    }

    CodeSheriff fixture3MethodLoc = new CodeSheriff()
            .thatEnsures()
            .methods()
            .inClassesOfPackage("fixture.f3")
            .have()
            .linesOfCode(m -> m < 100);

}
