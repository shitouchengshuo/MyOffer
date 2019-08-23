package qiqi.sort;

/**
 * 堆排序：不稳定排序  最好、最坏、平均: O(nlogn)
 * 堆： 1：必须是一个完全二叉树  2：父节点大于左右子节点
 * @author qiqi.zhao
 */
public class HeapSort {

    private static void heapSort(int[] arr) {
        //len也就是最后一个节点
        int len = arr.length - 1;
        //i指向子树的根节点
        for( int i = len / 2; i >= 0; i-- ){
            //构造堆
            heapAdjust(arr, i, len);
        }
        //排序
        while( len >= 0 ){
            //先使用后自减，将堆顶元素与尾节点交换后，长度减1，尾元素最大
            swap(arr,0, len--);
            //再次对堆进行调整,从堆顶节点开始交换
            heapAdjust(arr,0, len);
        }
    }

    public static  void heapAdjust( int[] arr, int i, int len){
        int left, right, j ;
        //如果当前父节点有左节点（即有孩子节点，left为左节点）
        while((left = 2 * i + 1) <= len){
            //右节点为左节点+1
            right = left + 1;
            //j指针指向左节点
            j = left;
            //如果右节点大于左节点，下一个if语句比较arr[i]（父节点）与右节点
            //这里j<len防止左右子节点超出范围，若left = len,那么右节点越界
            if( j < len && arr[left] < arr[right]) {
                //当前把指针指向右节点
                j = right;
            }
            //如果父节点小于孩子节点，将父节点与孩子节点交换
            // 这里：如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点
            if( arr[i] < arr[j] ){
                swap(arr, i, j);
            }else {
                //根节点比孩子节点都大，直接跳出循环语句
                break;
            }
            //1.堆顶元素4与第二个父节点元素10交换后，4还有子节点5和1，5大于4需要调整
            //2.堆顶元素与尾节点交换后，调整是从堆顶开始，用于控制流程
            i = j;
        }
    }

    public static  void swap(int[] arr, int i, int len){
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }
    public static void main(String[] args) {
        // int[] array = {4,10,3,5,1,2};
        int[] array = {4,4,3,4,1,0,12,10};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }
        heapSort(array);
        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}