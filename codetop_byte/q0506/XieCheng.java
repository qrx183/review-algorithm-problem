package codetop_byte.q0506;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XieCheng {
    private static Scanner scanner = new Scanner(System.in);
    static class Two {
        public static void main(String[] args) {
            int n = scanner.nextInt();
            int res = -1;
            String[] strs = new String[n];
            int[] value = new int[n];
            for(int i = 0; i < n; i ++) {
                strs[i] = scanner.next();
                value[i] = scanner.nextInt();
            }
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if (isMatch(strs[i],strs[j])) {
                        res = Math.max(res,value[i]+value[j]);
                    }
                }
            }
            System.out.println(res);
        }
        private static boolean isMatch(String s1,String s2) {
            int m = s1.length();
            int n = s2.length();
            for(int i = 0; i < m; i++) {
                if(i+n <= m && s1.substring(i,i+n).equals(s2)) {
                    return true;
                }
            }
            return false;
        }
    }
    static class Three {
        static Set<String> set = new HashSet<>();
        static {
            // 最终发现满足情况的只有以下4中排列的形式.
            // 再次细分发现,101和121这两种只满足长度为3的情况,对于长度大于3的情况,1后面无论跟0还是2,0(2)10和0(2)12都不满足条件
            // 对于020和202发现整个数组排列的形式必须是0和2交替. 这样一来就可以从字符串中的某个0或2开始向两边进行0和2交替的扩散,如果出现相邻相等的返回-1
            // 如果全是问号,直接返回0,2交替即可
            set.add("020");
            set.add("101");
            set.add("121");
            set.add("202");
            // 这道题的启发就是当题目中出现有限个选择(0,1,2)的时候,可以考虑将情况进行细分,最终满足条件的情况可能只有仅仅的几种,然后针对这几种分别去讨论
        }
        public static void main(String[] args) {
            String s = scanner.next();
            int n = s.length();
            for(int i = 0; i < n - 1; i ++) {
                if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) != '?') {
                    System.out.println(-1);
                    return;
                }
            }
            // f[i][j] 表示当第i位变成j后前i位是否满足条件
            boolean[][] f = new boolean[n][3];
            if(s.charAt(0) == '?') {
                Arrays.fill(f[0],true);
            }else {
                f[0][Integer.parseInt(s.charAt(0) + "")] = true;
            }

        }
    }

    static class Four {
        public static void main(String[] args) {


        }
    }
}
