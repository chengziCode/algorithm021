package sort;

import utils.Utils;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{30, 20, 10, 5, 4, 3, -1, 2, 1, 0};
        insertionSort(arr);
        Utils.displayArray(arr);
    }

    /**
     * 插入排序
     */
    private static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int preIndex = i;
            int curNum = arr[i + 1];
            while (preIndex >= 0 && curNum < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = curNum;
        }

    }

}
