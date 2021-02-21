package com.github.mauricioaniche.codesheriff.filters.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.codesheriff.util.CKUtil;

public class ClassInPackage implements ClassFilter {
    private final String packageName;

    public ClassInPackage(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public boolean accept(CKClassResult clazz) {
        String packageNameFromFullName = CKUtil.packageAndClassName(clazz.getClassName())[0];
        return packageNameFromFullName.contains(this.packageName);
    }
}
