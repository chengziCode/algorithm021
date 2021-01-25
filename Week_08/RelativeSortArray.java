import java.util.Map;
import java.util.TreeMap;

//1122 数组的相对排序  https://leetcode-cn.com/problems/relative-sort-array/
public class RelativeSortArray {
    public static void main(String[] args) {


    }

    /**
     *  arrCnt数组用于 hash计数，排序
     */
    public int[] relativeSortArray_1(int[] arr1, int[] arr2) {
        int[] arrCnt = new int[1001];
        int[] res = new int[arr1.length];
        int index = 0;

        for (int i : arr1) arrCnt[i]++; //计数
        for (int i : arr2)
            while (arrCnt[i]-- > 0) res[index++] = i;

        for (int i = 0; i < arrCnt.length; i++)
            while (arrCnt[i]-- > 0) res[index++] = i;

        return res;
    }


    /**
     * treemap 用于 计数，排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int index = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            int key = arr2[i];
            int value = map.get(key);
            while (value-- > 0) res[index++] = arr2[i];
            map.remove(key);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            while (value-- > 0)
                res[index++] = key;
        }
        return res;

    }
}
