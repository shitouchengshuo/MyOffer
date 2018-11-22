package qiqi.dynamicPlanning;

/**
 * Created by ZhaoQiqi on 2018/11/21.
 */
public class MaxValueOfGifts {

    private static int getMaxPathValue(int[][] values){

        int rows = values.length;
        int cols = values[0].length;
        if (values == null || rows <=0 || cols <=0){
            return 0;
        }
        int[][] maxValues = new int[rows][cols];
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                int left = 0; //左边
                int up = 0; //上面
                if (i > 0){
                    up = maxValues[i - 1][j];
                }
                if (j > 0){
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(left, up) + values[i][j];
            }
        }
        return maxValues[rows - 1][cols - 1];
    }

    public static void main(String[] args){
        int[][] values = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(getMaxPathValue(values));
        int[][] values1 = {{1, 10, 3, 8}};
        System.out.println(getMaxPathValue(values1));  //22
        int[][] values2 = {
                {1},
                {1},
                {5},
                {3}};
        System.out.println(getMaxPathValue(values2));  //10
    }
}
