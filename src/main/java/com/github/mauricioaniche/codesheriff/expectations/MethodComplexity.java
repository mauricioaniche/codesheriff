package com.github.mauricioaniche.codesheriff.expectations;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public class MethodComplexity implements MethodExpectation {

    private final int complexity;

    public MethodComplexity(int complexity) {
        this.complexity = complexity;
    }

    @Override
    public void match(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        if(method.getWmc() > complexity) {
            String message = String.format("%s in class %s has a complexity of %d (higher than %d)",
                    method.getMethodName(), clazz.getClassName(), method.getWmc(), complexity);

            report.expectationViolated(message);
        }
    }
}
