package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class MethodCoupling extends DefaultMethodExpectation {

    public MethodCoupling(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKMethodResult method, CKClassResult clazz) {
        return method.getCbo();
    }

    @Override
    protected String message() {
        return "%s in class %s has a coupling of %d";
    }
}
