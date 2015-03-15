# Group Members

* Evan (Zhenghui Liu, 1433013)
* Gareth Thomas (1440960)

# Answers

## 2

``` java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World: " + (args.length > 0 ? args[0] : ""));
    }
}
```

## 3

### x=6 and y=9

    Have a nice day!

### x=5 and y=2

    x = 5 and y = 5

## 4

### output

    0 1
    1 2
    2 4
    3 8
    4 16
    5 32
    6 64

### For loop

```java
for (int j = 0; j <= N; j++) {
    System.out.println(j + " " + v);
    v = 2 * v;
}
```

## 5

    1 1
    2 8
    3 27

## 6

```java
public class Cubes {
    public int cube(int i) {
        i = i * i * i;
        return i;
    }
}
public class TestCubes {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++)
            System.out.println(i + " " + new Cubes().cube(i));
    }
}
```

## 7a

    0: 0.15
    1: 0.21
    2: 0.25
    3: Not available

## 7b

```java
import java.util.Arrays;

public class Q7b {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        };
        int[][] b = {
                {3, 4, 5},
                {2, 3, 4},
                {1, 2, 3}
        };
        int[][] c = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        for (int i = 0; i < a.length; i++) {
            int[] aRow = a[i];
            for (int j = 0; j < aRow.length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println(Arrays.deepToString(c));
    }
}
```

## 8

### Code explanation

* Take one integer argument as a temperature
  * Print error message if there is no argument passed in.
  * Print error message if the argument passed in is not an integer
* Create a new `CoffeeCup` and set the temperature of its coffee to the argument passed in.
* Create and serve the coffee to a virtual customer.

### try-catch

```java
import java.util.Arrays;

public class exceptions {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        int[] array = new int[3];
        for (int i = 0; i < N; ++i) {
            try {
                array[i] = i;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("N can not be greater then 3");
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
```

### 9

```java
import java.util.ArrayList;

// define a public class named Prime
public class Prime {
    // generic main method
    public static void main(String[] args) {
        // Simple program to identify the first n prime numbers
        // A prime number is a number that is only divisable by 1 or itself // See http://en.wikipedia.org/wiki/Prime_number for more information // A factor is any number that equally divides another another number
        // initially we are only interested in the first 20 numbers
        int n = 20;

        ArrayList<Integer> factors = new ArrayList<Integer>();

        // start the loop from 2
        for (int number = 2; number <= 20; number++) {
            // simple flag to toggle between prime and composite
            boolean isPrime = true;

            factors.clear();

            // what are the factors of the variable number?
            for (int factor = 2; factor < number; factor++) {
                /*
                * test if a particular number / factor combination
                * a remainder if the number is equally divided by * higher than 1 then it must be a composite number */

                if (number % factor == 0) {
                    isPrime = false;
                    factors.add(factor);
                }
            } // end inner factor loop

            if (isPrime) {
                System.out.println(number + " is prime.");
            } else {
                System.out.println(number + " is composite.");
                System.out.println("The factors include " + factors.toString());
            }
        }
    }
}
```
