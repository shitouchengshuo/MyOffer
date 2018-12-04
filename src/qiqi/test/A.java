package qiqi.test;


import qiqi.binaryTree.BinaryTreeNode;
import qiqi.binaryTree.SequenceOfBST;
import qiqi.sort.QuickSort;

import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static String str = "arabaacfr";

    private static int getLongestSubStr(String str) {
        if(str == null){
            return 0;
        }
        int[] arr = new int[26];
        int max = 0;
        int count = 0;
        for (int i = 0; i < 26; i++){
            arr[i] = -1;
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) - 'a' == -1){
                arr[str.charAt(i) - 'a'] = i;
                count++;
            }else {
                if (i - arr[str.charAt(i) - 'a'] > count){
                    count++;
                }else {
                    count = i - arr[str.charAt(i) - 'a'];
                }
                arr[str.charAt(i) - 'a'] = i;
            }
            if (max < count){
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubStr(str));

    }
}
