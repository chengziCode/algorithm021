package practice.sort;

import utils.Utils;

public class MergeSort_2 {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 20, 10, 5, 4, 3, -1, 40, 1, 0};
        mergeSort(arr, 0, arr.length - 1);
        Utils.displayArray(arr);
    }

    /**
     * 只操作一个数组，通过下标限制排序的范围
     */
    private static void mergeSort(int[] arr, int begin, int end) {
        // terminator
        if (end <= begin) return;

        //process and  drill down
        int mid = (begin + end) >> 1;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int[] tmp = new int[end - begin + 1];
        int left = begin, right = mid + 1, tmpIndex = 0;

        while (left <= mid && right <= end) {
            tmp[tmpIndex++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) tmp[tmpIndex++] = arr[left++];
        while (right <= end) tmp[tmpIndex++] = arr[right++];

        for (int i = 0; i < tmp.length; i++) arr[begin + i] = tmp[i];
    }


}
