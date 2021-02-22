package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class MethodLOC extends DefaultMethodExpectation {

    public MethodLOC(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKMethodResult method, CKClassResult clazz) {
        return method.getLoc();
    }

    @Override
    protected String message() {
        return "%s in class %s has a total lines of code of %d";
    }

}
