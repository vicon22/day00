import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int number;
        int count = 0;

        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        while (number != 42){

            if (checkPrime(number))
                count++;
            number = in.nextInt();
        }
        System.out.println("Count of coffee-request - " + count);
    }

    private static boolean checkPrime(int number) {

        boolean isPrime = true;
        if (number < 2)
            return (false);
        for (int j = 2; j < number; j++){

            if (number % j == 0){
                isPrime = false;
                break;
            }
        }
        return (isPrime);
    }
}
