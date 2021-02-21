package com.github.mauricioaniche.codesheriff.expectations.method;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

public interface MethodExpectation {
    void match(CKMethodResult method, CKClassResult clazz, SheriffReport report);
}
