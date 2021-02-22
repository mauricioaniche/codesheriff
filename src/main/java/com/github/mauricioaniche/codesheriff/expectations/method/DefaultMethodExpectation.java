package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public abstract class DefaultMethodExpectation implements MethodExpectation {

    private final ComparisonOperator operator;

    public DefaultMethodExpectation(ComparisonOperator operator) {
        this.operator = operator;
    }

    @Override
    public void match(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        int metricValue = value(method, clazz);
        if(!operator.compare(metricValue)) {
            String message = String.format(message(),
                    method.getMethodName(), clazz.getClassName(), metricValue);

            report.expectationViolated(message);
        }
    }

    protected abstract int value(CKMethodResult method, CKClassResult clazz);
    protected abstract String message();



}
