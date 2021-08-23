package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.filters.method.IgnoreMethod;
import com.github.mauricioaniche.codesheriff.filters.method.MethodInPackage;
import com.github.mauricioaniche.codesheriff.filters.method.MethodNameStartsWith;


public class MethodFilters {

    private final CodeSheriff sheriff;

    public MethodFilters(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public MethodFilters inClassesOfPackage(String packageName) {
        sheriff.addFilter(new MethodInPackage(packageName));
        return this;
    }

    public MethodFilters withNamesStartingWith(String firstCharsOfMethodName) {
        sheriff.addFilter(new MethodNameStartsWith(firstCharsOfMethodName));
        return this;
    }

    public MethodFilters withExceptionOfMethod(String methodName) {
        sheriff.addFilter(new IgnoreMethod(methodName));
        return this;
    }

    public MethodExpectations have() {
        return new MethodExpectations(sheriff);
    }
}
