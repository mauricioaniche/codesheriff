package com.github.mauricioaniche.codesheriff.junit;

import com.github.mauricioaniche.codesheriff.dsl.CodeSheriff;
import com.github.mauricioaniche.codesheriff.runner.SheriffReport;
import com.github.mauricioaniche.codesheriff.runner.SheriffRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CodeSheriffJUnit5 {

    @Test
    void sheriffs() {
        List<CodeSheriff> methodSheriffs = getMethodSheriffs();
        List<CodeSheriff> fieldSheriffs = getFieldSheriffs();

        List<CodeSheriff> allSheriffs = new ArrayList<>();
        allSheriffs.addAll(methodSheriffs);
        allSheriffs.addAll(fieldSheriffs);

        SheriffReport report = new SheriffRunner()
                .run(allSheriffs);

        if(report.containsViolations()) {
            Assertions.fail(report.getViolationsAsString());
        }

    }

    private List<CodeSheriff> getFieldSheriffs() {
        Set<Field> fields = Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> f.getType().equals(CodeSheriff.class))
                .collect(Collectors.toSet());

        List<CodeSheriff> sheriffs = fields.stream().map(f -> {
            try {
                f.setAccessible(true);
                return (CodeSheriff) f.get(this);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        return sheriffs;
    }

    private List<CodeSheriff> getMethodSheriffs() {

        Set<Method> methods = Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(m -> m.getReturnType().equals(CodeSheriff.class))
                .collect(Collectors.toSet());

        List<CodeSheriff> sheriffs = methods.stream().map(m -> {
            try {
                m.setAccessible(true);
                return (CodeSheriff) m.invoke(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return sheriffs;
    }
}
