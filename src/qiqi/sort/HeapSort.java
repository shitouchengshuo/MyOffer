package qiqi.sort;

/**
   堆排序：不稳定排序  最好、最坏、平均: O(nlogn)
 */
public class HeapSort {

    private static void heapSort(int[] arr) {
        int len = arr.length -1;
        for(int i = len / 2; i >= 0; i--){
            heapAdjust(arr, i, len);  //堆构造
        }
        while (len >= 0){
            swap(arr,0, len--); //先使用后自减，将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(arr,0, len); //再次对堆进行调整,从堆顶节点开始交换
        }
    }

    public static  void heapAdjust( int[] arr, int i, int len){
        int left, right, j ;//i指向子树的根节点
        while((left = 2 * i + 1) <= len){//如果当前父节点有左节点（即有孩子节点，left为左节点）
            right = left + 1;  //右节点为左节点+1
            j = left;   //j"指针指向左节点"
            //如果右节点大于左节点，下一个if语句比较arr[i]（父节点）与右节点
            //这里j<len是在堆顶元素与尾节点交换后，不再让尾节点参与交换（80...），以此来保留排好序的最大值
            if( j < len && arr[left] < arr[right]) {
                j = right;     //当前把"指针"指向右节点
            }
            //如果父节点小于孩子节点，将父节点与孩子节点交换
            // 这里：如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点
            if( arr[i] < arr[j] ){
                swap(arr, i, j);
            }else {
                break; //说明根节点比孩子节点都大，直接跳出循环语句
            }
            i = j; //1.堆顶元素80与第二个父节点元素20交换后，20还有子节点5,6元素需要进行比较
                   //2.堆顶元素与尾节点交换后，调整是从堆顶开始，用于控制流程
        }
    }

    public static  void swap(int[] arr, int i, int len){
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }
    public static void main(String[] args) {
        int[] array = {20,50,20,40,70,10,80,30,60};
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