package com.github.mauricioaniche.codesheriff;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.expectations.MethodExpectation;
import com.github.mauricioaniche.codesheriff.filters.MethodFilter;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

import java.util.LinkedList;
import java.util.List;

public class CodeSheriff {

    private List<MethodFilter> methodFilters = new LinkedList<>();
    private List<MethodExpectation> expectations = new LinkedList<>();

    public ClassOrMethodSelection thatEnsures() {
        return new ClassOrMethodSelection(this);
    }

    void addFilter(MethodFilter methodFilter) {
        methodFilters.add(methodFilter);
    }

    void addExpectation(MethodExpectation expectation) {
        expectations.add(expectation);
    }

    private boolean acceptsMethod(CKMethodResult method, CKClassResult clazz) {
        return methodFilters.stream().allMatch(mf -> mf.accept(method, clazz));
    }

    public void checkMethod(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        if(!acceptsMethod(method, clazz))
            return;
        expectations.forEach(e -> e.match(method, clazz, report));
    }
}
