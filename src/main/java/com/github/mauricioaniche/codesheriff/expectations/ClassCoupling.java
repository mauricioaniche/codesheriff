package com.github.mauricioaniche.codesheriff.expectations;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.comparisons.ComparisonOperator;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public class ClassCoupling implements ClassExpectation {

    private final ComparisonOperator operator;

    public ClassCoupling(ComparisonOperator operator) {
        this.operator = operator;
    }

    @Override
    public void match(CKClassResult clazz, SheriffReport report) {
        if(!operator.compare(clazz.getCbo())) {
            String message = String.format("class %s has an overall coupling of %d",
                    clazz.getClassName(), clazz.getWmc());

            report.expectationViolated(message);
        }
    }
}
