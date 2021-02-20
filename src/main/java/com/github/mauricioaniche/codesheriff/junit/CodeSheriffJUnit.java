package com.github.mauricioaniche.codesheriff.junit;

import com.github.mauricioaniche.codesheriff.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CodeSheriffJUnit {

    @Test
    void sherrifs() {
        Reflections reflections = new Reflections(this.getClass(), new MethodParameterScanner());
        Set<Method> methods = reflections.getMethodsReturn(CodeSheriff.class);

        List<CodeSheriff> sheriffs = methods.stream().map(m -> {
            try {
                m.setAccessible(true);
                return (CodeSheriff) m.invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());

        SheriffReport report = new SheriffRunner("/Users/mauricioaniche/workspace/codesheriff/src/test/java/")
                .run(sheriffs);

        if(report.containsViolations()) {
            Assertions.fail(report.getViolationsAsString());
        }

    }
}
