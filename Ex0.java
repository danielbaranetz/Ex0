/*
*****************************************************
how the code should be in my own words step by step:
1. ask the user to insert a number that even and greater than 4
2.if the number is greater than 4 and even start count the prime numbers. else ask again to insert a valid number
3.create function with 1 parameter that check if the number is prime
4. call the function in every section to get only the prime numbers
5. for section (a) take the number and subtract number with i and check in prime function if its prime and print it x + y = number
6. for section (b) take the number and add number with i and check in prime function if its prime and print it as x - y = number
7. for section (c) create list and store every prime number into the list and then print list.size and show the first in list and last in list
8. for section (d) take number and check if divisible with i without remainder, store each factor in a list, and print the list with the factors multiplied together.
9. for section (e) set in the start of the function  system.nanotime till the end of the function and do the same and calculate delta (end - start) and divide by 1_000_000_000.0 to get seconds
10. for section (f) print my id number
*****************************************************


 */

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
                    long startTime = System.nanoTime();  // Start time

                    for ( int i = 2; i <=  number; i++) {
                        if (primeNumbers(i) && primeNumbers(number - i)) {
                            System.out.println("a) "+ i + " + " + (number - i) + " = " + number);
                            break;
                        }
                    }
                    for ( int i = 2; i <=  number; i++) {
                        if (primeNumbers(i) && primeNumbers(number + i)) {
                            System.out.println("b) "+ (number + i) + " - " + (i) + " = " + number);
                            break;
                        }
                    }
                    List<Object> myList = new ArrayList<>();
                    for ( int i = 2; i <=  number; i++) {
                        if (primeNumbers(i)) {
                            myList.add(i);
                        }
                    }
                    System.out.printf("c) There are %d prime numbers in %s%n", myList.size(), "[" + myList.getFirst() + "," + number + "]");

                    List<Integer> primeNumbers = new ArrayList<>();
                    for ( int i = 2; i <=  number; i++) {
                        while (number % i == 0) {
                            primeNumbers.add(i);
                            number = number / i;
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
                    System.out.println("d) " + result.toString());
                    long endTime = System.nanoTime();  // End time
                    double durationSeconds = (endTime - startTime) / 1_000_000_000.0;  // Convert to seconds
                    System.out.printf("e) The program runtime took %.2f seconds%n", durationSeconds);
                    break;
                } else {
                    System.out.println("The number must be greater than 4 and even. Please try again.");
                }
            } else {
                System.out.println("Thats not a valid integer. Please try again.");
                scanner.nextLine();
            }
        }
        System.out.println("f) ID: 208291377");
    }
    public static boolean primeNumbers(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) { //
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}