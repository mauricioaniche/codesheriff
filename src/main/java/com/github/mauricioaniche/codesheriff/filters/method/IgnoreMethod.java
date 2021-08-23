package com.github.mauricioaniche.codesheriff.filters.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;

public class IgnoreMethod implements MethodFilter {
    private final String methodName;

    public IgnoreMethod(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public boolean accept(CKMethodResult method, CKClassResult clazz) {
        return !method.getMethodName().startsWith(methodName);
    }
}
