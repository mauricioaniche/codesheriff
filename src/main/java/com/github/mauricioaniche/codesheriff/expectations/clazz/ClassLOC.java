package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class ClassLOC extends DefaultClassExpectation {

    public ClassLOC(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKClassResult clazz) {
        return clazz.getLoc();
    }

    @Override
    protected String message() {
        return "class %s has a total lines of code of %d";
    }
}
