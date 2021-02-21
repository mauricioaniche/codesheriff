package com.github.mauricioaniche.codesheriff.filters.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.util.CKUtil;

public class ClassNameStartsWith implements ClassFilter {
    private final String firstCharsOfClassName;

    public ClassNameStartsWith(String firstCharsOfClassName) {
        this.firstCharsOfClassName = firstCharsOfClassName;
    }

    @Override
    public boolean accept(CKClassResult clazz) {
        String className = CKUtil.packageAndClassName(clazz.getClassName())[1];
        return className.startsWith(firstCharsOfClassName);
    }
}
