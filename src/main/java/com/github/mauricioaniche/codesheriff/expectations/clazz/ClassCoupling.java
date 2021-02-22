package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class ClassCoupling extends DefaultClassExpectation {

    public ClassCoupling(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKClassResult clazz) {
        return clazz.getCbo();
    }

    @Override
    protected String message() {
        return "class %s has an overall coupling of %d";
    }
}
