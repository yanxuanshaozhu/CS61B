# Lecture 01 2018/01/17

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

1 Condition:

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

2 Else Statement:

1. Syntax:
```java
if(<boolean condition>) {
    // Do something here;
} else {
    // Do something here;
}
```

3 While Loop:

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

6 For Loop:

1. Syntax:
```java
for(<initialization>; <termination>; increment){
    // Do something here;
}
```

7 Break and Continue:

1. `break;`: terminate the innermost loop
2. `continue;`: skip the current iteration of the loop and jump to the increment

8 The Enhanced For Loop:

1. Syntax:
```java
for(<type> ele: <collections>) {
    // Do something here;
}
```





# Lecture 02 2018/01/19

1 Static v.s. Non-Static Methods:

1. Static methods:
    * If class uses methods in class B, then class A is a client class of class B.
    * Two ways to run methods in a class:
        * Run methods in `main` function in its own class
        * Run methods in `main` function of a client class

2. Instance variables and object instantiation
    * `Object` is an instance of every class
    * Instance variables, a.k.a. non-static variables, are defined within a class
    * Instance methods, a.k.a. non-static methods, are ones associated with instances
    * `new` is used for instantiation
    * Class methods, a.k.a. static methods, are accessed using dot notation

3. Constructor in Java:
    * No return type, the name should be the same as the class name
    * Syntax:
    ```java
    public class <ClassName> {
        // Constructor
        public <ClassName> (<formal parameters>) {
            this.<instance field> = parameter;
        }
    }
    ```

4. Array Instantiation, Arrays of Objects:
    * Syntax:
    ```java
    <ClassName>[] <array name> = new <ClassName>[length];
    ```

2 Class Methods v.s. Instance Methods:

1. Class methods, a.k.a. static methods, are actions taken by class itself. They are invoked by the class name: `<class name>.<static method name>`
2. Instance methods, a.k.a. non-static methods, are actions taken a specific instance of a class. They are invoked by a class instance: `<instance name>.<non-static method name>`
3. Static variables: properties inherent to the class itself, usage: `<class name>.<static variable name>`

3 `public static void main(string[] args)`:

1. The `main` function is called by the Java interpreter
2. The `args` are usually refereed to the command line arguments

4 Using Libraries:

1. It will save you bunch of time and energy






# Lecture 03 2018/01/22

1 Bits:

1. Information in memory are 1s and 0s.
2. 8 primitive types: `byte`, `short`, `char`, `int`, `long`, `float`, `double`, `boolean`(`true`, `false`)

2 Declare a Variable in Primitive Type:

1. Syntax: `type name;`, e.g. `int x;`
2. Procedure:
    * Computer sets aside enough bits to hold a thing of that type
    * Java creates an internal table to map a variable to a location
    * Java does not write anything in the reserved boxes if there is no assignment

3 The Golden Rule of Equals(GRoE):

1. `y = x` simply copies the bits of x into the box of y
2. The rule applies to both primitive values and reference type objects

4 Reference Type:

1. Object instantiation with `new`:
    * Java allocates a box of bits for each instance variable of the class and fills them with a default value for the variable type(0, false, null)
    * The constructor fills each box with formal parameters if there exists any
    * You can think that `new` returns the location in memory where the instance is put
2.  Declaration of reference type:
    * Java allocates a box of 64 bits, no matter what exactly the reference type object is
    * The bits set to null(all 0s) or the 64-bit address returned by the `new` statement
    * If you reassign a variable to the another object, then the original objet is no longer being referred, if there is no other references, it will be garbage collected

5 Parameter Passing:

1. GRoE applies in parameter passing, so the parameter passing is called the pass by value
2. An example:
```java
public class PassByValueFigure {
    public static void main(String[] args) {
           Walrus walrus = new Walrus(3500, 10.5);
           int x = 9;

           doStuff(walrus, x);                                  
           /*
           Pass by value, so the parameter W is the 64-bit address of walrus, and x is the bits of int 9,
           in the local scope, when W.weight is changed, it also changes the referred object walrus,
           but when the bits of int 9 is changed, is has no influence on the x in the outer scope. 
           */
           System.out.println(walrus.weight);                   // 3400
           System.out.println(x);                               // 9
    }

    public static void doStuff(Walrus W, int x) {
           W.weight = W.weight - 100;
           x = x - 5;
    }
}

```

6 The IntList class:

