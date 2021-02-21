package com.github.mauricioaniche.codesheriff.runner;

import com.github.mauricioaniche.ck.CK;
import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;

import java.util.List;

public class SheriffRunner {

    private final String codePath;

    public SheriffRunner(String codePath) {
        this.codePath = codePath;
    }

    public SheriffReport run(List<CodeSheriff> sheriffs) {
        SheriffCKNotifier notifier = new SheriffCKNotifier(sheriffs);
        new CK(false, 0, false).calculate(codePath, notifier);
        return notifier.report();

    }
}
