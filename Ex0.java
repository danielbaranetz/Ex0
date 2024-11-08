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
                    for ( int i = 2; i <=  number; i++) {
                        if (isPrime(i) && isPrime(number - i)) {
                            System.out.println("a) "+ i + " + " + (number - i) + " = " + number);
                            break;
                        }
                    }
                break;
                } else {
                    System.out.println("The number must be greater than 4 and even. Please try again.");
                }
            } else {
                System.out.println("Thats not a valid integer. Please try again.");
                scanner.next();
            }
        }

    }
    public static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) { //
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
