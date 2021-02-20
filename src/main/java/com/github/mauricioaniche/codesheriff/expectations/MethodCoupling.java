package com.github.mauricioaniche.codesheriff.expectations;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public class MethodCoupling implements MethodExpectation {

    private final int coupling;

    public MethodCoupling(int coupling) {
        this.coupling = coupling;
    }

    @Override
    public void match(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        if(method.getCbo() > coupling) {
            String message = String.format("%s in class %s has a coupling of %d (higher than %d)",
                    method.getMethodName(), clazz.getClassName(), method.getWmc(), coupling);

            report.expectationViolated(message);
        }
    }
}
