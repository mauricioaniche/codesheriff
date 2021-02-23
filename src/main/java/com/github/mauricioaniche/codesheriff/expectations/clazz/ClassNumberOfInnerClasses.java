package com.github.mauricioaniche.codesheriff.expectations.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.dsl.ComparisonOperator;

public class ClassNumberOfInnerClasses extends DefaultClassExpectation {

    public ClassNumberOfInnerClasses(ComparisonOperator operator) {
        super(operator);
    }

    @Override
    protected int value(CKClassResult clazz) {
        return clazz.getInnerClassesQty();
    }

    @Override
    protected String message() {
        return "class %s has %d inner classes";
    }
}
