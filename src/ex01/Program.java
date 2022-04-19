import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int MINIMAL_PRIME_NUMBER = 2;

        int number;
        int steps = 0;
        boolean isPrime = true;

        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        if (number < MINIMAL_PRIME_NUMBER)
        {
            System.out.println("Illegal Argument");
            System.exit(-1);
        }
        for (int j = MINIMAL_PRIME_NUMBER; j <= number; j++){

            steps++;
            if (number % j == 0 && number != j){
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime + " " + steps);
    }
}