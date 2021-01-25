package sort;

import utils.Utils;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 20, 10, 5, 4, 3, -1, 40, 1, 0};
        mergeSort(arr, 0, arr.length - 1);
        Utils.displayArray(arr);
    }

    /**
     * 只操作一个数组，通过下标限制排序的范围
     */
    private static void mergeSort(int[] arr, int begin, int end) {
        if (end <= begin) return;

        int mid = (begin + end) >> 1;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int[] tmp = new int[end - begin + 1];
        int a = begin, b = mid + 1, k = 0;

        while (a <= mid && b <= end)
            tmp[k++] = arr[a] < arr[b] ? arr[a++] : arr[b++];

        while (a <= mid) tmp[k++] = arr[a++];
        while (b <= end) tmp[k++] = arr[b++];

        for (int i = 0; i < tmp.length; i++) arr[begin + i] = tmp[i];
    }


}
