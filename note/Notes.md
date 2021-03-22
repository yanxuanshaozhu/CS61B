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




# Lab 01 

1 Version Control Systems(VCSs):

1. Version control systems are tools to keep track of changes to files over time
2. Categories:
    1. Local VCS(LVCS): copy files into another directory
    2. Centralized VCS(CVCS): 
        * One server with all versioned files
        * All clients checkout files from the central server
        * May be affected by single point of failure
        * Examples: CVS, Subversion, Perforce
    3. Distributed VCS(DVCS):
        * One server, multiple clients, all have versioned files
        * If the server dies, it can copy files from an arbitrary client to restore
        * Examples: Git, Mercurial, Bazaar, Darcs

2 Git Local Repository:

1. `git init`: initiate a repository
2. `git add <file/directory>`: add a file/directory to list of files to track, the terminology is called to stage a file
3. `git commit -m "Message" <file/directory>`: store a snapshot to the added files into the repository
4. `git log`: show git commit logs
5. `git show <object>`: for commits, show the commit messages and textual diff
```java
// untracked files  => git add => tracked files: unmodified/modified/staged
```
6. `git reset <file/directory>`: unstage a file/directory 
7. `git commit --amend`: change commit messages or add forgotten files
8. `git checkout --<file/directory>`: revert a file to its most recently committed version

3 Git Remote Repository:

1. `git push <remote repo name> <remote repo branch>`: push local repository to remote repository, for example, `git push origin master`
2. `git clone <remote repo url>`: copy remote repository to local repository
3. `git remote add <remote repo name> <remote repo url>`: add a remote for the repository
4. `git remote -v`: list all remotes for the repo
5. `git remote add <short name> <remote url>`: add a remote, the short first short name is usually called `origin`
6. `git remote rename <old short name> <new short name>`: rename a remote
7. `git remote rm <short name>`: remove a remote
8. `git clone <remote url>`: clone a remote repository to local repository
9. `git clone <remote url> <directory name>`: clone a remote repository to a specific directory
10. `fetch`: download but not merge, `pull` = `fetch` + `merge` 

4 Git Branching:

1. Reasons:
    * Be prepared for dramatic changes(called refactoring)
    * Separate works from others
    * Leave space for possible incompatible program features
2. Commands:
    * `git branch <branch name>`: create a new branch
    * `git checkout <branch name>`: switch to a specific branch
    * `git checkout -b <branch name>`:create a new branch and switch to it
    * `git branch -d <branch name>`: delete a branch
    * `git branch -v`: show current branch name



# HW 00 

1 Conditions

1. If Statement:
    * Syntax:
    ```java
    if(<boolean condition>) {
        // Do something here;
    }
    ```
    * If no curly braces are used, then only the first statement after the boolean condition is regarded as inside the if statement
    * Curly braces:
    ```java
    // Allman style/BSD style(in honor of Eric Allman)
    if(<boolean condition>)
    {
        // Do something here;
    }
    //k&R style(in honor of Kernighan & Ritchie)
    if(<boolean condition>) {
        // Do something here;
    }
    ```

2 Else Statement

1. Syntax:
```java
if(<boolean condition>) {
    // Do something here;
} else {
    // Do something here;
}
```

3 While Loop

1. Syntax:
```java
int counter = <start value>;
while(<boolean condition>) {
    // Do something here;
    //Change the counter;
}
```

4 Data Type in Java:

1. Data type in Java: `byte`, `short`, `char`, `int`, `long`, `float`, `double`, `boolean`(`true`, `false`), `Object`
2. There are typecasts among different types, and transformation from a more general type to a smaller type will lose precision

5 Array:

1. Initialize an array: `<type>[] <name> = new <type>[length];`, For example, `int[] values = new int[10];`. There is also another way: `int[] values = {1, 2, 3};`
2. Upon initialization using the first way, an array will be filled with default values. For an numeric array, it will be filled with `0`, for a boolean array, it will be filled with `false`, for an object array, it will be filled with `null`
3. Length of an array: `<name>.length`
4. Sort an array in place:
```java
import java.util.Arrays;
Arrays.sort(<array name>); //This method sort returns nothing(void)
```
5. Higher-dimension array:
    * Initialize an higher-dimension array example: `int[][] values = new int[3][4];`

6 For Loop

1. Syntax:
```java
for(<initialization>; <termination>; increment){
    // Do something here;
}
```

7 Break and Continue

1. `break;`: terminate the innermost loop
2. `continue;`: skip the current iteration of the loop and jump to the increment

8 The Enhanced For Loop

1. Syntax:
```java
for(<type> ele: <collections>) {
    // Do something here;
}
```