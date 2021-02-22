package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class ClassNumberOfMethods extends DefaultClassExpectation {

    public ClassNumberOfMethods(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKClassResult clazz) {
        return clazz.getNumberOfMethods();
    }

    @Override
    protected String message() {
        return "class %s has a total of %d methods";
    }
}
