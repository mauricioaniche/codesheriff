# CodeSheriff

CodeSheriff is a simple library that helps you in writing JUnit tests 
that check the quality of your code.

For example, CodeSheriff may fail because you have methods in your code that 
have more than X lines of code, or that have complexity greater than Y.

CodeSheriff is highly flexible and lets you define the quality rules through
a very simple DSL. No more complicated configurations in complicated code
quality tools. Just write a test!

This framework was highly inspired by ArchUnit. If you want to write unit tests 
to check architectural conformance, check that framework! 

*Note that this is still just a prototype and is not yet battle tested. Help me out here!*

## The CodeSheriff API

The best way to understand CodeSheriff is by means of examples. See the 
test class below:

```java
public class SheriffRunnerJUnitTest extends CodeSheriffJUnit5 {

    CodeSheriff complexity() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .methods()
                .inClassesOfPackage("a.b.c")
                .have()
                .complexity(ofLessThan(10));

        return sheriff;
    }

    CodeSheriff loc() {
        CodeSheriff sheriff = new CodeSheriff();

        sheriff.thatEnsures()
                .classes()
                .inPackage("a.b.c")
                .have()
                .linesOfCode(ofLessThan(100));

        return sheriff;
    }

}
```
For CodeSheriff to work, all you need to do it:

- Create a class that extends from the provided `CodeSheriffJUnit` class.
- Write as many _CodeSheriff_s as you want. A CodeSheriff is basically a rule
that the library will check later.
- See the `complexity` rule. It ensures that all methods within the `a.b.c` package
have complexity of less than 10. Complexity here is basically cyclomatic complexity (i.e.,
the number of ifs, fors, while, etc, in your code)
- See the `loc` rule. It ensures that all classes in the `a.b.c` package have
less than 100 lines of code.

This class is a JUnit 5 test class. Just run it. If no rules are broken in your
code, then, the test passes. If a rule is broken, CodeSheriff will list you all
the classes and methods that break a rule.

## How does it work?

CodeSheriff builds the AST of your entire source code and collect code metrics.
This is done by my other library, CK. 

This means that checking the rules may take a while depending on the size of
your project.

## Available rules

Just use the DSL to explore all the options.

## License

This code is licensed under the MIT license.