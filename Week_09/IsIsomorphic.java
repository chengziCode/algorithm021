import java.util.HashMap;

// 205. 同构字符串 https://leetcode-cn.com/problems/isomorphic-strings/
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("egg", "add"));
    }

    /**
     * 通过map映射 ： 每次put操作之前判断之前是否已经映射， 若是，比较已经映射的值 和 即将映射的值 知否相等。
     * 如果之前没有被映射， 还要判断即将映射的值是否已经被映射。
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int index = 0;
        while (index < s.length()) {
            if (map.containsKey(s.charAt(index))) {
                if (map.get(s.charAt(index)) != t.charAt(index)) return false;
            } else if (!map.containsValue(t.charAt(index))){
                map.put(s.charAt(index), t.charAt(index));
            }else return false;
            index++;
        }
        return true;
    }


}
