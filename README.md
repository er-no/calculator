# Calculator App
This calculator app was test drivenly developed using toolset:

- VSCode with plugin "Extension Pack for Java" by Microsoft as IDE

- Gradle with plugins "jacoco" and "spotbugs"

The repo serves as an example of a development enviroment more light-weight
than eclipse or IntelliJ, but still equally competent.

## Static test on the application
Using spotbugs it is possilbe to use static analysis to spot bugs on the
codebase. Once the spotbugs plugin is loaded, you simply run:

```
$ gradle check
```

This will generate static analysis for all of the source-sets (src and test in
this case).

## Test the application
By running:

```
$ gralde test
```

You will execute all unit tests. This will also trigger JaCoCo test-coverage
report and those reports can be found (line-by-line highlighting) in
<code>calculator/build/reports/jacoco/test/html/</code>.

## Running the app
The calculator takes a list of numbers or operators and squentially executes
the corresponding inputs just like some old pocket calculator. Example:

```
$ gradle clean jar
$ java -jar calculator.jar 1 + 1 . 4 - 2 / 3
Executing instructions...
Input:  1
Output: 1
Input:  +
Output: 1
Input:  1
Output: 2
Input:  .
Output: 2
Input:  4
Output: 8
Input:  -
Output: 8
Input:  2
Output: 6
Input:  /
Output: 6
Input:  3
Output: 2
```