1. A comparison 
```java
public int size() {
    if (this.rest == null) {                     // Here you cannot write like if(this == null ){ return 0;}, because it is an instance method,
        return 1;                                //  it's invoked by lst.size(), if lst == null, then this call will result in NullPointer error
    }
    return 1 + this.rest.size();
}

public static int size(IntList lst) {
    if(lst == null) {                           // For the static method, you can use however, the lst == null statement, because in this situation, 
        return 0;                               // it's invoked by IntList.size(lst)
    } else {
        return 1 + size(lst.rest)
    }
}

```
2. If you use something like `this = this.rest` in your code, it's better to declare ahead `IntList cur = this` and use `cur` instead
3. Other functions: `size`, `iterativeSize`, `get`






# Lecture 04 2018/01/24

1 Improvements of the `IntList` into the `SLList`:

1. Re-branding: rename to `IntList` class to the `IntNode` class

2. Bureaucracy: 
    * Put `IntNode` class inside the `SLList` class, hide the naked recursive structure in the `IntNode` class
    * add method: `addFirst`, `getFirst`, `addLast`, `size`

3. Private v.s. Public:
    * Private variables/methods cannot be accessed from somewhere outside the java file where they are defined
    * in real world, private codes should be ignored by users, whereas public codes could be accessed and used from all users from anywhere

4. Nested classes:
    * Classes in different files can be put together into nested classes into a single file
    * If the nested class doesn't need access to other instance variables and methods, it could be declared as `static`
    * Use a helper function when inner class is recursive structure, but the outer one is not
    ``` java

    private static int sizeHelper(IntNode cur) {
        if(cur.next == null) {
            return 1;
        } else {
            return 1 + sizeHelper(cur.next);
        }
    }      
    /* This function is wrong, since there is no such function called size() in the inner InterNode class.
    public int size() {
            if(cur.next == null) {
                return 1;
            } else {
                return 1 + node.next.size();  => this call is wrong
            }   
    }
    */
    public int size() {
        return sizeHelper(node);
    }
    ```
    * Functions with same name but different signatures are called overloaded functions

5. Caching:
   
* Use a variable to cache the list size will result in quicker size function, but lower in addFirst function, addLast function and heavier memory usage
  
6. The empty lists:
    * The first way: use a new constructor for the empty list, in this way you need to take care of the null boundary condition
    * Use sentinel node as a instance variable to calculate store the first dummy node, the first actual node is `sentinel.next`, this way is preferred for simpler boundary conditions

7. Invariants:
    * An invariant is a condition that is guaranteed to be true during code execution
    * Invariants for the `SLList` class:
        * The first item is the `sentinel.next.first`
        * The size is the actual amount of items
        * Sentinel references refer to a sentinel node






# Lecture 05 2018/01/26

1 Improvements of the `SLList` into the `DLList`:

1. Looking back:
    * The addLast function is slow for the SLList, you can add a `public IntNode prev` to convert the SLList(single-linked list) into the DLList(double-linked list)
    * Add a last node `private IntNode prev`

2. Sentinel Update:
    * Deal with the problem that last node can point to both a sentinel node or a real node
    * The first way: use two sentinel nodes, one at the beginning of the list, one at the end of the list
    * The second way: use one sentinel node, but let the list become circular, which means the last real node points to the sentinel node at the beginning

3. Generic lists:
    * Deal with the problem that the current DLList can only holds int values
    * Syntax:
    ```java
    public class DLList<T> {                      // This means the DLList can hold type T values
        private IntNode sentinel;
        private int size;

        public class IntNode {
            public IntNode prev;
            public IntNode next;
            public T first;                      // The first item in the IntNode is type T
        }

        // Other codes
    }
    //The type in the new statement can be omitted, although it's definitely right to add it in the statement 
    DLList<String> lst = new DLList<>("String values");                     
    ```


2 Array Basics:

1. An array is a special type of object ths consists of a numbered sequence of memory boxes

2. Fixed integer length $N$, then $N$ boxes with indices starting from $0$ to $N - 1$, get length of an array: `myArray.length`

3. Creation:
    * `int[] x = new int[3];`
    * `int[] x = new int[] {1, 2, 3};`
    * `int[] x = {1, 2, 3};`

4. Access and Modification:
    * `myArray.length;`
    * Same object `array1 = array2;`
    * Create a new object: `System.arraycopy(old_array, start_old_index, new_array, start_new_index, copy_length);`

5. 2D Arrays in Java:
    * Example: `int[][] x = new int[4][];`

