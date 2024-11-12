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
                    System.out.printf("c) There are %d prime numbers in %s%n", myList.size(), "[" + myList.getFirst() + "," + myList.getLast() + "]");

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
                        result.append(primeNumbers.get(i)); // Append the factor
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
                    System.out.printf("e) %.2f seconds, the program runtime%n", durationSeconds);
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