package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public abstract class DefaultClassExpectation implements ClassExpectation {
    private final ComparisonOperator operator;

    public DefaultClassExpectation(ComparisonOperator operator) {
        this.operator = operator;
    }

    @Override
    public void match(CKClassResult clazz, SheriffReport report) {
        int metricValue = value(clazz);

        if(!operator.compare(metricValue)) {
            String message = String.format(message(),
                    clazz.getClassName(), metricValue);

            report.expectationViolated(message);
        }
    }

    protected abstract int value(CKClassResult clazz);
    protected abstract String message();
}
