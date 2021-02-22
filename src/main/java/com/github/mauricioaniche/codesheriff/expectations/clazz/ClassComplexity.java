package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class ClassComplexity extends DefaultClassExpectation {

    public ClassComplexity(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKClassResult clazz) {
        return clazz.getWmc();
    }

    @Override
    protected String message() {
        return "class %s has an overall complexity of %d";
    }
}
