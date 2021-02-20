package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.codesheriff.filters.MethodInPackage;


public class MethodFilters {

    private final CodeSheriff sheriff;

    public MethodFilters(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public MethodFilters inClassesOfPackage(String packageName) {
        sheriff.addFilter(new MethodInPackage(packageName));
        return this;
    }

    public MethodExpectations have() {
        return new MethodExpectations(sheriff);
    }
}
