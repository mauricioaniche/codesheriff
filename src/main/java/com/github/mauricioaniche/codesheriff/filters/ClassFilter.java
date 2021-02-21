package com.github.mauricioaniche.codesheriff.filters;

import com.github.mauricioaniche.ck.CKClassResult;

public interface ClassFilter {
    boolean accept(CKClassResult clazz);
}
