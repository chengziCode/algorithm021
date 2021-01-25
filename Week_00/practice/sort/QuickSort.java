package practice.sort;

import utils.Utils;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{30, 20, 10, 5, 4, 3, -1, 40, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        Utils.displayArray(arr);
    }

    /**
     *  根据pivot进行分治排序
     */
    private static void quickSort(int[] arr,int begin, int end) {
        //terminator
        if (end <= begin) return;
        //process
        int pivot = partition(arr, begin, end);
        //drill down + merge
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    /**
     * 目的是返回pivot, 首次默认以end作为pivot
     */
    private static int partition(int[] arr, int begin, int end) {
        int pivot = end, curIndex = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot])
                swap(arr, curIndex++, i);
        }
        
        swap(arr, curIndex, pivot);

        return curIndex;
    }


    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
