package com.github.mauricioaniche.codesheriff.runner;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKNotifier;
import com.github.mauricioaniche.codesheriff.CodeSheriff;

import java.util.List;

public class SheriffCKNotifier implements CKNotifier {

    private final List<CodeSheriff> sheriffs;
    private final SheriffReport report = new SheriffReport();

    public SheriffCKNotifier(List<CodeSheriff> sheriffs) {
        this.sheriffs = sheriffs;
    }

    @Override
    public void notify(CKClassResult clazz) {
        for (CodeSheriff sheriff : sheriffs) {
            clazz.getMethods().forEach(m -> sheriff.checkMethod(m, clazz, report));
        }
    }

    public SheriffReport report() {
        return report;
    }
}
