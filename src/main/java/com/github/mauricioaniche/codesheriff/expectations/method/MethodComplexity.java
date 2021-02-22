package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class MethodComplexity extends DefaultMethodExpectation {

    public MethodComplexity(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKMethodResult method, CKClassResult clazz) {
        return method.getWmc();
    }

    @Override
    protected String message() {
        return "%s in class %s has a complexity of %d";
    }

}
