package lab0;

import com.beust.jcommander.IStringConverter;

public class Variant3 {

    public static int integerTask(int a) {
        int BYTE_IN_KILOBYTE = 1024;
        return (a / BYTE_IN_KILOBYTE);
    }


    public static boolean booleanTask(int a){
        return a % 2 == 0;
    }

    public static int ifTask(int number){
        if(number > 0){
            return number + 1;
        }
        if(number < 0){
            return number - 2;
        }
        return 10;
    }

    public static String caseTask(int number){
        if(number > 12 || number < 1){
            throw new IllegalArgumentException("Number should...");
        }
        String[] seasons = {"Winter", "Spring", "Summer", "Autumn", "Winter"};
        return seasons[number / 3];
    }

    public static int[] forTask(int a, int b){
        int n;
        n = b - a;
        int[] list = new int[n - 1];
        for (int i = 1; i < n; i++) {
            list[i - 1] = a + i;
        }
        return list;
    }

    public static int[] whileTask(int n, int k){
        int quotient = 0, rest;
        int[] answer = new int[2];
        while(n > 0 && n >= k){
            n = n - k;
            quotient++;
        }
        rest = n;
        answer[0] = quotient;
        answer[1] = rest;
        return answer;
    }

    public static  int minmaxTask(int[][] rectangles){
        int perimeter = 0, x = 0;
        for (int i = 0; i < rectangles.length; i++) {
            x += (rectangles[i][0] + rectangles[i][1]) * 2;
            if(x > perimeter){
                perimeter = x;
            }
            x = 0;
        }
        return perimeter;
    }

    /**
     *
     * @param n progression size
     * @param a first element of progression
     * @param d progression multiplier
     * @return progression
     */
    public static int[] arrayTask(int n, int a, int d){
        int[] progression = new int[n];
        progression[0] = a;
        for (int i = 1; i < n; i++) {
            progression[i] = a + i * d;
        }
        return progression;
    }

    /**
     *
     * @param m the number of items in column
     * @param n the number of items in a row
     * @param list array on m elements
     * @return matrix
     */
    public static int[][] matrixTask(int m, int n, int[] list){
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = list[i];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] x;
        int [] y = {1, 7, 5};
        x = matrixTask(3, 3, y);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(x[i][j]);
            }
        }
        y = whileTask(21, 3);
        for (int i = 0; i < 2; i++) {
            System.out.println(y[i]);
        }
    }
}

