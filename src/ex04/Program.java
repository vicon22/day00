import java.util.Scanner;

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42BB

public class Main {

    public static void main(String[] args) {

        int countLetters = 0;
        int count = 0;
        int j;
        char currentChar;
        int[][] ans = new int[10][2];

        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        currentChar = (char) -1;
        for (char ch0 : chars) {
            if (currentChar != ch0 && checkInArray(ch0, ans)) {
                currentChar = ch0;
                j = 0;
                for (char ch1 : chars) {
                    if (currentChar == ch1)
                        j++;
                }
                addToArray(currentChar, j, ans);
            }
        }
        sortArray(ans);


        System.out.println("-------------------");
        for (int i = 0; i < 10; i++) {
            if (ans[i][1] != 0)
                System.out.println((char) ans[i][0] + " " + ans[i][1]);
        }
        System.out.println("-------------------");
        printArray(ans);
    }

    private static boolean checkInArray(char currentChar, int[][] array) {


        //System.out.println("currentChar(checkInArray) " + currentChar);
        for (int i = 0; i < 10; i++) {
            if (currentChar == array[i][0]) {
                //System.out.println("-+-" + i + "-+-");
                return (false);
            }
        }
        return (true);
    }

    private static void addToArray(char currentChar, int count, int[][] array) {

        int[] minCountLetter = new int[2];
        minCountLetter[1] = 1000;
        minCountLetter[0] = 100000000;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            if (array[i][1] < minCountLetter[1] || array[i][1] == minCountLetter[1] && array[i][0] > minCountLetter[0]) {
                minCountLetter[0] = array[i][0];
                minCountLetter[1] = array[i][1];
                index = i;
                if (array[i][1] == 0)
                    break;
            }
        }
        if (count > minCountLetter[1] || (count == minCountLetter[1]) && currentChar < minCountLetter[0]) {
            array[index][0] = currentChar;
            array[index][1] = count;
        }
    }

    private static void sortArray(int[][] array) {

        int tmpInt;
        int tmpLetter;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (array[i][1] > array[j][1] || (array[i][1] == array[j][1] && array[i][0] < array[j][0])) {
                    tmpInt = array[i][1];
                    tmpLetter = array[i][0];
                    array[i][1] = array[j][1];
                    array[i][0] = array[j][0];
                    array[j][1] = tmpInt;
                    array[j][0] = tmpLetter;
                }
            }
        }
    }

//    private static void printArray(int[][] array) {
//
//        int min = 1000;
//        int max = 0;
//        int numberLetters = 0;
//        int totalLines;
//
//
//        for (int i = 0; i < 10; i++) {
//            if (array[i][1] != 0)
//                numberLetters++;
//        }
//        for (int i = 0; i < numberLetters; i++) {
//            if (min > array[i][1])
//                min = array[i][1];
//            if (max < array[i][1])
//                max = array[i][1];
//        }
//        System.out.println("min: " + min);
//        System.out.println("max: " + max);
//        System.out.println("numberLetters: " + numberLetters);
//        totalLines = (max - min) / numberLetters;
//        System.out.println("totalLines: " + totalLines);
//
//        for (int i = 12; i != 1; i -= 1) {
//            for (int j = 0; j < 10; j++) {
//                if (array[j][1] != 0) {
//                    if (i == 2)
//                        System.out.printf("%3c", array[j][0]);
//                    else if (array[j][1] > i * totalLines)
//                        System.out.printf("%3c", '#');
//                    else if (array[j][1] <=  i * totalLines)
//                        System.out.printf("%3d", array[j][1]);
//                }
//            }
//            System.out.println();
//        }
//    }

    private static void printArray(int[][] array) {
        int c = 0;
        int g = 10;
        for (int x = 0; x < 10; x++) {
            if (array[x][1] > 0){
                c++;
            }
        }
        if (c < 10)
            g = array[0][1];
        for(int i = 0; i < 12; i++){
            for(int f = 0; f < c; f++){
                if (12 - i == (int)(((float)g / (float)array[0][1] * (float)array[f][1]) + (float)2)) {
                    System.out.print(array[f][1] + "\t");
                }
                else if (12 - i == 1)
                    System.out.print((char)array[f][0] + "\t");
                else if (11 - i <= (((float)g / (float)array[0][1]) * (float)array[f][1]))
                    System.out.print("#" + "\t");
            }
            System.out.println();
        }
    }

}