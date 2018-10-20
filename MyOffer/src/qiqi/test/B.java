package qiqi.test;

public class B  {
    public static void test(){
        int[] w = {2,1,3,2,4,5,3,1};
        int[] p = {13,10,24,15,28,33,20,8};

        int n = w.length;
        int totalWeight = 12;
        int[][] bestValue = new int[n+1][totalWeight+1];
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= totalWeight; j++){
                if (j >= w[i-1]){
                    bestValue[i][j] = Integer.max(bestValue[i-1][j],bestValue[i-1][j-w[i-1]]+p[i-1]);
                }else{
                    bestValue[i][j] = bestValue[i-1][j];
                }
            }
        }

        //输出表
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= totalWeight; j++){
                System.out.print(bestValue[i][j]+"\t");
            }
            System.out.print("\n");
        }
        //输出最大值
        System.out.println("能装的最大价值为："+bestValue[n][totalWeight]);
        //输出装的物品
        System.out.print("装的物品编号为：");
        int x=totalWeight;
        for(int i = n; i > 0; i--){
            if(bestValue[i][x] > bestValue[i-1][x]){
                System.out.print(i+"\t");
                x-=w[i-1];
            }
        }
    }

    public static void main(String[] args) {
        test();
    }
}
