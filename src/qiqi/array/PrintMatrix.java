package qiqi.array;

/**
 * 输入一个矩阵，按照从外向里以顺时针顺序打印出每一个数字
 */
public class PrintMatrix {

    public static void printMatixClockwisely(int[][] numbers, int columns, int rows){
        if (numbers == null || columns <= 0 ||rows <= 0){
            return;
        }

        int start = 0;
        while (columns > start*2 && rows > start*2){
            printMatixInCircle(numbers, columns, rows, start);
            start++;
        }
    }

    private static void printMatixInCircle(int[][] numbers, int columns, int rows, int start) {

        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //从左到右打印一行
        for (int i = start; i <= endX; i++){
            System.out.print(numbers[start][i]+ " ");
        }

        //从上到下一列
        if (endY > start){
            for (int i = start + 1; i <= endY; i++){
                System.out.print(numbers[i][endX]+ " ");
            }
        }

        //从右到左打印一行
        if (endY > start && endX > start){
            for (int i = endX - 1; i >= start; i--){
                System.out.print(numbers[endY][i]+ " ");
            }
        }

        //从下到上打印一行
        if (endY > start+1 && endX > start){
            for (int i = endY - 1; i >= start + 1; i--){
                System.out.print(numbers[i][start]+ " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = new int[4][4];
        numbers[0][0] = 1;
        numbers[0][1] = 2;
        numbers[0][2] = 3;
        numbers[0][3] = 4;
        numbers[1][0] = 5;
        numbers[1][1] = 6;
        numbers[1][2] = 7;
        numbers[1][3] = 8;
        numbers[2][0] = 9;
        numbers[2][1] = 10;
        numbers[2][2] = 11;
        numbers[2][3] = 12;
        numbers[3][0] = 13;
        numbers[3][1] = 14;
        numbers[3][2] = 15;
        numbers[3][3] = 16;
        printMatixClockwisely(numbers,4,4);
    }
}
