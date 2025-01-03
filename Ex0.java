/**
 ID: 208291377
 *****************************************************
 how the code should be in my own words step by step:

 1. ask the user to insert a number that even and greater than 4
 2.if the number is greater than 4 and even start count the prime numbers. else ask again to insert a valid number
 3.create function with 1 parameter that check if the number is prime
 4. call the function in every section to get only the prime numbers
 5. for section (a) take the number and subtract number with i and check in prime function if its prime and print it x + y = number
 6. for section (b) take the number and add number with i and check in prime function if its prime and print it as x - y = number
 7. for section (c) create primeCounter = 0 and check with primeNumber function if I is prime and add 1 to primeCounter every time
 8. for section (d) take number and check if divisible with i without remainder, store each factor in a list, and print the list with the factors multiplied together.
 9. for section (e) set in the start of the function  system.nanotime till the end of the function and do the same and calculate delta (end - start) and divide by 1_000_000_000.0 to get seconds
 10. for section (f) print my id number
 *****************************************************

 *****************************************************
 pseudocode:


 input(number) // prompt the user to enter a number greater than 4 and even.

(A)
 for (i = 2 to number) {
    if (primenumbers(i) and primenumbers(number - i)) {
        print("a) i + (number - i) = number")
        break
    }
 }

 (B)
 for (i = 2 to number) {
    if (primenumbers(i) and primenumbers(number + i)) {
    print("b) (number + i) - i = number")
    break
    }
 }

 (C)
 primecounter = 0
 for (i = 2 to number) {
    if (primenumbers(i)) {
    primecounter = primecounter + 1
    }
 }
 print("c) there are primecounter primes between (2 - number)")

 (D)
 primenumbers = 0
 for (i = 2 to number) {
    while (number % i == 0) {
        append i to primenumbers
        number = number / i
    }
 }
 print("d) factors = result")

 (E)
 endtime = currenttime
 totaltime = (endtime - starttime) / 1,000,000,000
 print("e) the program runtime took totaltime seconds")

 (check prime function)
 if (n == 2) return true
 if (n % 2 == 0) return false
 for (i = 3 to sqrt(n) with i+=2) {
    if (n % i == 0) return false
    }
 return true


 *****************************************************
 **/

import java.util.*;
import java.util.Scanner;

public class Ex0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Enter a number(even) greater than 4: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 4 && number % 2 == 0) { // accept only numbers that higher than 4 and even
                    long startTime = System.nanoTime();  // start time
                    sectionA(number);
                    sectionB(number);
                    sectionC(number);
                    sectionD(number);
                    sectionE(startTime);
                    System.out.println("f) ID: 208291377");
                    break;
                } else {
                    System.out.println("The number must be greater than 4 and even. Please try again.");
                }
            } else {
                System.out.println("Thats not a valid integer. Please try again.");
                scanner.nextLine();
            }
        }

    }

    public static void sectionA(int number) {
        for (int i = 2; i <= number; i++) {
            if (primeNumbers(i) && primeNumbers(number - i)) {
                System.out.println("a) " + i + " + " + (number - i) + " = " + number);
                break;
            }
        }
    }

    public static void sectionB(int number) {
        for (int i = 2; i <= number; i++) {
            if (primeNumbers(i) && primeNumbers(number + i)) {
                System.out.println("b) " + (number + i) + " - " + (i) + " = " + number);
                break;
            }
        }
    }

    public static void sectionC(int number) {
        int primeCounter = 0;
        for (int i = 2; i <= number; i++) {
            if (primeNumbers(i)) {
                primeCounter++;
            }
        }
        System.out.printf("c) There are %d prime numbers %s%n", primeCounter, "between (2 " + "- " + number + ")");
    }

    public static void sectionD(int number) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                number = number / i;
                primeNumbers.add(i);
            }
        }
        StringBuilder result = new StringBuilder();
        int product = 1;
        for (int i = 0; i < primeNumbers.size(); i++) {
            result.append(primeNumbers.get(i));
            product *= primeNumbers.get(i);
            if (i < primeNumbers.size() - 1) {
                result.append(" * ");
            }
        }
        result.append(" = ").append(product);
        // Print the result
        System.out.println("d) " + result);
    }

    public static void sectionE(long startTime) {
        long endTime = System.nanoTime();  // end time
        double totalTime = (endTime - startTime) / 1_000_000_000.0;  // convert to seconds
        System.out.printf("e) The program runtime took %.2f seconds%n", totalTime);
    }

    public static boolean primeNumbers(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}