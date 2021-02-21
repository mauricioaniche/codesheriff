package com.github.mauricioaniche.codesheriff.filters.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;

public interface MethodFilter {
    boolean accept(CKMethodResult method, CKClassResult clazz);
}
