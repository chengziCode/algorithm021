public class TotalNQueens {
    private int size;
    private int count;


    public static void main(String[] args) {
//        System.out.println(new practice.bit.TotalNQueens().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        displayBit("size", size);
        solve(0, 0, 0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        displayBit("row",row);
        displayBit("ld",ld);
        displayBit("rd",rd);

        int pos = size & (~(row | ld | rd)); // 位上的1表示没有被占
        displayBit("pos",pos);
        while (pos != 0) {
            displayBit("-pos",(-pos));
            int p = pos & (-pos);
            displayBit("p",p);
            pos -= p; // pos &= pos - 1;
            displayBit("pos",(pos));
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static void displayBit(String info, int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int bit = num % 2;
            sb.append(String.valueOf(bit));
            num = num / 2;
        }
        while (sb.length() < 4) sb.append("0");
        System.out.println(info + " : " + sb.reverse().toString());
    }


}
