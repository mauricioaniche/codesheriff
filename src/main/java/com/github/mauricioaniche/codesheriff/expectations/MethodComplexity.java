package com.github.mauricioaniche.codesheriff.expectations;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.comparisons.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public class MethodComplexity implements MethodExpectation {
    private final ComparisonOperator operator;

    public MethodComplexity(ComparisonOperator operator) {
        this.operator = operator;
    }

    @Override
    public void match(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        if(!operator.compare(method.getWmc())) {
            String message = String.format("%s in class %s has a complexity of %d",
                    method.getMethodName(), clazz.getClassName(), method.getWmc());

            report.expectationViolated(message);
        }
    }
}
