//541. 反转字符串 II     https://leetcode-cn.com/problems/reverse-string-ii/
public class ReverseStr {

    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcd1234jkmn12", 2));
    }

    public String reverseStr(String s, int k) {
        char[] strArr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {  //每次只对 (2k * i, k)范围内的前k个字符操作
            int start = i; //双指针
            int end = Math.min(i + k - 1, s.length() - 1); //如果 s.length < k ,只对k个字符反转
            while (start < end) {
                char tmp = strArr[start];
                strArr[start++] = strArr[end];
                strArr[end--] = tmp;
            }
        }

        return new String(strArr);
    }
}
