package com.github.mauricioaniche.codesheriff.filters.clazz;

import com.github.mauricioaniche.ck.CKClassResult;

import static com.github.mauricioaniche.codesheriff.util.CKUtil.packageAndClassName;

public class IgnoreClass implements ClassFilter {

    private final String classToIgnore;

    public IgnoreClass(String classToIgnore) {
        this.classToIgnore = classToIgnore;
    }

    @Override
    public boolean accept(CKClassResult clazz) {
        String className = packageAndClassName(clazz.getClassName())[1];
        return !className.equals(classToIgnore);
    }
}
