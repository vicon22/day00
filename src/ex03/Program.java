
import java.util.Scanner;
import java.util.InputMismatchException;

public class Program {
    private static final String WEEK_TEXT = "Week ";
    private static final String TERMINATOR = "42";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] allGrades = new int[19];
        int weekNumber = 1;
        String str = scanner.nextLine();
        while (!str.equals(TERMINATOR) && weekNumber <= 18) {
            if (!str.equals(WEEK_TEXT + weekNumber)) {
                printIllegalArgument();
            }
            allGrades[weekNumber] = findGrade();
            weekNumber++;
            str = scanner.nextLine();
        }
        for (int i = 1; i < weekNumber; i++) {
            System.out.print(WEEK_TEXT + i + " ");
            findLessersWeeks(allGrades, weekNumber, i);
        }
    }

    private static void findLessersWeeks(int[] allGrades,int weekNumber, int current)
    {
        int lesser = 1;

        for (int i = 1; i < weekNumber; i++) {
            if (allGrades[i] < allGrades[current]) {
                lesser++;
            }
        }

        putEquales(lesser);
    }

    private static void putEquales(int lesser)
    {
        System.out.print("=");
        while (lesser > 0) {
            System.out.print("=");
            lesser--;
        }
        System.out.println(">");
    }

    private static int findGrade()
    {
        Scanner scanner = new Scanner(System.in);
        int lesserGrade = 9;
        int grade;
        try {
            for (int i = 0; i < 5; i++) {
                grade = scanner.nextInt();
                if (lesserGrade > grade)
                    lesserGrade = grade;
            }
        }
        catch (InputMismatchException e){
            printIllegalArgument();
        }
        return (lesserGrade);
    }

    private static void printIllegalArgument(){
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
}
