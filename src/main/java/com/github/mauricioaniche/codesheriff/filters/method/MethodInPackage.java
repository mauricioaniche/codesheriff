package com.github.mauricioaniche.codesheriff.filters.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;

public class MethodInPackage implements MethodFilter {
    private final String packageName;

    public MethodInPackage(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public boolean accept(CKMethodResult result, CKClassResult clazz) {
        return clazz.getClassName().contains(packageName);
    }
}
