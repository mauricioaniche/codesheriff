package com.github.mauricioaniche.codesheriff.filters.clazz;

import com.github.mauricioaniche.ck.CKClassResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassInPackageTest {

    @ParameterizedTest
    @CsvSource({
            "a.b.c, a.b.c.Class1, true",
            "a.b.c, a.b.d.Class1, false",
            "x, a.b.d.Class1, false",
            "b.c, a.b.c.Class1, true"
    })
    void filter(String packageName, String className, boolean expectedResult) {
        CKClassResult clazz = mock(CKClassResult.class);
        when(clazz.getClassName()).thenReturn(className);

        assertThat(new ClassInPackage(packageName).accept(clazz))
                .isEqualTo(expectedResult);
    }
}
