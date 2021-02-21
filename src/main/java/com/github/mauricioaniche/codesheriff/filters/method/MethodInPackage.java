package com.github.mauricioaniche.codesheriff.filters.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.util.CKUtil;

public class MethodInPackage implements MethodFilter {
    private final String packageName;

    public MethodInPackage(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public boolean accept(CKMethodResult result, CKClassResult clazz) {
        String packageNameFromFullName = CKUtil.packageAndClassName(clazz.getClassName())[0];
        return packageNameFromFullName.contains(this.packageName);
    }
}
