package codetop_byte.q0409;

import org.junit.jupiter.api.Test;

public class FindKthNumber {
    // 前缀树[0-n] 就是以0为根节点的一棵十叉树
    public int findKthNumber(int n, int k) {
        if (k == 1) {
            return 1;
        }
        int cur = 1;
        // 跳过1,所以k要减1
        k--;
        while(k > 0) {
            int count = getThTree(n,cur);
            // 判断是沿着树向下找还是横向找:以cur为根节点的树的节点个数是否大于cur
            if (k >= count) {
                // 横向找
                k -= count;
                cur ++;
            }else {
                // 向下找
                k -= 1;
                cur = cur * 10;
            }
        }
        return cur;


    }
    // 看在哪个数字作为根节点的树上去找,统计当前树上的节点个数
    private int getThTree(int n,int cur) {
        int count = 0;
        // 这里得设置成long,否则会越界(10^10 > 2^31)
        long first = cur;
        long last = cur;
        while(first <= n) {
            count += Math.min(n,last)-first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return count;
    }
    @Test
    public void show() {
        System.out.println(findKthNumber(2,2));
    }
}
