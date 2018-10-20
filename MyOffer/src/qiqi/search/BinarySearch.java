package qiqi.search;

public class BinarySearch {

    private  static int[] arrayTest = new int[]{1,3,4,8,10,12,17,33};

    private  static int binarySearch(int[] array, int number){
        if (array == null || array.length <= 0){
            return -1;
        }
        int min = 0;
        int max = array.length - 1;
        int mid = (min + max) / 2;
        while(true){
            if (array[mid] == number){
                return mid;
            }
            if (array[mid] > number){
                max = mid -1;
            }else {
                min = mid +1;
            }
            if (min > max){
                return -1;
            }
            mid = (min + max) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(arrayTest, 33));
    }
}
