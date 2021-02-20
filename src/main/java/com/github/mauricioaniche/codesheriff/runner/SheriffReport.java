package com.github.mauricioaniche.codesheriff.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SheriffReport {
    public List<String> violations = new ArrayList<>();

    public void expectationViolated(String message) {
        violations.add(message);
    }

    public List<String> getViolations() {
        return Collections.unmodifiableList(violations);
    }

    public boolean containsViolations() {
        return !violations.isEmpty();
    }

    public String getViolationsAsString() {
        return violations.stream().reduce("CodeSheriff found the following violations in the code:\n", (message, s) -> message + "\n- " + s);
    }
}
