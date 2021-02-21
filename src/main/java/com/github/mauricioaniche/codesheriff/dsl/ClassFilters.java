package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.filters.clazz.ClassInPackage;


public class ClassFilters {

    private final CodeSheriff sheriff;

    public ClassFilters(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public ClassFilters inPackage(String packageName) {
        sheriff.addFilter(new ClassInPackage(packageName));
        return this;
    }

    public ClassExpectations have() {
        return new ClassExpectations(sheriff);
    }
}
