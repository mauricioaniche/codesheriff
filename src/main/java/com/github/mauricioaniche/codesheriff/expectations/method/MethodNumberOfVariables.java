package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class MethodNumberOfVariables extends DefaultMethodExpectation {

    public MethodNumberOfVariables(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKMethodResult method, CKClassResult clazz) {
        return method.getVariablesQty();
    }

    @Override
    protected String message() {
        return "%s in class %s has a total of %d variables";
    }

}
