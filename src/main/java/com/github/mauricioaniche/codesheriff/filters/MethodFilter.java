package com.github.mauricioaniche.codesheriff.filters;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;

public interface MethodFilter {
    boolean accept(CKMethodResult result, CKClassResult clazz);
}
