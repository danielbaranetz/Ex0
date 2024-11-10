import java.util.*;
import java.util.Scanner;

public class Ex0 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();  // Start time

        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a number(even) greater than 4: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number > 4 && number % 2 == 0) { // accept only numbers that higher than 4 and even
                    for ( int i = 2; i <=  number; i++) {
                        if (isPrime(i) && isPrime(number - i)) {
                            System.out.println("a) "+ i + " + " + (number - i) + " = " + number);
                            break;
                        }
                    }
                    for ( int i = 2; i <=  number; i++) {
                        if (isPrime(i) && isPrime(number + i)) {
                            System.out.println("b) "+ (number + i) + " - " + (i) + " = " + number);
                            break;
                        }
                    }
                    List<Object> myList = new ArrayList<>();
                    for ( int i = 2; i <=  number; i++) {
                        if (isPrime(i)) {
                            myList.add(i);
                        }
                    }
                    System.out.printf("c) There are %d prime numbers in %s%n", myList.size(), "[" + myList.get(0) + "," + myList.get(myList.size() - 1) + "]");

                    List<Integer> primeNumbers = new ArrayList<>();
                    for ( int i = 2; i <=  number; i++) {
                        if (isPrime(i) && (number % i == 0)) {
                            primeNumbers.add(i);
                        }
                    }
                    StringBuilder result = new StringBuilder("d) ");
                    for (int i = 0; i < primeNumbers.size(); i++) {
                        result.append(primeNumbers.get(i));

                        if (i < primeNumbers.size() - 1) {
                            result.append(" * ");
                        }
                    }
                    result.append(" = ").append(number);
                    System.out.println(result.toString());
                    break;
                } else {
                    System.out.println("The number must be greater than 4 and even. Please try again.");
                }
            } else {
                System.out.println("Thats not a valid integer. Please try again.");
                scanner.next();
            }
        }
        long endTime = System.nanoTime();  // End time
        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;  // Convert to seconds
        System.out.printf("e) %.2f seconds, the program runtime%n", durationSeconds);
        System.out.println("f) ID: 208291377");
    }

    public static boolean isPrime(int n) {
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