6. Arrays v.s. Classes:
    * Both can be used to organize a bunch of memory boxes
    * Array boxes are numbered and accessed by `[]`, class boxes are named(fields) and accessed by `.`
    * Array boxes should be in the same type, class boxes can be in different types
    * One can specify array indices at runtime, and can only use reflection to specify class fields






# Lecture 06 2018/01/29

1 DLList: fast in add/remove/get methods, ignore special cases, but get is slow for long lists, because you need to travel through every item on the way, which is slower than arrays in this sense, so we can use AList to tackle this problem

2 Resize AList when full, i.e., when `size == items.length`:

* The most trivial way:
    ```java
        // Part of the addLast function with resizing taken into consideration
        if (size == items.length) {
            int[] newItems = new int[size + 1];
            System.arraycopy(items, 0, newItems, 0, size);
            newItems[size] = value;
            size += 1;
            items = newItems;
        }
    ```
* The above way is quite slow when one adds a large quantity of items into the array, because there is so many resizing during the process
* A faster way is called the multiplicative resizing: `items.length * multiplicative factor`

3 Load factor/usage ratio

* Definition: `LF = size / items.length`
* If $LF < 0.25$, then there is so much space unused in the array, so we resize downwards the array by `items.length => items.length / 2`

4 Genetic arrays:

* Add a type generic to the AList so it can hold items other than integers
* Syntax: 

```java
//  This is correct
Type[] items = (Type[]) new Object[capacity];

//  This is wrong
Type[] items = new Type[capacity];
```
* One is not allowed to create generic type arrays in Java, one needs to use the typecast, otherwise a generic array creation error is caused





# Lab 03 

1 Unit Testing:

1. Test each method in your code, and ultimately ensure that you have a working program
2. Unit: break down the program into smallest part to enforce good code structure, each method should do only one thing
3. JUnit: a unit testing framework for Java

2 Add JUnit to your program:

1. Java program: `import org.junit.Test`, `import static org.junit.Assert.*`
2. Maven program:
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>     <!-- Enter a compatible junit version number here -->
</dependency>
```
For compatible versions, search <a href = "https://search.maven.org/">search.maven.org</a>

3 JUnit Syntax:

1. Syntax:
```java
public class ClassTest {
    
    @Test
    public void methodTest {
        assertEquals(ExpectedValue, MethodCalculation);
        assertNull(MethodCalculation);   // This one equals to assertEquals(null, MethodCalculation);
        assertTrue(MethodCalculation);
        assertFalse(MethodCalculation);
        assertNotEquals(ExpectedValue, MethodCalculation);
    }
}
```
2.  Use annotation `@Test` and non-static method only

4 Reverse a linked list:

1. Recursion:

```java 
    public class Test {
        public static void reverse(LinkedNode first) {
            if (first == null || first.next == null) {                 // Situation where the list is an empty linked list or there is only one item in the list
                return first;                                
            } else {
                LinkedNode re = Test.reverse(first.next);              // re is the reversed linked list,
                first.next.next = first;                               // Let the second item in the linked list points to first
                first.next = null;                                     // Let first points to null
                return re;                                             // Return the whole reversed linked list
            }
        }
    }
    /* An example
    LinkedList(1,2,3,4) =>  1 -> 2 -> 3 -> 4 -> null
    first = 1, re = LinkedList(4,3,2) => 4 -> 3 -> 2 -> null
    first.next = 2, so the first.next.next = first turns re into 4 -> 3 -> 2 -> 1
    first.next = null turns re into 4 -> 3 -> 2 -> 1 -> null, then done
    */
```

2. Iteration:

```java
    public class Test {
        public static void reverse(LinkedNode first) {
            LinkedNode re = null;                                      // This is the reversed linked list
            LinkedNode cur = first;                                    // This is the first node in the unreversed part of the original list
            while (cur != null) {
                LinkedNode temp = cur.next;                            // Save the next node of the current node
                cur.next = re;                                         // current node points to first node in the reversed linked list
                re = cur;                                              // Modify the linked list to the current node is the first node in it
                cur = temp;                                            // Next node in the unreversed part of the original list
            }
            return re;                                                 // Return the whole reversed linked list
        }
    }
```

5 int and Integer:

1. If two `int` variables have the same value, then they are equal
2. If two `Integer` variables have the same value, then they may be not equal:
```java
int a = val;
Integer val1 = Integer.valueOf(a);
Integer val2 = Integer.valueOf(a);

val1 == val2; 

```
If $0 \leq val \leq 127$, then `true`, else if $128 \leq val$, then `false`.  This is related to wrapper class and java constant pool.