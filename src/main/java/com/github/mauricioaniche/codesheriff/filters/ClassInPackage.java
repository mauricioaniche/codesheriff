package com.github.mauricioaniche.codesheriff.filters;

import com.github.mauricioaniche.ck.CKClassResult;

public class ClassInPackage implements ClassFilter {
    private final String packageName;

    public ClassInPackage(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public boolean accept(CKClassResult clazz) {
        return clazz.getClassName().contains(packageName);
    }
}
