

import java.util.Scanner;

public class Program {
    private static final String WEEK_TEXT = "Week ";
    private static final String TERMINATOR = "42";

    public static void main(String[] args) {

        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        int[] allGrades = new int[19];
        int weekNumber = 1;
        String str = scanner.nextLine();
        while (!str.equals(TERMINATOR) && weekNumber <= 18)
        {
            if (!str.equals(WEEK_TEXT + weekNumber))
            {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            allGrades[weekNumber] = findGrade();
            weekNumber++;
            System.out.print("-> ");
            str = scanner.nextLine();
        }
        for (int i = 1; i < weekNumber; i++)
        {
            System.out.print("Week" + i + " ");
            findLessersWeeks(allGrades, weekNumber, i);
        }
    }

    public static void findLessersWeeks(int[] allGrades,int weekNumber, int current)
    {
        int lesser = 1;

        for (int i = 1; i < weekNumber; i++)
        {
            if (allGrades[i] < allGrades[current])
            {
                lesser++;
            }
        }

        putEquales(lesser);
    }

    public static void putEquales(int lesser)
    {
        while (lesser > 0)
        {
            System.out.print("=");
            lesser--;
        }
        System.out.println(">");
    }

    public static int findGrade()
    {
        System.out.print("-> ");
        Scanner scanner = new Scanner(System.in);
        int grade = 0;
        char ch;
        String gradeline = scanner.nextLine();
        for (int i = 0; i < 9; i = i + 2)
        {
            ch = gradeline.charAt(i);
            grade += Character.getNumericValue(ch);
        }
        return (grade);
    }
}