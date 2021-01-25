package practice.bit;

//131 位的个数 https://leetcode-cn.com/problems/number-of-1-bits/
public class HammingWeight {


    public static void main(String[] args) {

        int a = 4;
        int b = a >> 1;
        System.out.println(b);
    }


    // 通过消除最低位的1进行计数，直到最后为0
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n; //消除最低位的 1
        }
        return count;
    }

    // 通过 1 左移，与原数进行“与”操作， 不为零则计数1个
    public int hammingWeight_2(int n) {
        int count = 0;
        int mark = 1;
        int bit = 32;

        while (bit-- != 0) {
            if((mark & n) != 0) count++;
            mark <<= 1;
        }
        return count;
    }

}
