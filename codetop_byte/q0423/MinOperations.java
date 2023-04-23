package codetop_byte.q0423;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinOperations {
    // 字符串操作:每次将两个相同的字符改成任意一个字符放到串尾,求字符串中各个字符都不相同的最少移动次数(全是小写字母)
    // 首先两两合并成1个字符,记录合并的次数cnt以及没有合并的单个字符的个数remain,当remain+cnt<=26时,说明一次合并可以拨正剩下的字符不重复
    // 如果cnt+remain>26,那么说明一次合并后仍有重复的字符,那么每一个重复的字符都对应一次合并,所以结果为cnt + cnt+remain-26 = len-26
    public int minOperations (String str) {
        int n = str.length();
        int[] count = new int[26];
        for(int i = 0; i < n; i++) {
            count[str.charAt(i)-'a']++;
        }
        int cnt = 0;
        for(int i = 0; i < 26;i++) {
            cnt += (count[i])/2;
        }
        int remain = n - cnt * 2;
        return cnt+remain <= 26 ? cnt : n-26;
    }
    @Test
    public void show() {
        String a = "eueyeuvdeoyuveoyvyvecevveocedcddvouvudvuuuoydeucvecdycdodcdcdvecooeecdycycydecuc";
        System.out.println(minOperations(a));
    }
}
