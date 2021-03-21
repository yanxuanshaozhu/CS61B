# Lecture 1 2018/01/17

1 Hello World

1. All code lives inside of classes, each file should have a public class that is has the same name with the file itself
2. Main function
    * Syntax: 
    ```java
    public class <ClassName> {
        public static void main(String[] args) {
            //Function body here;
        }
    }
    ```
    * The main function can be regarded as the entrance to the program
3. Use curly braces to denote the beginning and ending of the code
4. Statements should end with semi-colons

2 Running a Java Program

1. Java complier: `javac`, Java interpreter: `java`
2. Syntax: `javac xxx.java`, `java xxx`
3. Procedure:
```java
// source file: xxx.java => javac xxx.java => binary file: xxx.class => java xxx => execution results
```
4. Notice: the source file name should be the same as the name of the public class contained inside it
5. Why binary file is needed:
    * It's type checked, to it's safer
    * It's simpler for machine to execute the binary file, so it's faster
    * Protect intellectual property, you don't need to give the original source file

3 Variables and Loops

1. A variable should be declared with its type before it's used
2. You can use while loop, for loop, for each loop or other loops

4 Gradscope course code: MNXYKX

5 Static Typing

1. All variables and expressions have a static-type, the type cannot be changed
2. Java complier performs a static type check, if there is an error in the source code, then the program is rejected before it even runs. While Python is a dynamically typed language, it runs until an error occurs

6 Defining Functions

1. Functions should be defined inside classes, we can call them methods
2. Here we only use static function
    * Syntax:
    ```java
    public class Test {
        public static <return type> <function name> (<formal parameters>) {
            //function body;
        }
    }
    ```
3. Functions in Java can have at most one return values, but functions in Python can return multiple values

7 Code Style, Comments, Javadoc

1. Good coding style:
    * Consistent styles(spacing, variable naming, brace style, etc)
    * Size(lines are not two wide, source files are not too large)
    * Description naming(variables, functions, classes)
    * Comments where appropriate
        * Line comment `// Comments`
        * Multi-line comments: 
        ```java
        /*
        Comments
        */
        ```
        * Javadoc:
        ```java
        /**
         * Comments
         * /
        ```
2. Comments:
    * Methods, classes and variables should be described using Javadoc format
    ```java
    // Class comments:
    /**
     * @author First Name Last Name <address@example.com>
     * @version Version number
     * @ since  First compatible version number
     *
     */
     public class Test {
        /**
         * One line description
         * 
         * Detailed description
         * 
         * @param Parameter Name   Description of parameter
         * 
         * @return Describe the return value
         * 
         */
         public static void main(String[] args) {
             /**  Description of variable x */
            int x = 0;
            // Function body;
         }
     }

    ```