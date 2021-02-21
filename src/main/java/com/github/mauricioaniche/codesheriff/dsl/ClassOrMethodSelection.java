package com.github.mauricioaniche.codesheriff.dsl;

public class ClassOrMethodSelection {
    private final CodeSheriff sheriff;

    public ClassOrMethodSelection(CodeSheriff sheriff) {
        this.sheriff = sheriff;
    }

    public MethodFilters methods() {
        return new MethodFilters(sheriff);
    }

    public ClassFilters classes() { return new ClassFilters(sheriff); }
}
