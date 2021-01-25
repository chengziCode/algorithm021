package sort;

import utils.Utils;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{30, 20, 10, 5, 4, 3, -1, 2, 1, 0};
        bubbleSort(arr);
        Utils.displayArray(arr);
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
