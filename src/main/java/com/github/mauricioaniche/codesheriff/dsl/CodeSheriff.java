package com.github.mauricioaniche.codesheriff.dsl;

import com.github.mauricioaniche.ck.CKClassResult;
import com.github.mauricioaniche.ck.CKMethodResult;
import com.github.mauricioaniche.codesheriff.expectations.clazz.ClassExpectation;
import com.github.mauricioaniche.codesheriff.expectations.method.MethodExpectation;
import com.github.mauricioaniche.codesheriff.filters.clazz.ClassFilter;
import com.github.mauricioaniche.codesheriff.filters.method.MethodFilter;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;

import java.util.LinkedList;
import java.util.List;

public class CodeSheriff {

    private List<MethodFilter> methodFilters = new LinkedList<>();
    private List<MethodExpectation> methodExpectations = new LinkedList<>();

    private List<ClassFilter> classFilters = new LinkedList<>();
    private List<ClassExpectation> classExpectations = new LinkedList<>();

    public ClassOrMethodSelection thatEnsures() {
        return new ClassOrMethodSelection(this);
    }

    void addFilter(MethodFilter filter) {
        methodFilters.add(filter);
    }
    void addFilter(ClassFilter filter) {
        classFilters.add(filter);
    }

    void addExpectation(MethodExpectation expectation) {
        methodExpectations.add(expectation);
    }
    void addExpectation(ClassExpectation expectation) {
        classExpectations.add(expectation);
    }

    private boolean acceptsMethod(CKMethodResult method, CKClassResult clazz) {
        if(methodFilters.isEmpty()) return true;
        return methodFilters.stream().allMatch(mf -> mf.accept(method, clazz));
    }

    public void checkMethod(CKMethodResult method, CKClassResult clazz, SheriffReport report) {
        if(!acceptsMethod(method, clazz))
            return;
        methodExpectations.forEach(e -> e.match(method, clazz, report));
    }

    private boolean acceptsClass(CKClassResult clazz) {
        if(classFilters.isEmpty()) return true;
        return classFilters.stream().allMatch(mf -> mf.accept(clazz));
    }

    public void checkClass(CKClassResult clazz, SheriffReport report) {
        if(!acceptsClass(clazz))
            return;
        classExpectations.forEach(e -> e.match(clazz, report));
    }
}
