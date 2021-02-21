package com.github.mauricioaniche.codesheriff.filters.clazz;

import com.github.mauricioaniche.ck.CKClassResult;

public interface ClassFilter {
    boolean accept(CKClassResult clazz);
}
