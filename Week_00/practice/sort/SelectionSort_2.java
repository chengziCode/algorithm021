package practice.sort;

import utils.Utils;

public class SelectionSort_2 {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 20, 10, 5, 4, 3, -1, 2, 1, 0};
        selectSort(arr);
        Utils.displayArray(arr);
    }

    /**
     * 选择排序 : 选最小的数替换数组
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

}
