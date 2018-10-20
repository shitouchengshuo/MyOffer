package qiqi.search;

/**
 * 题目： 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
 * 输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。
 * 例如数组{3，4, 5, 1, 2 ｝为｛ l1,2,3, 4，5}的一个旋转，该数组的最小值为1
 */
public class MinNumberInRotatedArray {

    public static int search(int[] numbers){
        if (numbers == null || numbers.length <=0){
            return -1;
        }
        int index1 = 0;
        int index2 = numbers.length-1;
        int indexMad = index1;
        while (numbers[index1] >= numbers[index2] ){
            if (index2 - index1 == 1){
                indexMad = index2;
                break;
            }
            indexMad = (index1+index2)/2;
            //如果下标index1/index2/indexmad指示的数字相同，只能顺序查找
            if (numbers[index1] == numbers[index2] &&
                    numbers[indexMad] == numbers[index1]){
                return MinInOrder(numbers, index1, index2);
            }

            if (numbers[indexMad] >= numbers[index1]){
                index1 = indexMad;
            }
            if (numbers[indexMad] <= numbers[index2]){
                index2 = indexMad;
            }
        }
        return numbers[indexMad];

    }

    public static int MinInOrder(int[] numbers, int index1, int index2){
        int result = numbers[index1];
        for (int i = index1=1; i < index2; i++){
            if (result > numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,4,5,1,2}));
    }
}
