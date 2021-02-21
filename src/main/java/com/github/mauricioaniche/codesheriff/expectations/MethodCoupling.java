package com.github.mauricioaniche.codesheriff.expectations;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.comparisons.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public class MethodCoupling implements MethodExpectation {

    private final ComparisonOperator operator;

    public MethodCoupling(ComparisonOperator operator) {
        this.operator = operator;
    }

    @Override
    public void match(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        if(!operator.compare(method.getCbo())) {
            String message = String.format("%s in class %s has a coupling of %d",
                    method.getMethodName(), clazz.getClassName(), method.getWmc());

            report.expectationViolated(message);
        }
    }
}
