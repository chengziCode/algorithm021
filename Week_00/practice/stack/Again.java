package practice.stack;

import utils.Utils;

import java.util.LinkedList;

public class Again {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        new LinkedList();
        System.out.println(a ^ b);

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1000];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) arr[arr1[i]]++;
        for (int i = 0; i < arr2.length; i++) {
            while (arr[arr2[i]]-- > 0) {
                arr1[index++] = arr2[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) arr1[index++] = i;
        }

        return arr1;
    }


}
