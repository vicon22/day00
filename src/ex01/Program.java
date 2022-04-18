import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int number;
        int i = 0;
        boolean isPrime = true;

        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        if (number < 2)
        {
            System.out.println("Illegal Argument");
            System.exit(-1);
        }
        for (int j = 2; j < number; j++){

            if (number % j == 0){
                isPrime = false;
                break;
            }
            i++;
        }
        System.out.println(isPrime + " " + i);
    }
}