package com.github.mauricioaniche.codesheriff.filters.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;

public class MethodNameStartsWith implements MethodFilter {
    private final String firstCharsOfMethodName;

    public MethodNameStartsWith(String firstCharsOfMethodName) {
        this.firstCharsOfMethodName = firstCharsOfMethodName;
    }

    @Override
    public boolean accept(CKMethodResult method, CKClassResult clazz) {
        return method.getMethodName().startsWith(firstCharsOfMethodName);
    }
}
