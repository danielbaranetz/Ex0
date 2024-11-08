import java.util.Scanner;

public class Ex0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a number(even) greater than 4: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number > 4 && number % 2 == 0) {
                    for ( int i = 2; i <=  number/2; i++) {
                        if (i % 2 != 0 || i==2) {
                            System.out.println(i);
                        }
                    }
                break;
                } else {
                    System.out.println("The number must be greater than 4 and even. Please try again.");
                }
            } else {
                System.out.println("Thats not a valid integer. Please try again.");
                scanner.next(); // clear invalid input
            }
        }

    }
}
