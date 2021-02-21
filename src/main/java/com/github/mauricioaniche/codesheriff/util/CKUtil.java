package com.github.mauricioaniche.codesheriff.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CKUtil {

    /**
     * CK returns the full name of the class, like
     * a.b.c.d.ClassName
     *
     * This method breaks it up in two parts: package and class name.
     * Note that this is only an approximation, as it considers take
     * package names all start with low case, and class names all start
     * with upper case letters.
     *
     * In the future, we should find a better way to do it. Maybe CK should
     * return the package name as in the source code. Submit a PR there!
     *
     * @param fullName the full name of the class, containing package
     * @return a String array [package name, class name]
     */
    public static String[] packageAndClassName(String fullName) {
        String[] splittedName = fullName.split("\\.");

        String packageName = Arrays.stream(splittedName)
                .filter(n -> Character.isLowerCase(n.charAt(0)))
                .collect(Collectors.joining("."));

        List<String> classes = Arrays.stream(splittedName)
                .filter(n -> Character.isUpperCase(n.charAt(0)))
                .collect(Collectors.toList());
        String className = classes.get(classes.size() - 1);

        return new String[] { packageName, className };
    }
}
