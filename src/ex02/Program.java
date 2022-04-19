import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int TERMITE_NUMBER = 42;

        int number;
        int count = 0;

        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        while (number != TERMITE_NUMBER){

            if (checkPrime(number))
                count++;
            number = in.nextInt();
        }
        System.out.println("Count of coffee-request - " + count);
    }

    private static boolean checkPrime(int number) {

        int MINIMAL_PRIME_NUMBER = 2;
        boolean isPrime = true;

        if (number < MINIMAL_PRIME_NUMBER)
            return (false);
        for (int j = MINIMAL_PRIME_NUMBER; j < number; j++){

            if (number % j == 0){
                isPrime = false;
                break;
            }
        }
        return (isPrime);
    }
}
