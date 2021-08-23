package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.codesheriff.filters.clazz.ClassInPackage;
import com.github.mauricioaniche.codesheriff.filters.clazz.ClassNameStartsWith;
import com.github.mauricioaniche.codesheriff.filters.clazz.IgnoreClass;


public class ClassFilters {

    private final CodeSheriff sheriff;

    public ClassFilters(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public ClassFilters inPackage(String packageName) {
        sheriff.addFilter(new ClassInPackage(packageName));
        return this;
    }

    public ClassFilters withNamesStartingWith(String firstCharsOfClassName) {
        sheriff.addFilter(new ClassNameStartsWith(firstCharsOfClassName));
        return this;
    }

    public ClassExpectations have() {
        return new ClassExpectations(sheriff);
    }

    public ClassFilters withExceptionOfClass(String classToIgnore) {
        sheriff.addFilter(new IgnoreClass(classToIgnore));
        return this;
    }
}
