package com.github.mauricioaniche.codesheriff.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CKUtilTest {

    @ParameterizedTest
    @CsvSource({
            "a.b.c.ClassName,a.b.c, ClassName",
            "ClassName,'',ClassName",
            "a.b.c.Class1.Class2, a.b.c,Class2"
    })
    void extractPackageAndClassName(String fullName, String packageName, String className) {
        String[] name = CKUtil.packageAndClassName(fullName);

        assertThat(name[0]).isEqualTo(packageName);
        assertThat(name[1]).isEqualTo(className);
    }
}
